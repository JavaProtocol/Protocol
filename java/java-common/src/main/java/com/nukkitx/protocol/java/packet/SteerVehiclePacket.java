package com.nukkitx.protocol.java.packet;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.nukkitx.protocol.java.JavaPacket;
import com.nukkitx.protocol.java.JavaPacketType;
import com.nukkitx.protocol.java.handler.JavaPacketHandler;

@Data
@EqualsAndHashCode(doNotUseGetters = true, callSuper = false)
public class SteerVehiclePacket extends JavaPacket {
    private static final int FLAG_JUMP = 0x01;
    private static final int FLAG_DISMOUNT = 0x02;

    private float sideways;
    private float forward;
    private boolean jump;
    private boolean dismount;

    @Override
    public final boolean handle(JavaPacketHandler handler) {
        return handler.handle(this);
    }

    public JavaPacketType getPacketType() {
        return JavaPacketType.STEER_VEHICLE;
    }
}

