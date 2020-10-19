package com.nukkitx.protocol.java.handler;

import com.nukkitx.protocol.java.packet.*;
import com.nukkitx.protocol.PacketHandler;

public interface JavaPacketHandler extends PacketHandler {

    default boolean handle(AdvancementTabPacket packet) {
        return false;
    }

    default boolean handle(ChatPacket packet) {
        return false;
    }

    default boolean handle(ClickWindowButtonPacket packet) {
        return false;
    }

    default boolean handle(CloseWindowPacket packet) {
        return false;
    }

    default boolean handle(ConfirmTransactionPacket packet) {
        return false;
    }

    default boolean handle(CraftingBookStatePacket packet) {
        return false;
    }

    default boolean handle(CreativeInventoryActionPacket packet) {
        return false;
    }

    default boolean handle(DisplayedRecipePacket packet) {
        return false;
    }

    default boolean handle(EditBookPacket packet) {
        return false;
    }

    default boolean handle(HandshakePacket packet) {
        return false;
    }

    default boolean handle(KeepAlivePacket packet) {
        return false;
    }

    default boolean handle(LockDifficultyPacket packet) {
        return false;
    }

    default boolean handle(MoveItemToHotbarPacket packet) {
        return false;
    }

    default boolean handle(PlayerAbilitiesPacket packet) {
        return false;
    }

    default boolean handle(PlayerActionPacket packet) {
        return false;
    }

    default boolean handle(PlayerChangeHeldItemPacket packet) {
        return false;
    }

    default boolean handle(PlayerInteractEntityPacket packet) {
        return false;
    }

    default boolean handle(PlayerMovementPacket packet) {
        return false;
    }

    default boolean handle(PlayerPlaceBlockPacket packet) {
        return false;
    }

    default boolean handle(PlayerPositionPacket packet) {
        return false;
    }

    default boolean handle(PlayerPositionRotationPacket packet) {
        return false;
    }

    default boolean handle(PlayerRotationPacket packet) {
        return false;
    }

    default boolean handle(PlayerStatePacket packet) {
        return false;
    }

    default boolean handle(PlayerSwingArmPacket packet) {
        return false;
    }

    default boolean handle(PlayerUseItemPacket packet) {
        return false;
    }

    default boolean handle(PluginMessagePacket packet) {
        return false;
    }

    default boolean handle(PrepareCraftingGridPacket packet) {
        return false;
    }

    default boolean handle(RenameItemPacket packet) {
        return false;
    }

    default boolean handle(RequestPacket packet) {
        return false;
    }

    default boolean handle(ResourcePackStatusPacket packet) {
        return false;
    }

    default boolean handle(SelectTradePacket packet) {
        return false;
    }

    default boolean handle(SetBeaconEffectPacket packet) {
        return false;
    }

    default boolean handle(SetDifficultyPacket packet) {
        return false;
    }

    default boolean handle(SettingsPacket packet) {
        return false;
    }

    default boolean handle(TabCompletePacket packet) {
        return false;
    }

    default boolean handle(UpdateCommandBlockPacket packet) {
        return false;
    }

    default boolean handle(UpdateCommandBlockMinecartPacket packet) {
        return false;
    }

    default boolean handle(UpdateJigsawBlockPacket packet) {
        return false;
    }

    default boolean handle(UpdateStructureBlockPacket packet) {
        return false;
    }

    default boolean handle(WindowActionPacket packet) {
        return false;
    }
}
