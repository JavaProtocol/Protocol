package com.nukkitx.protocol.java.data;

import com.nukkitx.nbt.NbtMap;
import lombok.Value;

@Value
public class ItemStack {
    private final int id;
    private final int amount;
    private final NbtMap nbt;
}
