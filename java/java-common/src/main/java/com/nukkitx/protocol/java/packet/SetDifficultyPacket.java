package com.nukkitx.protocol.java.packet;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.nukkitx.protocol.java.JavaPacket;
import com.nukkitx.protocol.java.JavaPacketType;
import com.nukkitx.protocol.java.data.Difficulty;
import com.nukkitx.protocol.java.handler.JavaPacketHandler;

@Data
@EqualsAndHashCode(doNotUseGetters = true, callSuper = false)
public class SetDifficultyPacket extends JavaPacket {
    private Difficulty difficulty;

    @Override
    public final boolean handle(JavaPacketHandler handler) {
        return handler.handle(this);
    }

    public JavaPacketType getPacketType() {
        return JavaPacketType.SET_DIFFICULTY;
    }
}
