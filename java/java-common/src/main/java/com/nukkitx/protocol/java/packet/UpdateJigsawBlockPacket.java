package com.nukkitx.protocol.java.packet;

import com.github.steveice10.mc.protocol.data.game.entity.metadata.Position;
import com.nukkitx.protocol.java.JavaPacket;
import com.nukkitx.protocol.java.JavaPacketType;
import com.nukkitx.protocol.java.handler.JavaPacketHandler;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(doNotUseGetters = true, callSuper = false)
public class UpdateJigsawBlockPacket extends JavaPacket {
    private Position position;
    private String name;
    private String target;
    private String pool;
    private String finalState;
    private String jointType;

    @Override
    public final boolean handle(JavaPacketHandler handler) {
        return handler.handle(this);
    }

    public JavaPacketType getPacketType() {
        return JavaPacketType.UPDDATE_JIGSAW_BLOCK;
    }
}
