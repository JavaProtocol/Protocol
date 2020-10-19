package com.nukkitx.protocol.java;

import com.nukkitx.network.raknet.RakNetClient;
import com.nukkitx.network.raknet.RakNetClientSession;
import com.nukkitx.network.util.EventLoops;
import com.nukkitx.protocol.java.wrapper.BedrockWrapperSerializer;
import com.nukkitx.protocol.java.wrapper.BedrockWrapperSerializers;
import io.netty.channel.EventLoopGroup;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetSocketAddress;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class JavaClient extends Java {
    private final RakNetClient rakNetClient;
    JavaClientSession session;

    public JavaClient(InetSocketAddress bindAddress) {
        this(bindAddress, EventLoops.commonGroup());
    }

    public JavaClient(InetSocketAddress bindAddress, EventLoopGroup eventLoopGroup) {
        super(eventLoopGroup);
        this.rakNetClient = new RakNetClient(bindAddress, eventLoopGroup);
    }

    @Override
    protected void onTick() {
        if (this.session != null) {
            this.session.tick();
        }
    }

    @Override
    public RakNetClient getRakNet() {
        return this.rakNetClient;
    }

    public void setRakNetVersion(int version) {
        this.rakNetClient.setProtocolVersion(version);
    }

    @Override
    public void close() {
        if (session != null) {
            session.disconnect();
        }
        rakNetClient.close();
    }

    public CompletableFuture<JavaClientSession> connect(InetSocketAddress address) {
        return this.ping(address).thenApply(pong -> {
            int port;
            if (address.getAddress() instanceof Inet4Address && pong.getIpv4Port() != -1) {
                port = pong.getIpv4Port();
            } else if (address.getAddress() instanceof Inet6Address && pong.getIpv6Port() != -1) {
                port = pong.getIpv6Port();
            } else {
                port = address.getPort();
            }

            return new InetSocketAddress(address.getAddress(), port);
        }).thenCompose(this::directConnect);
    }

    public CompletableFuture<JavaClientSession> directConnect(InetSocketAddress address) {
        CompletableFuture<JavaClientSession> future = new CompletableFuture<>();

        RakNetClientSession connection = this.rakNetClient.create(address);
        BedrockWrapperSerializer serializer = BedrockWrapperSerializers.getSerializer(connection.getProtocolVersion());
        this.session = new JavaClientSession(connection, this.eventLoopGroup.next(), serializer);
        JavaRakNetSessionListener.Client listener = new JavaRakNetSessionListener.Client(this.session,
                connection, this, future);
        connection.setListener(listener);
        connection.connect();

        return future;
    }

    public CompletableFuture<JavaPong> ping(InetSocketAddress address) {
        return this.rakNetClient.ping(address, 10, TimeUnit.SECONDS).thenApply(JavaPong::fromRakNet);
    }

    public JavaClientSession getSession() {
        return session;
    }
}
