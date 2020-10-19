package com.nukkitx.protocol.java;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.net.InetSocketAddress;

@ParametersAreNonnullByDefault
public interface JavaServerEventHandler {

    boolean onConnectionRequest(InetSocketAddress address);

    @Nullable
    JavaPong onQuery(InetSocketAddress address);

    void onSessionCreation(JavaServerSession serverSession);

    default void onUnhandledDatagram(ChannelHandlerContext ctx, DatagramPacket packet) {
    }
}