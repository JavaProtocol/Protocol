package com.nukkitx.protocol.java.packet;

import com.nukkitx.protocol.java.data.Position;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.nukkitx.protocol.java.JavaPacket;
import com.nukkitx.protocol.java.JavaPacketType;
import com.nukkitx.protocol.java.handler.JavaPacketHandler;

@Data
@EqualsAndHashCode(doNotUseGetters = true, callSuper = false)
public class BlockNbtRequestPacket extends JavaPacket {
    private int transactionId;
    private Position position;

    @Override
    public final boolean handle(JavaPacketHandler handler) {
        return handler.handle(this);
    }

    public JavaPacketType getPacketType() {
        return JavaPacketType.BLOCK_NBT_REQUEST;
    }
}
