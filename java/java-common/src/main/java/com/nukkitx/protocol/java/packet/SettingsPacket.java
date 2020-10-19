package com.nukkitx.protocol.java.packet;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.nukkitx.protocol.java.JavaPacket;
import com.nukkitx.protocol.java.JavaPacketType;
import com.nukkitx.protocol.java.data.ChatVisibility;
import com.nukkitx.protocol.java.data.HandPreference;
import com.nukkitx.protocol.java.data.SkinPart;
import com.nukkitx.protocol.java.handler.JavaPacketHandler;

import java.util.List;

@Data
@EqualsAndHashCode(doNotUseGetters = true, callSuper = false)
public class SettingsPacket extends JavaPacket {
    private String locale;
    private int renderDistance;
    private ChatVisibility chatVisibility;
    private boolean useChatColors;
    private List<SkinPart> visibleParts;
    private HandPreference mainHand;

    @Override
    public final boolean handle(JavaPacketHandler handler) {
        return handler.handle(this);
    }

    public JavaPacketType getPacketType() {
        return JavaPacketType.SETTINGS;
    }
}
