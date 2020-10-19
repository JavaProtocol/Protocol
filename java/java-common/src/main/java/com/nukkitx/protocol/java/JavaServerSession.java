package com.nukkitx.protocol.java;

import com.nukkitx.network.raknet.RakNetSession;
import com.nukkitx.protocol.MinecraftServerSession;
import com.nukkitx.protocol.bedrock.packet.DisconnectPacket;
import com.nukkitx.protocol.java.wrapper.BedrockWrapperSerializer;
import io.netty.channel.EventLoop;

import javax.annotation.Nullable;

public class JavaServerSession extends JavaSession implements MinecraftServerSession<BedrockPacket> {

    public JavaServerSession(RakNetSession connection, EventLoop eventLoop, BedrockWrapperSerializer serializer) {
        super(connection, eventLoop, serializer);
    }

    @Override
    public void disconnect() {
        this.disconnect(null, true);
    }

    public void disconnect(@Nullable String reason) {
        this.disconnect(reason, false);
    }

    public void disconnect(@Nullable String reason, boolean hideReason) {
        this.checkForClosed();

        DisconnectPacket packet = new DisconnectPacket();
        if (reason == null || hideReason) {
            packet.setMessageSkipped(true);
            reason = "disconnect.disconnected";
        }
        packet.setKickMessage(reason);
        this.sendPacketImmediately(packet);
    }
}
