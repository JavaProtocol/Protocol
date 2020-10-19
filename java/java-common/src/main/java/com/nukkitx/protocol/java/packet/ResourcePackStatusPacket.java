package com.nukkitx.protocol.java.packet;

import com.github.steveice10.mc.protocol.data.game.ResourcePackStatus;
import com.nukkitx.protocol.java.JavaPacket;
import com.nukkitx.protocol.java.JavaPacketType;
import com.nukkitx.protocol.java.handler.JavaPacketHandler;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(doNotUseGetters = true, callSuper = false)
public class ResourcePackStatusPacket extends JavaPacket {
    private ResourcePackStatus status;

    @Override
    public final boolean handle(JavaPacketHandler handler) {
        return handler.handle(this);
    }

    public JavaPacketType getPacketType() {
        return JavaPacketType.RESOURCE_PACK_STATUS;
    }
}
