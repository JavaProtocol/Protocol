package com.nukkitx.protocol.bedrock.v354.serializer;

import com.nukkitx.protocol.bedrock.packet.SimpleEventPacket;
import com.nukkitx.protocol.serializer.PacketSerializer;
import io.netty.buffer.ByteBuf;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SimpleEventSerializer_v354 implements PacketSerializer<SimpleEventPacket> {
    public static final SimpleEventSerializer_v354 INSTANCE = new SimpleEventSerializer_v354();


    @Override
    public void serialize(ByteBuf buffer, SimpleEventPacket packet) {
        buffer.writeShortLE(packet.getEvent());
    }

    @Override
    public void deserialize(ByteBuf buffer, SimpleEventPacket packet) {
        packet.setEvent(buffer.readShortLE());
    }
}
