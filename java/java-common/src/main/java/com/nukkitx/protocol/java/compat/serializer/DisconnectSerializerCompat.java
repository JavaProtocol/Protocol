package com.nukkitx.protocol.java.compat.serializer;

import com.nukkitx.protocol.java.JavaPacketHelper;
import com.nukkitx.protocol.java.JavaPacketSerializer;
import com.nukkitx.protocol.bedrock.packet.DisconnectPacket;
import io.netty.buffer.ByteBuf;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DisconnectSerializerCompat implements JavaPacketSerializer<DisconnectPacket> {
    public static final DisconnectSerializerCompat INSTANCE = new DisconnectSerializerCompat();

    @Override
    public void serialize(ByteBuf buffer, JavaPacketHelper helper, DisconnectPacket packet) {
        buffer.writeBoolean(packet.isMessageSkipped());
        if (!packet.isMessageSkipped()) {
            helper.writeString(buffer, packet.getKickMessage());
        }
    }

    @Override
    public void deserialize(ByteBuf buffer, JavaPacketHelper helper, DisconnectPacket packet) {
        packet.setMessageSkipped(buffer.readBoolean());
        if (!packet.isMessageSkipped()) {
            packet.setKickMessage(helper.readString(buffer));
        }
    }
}
