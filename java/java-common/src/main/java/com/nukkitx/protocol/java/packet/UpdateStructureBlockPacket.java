package com.nukkitx.protocol.java.packet;

import com.nukkitx.protocol.java.JavaPacket;
import com.nukkitx.protocol.java.JavaPacketType;
import com.nukkitx.protocol.java.data.*;
import com.nukkitx.protocol.java.handler.JavaPacketHandler;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(doNotUseGetters = true, callSuper = false)
public class UpdateStructureBlockPacket extends JavaPacket {
    public static final int FLAG_IGNORE_ENTITIES = 0x01;
    public static final int FLAG_SHOW_AIR = 0x02;
    public static final int FLAG_SHOW_BOUNDING_BOX = 0x04;

    private Position position;
    private UpdateStructureBlockAction action;
    private UpdateStructureBlockMode mode;
    private String name;
    private Position offset;
    private Position size;
    private StructureMirror mirror;
    private StructureRotation rotation;
    private String metadata;
    private float integrity;
    private long seed;
    private boolean ignoreEntities;
    private boolean showAir;
    private boolean showBoundingBox;

    @Override
    public final boolean handle(JavaPacketHandler handler) {
        return handler.handle(this);
    }

    public JavaPacketType getPacketType() {
        return JavaPacketType.UPDATE_STRUCTURE_BLOCK;
    }
}
