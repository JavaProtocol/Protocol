package com.nukkitx.protocol.java.packet;

import com.github.steveice10.mc.protocol.data.message.Message;
import com.nukkitx.protocol.java.JavaPacket;
import com.nukkitx.protocol.java.JavaPacketType;
import com.nukkitx.protocol.java.handler.JavaPacketHandler;

public class LoginDisconnectPacket extends JavaPacket {
    private Message reason;

    @Override
    public final boolean handle(JavaPacketHandler handler) {
        return handler.handle(this);
    }

    public JavaPacketType getPacketType() {
        return JavaPacketType.LOGIN_DISCONNECT;
    }
}
