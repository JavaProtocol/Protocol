package com.nukkitx.protocol.java.packet;

import com.nukkitx.protocol.java.data.BlockFace;
import com.nukkitx.protocol.java.data.Hand;
import com.nukkitx.protocol.java.data.Position;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.nukkitx.protocol.java.JavaPacket;
import com.nukkitx.protocol.java.JavaPacketType;
import com.nukkitx.protocol.java.handler.JavaPacketHandler;

@Data
@EqualsAndHashCode(doNotUseGetters = true, callSuper = false)
public class PlayerPlaceBlockPacket extends JavaPacket {
    private Position position;
    private BlockFace face;
    private Hand hand;
    private float cursorX;
    private float cursorY;
    private float cursorZ;
    private boolean insideBlock;

    @Override
    public final boolean handle(JavaPacketHandler handler) {
        return handler.handle(this);
    }

    public JavaPacketType getPacketType() {
        return JavaPacketType.PLAYER_PLACE_BLOCK;
    }
}
