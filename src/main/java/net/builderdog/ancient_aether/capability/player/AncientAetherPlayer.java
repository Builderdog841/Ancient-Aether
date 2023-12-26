package net.builderdog.ancient_aether.capability.player;

import com.aetherteam.nitrogen.capability.INBTSynchable;
import net.builderdog.ancient_aether.capability.AncientAetherCapabilities;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.util.LazyOptional;

public interface AncientAetherPlayer extends INBTSynchable<CompoundTag> {
    Player getPlayer();

    static LazyOptional<AncientAetherPlayer> get(Player player) {
        return player.getCapability(AncientAetherCapabilities.ANCIENT_AETHER_PLAYER_CAPABILITY);
    }
    int getWingRotation();
    int getWingRotationO();
    int getGravititeDartCount();
    void setGravititeDartCount(int var1);
    void onUpdate();
}
