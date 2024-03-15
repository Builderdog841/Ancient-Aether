package net.builderdog.ancient_aether.capability.player;

import net.builderdog.ancient_aether.capability.AncientAetherCapabilities;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;

public class AncientAetherPlayerProvider implements ICapabilitySerializable<CompoundTag> {
    private final AncientAetherPlayer ancientAetherPlayer;

    public AncientAetherPlayerProvider(AncientAetherPlayer aaPlayer) {
        ancientAetherPlayer = aaPlayer;
    }

    public CompoundTag serializeNBT() {
        return ancientAetherPlayer.serializeNBT();
    }

    public void deserializeNBT(CompoundTag tag) {
        ancientAetherPlayer.deserializeNBT(tag);
    }

    @SuppressWarnings("unchecked")
    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, Direction side) {
        if (cap == AncientAetherCapabilities.ANCIENT_AETHER_PLAYER_CAPABILITY) {
            return LazyOptional.of(() -> (T) ancientAetherPlayer);
        }
        return LazyOptional.empty();
    }
}