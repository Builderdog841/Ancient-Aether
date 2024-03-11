package net.builderdog.ancient_aether.entity.miscellaneous;

import net.builderdog.ancient_aether.entity.AncientAetherEntityTypes;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.HasCustomInventoryScreen;
import net.minecraft.world.entity.SlotAccess;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.ContainerEntity;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class AncientAetherChestBoatEntity extends AncientAetherBoatEntity implements HasCustomInventoryScreen, ContainerEntity {
    private static final int CONTAINER_SIZE = 27;
    private NonNullList<ItemStack> itemStacks = NonNullList.withSize(CONTAINER_SIZE, ItemStack.EMPTY);
    @Nullable
    private ResourceLocation lootTable;
    private long lootTableSeed;

    public AncientAetherChestBoatEntity(EntityType<? extends Boat> entityType, Level level) {
        super(entityType, level);
    }

    public AncientAetherChestBoatEntity(Level level, double x, double y, double z) {
        this(AncientAetherEntityTypes.CHEST_BOAT.get(), level);
        setPos(x, y, z);
        xo = x;
        yo = y;
        zo = z;
    }

    @Override
    protected float getSinglePassengerXOffset() {
        return 0.15F;
    }

    @Override
    protected int getMaxPassengers() {
        return 1;
    }

    @Override
    protected void addAdditionalSaveData(@NotNull CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        addChestVehicleSaveData(pCompound);
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        readChestVehicleSaveData(pCompound);
    }

    @Override
    public void destroy(@NotNull DamageSource source) {
        super.destroy(source);
        chestVehicleDestroyed(source, level(), this);
    }

    @Override
    public void remove(@NotNull RemovalReason pReason) {
        if (!level().isClientSide && pReason.shouldDestroy()) {
            Containers.dropContents(level(), this, this);
        }
        super.remove(pReason);
    }

    @Override
    public @NotNull InteractionResult interact(@NotNull Player pPlayer, @NotNull InteractionHand pHand) {
        return canAddPassenger(pPlayer) && !pPlayer.isSecondaryUseActive() ? super.interact(pPlayer, pHand) : this.interactWithContainerVehicle(pPlayer);
    }

    @Override
    public void openCustomInventoryScreen(Player player) {
        player.openMenu(this);
        if (!player.level().isClientSide) {
            this.gameEvent(GameEvent.CONTAINER_OPEN, player);
            PiglinAi.angerNearbyPiglins(player, true);
        }

    }

    @Override
    public @NotNull Item getDropItem() {
        return getWoodType().getChestItem().get();
    }

    @Override
    public void clearContent() {
        clearChestVehicleContent();
    }

    @Override
    public int getContainerSize() {
        return 27;
    }

    @Override
    public @NotNull ItemStack getItem(int pIndex) {
        return getChestVehicleItem(pIndex);
    }

    @Override
    public @NotNull ItemStack removeItem(int pIndex, int pCount) {
        return removeChestVehicleItem(pIndex, pCount);
    }

    @Override
    public @NotNull ItemStack removeItemNoUpdate(int pIndex) {
        return removeChestVehicleItemNoUpdate(pIndex);
    }

    @Override
    public void setItem(int pIndex, @NotNull ItemStack pStack) {
        setChestVehicleItem(pIndex, pStack);
    }

    @Override
    public @NotNull SlotAccess getSlot(int pSlot) {
        return getChestVehicleSlot(pSlot);
    }

    @Override
    public void setChanged() {
    }

    @Override
    public boolean stillValid(@NotNull Player pPlayer) {
        return isChestVehicleStillValid(pPlayer);
    }

    @Nullable
    public AbstractContainerMenu createMenu(int pContainerId, @NotNull Inventory pInventory, @NotNull Player pPlayer) {
        if (lootTable != null && pPlayer.isSpectator()) {
            return null;
        } else {
            unpackLootTable(pInventory.player);
            return ChestMenu.threeRows(pContainerId, pInventory, this);
        }
    }

    public void unpackLootTable(@Nullable Player player) {
        unpackChestVehicleLootTable(player);
    }

    @Nullable
    public ResourceLocation getLootTable() {
        return lootTable;
    }

    @Override
    public void setLootTable(@Nullable ResourceLocation location) {
        lootTable = location;
    }

    @Override
    public long getLootTableSeed() {
        return lootTableSeed;
    }

    @Override
    public void setLootTableSeed(long seed) {
        lootTableSeed = seed;
    }

    @Override
    public @NotNull NonNullList<ItemStack> getItemStacks() {
        return itemStacks;
    }

    @Override
    public void clearItemStacks() {
        itemStacks = NonNullList.withSize(getContainerSize(), ItemStack.EMPTY);
    }
}