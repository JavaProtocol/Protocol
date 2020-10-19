package com.nukkitx.protocol.java;

@FunctionalInterface
public interface JavaPacketFactory<T extends BedrockPacket> {

    BedrockPacket newInstance();

    @SuppressWarnings("unchecked")
    default Class<BedrockPacket> getPacketClass() {
        return (Class<BedrockPacket>) newInstance().getClass();
    }
}
