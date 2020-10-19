package com.nukkitx.protocol.java.packet;

import com.nukkitx.protocol.java.data.Hand;
import com.nukkitx.protocol.java.data.InteractAction;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.nukkitx.protocol.java.JavaPacket;
import com.nukkitx.protocol.java.JavaPacketType;
import com.nukkitx.protocol.java.handler.JavaPacketHandler;

@Data
@EqualsAndHashCode(doNotUseGetters = true, callSuper = false)
public class PlayerInteractEntityPacket extends JavaPacket {
    private int entityId;
    private InteractAction action;

    private float targetX;
    private float targetY;
    private float targetZ;
    private Hand hand;
    private boolean isSneaking;

    @Override
    public final boolean handle(JavaPacketHandler handler) {
        return handler.handle(this);
    }

    public JavaPacketType getPacketType() {
        return JavaPacketType.PLAYER_INTERACT_ENTITY;
    }
}
