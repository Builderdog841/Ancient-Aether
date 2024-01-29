package net.builderdog.ancient_aether.data.generators;

import com.aetherteam.aether.data.providers.AetherItemModelProvider;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.builderdog.ancient_aether.item.AncientAetherItems;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AncientAetherItemModelData extends AetherItemModelProvider {
    public AncientAetherItemModelData(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, AncientAether.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        //Food
        simpleItem(AncientAetherItems.GRAPES);
        simpleItem(AncientAetherItems.FESTIVE_GUMMY_SWET);

        //Accessories
        simpleItem(AncientAetherItems.ANCIENT_RING);
        simpleItem(AncientAetherItems.ANCIENT_PENDANT);
        simpleItem(AncientAetherItems.HEALTH_RING);
        simpleItem(AncientAetherItems.HEALTH_PENDANT);
        simpleItem(AncientAetherItems.HERMES_RING);
        simpleItem(AncientAetherItems.HERMES_PENDANT);
        simpleItem(AncientAetherItems.ARKENIUM_RING);
        simpleItem(AncientAetherItems.ARKENIUM_PENDANT);
        simpleItem(AncientAetherItems.VALKYRUM_RING);
        simpleItem(AncientAetherItems.VALKYRUM_PENDANT);
        simpleItem(AncientAetherItems.STRENGTH_STONE);
        simpleItem(AncientAetherItems.PINK_CAPE);

        //Materials
        simpleItem(AncientAetherItems.VALKYRUM);

        //Boats
        item(AncientAetherItems.HIGHSPROOT_BOAT.get(), "");
        item(AncientAetherItems.HIGHSPROOT_CHEST_BOAT.get(), "");
        item(AncientAetherItems.SAKURA_BOAT.get(), "");
        item(AncientAetherItems.SAKURA_CHEST_BOAT.get(), "");

        //Moa Eggs
        untintedMoaEggItem(AncientAetherItems.TURQUOISE_MOA_EGG.get());
        untintedMoaEggItem(AncientAetherItems.TEAL_MOA_EGG.get());
        untintedMoaEggItem(AncientAetherItems.SKY_BLUE_MOA_EGG.get());
        untintedMoaEggItem(AncientAetherItems.LAVENDER_MOA_EGG.get());
        untintedMoaEggItem(AncientAetherItems.SAKURA_MOA_EGG.get());
        untintedMoaEggItem(AncientAetherItems.VIOLET_MOA_EGG.get());
        untintedMoaEggItem(AncientAetherItems.BURGUNDY_MOA_EGG.get());

        //Spawn Eggs
        eggItem(AncientAetherItems.HIGHLAND_BUFFALO_SPAWN_EGG.get());
        eggItem(AncientAetherItems.ROOTHYRN_SPAWN_EGG.get());
        eggItem(AncientAetherItems.AERONAUTIC_LEAPER_SPAWN_EGG.get());
        eggItem(AncientAetherItems.ANCIENT_GUARDIAN_SPAWN_EGG.get());
        eggItem(AncientAetherItems.FESTIVE_SWET_SPAWN_EGG.get());

        //Armor Trims
        item(AncientAetherItems.WYND_ARMOR_TRIM_SMITHING_TEMPLATE.get(), "");
        item(AncientAetherItems.WHALE_ARMOR_TRIM_SMITHING_TEMPLATE.get(), "");
        item(AncientAetherItems.ASCENDED_ARMOR_TRIM_SMITHING_TEMPLATE.get(), "");
        item(AncientAetherItems.MYSTERIOUS_ARMOR_TRIM_SMITHING_TEMPLATE.get(), "");
        item(AncientAetherItems.MECHANICAL_ARMOR_TRIM_SMITHING_TEMPLATE.get(), "");
        item(AncientAetherItems.MOSAIC_ARMOR_TRIM_SMITHING_TEMPLATE.get(), "");
        item(AncientAetherItems.ROYAL_ARMOR_TRIM_SMITHING_TEMPLATE.get(), "");
        item(AncientAetherItems.SOLAR_ARMOR_TRIM_SMITHING_TEMPLATE.get(), "");
        item(AncientAetherItems.ANCIENT_ARMOR_TRIM_SMITHING_TEMPLATE.get(), "");

        //Equipment
        handheldItem(AncientAetherItems.VALKYRUM_SWORD.get(), "");
        handheldItem(AncientAetherItems.VALKYRUM_LANCE.get(), "");
        handheldItem(AncientAetherItems.VALKYRUM_PICKAXE.get(), "");
        handheldItem(AncientAetherItems.VALKYRUM_AXE.get(), "");
        handheldItem(AncientAetherItems.VALKYRUM_SHOVEL.get(), "");
        handheldItem(AncientAetherItems.VALKYRUM_HOE.get(), "");
        handheldItem(AncientAetherItems.ANCIENT_SWORD.get(), "");
        handheldItem(AncientAetherItems.ARKZENUS_PICKAXE.get(), "");
        simpleItem(AncientAetherItems.AERONAUTIC_DART_SHOOTER);

        //Armor
        helmetItem(AncientAetherItems.VALKYRUM_HELMET.get(), "");
        chestplateItem(AncientAetherItems.VALKYRUM_CHESTPLATE.get(), "");
        leggingsItem(AncientAetherItems.VALKYRUM_LEGGINGS.get(), "");
        bootsItem(AncientAetherItems.VALKYRUM_BOOTS.get(), "");
        glovesItem(AncientAetherItems.VALKYRUM_GLOVES.get(), "");

        //|--------------Blocks--------------|

        //Highsproot
        itemBlock(AncientAetherBlocks.HIGHSPROOT_STAIRS.get());
        itemBlock(AncientAetherBlocks.HIGHSPROOT_SLAB.get());
        itemFence(AncientAetherBlocks.HIGHSPROOT_FENCE.get(), AncientAetherBlocks.HIGHSPROOT_PLANKS.get(), "");
        itemBlock(AncientAetherBlocks.HIGHSPROOT_FENCE_GATE.get());
        item(AncientAetherBlocks.HIGHSPROOT_DOOR.get().asItem(), "");
        itemBlock(AncientAetherBlocks.HIGHSPROOT_TRAPDOOR.get(), "_bottom");
        itemButton(AncientAetherBlocks.HIGHSPROOT_BUTTON.get(), AncientAetherBlocks.HIGHSPROOT_PLANKS.get(), "");
        itemBlock(AncientAetherBlocks.HIGHSPROOT_PRESSURE_PLATE.get());
        item(AncientAetherBlocks.HIGHSPROOT_SIGN.get().asItem(), "");
        item(AncientAetherBlocks.HIGHSPROOT_HANGING_SIGN.get().asItem(), "");
        itemBlock(AncientAetherBlocks.HIGHSPROOT_BOOKSHELF.get());
        itemLogWallBlock(AncientAetherBlocks.HIGHSPROOT_LOG_WALL.get(), AncientAetherBlocks.HIGHSPROOT_LOG.get(), "", "ancient_aether");
        itemLogWallBlock(AncientAetherBlocks.STRIPPED_HIGHSPROOT_LOG_WALL.get(), AncientAetherBlocks.STRIPPED_HIGHSPROOT_LOG.get(), "", "ancient_aether");
        itemWoodWallBlock(AncientAetherBlocks.HIGHSPROOT_WOOD_WALL.get(), AncientAetherBlocks.HIGHSPROOT_LOG.get(), "", "ancient_aether");
        itemWoodWallBlock(AncientAetherBlocks.STRIPPED_HIGHSPROOT_WOOD_WALL.get(), AncientAetherBlocks.STRIPPED_HIGHSPROOT_LOG.get(), "", "ancient_aether");

        //Sakura
        itemBlock(AncientAetherBlocks.SAKURA_STAIRS.get());
        itemBlock(AncientAetherBlocks.SAKURA_SLAB.get());
        itemFence(AncientAetherBlocks.SAKURA_FENCE.get(), AncientAetherBlocks.SAKURA_PLANKS.get(), "");
        itemBlock(AncientAetherBlocks.SAKURA_FENCE_GATE.get());
        item(AncientAetherBlocks.SAKURA_DOOR.get().asItem(), "");
        itemBlock(AncientAetherBlocks.SAKURA_TRAPDOOR.get(), "_bottom");
        itemButton(AncientAetherBlocks.SAKURA_BUTTON.get(), AncientAetherBlocks.SAKURA_PLANKS.get(), "");
        itemBlock(AncientAetherBlocks.SAKURA_PRESSURE_PLATE.get());
        item(AncientAetherBlocks.SAKURA_SIGN.get().asItem(), "");
        item(AncientAetherBlocks.SAKURA_HANGING_SIGN.get().asItem(), "");
        itemBlock(AncientAetherBlocks.SAKURA_BOOKSHELF.get());
        itemLogWallBlock(AncientAetherBlocks.SAKURA_LOG_WALL.get(), AncientAetherBlocks.SAKURA_LOG.get(), "", "ancient_aether");
        itemLogWallBlock(AncientAetherBlocks.STRIPPED_SAKURA_LOG_WALL.get(), AncientAetherBlocks.STRIPPED_SAKURA_LOG.get(), "", "ancient_aether");
        itemWoodWallBlock(AncientAetherBlocks.SAKURA_WOOD_WALL.get(), AncientAetherBlocks.SAKURA_LOG.get(), "", "ancient_aether");
        itemWoodWallBlock(AncientAetherBlocks.STRIPPED_SAKURA_WOOD_WALL.get(), AncientAetherBlocks.STRIPPED_SAKURA_LOG.get(), "", "ancient_aether");

        //Saplings
        itemBlockFlat(AncientAetherBlocks.ENCHANTED_SKYROOT_SAPLING.get(), "");
        itemBlockFlat(AncientAetherBlocks.SKYROOT_PINE_SAPLING.get(), "");
        itemBlockFlat(AncientAetherBlocks.CRYSTAL_SKYROOT_SAPLING.get(), "");
        itemBlockFlat(AncientAetherBlocks.HIGHSPROOT_SAPLING.get(), "");
        itemBlockFlat(AncientAetherBlocks.SAKURA_SAPLING.get(), "");

        //Aerclouds
        itemBlock(AncientAetherBlocks.VIOLET_AERCLOUD.get());

        //Construction
        itemBlock(AncientAetherBlocks.AEROGEL_GLASS.get());
        pane(AncientAetherBlocks.AEROGEL_GLASS_PANE.get(), AncientAetherBlocks.AEROGEL_GLASS.get(), "");
        item(AncientAetherBlocks.AEROGEL_GLASS_DOOR.get().asItem(), "");
        itemBlock(AncientAetherBlocks.AEROGEL_GLASS_TRAPDOOR.get(), "_bottom");
        itemBlock(AncientAetherBlocks.BUFFALO_CARPET.get());

        //Dungeon Blocks
        itemBlock(AncientAetherBlocks.CARVED_TILE_STAIRS.get());
        itemBlock(AncientAetherBlocks.CARVED_TILE_SLAB.get());
        itemWallBlock(AncientAetherBlocks.CARVED_TILE_WALL.get(), AncientAetherBlocks.CARVED_TILES.get(), "");
        itemBlock(AncientAetherBlocks.AEROGETIC_STAIRS.get());
        itemBlock(AncientAetherBlocks.AEROGETIC_SLAB.get());
        itemWallBlock(AncientAetherBlocks.AEROGETIC_WALL.get(), AncientAetherBlocks.AEROGETIC_STONE.get(), "");
        itemBlock(AncientAetherBlocks.ANCIENT_OBELISK.get());
        itemBlock(AncientAetherBlocks.UNPOWERED_ANCIENT_OBELISK.get());

        //Plants
        itemBlockFlat(AncientAetherBlocks.SAKURA_BLOSSOMS.get(), "");
        itemBlockFlat(AncientAetherBlocks.TRAPPED_SAKURA_BLOSSOMS.get(), "");
        itemBlockFlat(AncientAetherBlocks.WYND_THISTLE.get(), "");
        itemBlockFlat(AncientAetherBlocks.SKY_BLUES.get(), "");
        itemBlockFlat(AncientAetherBlocks.HIGHLAND_VIOLA.get(), "");

        //Lanterns and Campfires
        item(AncientAetherBlocks.HOLYSTONE_LANTERN.get().asItem(), "");
        item(AncientAetherBlocks.SENTRY_LANTERN.get().asItem(), "");
        item(AncientAetherBlocks.ANGELIC_LANTERN.get().asItem(), "");
        item(AncientAetherBlocks.HELLFIRE_LANTERN.get().asItem(), "");
        item(AncientAetherBlocks.GALE_LANTERN.get().asItem(), "");
        item(AncientAetherBlocks.AEROGETIC_LANTERN.get().asItem(), "");
        item(AncientAetherBlocks.AMBROSIUM_CAMPFIRE.get().asItem(), "");

        //Redstone
        itemBlock(AncientAetherBlocks.WIND_BLOWER.get());
        itemBlock(AncientAetherBlocks.GRAVITITE_LAUNCHER.get());
        itemBlock(AncientAetherBlocks.CRACKED_SLIDER.get());

        //Vases
        itemBlock(AncientAetherBlocks.HOLYSTONE_VASE.get());
        itemBlock(AncientAetherBlocks.MOSSY_HOLYSTONE_VASE.get());
        itemBlock(AncientAetherBlocks.FROZEN_HOLYSTONE_VASE.get());
        itemBlock(AncientAetherBlocks.SENTRY_VASE.get());
        itemBlock(AncientAetherBlocks.ANGELIC_VASE.get());
        itemBlock(AncientAetherBlocks.HELLFIRE_VASE.get());
        itemBlock(AncientAetherBlocks.AEROGETIC_VASE.get());
    }

    public String itemName(Item item) {
        ResourceLocation location = ForgeRegistries.ITEMS.getKey(item);
        if (location != null) {
            return location.getPath();
        } else {
            throw new IllegalStateException("Unknown item: " + item.toString());
        }
    }
    private void simpleItem(RegistryObject<Item> item) {
        withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated"))
                .texture("layer0", new ResourceLocation(AncientAether.MOD_ID, "item/" + item.getId().getPath()));
    }

    public void untintedMoaEggItem(Item item) {
        (withExistingParent(itemName(item), modLoc("item/untinted_moa_egg")))
                .texture("egg", modLoc( "item/" + itemName(item)))
                .texture("particle", modLoc( "item/" + itemName(item)));
    }

    public void itemLogWallBlock(Block block, Block baseBlock, String location, String modid) {
        ResourceLocation baseTexture = new ResourceLocation(modid, "block/" + location + blockName(baseBlock));
        (((((withExistingParent(blockName(block), mcLoc("block/block"))).transforms().transform(ItemDisplayContext.GUI).rotation(30.0F, 135.0F, 0.0F).translation(0.0F, 0.0F, 0.0F).scale(0.625F, 0.625F, 0.625F).end().transform(ItemDisplayContext.FIXED).rotation(0.0F, 90.0F, 0.0F).translation(0.0F, 0.0F, 0.0F).scale(0.5F, 0.5F, 0.5F).end().end()).texture("top", baseTexture + "_top")).texture("side", baseTexture)).element().from(4.0F, 0.0F, 4.0F).to(12.0F, 16.0F, 12.0F).face(Direction.DOWN).uvs(4.0F, 4.0F, 12.0F, 12.0F).texture("#top").cullface(Direction.DOWN).end().face(Direction.UP).uvs(4.0F, 4.0F, 12.0F, 12.0F).texture("#top").end().face(Direction.NORTH).uvs(4.0F, 0.0F, 12.0F, 16.0F).texture("#side").end().face(Direction.SOUTH).uvs(4.0F, 0.0F, 12.0F, 16.0F).texture("#side").end().face(Direction.WEST).uvs(4.0F, 0.0F, 12.0F, 16.0F).texture("#side").end().face(Direction.EAST).uvs(4.0F, 0.0F, 12.0F, 16.0F).texture("#side").end().end()).element().from(5.0F, 0.0F, 0.0F).to(11.0F, 13.0F, 16.0F).face(Direction.DOWN).uvs(5.0F, 0.0F, 11.0F, 16.0F).texture("#top").cullface(Direction.DOWN).end().face(Direction.UP).uvs(5.0F, 0.0F, 11.0F, 16.0F).texture("#top").end().face(Direction.NORTH).uvs(5.0F, 3.0F, 11.0F, 16.0F).texture("#side").cullface(Direction.NORTH).end().face(Direction.SOUTH).uvs(5.0F, 3.0F, 11.0F, 16.0F).texture("#side").cullface(Direction.SOUTH).end().face(Direction.WEST).uvs(0.0F, 3.0F, 16.0F, 16.0F).texture("#side").end().face(Direction.EAST).uvs(0.0F, 3.0F, 16.0F, 16.0F).texture("#side").end().end();
    }
    public void itemWoodWallBlock(Block block, Block baseBlock, String location, String modid) {
        wallInventory(blockName(block), new ResourceLocation(modid, "block/" + location + blockName(baseBlock)));
    }
}
