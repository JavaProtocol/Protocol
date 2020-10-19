package com.nukkitx.protocol.java.packet;

import com.github.steveice10.mc.protocol.data.game.entity.metadata.ItemStack;
import com.github.steveice10.mc.protocol.data.game.window.WindowAction;
import com.github.steveice10.mc.protocol.data.game.window.WindowActionParam;
import com.nukkitx.protocol.java.JavaPacket;
import com.nukkitx.protocol.java.JavaPacketType;
import com.nukkitx.protocol.java.handler.JavaPacketHandler;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(doNotUseGetters = true, callSuper = false)
public class WindowActionPacket extends JavaPacket {
    public static final int CLICK_OUTSIDE_NOT_HOLDING_SLOT = -999;

    private int windowId;
    private int actionId;
    private int slot;
    private ItemStack clickedItem;
    private WindowAction action;
    private WindowActionParam param;

    @Override
    public final boolean handle(JavaPacketHandler handler) {
        return handler.handle(this);
    }

    public JavaPacketType getPacketType() {
        return JavaPacketType.WINDOW_ACTION;
    }
}
