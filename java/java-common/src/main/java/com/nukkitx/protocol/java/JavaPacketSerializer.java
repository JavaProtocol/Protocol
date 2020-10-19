package com.nukkitx.protocol.java;

import com.nukkitx.protocol.serializer.PacketSerializer;

public interface JavaPacketSerializer<T extends BedrockPacket> extends PacketSerializer<T, BedrockPacketHelper> {
}
