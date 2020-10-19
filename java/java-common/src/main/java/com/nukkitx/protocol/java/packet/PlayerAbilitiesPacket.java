package com.nukkitx.protocol.java.packet;

import com.nukkitx.protocol.java.handler.JavaPacketHandler;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.nukkitx.protocol.java.JavaPacket;
import com.nukkitx.protocol.java.JavaPacketType;

@Data
@EqualsAndHashCode(doNotUseGetters = true, callSuper = false)
public class PlayerAbilitiesPacket extends JavaPacket {
    private static final int FLAG_FLYING = 0x02;

    private boolean flying;

    @Override
    public final boolean handle(JavaPacketHandler handler) {
        return handler.handle(this);
    }

    public JavaPacketType getPacketType() {
        return JavaPacketType.PLAYER_ABILITIES;
    }
}
