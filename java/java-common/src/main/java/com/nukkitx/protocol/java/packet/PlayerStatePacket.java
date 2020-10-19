package com.nukkitx.protocol.java.packet;

import com.nukkitx.protocol.java.data.PlayerState;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.nukkitx.protocol.java.JavaPacket;
import com.nukkitx.protocol.java.JavaPacketType;
import com.nukkitx.protocol.java.handler.JavaPacketHandler;

@Data
@EqualsAndHashCode(doNotUseGetters = true, callSuper = false)
public class PlayerStatePacket extends JavaPacket {
    private int entityId;
    private PlayerState state;
    private int jumpBoost;

    @Override
    public final boolean handle(JavaPacketHandler handler) {
        return handler.handle(this);
    }

    public JavaPacketType getPacketType() {
        return JavaPacketType.PLAYER_STATE;
    }
}
