package com.nukkitx.protocol.java.data;

import lombok.Value;

@Value
public class Position {
    private static final int POSITION_X_SIZE = 38;
    private static final int POSITION_Y_SIZE = 12;
    private static final int POSITION_Z_SIZE = 38;
    private static final int POSITION_Y_SHIFT = 0xFFF;
    private static final int POSITION_WRITE_SHIFT = 0x3FFFFFF;

    private final int x;
    private final int y;
    private final int z;
}
