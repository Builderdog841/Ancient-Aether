package net.builderdog.ancient_aether.entity.miscellaneous;

import com.aetherteam.aether.entity.miscellaneous.SkyrootBoatBehavior;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.entity.AncientEntityTypes;
import net.builderdog.ancient_aether.item.AncientItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class AncientBoat extends Boat implements SkyrootBoatBehavior {
    private static final EntityDataAccessor<Integer> WOOD_TYPE = SynchedEntityData.defineId(AncientBoat.class, EntityDataSerializers.INT);

    public AncientBoat(EntityType<? extends Boat> type, Level level) {
        super(type, level);
        blocksBuilding = true;
    }

    public AncientBoat(Level level, double x, double y, double z) {
        this(AncientEntityTypes.BOAT.get(), level);
        setPos(x, y, z);
        xo = x;
        yo = y;
        zo = z;
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(WOOD_TYPE, 0);
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag pCompound) {
        if (pCompound.contains("Type", 8)) {
            setWoodType(Type.byName(pCompound.getString("Type")));
        }
    }

    @Override
    protected void addAdditionalSaveData(@NotNull CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putString("Type", getWoodType().getName());
    }

    public Type getWoodType() {
        return Type.byId(entityData.get(WOOD_TYPE));
    }

    public void setWoodType(Type type) {
        entityData.set(WOOD_TYPE, type.ordinal());
    }

    @Override
    public @NotNull Item getDropItem() {
        return getWoodType().getItem().get();
    }

    @Override
    public @NotNull Packet<ClientGamePacketListener> getAddEntityPacket() {
        return new ClientboundAddEntityPacket(this);
    }

    public enum Type {
        HIGHSPROOT("highsproot", AncientItems.HIGHSPROOT_BOAT, AncientItems.HIGHSPROOT_CHEST_BOAT),
        SAKURA("sakura", AncientItems.SAKURA_BOAT, AncientItems.SAKURA_CHEST_BOAT);

        private final String name;
        private final Supplier<Item> item;
        private final Supplier<Item> chestItem;

        Type(String name, Supplier<Item> boatItem, Supplier<Item> chestBoatItem) {
            this.name = name;
            this.item = boatItem;
            this.chestItem = chestBoatItem;
        }

        public ResourceLocation getTexture(boolean hasChest) {
            if (hasChest) {
                return new ResourceLocation(AncientAether.MODID, "textures/entity/miscellaneous/chest_boat/" + name + ".png");
            }
            return new ResourceLocation(AncientAether.MODID, "textures/entity/miscellaneous/boat/" + name + ".png");
        }

        public String getModelLocation() {
            return "boat/" + name;
        }

        public String getChestModelLocation() {
            return "chest_boat/" + name;
        }

        public String getName() {
            return name;
        }

        public Supplier<Item> getItem() {
            return item;
        }

        public Supplier<Item> getChestItem() {
            return chestItem;
        }

        public static Type byId(int id) {
            Type[] values = values();
            if (id < 0 || id >= values.length) {
                id = 0;
            }

            return values[id];
        }

        public static Type byName(String name) {
            Type[] values = values();

            for (Type value : values) {
                if (value.getName().equals(name)) {
                    return value;
                }
            }

            return values[0];
        }
    }
}