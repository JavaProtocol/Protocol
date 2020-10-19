package com.nukkitx.protocol.java;

import com.nukkitx.protocol.java.handler.JavaPacketHandler;
import com.nukkitx.protocol.MinecraftPacket;
import lombok.Data;

@Data
public abstract class JavaPacket implements MinecraftPacket {
    private int packetId;
    private int senderId;
    private int clientId;

    public abstract boolean handle(JavaPacketHandler handler);

    public abstract JavaPacketType getPacketType();
}
