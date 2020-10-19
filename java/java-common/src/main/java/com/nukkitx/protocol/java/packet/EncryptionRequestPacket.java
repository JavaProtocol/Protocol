package com.nukkitx.protocol.java.packet;

import com.nukkitx.protocol.java.JavaPacket;
import com.nukkitx.protocol.java.JavaPacketType;
import com.nukkitx.protocol.java.handler.JavaPacketHandler;

import java.security.PublicKey;

public class EncryptionRequestPacket extends JavaPacket {
    private String serverId;
    private PublicKey publicKey;
    private byte[] verifyToken;

    @Override
    public final boolean handle(JavaPacketHandler handler) {
        return handler.handle(this);
    }

    public JavaPacketType getPacketType() {
        return JavaPacketType.ENCRYPTION_REQUEST;
    }
}
