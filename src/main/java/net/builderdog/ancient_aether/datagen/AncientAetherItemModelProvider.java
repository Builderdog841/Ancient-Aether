package net.builderdog.ancient_aether.datagen;

import com.aetherteam.aether.block.AetherBlocks;
import com.aetherteam.aether.data.providers.AetherItemModelProvider;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.builderdog.ancient_aether.item.AncientAetherItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AncientAetherItemModelProvider extends AetherItemModelProvider {
    public AncientAetherItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, AncientAether.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        //Food
        simpleItem(AncientAetherItems.AECHOR_ICE_CREAM_BUCKET);
        simpleItem(AncientAetherItems.RAW_BUFFALO_RIBS);
        simpleItem(AncientAetherItems.COOKED_BUFFALO_RIBS);
        simpleItem(AncientAetherItems.BUFFALO_RIB);

        //Boats
        item(AncientAetherItems.HIGHSPROOT_BOAT.get(), "");
        item(AncientAetherItems.HIGHSPROOT_CHEST_BOAT.get(), "");
        item(AncientAetherItems.SAKURA_BOAT.get(), "");
        item(AncientAetherItems.SAKURA_CHEST_BOAT.get(), "");

        //Spawn Eggs
        eggItem(AncientAetherItems.HIGHLAND_BUFFALO_SPAWN_EGG.get());
        eggItem(AncientAetherItems.ROOTHYRN_SPAWN_EGG.get());
        eggItem(AncientAetherItems.LEAPING_SENTRY_SPAWN_EGG.get());

        moaEggItem(AncientAetherItems.SAKURA_MOA_EGG.get(), "");

        //Music Discs
        simpleItem(AncientAetherItems.MUSIC_DISC_LABYRINTHS_VENGEANCE_BUILDERDOG_REMIX);

        //Dungeon Loot
        handheldItem(AncientAetherItems.ANCIENT_SWORD.get(), "");

        //Blocks
        itemBlock(AncientAetherBlocks.HIGHSPROOT_STAIRS.get());
        itemBlock(AncientAetherBlocks.HIGHSPROOT_SLAB.get());
        itemFence(AncientAetherBlocks.HIGHSPROOT_FENCE.get(), AncientAetherBlocks.HIGHSPROOT_PLANKS.get(), "");
        itemBlock(AncientAetherBlocks.HIGHSPROOT_FENCE_GATE.get());
        item(AncientAetherBlocks.HIGHSPROOT_DOOR.get().asItem(), "");
        itemBlock(AncientAetherBlocks.HIGHSPROOT_TRAPDOOR.get(), "_bottom");
        itemButton(AncientAetherBlocks.HIGHSPROOT_BUTTON.get(), AncientAetherBlocks.HIGHSPROOT_PLANKS.get(), "");
        itemBlock(AncientAetherBlocks.HIGHSPROOT_PRESSURE_PLATE.get());

        itemBlock(AncientAetherBlocks.SAKURA_STAIRS.get());
        itemBlock(AncientAetherBlocks.SAKURA_SLAB.get());
        itemFence(AncientAetherBlocks.SAKURA_FENCE.get(), AncientAetherBlocks.SAKURA_PLANKS.get(), "");
        itemBlock(AncientAetherBlocks.SAKURA_FENCE_GATE.get());
        item(AncientAetherBlocks.SAKURA_DOOR.get().asItem(), "");
        itemBlock(AncientAetherBlocks.SAKURA_TRAPDOOR.get(), "_bottom");
        itemButton(AncientAetherBlocks.SAKURA_BUTTON.get(), AncientAetherBlocks.SAKURA_PLANKS.get(), "");
        itemBlock(AncientAetherBlocks.SAKURA_PRESSURE_PLATE.get());

        itemBlock(AncientAetherBlocks.QUICKSOIL_BRICK_STAIRS.get());
        itemBlock(AncientAetherBlocks.QUICKSOIL_BRICK_SLAB.get());
        itemWallBlock((Block) AncientAetherBlocks.QUICKSOIL_BRICK_WALL.get(), (Block)AncientAetherBlocks.QUICKSOIL_BRICKS.get(), "");

        item(AncientAetherBlocks.HOLYSTONE_LANTERN.get().asItem(), "");
        item(AncientAetherBlocks.SENTRY_LANTERN.get().asItem(), "");
        item(AncientAetherBlocks.ANGELIC_LANTERN.get().asItem(), "");
        item(AncientAetherBlocks.HELLFIRE_LANTERN.get().asItem(), "");
        item(AncientAetherBlocks.GALE_LANTERN.get().asItem(), "");

        item(AncientAetherBlocks.HIGHSPROOT_SIGN.get().asItem(), "");
        item(AncientAetherBlocks.SAKURA_SIGN.get().asItem(), "");

        itemBlockFlat(AncientAetherBlocks.HIGHSPROOT_SAPLING.get(), "");
        itemBlockFlat(AncientAetherBlocks.SAKURA_SAPLING.get(), "");
        itemBlockFlat(AncientAetherBlocks.SAKURA_BLOSSOMS.get(), "");
        itemBlockFlat(AncientAetherBlocks.TRAPPED_SAKURA_BLOSSOMS.get(), "");
        itemBlockFlat(AncientAetherBlocks.EDELWEISS.get(), "");
        itemBlockFlat(AncientAetherBlocks.HIGHLAND_TULIP.get(), "");
    }

    public String itemName(Item item) {
        ResourceLocation location = ForgeRegistries.ITEMS.getKey(item);
        if (location != null) {
            return location.getPath();
        } else {
            throw new IllegalStateException("Unknown item: " + item.toString());
        }
    }
    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(AncientAether.MOD_ID,"item/" + item.getId().getPath()));
    }
        public void eggItem(Item item) {
            this.withExistingParent(this.itemName(item), this.mcLoc("item/template_spawn_egg"));
    }
}
