package net.builderdog.ancient_aether.capability.player;

import com.aetherteam.aether.capability.CapabilitySyncing;
import com.aetherteam.aether.network.AetherPacket;
import com.aetherteam.aether.network.packet.AetherPlayerSyncPacket;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;

public class AncientAetherPlayerCapability extends CapabilitySyncing implements AncientAetherPlayer {
    private final Player player;
    private int gravititeDartCount;


    public AncientAetherPlayerCapability(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public CompoundTag serializeNBT() {
        return new CompoundTag();
    }

    public void deserializeNBT(CompoundTag nbt) {
    }

    public CompoundTag serializeSynchableNBT() {
        CompoundTag tag = new CompoundTag();
        tag.putInt("GravititeDartCount_Syncing", getGravititeDartCount());
        return tag;
    }

    public void deserializeSynchableNBT(CompoundTag tag) {
        if (tag.contains("GravititeDartCount_Syncing")) {
            setGravititeDartCount(tag.getInt("GravititeDartCount_Syncing"));
        }

    }

    public void setGravititeDartCount(int count) {
        this.markDirty(true);
        this.gravititeDartCount = count;
    }

    public int getGravititeDartCount() {
        return gravititeDartCount;
    }

    public AetherPacket getSyncPacket(CompoundTag tag) {
        return new AetherPlayerSyncPacket(getPlayer().getId(), tag);
    }
}
