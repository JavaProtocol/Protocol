package com.nukkitx.protocol.java.compat.serializer;

import com.nukkitx.protocol.java.JavaPacketHelper;
import com.nukkitx.protocol.java.JavaPacketSerializer;
import com.nukkitx.protocol.bedrock.packet.PlayStatusPacket;
import io.netty.buffer.ByteBuf;

public class PlayStatusSerializerCompat implements JavaPacketSerializer<PlayStatusPacket> {
    public static final PlayStatusSerializerCompat INSTANCE = new PlayStatusSerializerCompat();

    @Override
    public void serialize(ByteBuf buffer, JavaPacketHelper helper, PlayStatusPacket packet) {
        buffer.writeInt(packet.getStatus().ordinal());
    }

    @Override
    public void deserialize(ByteBuf buffer, JavaPacketHelper helper, PlayStatusPacket packet) {
        packet.setStatus(PlayStatusPacket.Status.values()[buffer.readInt()]);
    }
}

