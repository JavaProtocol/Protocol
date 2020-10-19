package com.nukkitx.protocol.java.packet;

import com.github.steveice10.mc.protocol.data.game.window.CraftingBookStateType;
import com.nukkitx.protocol.java.JavaPacket;
import com.nukkitx.protocol.java.JavaPacketType;
import com.nukkitx.protocol.java.handler.JavaPacketHandler;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(doNotUseGetters = true, callSuper = false)
public class CraftingBookStatePacket extends JavaPacket {
    private CraftingBookStateType type;
    private boolean bookOpen;
    private boolean filterActive;

    @Override
    public final boolean handle(JavaPacketHandler handler) {
        return handler.handle(this);
    }

    public JavaPacketType getPacketType() {
        return JavaPacketType.CRAFTING_BOOK_STATE;
    }
}
