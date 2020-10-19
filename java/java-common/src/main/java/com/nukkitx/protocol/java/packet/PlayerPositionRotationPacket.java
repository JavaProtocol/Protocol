package com.nukkitx.protocol.java.packet;

import com.nukkitx.protocol.java.JavaPacket;
import com.nukkitx.protocol.java.JavaPacketType;
import com.nukkitx.protocol.java.handler.JavaPacketHandler;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(doNotUseGetters = true, callSuper = false)
public class PlayerPositionRotationPacket extends JavaPacket {
    private boolean onGround;
    private double x;
    private double y;
    private double z;
    private float yaw;
    private float pitch;

    @Override
    public final boolean handle(JavaPacketHandler handler) {
        return handler.handle(this);
    }

    public JavaPacketType getPacketType() {
        return JavaPacketType.PLAYER_POSITION_ROTATION;
    }
}
