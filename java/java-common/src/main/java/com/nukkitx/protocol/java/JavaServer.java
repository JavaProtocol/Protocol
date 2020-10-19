package com.nukkitx.protocol.java;

import com.nukkitx.network.raknet.RakNetServer;
import com.nukkitx.network.raknet.RakNetServerListener;
import com.nukkitx.network.raknet.RakNetServerSession;
import com.nukkitx.network.util.EventLoops;
import com.nukkitx.protocol.java.wrapper.BedrockWrapperSerializer;
import com.nukkitx.protocol.java.wrapper.BedrockWrapperSerializers;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.socket.DatagramPacket;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.net.InetSocketAddress;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class JavaServer extends Java {
    private final RakNetServer rakNetServer;
    final Set<JavaServerSession> sessions = Collections.newSetFromMap(new ConcurrentHashMap<>());
    private JavaServerEventHandler handler;

    public JavaServer(InetSocketAddress bindAddress) {
        this(bindAddress, 1);
    }

    public JavaServer(InetSocketAddress bindAddress, int maxThreads) {
        this(bindAddress, maxThreads, EventLoops.commonGroup());
    }

    public JavaServer(InetSocketAddress bindAddress, int maxThreads, EventLoopGroup eventLoopGroup) {
        super(eventLoopGroup);
        this.rakNetServer = new RakNetServer(bindAddress, maxThreads, eventLoopGroup);
        this.rakNetServer.setProtocolVersion(-1);
        this.rakNetServer.setListener(new BedrockServerListener());
    }

    public JavaServerEventHandler getHandler() {
        return this.handler;
    }

    public void setHandler(JavaServerEventHandler handler) {
        this.handler = handler;
    }

    @Override
    public RakNetServer getRakNet() {
        return this.rakNetServer;
    }

    @Override
    public void close() {
        this.close("disconnect.disconnected");
    }

    public void close(String reason) {
        for (JavaServerSession session : this.sessions) {
            session.disconnect(reason);
        }
        this.rakNetServer.close();
    }

    public boolean isClosed() {
        return this.rakNetServer.isClosed();
    }

    @Override
    protected void onTick() {
        for (JavaServerSession session : sessions) {
            session.tick();
        }
    }

    @ParametersAreNonnullByDefault
    private class BedrockServerListener implements RakNetServerListener {

        @Override
        public boolean onConnectionRequest(InetSocketAddress address) {
            return JavaServer.this.handler == null || JavaServer.this.handler.onConnectionRequest(address);
        }

        @Nullable
        @Override
        public byte[] onQuery(InetSocketAddress address) {
            if (JavaServer.this.handler != null) {
                JavaPong pong = JavaServer.this.handler.onQuery(address);
                if (pong != null) {
                    pong.setServerId(JavaServer.this.rakNetServer.getGuid());
                    return pong.toRakNet();
                }
            }
            return null;
        }

        @Override
        public void onSessionCreation(RakNetServerSession connection) {
            BedrockWrapperSerializer serializer = BedrockWrapperSerializers.getSerializer(connection.getProtocolVersion());
            JavaServerSession session = new JavaServerSession(connection, JavaServer.this.eventLoopGroup.next(), serializer);
            connection.setListener(new JavaRakNetSessionListener.Server(session, connection, JavaServer.this));
        }

        @Override
        public void onUnhandledDatagram(ChannelHandlerContext ctx, DatagramPacket packet) {
            if (JavaServer.this.handler != null) {
                JavaServer.this.handler.onUnhandledDatagram(ctx, packet);
            }
        }
    }
}
