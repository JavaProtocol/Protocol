package com.nukkitx.protocol.java.compat;

import com.nukkitx.protocol.java.JavaPacketCodec;
import com.nukkitx.protocol.java.compat.serializer.DisconnectSerializerCompat;
import com.nukkitx.protocol.java.compat.serializer.LoginSerializerCompat;
import com.nukkitx.protocol.java.compat.serializer.PlayStatusSerializerCompat;
import com.nukkitx.protocol.bedrock.packet.DisconnectPacket;
import com.nukkitx.protocol.bedrock.packet.LoginPacket;
import com.nukkitx.protocol.bedrock.packet.PlayStatusPacket;

public class BedrockCompat {
    /**
     * This is for servers when figuring out the protocol of a client joining.
     */
    public static JavaPacketCodec COMPAT_CODEC = JavaPacketCodec.builder()
            .helper(NoopBedrockPacketHelper.INSTANCE)
            .registerPacket(LoginPacket.class, LoginSerializerCompat.INSTANCE, 1)
            .registerPacket(PlayStatusPacket.class, PlayStatusSerializerCompat.INSTANCE, 2)
            .registerPacket(DisconnectPacket.class, DisconnectSerializerCompat.INSTANCE, 5)
            .protocolVersion(0)
            .minecraftVersion("0.0.0")
            .build();
}
