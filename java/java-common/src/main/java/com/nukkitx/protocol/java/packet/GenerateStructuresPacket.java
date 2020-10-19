package com.nukkitx.protocol.java.packet;

import com.nukkitx.protocol.java.data.Position;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.nukkitx.protocol.java.JavaPacket;
import com.nukkitx.protocol.java.JavaPacketType;
import com.nukkitx.protocol.java.handler.JavaPacketHandler;

@Data
@EqualsAndHashCode(doNotUseGetters = true, callSuper = false)
public class GenerateStructuresPacket extends JavaPacket {
    private Position position;
    private int levels;
    private boolean keepJigsaws;

    @Override
    public final boolean handle(JavaPacketHandler handler) {
        return handler.handle(this);
    }

    public JavaPacketType getPacketType() {
        return JavaPacketType.GENERATE_STRUCTURES;
    }
}
