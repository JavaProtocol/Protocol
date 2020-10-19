package com.nukkitx.protocol.java.packet;

import com.github.steveice10.mc.protocol.data.game.entity.player.PlayerState;
import com.nukkitx.protocol.java.JavaPacket;
import com.nukkitx.protocol.java.JavaPacketType;
import com.nukkitx.protocol.java.handler.JavaPacketHandler;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
