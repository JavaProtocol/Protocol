package com.nukkitx.protocol.bedrock.v361.serializer;

import com.nukkitx.protocol.bedrock.packet.ContainerClosePacket;
import com.nukkitx.protocol.serializer.PacketSerializer;
import io.netty.buffer.ByteBuf;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ContainerCloseSerializer_v361 implements PacketSerializer<ContainerClosePacket> {
    public static final ContainerCloseSerializer_v361 INSTANCE = new ContainerCloseSerializer_v361();

    @Override
    public void serialize(ByteBuf buffer, ContainerClosePacket packet) {
        buffer.writeByte(packet.getWindowId());
    }

    @Override
    public void deserialize(ByteBuf buffer, ContainerClosePacket packet) {
        packet.setWindowId(buffer.readByte());
    }
}
