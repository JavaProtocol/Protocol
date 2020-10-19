package com.nukkitx.protocol.java.packet;

import com.nukkitx.protocol.java.data.Position;
import com.nukkitx.protocol.java.handler.JavaPacketHandler;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.nukkitx.protocol.java.JavaPacket;
import com.nukkitx.protocol.java.JavaPacketType;
import com.nukkitx.protocol.java.data.BlockFace;
import com.nukkitx.protocol.java.data.PlayerAction;

@Data
@EqualsAndHashCode(doNotUseGetters = true, callSuper = false)
public class PlayerActionPacket extends JavaPacket {
    private PlayerAction action;
    private Position position;
    private BlockFace blockFace;

    @Override
    public final boolean handle(JavaPacketHandler handler) {
        return handler.handle(this);
    }

    public JavaPacketType getPacketType() {
        return JavaPacketType.PLAYER_ACTION;
    }
}
