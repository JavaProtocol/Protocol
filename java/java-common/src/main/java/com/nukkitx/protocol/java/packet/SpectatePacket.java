package com.nukkitx.protocol.java.packet;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.nukkitx.protocol.java.JavaPacket;
import com.nukkitx.protocol.java.JavaPacketType;
import com.nukkitx.protocol.java.handler.JavaPacketHandler;

import java.util.UUID;

@Data
@EqualsAndHashCode(doNotUseGetters = true, callSuper = false)
public class SpectatePacket extends JavaPacket {
    private UUID target;

    @Override
    public final boolean handle(JavaPacketHandler handler) {
        return handler.handle(this);
    }

    public JavaPacketType getPacketType() {
        return JavaPacketType.SPECTATE;
    }
}
