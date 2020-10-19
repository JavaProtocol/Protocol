package com.nukkitx.protocol.java.packet;

import com.nukkitx.protocol.java.data.AdvancementTabAction;
import com.nukkitx.protocol.java.data.Hand;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.nukkitx.protocol.java.JavaPacket;
import com.nukkitx.protocol.java.JavaPacketType;
import com.nukkitx.protocol.java.handler.JavaPacketHandler;

@Data
@EqualsAndHashCode(doNotUseGetters = true, callSuper = false)
public class AdvancementTabPacket extends JavaPacket {
    private AdvancementTabAction action;
    private String tabId;

    @Override
    public final boolean handle(JavaPacketHandler handler) {
        return handler.handle(this);
    }

    public JavaPacketType getPacketType() {
        return JavaPacketType.ADVANCEMENT_TAB;
    }
}
