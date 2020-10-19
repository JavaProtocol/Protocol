package com.nukkitx.protocol.java.packet;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.nukkitx.protocol.java.JavaPacket;
import com.nukkitx.protocol.java.JavaPacketType;
import com.nukkitx.protocol.java.data.ResourcePackStatus;
import com.nukkitx.protocol.java.handler.JavaPacketHandler;

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
