package net.builderdog.ancient_aether.data.generators;

import com.aetherteam.aether.AetherTags;
import com.aetherteam.aether.block.AetherBlocks;
import com.aetherteam.aether.entity.AetherEntityTypes;
import com.aetherteam.aether.item.AetherItems;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.AncientTags;
import net.builderdog.ancient_aether.block.AncientBlocks;
import net.builderdog.ancient_aether.block.blockstate.AetherGrassType;
import net.builderdog.ancient_aether.block.blockstate.AncientBlockStateProperties;
import net.builderdog.ancient_aether.data.providers.AncientRecipeProvider;
import net.builderdog.ancient_aether.data.resources.registries.AncientMoaTypes;
import net.builderdog.ancient_aether.item.AncientItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class AncientRecipeData extends AncientRecipeProvider {
    public AncientRecipeData(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, AncientAether.MODID);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput consumer) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, AncientBlocks.WYND_LANTERN.get())
                .requires(AncientBlocks.AMBROSIUM_LANTERN.get())
                .requires(AncientBlocks.WYND_SENTRY_STONE.get())
                .unlockedBy(getHasName(AncientBlocks.WYND_SENTRY_STONE.get()), has(AncientBlocks.WYND_SENTRY_STONE.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, AncientBlocks.SUN_LANTERN.get())
                .requires(AncientBlocks.AMBROSIUM_LANTERN.get())
                .requires(AetherBlocks.LIGHT_HELLFIRE_STONE.get())
                .unlockedBy(getHasName(AetherBlocks.LIGHT_HELLFIRE_STONE.get()), has(AetherBlocks.LIGHT_HELLFIRE_STONE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, AncientBlocks.AEROGEL_GLASS.get(), 8)
                .define('#', AetherBlocks.AEROGEL.get())
                .define('X', AetherBlocks.SKYROOT_PLANKS.get())
                .pattern("###")
                .pattern("#X#")
                .pattern("###")
                .unlockedBy(getHasName(AetherBlocks.AEROGEL.get()), has(AetherBlocks.AEROGEL.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, AncientBlocks.AEROGEL_GLASS_PANE.get(),16)
                .define('#', AncientBlocks.AEROGEL_GLASS.get())
                .pattern("###")
                .pattern("###")
                .unlockedBy(getHasName(AncientBlocks.AEROGEL_GLASS.get()), has(AncientBlocks.AEROGEL_GLASS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, AncientBlocks.AEROGEL_GLASS_TRAPDOOR.get(),2)
                .define('#', AncientBlocks.AEROGEL_GLASS.get())
                .pattern("##")
                .pattern("##")
                .unlockedBy(getHasName(AncientBlocks.AEROGEL_GLASS.get()), has(AncientBlocks.AEROGEL_GLASS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, AetherBlocks.PILLAR.get(),2)
                .define('#', AncientBlocks.VALKYRIE_BRICKS.get())
                .pattern("#")
                .pattern("#")
                .unlockedBy(getHasName(AncientBlocks.VALKYRIE_BRICKS.get()), has(AncientBlocks.VALKYRIE_BRICKS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AncientBlocks.AMBROSIUM_LANTERN.get())
                .define('#', AetherBlocks.HOLYSTONE.get())
                .define('/', Tags.Items.RODS_WOODEN)
                .define('T', AetherBlocks.AMBROSIUM_TORCH.get())
                .pattern("/#/")
                .pattern("/T/")
                .pattern("/#/")
                .unlockedBy(getHasName(AetherBlocks.AMBROSIUM_TORCH.get()), has(AetherBlocks.AMBROSIUM_TORCH.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, AncientBlocks.AMBROSIUM_CAMPFIRE.get())
                .define('#', ItemTags.LOGS)
                .define('A', AetherItems.AMBROSIUM_SHARD.get())
                .define('/', Tags.Items.RODS_WOODEN)
                .pattern(" / ")
                .pattern("/A/")
                .pattern("###")
                .unlockedBy(getHasName(AetherItems.AMBROSIUM_SHARD.get()), has(AetherItems.AMBROSIUM_SHARD.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, Blocks.STONECUTTER)
                .group("stonecutter")
                .define('Z', AetherTags.Items.GEMS_ZANITE)
                .define('#', AetherBlocks.HOLYSTONE.get())
                .pattern(" Z ")
                .pattern("###")
                .unlockedBy("has_holystone", has(AetherBlocks.HOLYSTONE.get()))
                .save(consumer, name("holystone_stonecutter_from_zanite"));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, Blocks.SMITHING_TABLE)
                .group("smithing_table")
                .define('@', AetherTags.Items.GEMS_ZANITE)
                .define('#', AetherTags.Items.PLANKS_CRAFTING)
                .pattern("@@")
                .pattern("##")
                .pattern("##")
                .unlockedBy(getHasName(AetherItems.ZANITE_GEMSTONE.get()), has(AetherTags.Items.GEMS_ZANITE))
                .save(consumer, name("skyroot_smithing_table_from_zanite"));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, Blocks.ANVIL)
                .define('Z', AetherBlocks.ZANITE_BLOCK.get())
                .define('z', AetherTags.Items.GEMS_ZANITE)
                .pattern("ZZZ")
                .pattern(" z ")
                .pattern("zzz")
                .unlockedBy(getHasName(AetherBlocks.ZANITE_BLOCK.get()), has(AetherBlocks.ZANITE_BLOCK.get()))
                .save(consumer, name("anvil_from_zanite"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Blocks.ENCHANTING_TABLE)
                .define('G', AetherTags.Items.PROCESSED_GRAVITITE)
                .define('#', Blocks.OBSIDIAN)
                .define('B', Items.BOOK)
                .pattern(" B ")
                .pattern("G#G")
                .pattern("###")
                .unlockedBy(getHasName(AetherBlocks.ENCHANTED_GRAVITITE.get()), has(AetherTags.Items.PROCESSED_GRAVITITE))
                .save(consumer, name("enchanting_table_from_gravitite"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, AncientBlocks.WIND_BLOWER.get())
                .define('#', AetherBlocks.COLD_AERCLOUD.get())
                .define('@', AncientTags.Items.WINDBLOWER_INGREDIENTS)
                .pattern("###")
                .pattern("#@#")
                .pattern("###")
                .unlockedBy(getHasName(AetherBlocks.BLUE_AERCLOUD.get()), has(AncientTags.Items.WINDBLOWER_INGREDIENTS))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.FLOWER_POT)
                .define('#', AncientItems.VALKYRIE_BRICK.get())
                .pattern("# #")
                .pattern(" # ")
                .unlockedBy(getHasName(AncientItems.VALKYRIE_BRICK.get()), has(AncientItems.VALKYRIE_BRICK.get()))
                .save(consumer, name("flower_pot_from_valkyrie_bricks"));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, Items.ARMOR_STAND)
                .define('/', Tags.Items.RODS_WOODEN)
                .define('_', AetherBlocks.HOLYSTONE_SLAB.get())
                .pattern("///")
                .pattern(" / ")
                .pattern("/_/")
                .unlockedBy(getHasName(AetherBlocks.HOLYSTONE_SLAB.get()), has(AetherBlocks.HOLYSTONE_SLAB.get()))
                .save(consumer, name("armor_stand_from_holystone"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, AncientItems.ANCIENT_RUNE.get(),2)
                .define('#', AetherTags.Items.PROCESSED_GRAVITITE)
                .define('R', AncientItems.ANCIENT_RUNE.get())
                .define('A', AetherBlocks.AEROGEL.get())
                .pattern("#R#")
                .pattern("#A#")
                .pattern("###")
                .unlockedBy(getHasName(AncientItems.ANCIENT_RUNE.get()), has(AncientItems.ANCIENT_RUNE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AncientItems.VALKYRUM_LANCE.get())
                .define('#', Tags.Items.RODS_WOODEN)
                .define('X', AncientItems.VALKYRUM.get())
                .pattern("X  ")
                .pattern(" X ")
                .pattern("  #")
                .unlockedBy(getHasName(AncientItems.VALKYRUM.get()), has(AncientItems.VALKYRUM.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, Items.SHEARS)
                .define('#', AetherTags.Items.GEMS_ZANITE)
                .pattern(" #")
                .pattern("# ")
                .unlockedBy(getHasName(AetherItems.ZANITE_GEMSTONE.get()), has(AetherTags.Items.GEMS_ZANITE))
                .save(consumer, name("shears_from_zanite"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.PAPER, 3)
                .define('#', AetherItems.AECHOR_PETAL.get())
                .pattern("###")
                .unlockedBy(getHasName(AetherItems.AECHOR_PETAL.get()), has(AetherItems.AECHOR_PETAL.get()))
                .save(consumer, name("paper_from_aechor_petals"));

        woodFromLogs(consumer, AncientBlocks.HIGHSPROOT_WOOD.get(), AncientBlocks.HIGHSPROOT_LOG.get());
        woodFromLogs(consumer, AncientBlocks.STRIPPED_HIGHSPROOT_WOOD.get(), AncientBlocks.STRIPPED_HIGHSPROOT_LOG.get());
        woodFromLogs(consumer, AncientBlocks.SAKURA_WOOD.get(), AncientBlocks.SAKURA_LOG.get());
        woodFromLogs(consumer, AncientBlocks.STRIPPED_SAKURA_WOOD.get(), AncientBlocks.STRIPPED_SAKURA_LOG.get());

        planksFromLogs(consumer, AncientBlocks.HIGHSPROOT_PLANKS.get(), AncientTags.Items.HIGHSPROOT_LOGS, 4);
        planksFromLogs(consumer, AncientBlocks.SAKURA_PLANKS.get(), AncientTags.Items.SAKURA_LOGS, 4);

        stairs(AncientBlocks.HIGHSPROOT_STAIRS, AncientBlocks.HIGHSPROOT_PLANKS).group("wooden_stairs").save(consumer);
        stairs(AncientBlocks.SAKURA_STAIRS, AncientBlocks.SAKURA_PLANKS).group("wooden_stairs").save(consumer);
        stairs(AncientBlocks.CARVED_TILE_STAIRS, AncientBlocks.CARVED_TILES).save(consumer);
        stairs(AncientBlocks.VALKYRIE_BRICK_STAIRS, AncientBlocks.VALKYRIE_BRICKS).save(consumer);
        stairs(AncientBlocks.VALKYRIE_TILE_STAIRS, AncientBlocks.VALKYRIE_TILES).save(consumer);
        stairs(AncientBlocks.AEROGETIC_STAIRS, AncientBlocks.AEROGETIC_STONE).save(consumer);

        slabBuilder(RecipeCategory.BUILDING_BLOCKS, AncientBlocks.HIGHSPROOT_SLAB.get(), Ingredient.of(AncientBlocks.HIGHSPROOT_PLANKS.get()))
                .group("wooden_slab")
                .unlockedBy(getHasName(AncientBlocks.HIGHSPROOT_PLANKS.get()), has(AncientBlocks.HIGHSPROOT_PLANKS.get()))
                .save(consumer);
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, AncientBlocks.SAKURA_SLAB.get(), Ingredient.of(AncientBlocks.SAKURA_PLANKS.get()))
                .group("wooden_slab")
                .unlockedBy(getHasName(AncientBlocks.SAKURA_PLANKS.get()), has(AncientBlocks.SAKURA_PLANKS.get()))
                .save(consumer);

        slab(consumer, RecipeCategory.BUILDING_BLOCKS, AncientBlocks.CARVED_TILE_SLAB.get(), AncientBlocks.CARVED_TILES.get());
        slab(consumer, RecipeCategory.BUILDING_BLOCKS, AncientBlocks.VALKYRIE_BRICK_SLAB.get(), AncientBlocks.VALKYRIE_BRICKS.get());
        slab(consumer, RecipeCategory.BUILDING_BLOCKS, AncientBlocks.VALKYRIE_TILE_SLAB.get(), AncientBlocks.VALKYRIE_TILES.get());
        slab(consumer, RecipeCategory.BUILDING_BLOCKS, AncientBlocks.AEROGETIC_SLAB.get(), AncientBlocks.AEROGETIC_STONE.get());

        fence(AncientBlocks.HIGHSPROOT_FENCE, AncientBlocks.HIGHSPROOT_PLANKS).save(consumer);
        fence(AncientBlocks.SAKURA_FENCE, AncientBlocks.SAKURA_PLANKS).save(consumer);

        fenceGate(AncientBlocks.HIGHSPROOT_FENCE_GATE, AncientBlocks.HIGHSPROOT_PLANKS).save(consumer);
        fenceGate(AncientBlocks.SAKURA_FENCE_GATE, AncientBlocks.SAKURA_PLANKS).save(consumer);

        wall(consumer, RecipeCategory.DECORATIONS, AncientBlocks.CARVED_TILE_WALL.get(), AncientBlocks.CARVED_TILES.get());
        wall(consumer, RecipeCategory.DECORATIONS, AncientBlocks.VALKYRIE_BRICK_WALL.get(), AncientBlocks.VALKYRIE_BRICKS.get());
        wall(consumer, RecipeCategory.DECORATIONS, AncientBlocks.VALKYRIE_TILE_WALL.get(), AncientBlocks.VALKYRIE_TILES.get());
        wall(consumer, RecipeCategory.DECORATIONS, AncientBlocks.AEROGETIC_WALL.get(), AncientBlocks.AEROGETIC_STONE.get());

        doorBuilder(AncientBlocks.HIGHSPROOT_DOOR.get(), Ingredient.of(AncientBlocks.HIGHSPROOT_PLANKS.get())).unlockedBy(getHasName(AncientBlocks.HIGHSPROOT_PLANKS.get()), has(AncientBlocks.HIGHSPROOT_PLANKS.get())).group("wooden_door").save(consumer);
        doorBuilder(AncientBlocks.SAKURA_DOOR.get(), Ingredient.of(AncientBlocks.SAKURA_PLANKS.get())).unlockedBy(getHasName(AncientBlocks.SAKURA_PLANKS.get()), has(AncientBlocks.SAKURA_PLANKS.get())).group("wooden_door").save(consumer);
        doorBuilder(AncientBlocks.AEROGEL_GLASS_DOOR.get(), Ingredient.of(AncientBlocks.AEROGEL_GLASS.get())).unlockedBy(getHasName(AncientBlocks.AEROGEL_GLASS.get()), has(AncientBlocks.AEROGEL_GLASS.get())).save(consumer);

        trapdoorBuilder(AncientBlocks.HIGHSPROOT_TRAPDOOR.get(), Ingredient.of(AncientBlocks.HIGHSPROOT_PLANKS.get())).unlockedBy(getHasName(AncientBlocks.HIGHSPROOT_PLANKS.get()), has(AncientBlocks.HIGHSPROOT_PLANKS.get())).group("wooden_trapdoor").save(consumer);
        trapdoorBuilder(AncientBlocks.SAKURA_TRAPDOOR.get(), Ingredient.of(AncientBlocks.SAKURA_PLANKS.get())).unlockedBy(getHasName(AncientBlocks.SAKURA_PLANKS.get()), has(AncientBlocks.SAKURA_PLANKS.get())).group("wooden_trapdoor").save(consumer);

        pressurePlateBuilder(RecipeCategory.REDSTONE, AncientBlocks.HIGHSPROOT_PRESSURE_PLATE.get(), Ingredient.of(AncientBlocks.HIGHSPROOT_PLANKS.get())).unlockedBy(getHasName(AncientBlocks.HIGHSPROOT_PLANKS.get()), has(AncientBlocks.HIGHSPROOT_PLANKS.get())).group("wooden_pressure_plate").save(consumer);
        pressurePlateBuilder(RecipeCategory.REDSTONE, AncientBlocks.SAKURA_PRESSURE_PLATE.get(), Ingredient.of(AncientBlocks.SAKURA_PLANKS.get())).unlockedBy(getHasName(AncientBlocks.SAKURA_PLANKS.get()), has(AncientBlocks.SAKURA_PLANKS.get())).group("wooden_pressure_plate").save(consumer);

        buttonBuilder(AncientBlocks.HIGHSPROOT_BUTTON.get(), Ingredient.of(AncientBlocks.HIGHSPROOT_PLANKS.get())).unlockedBy(getHasName(AncientBlocks.HIGHSPROOT_PLANKS.get()), has(AncientBlocks.HIGHSPROOT_PLANKS.get())).group("wooden_button").save(consumer);
        buttonBuilder(AncientBlocks.SAKURA_BUTTON.get(), Ingredient.of(AncientBlocks.SAKURA_PLANKS.get())).unlockedBy(getHasName(AncientBlocks.SAKURA_PLANKS.get()), has(AncientBlocks.SAKURA_PLANKS.get())).group("wooden_button").save(consumer);

        sign(consumer, AncientBlocks.HIGHSPROOT_SIGN.get(), AncientBlocks.HIGHSPROOT_PLANKS.get());
        sign(consumer, AncientBlocks.SAKURA_SIGN.get(), AncientBlocks.SAKURA_PLANKS.get());

        hangingSign(consumer, AncientBlocks.HIGHSPROOT_HANGING_SIGN.get(), AncientBlocks.STRIPPED_HIGHSPROOT_LOG.get());
        hangingSign(consumer, AncientBlocks.SAKURA_HANGING_SIGN.get(), AncientBlocks.STRIPPED_SAKURA_LOG.get());

        bookshelf(consumer, AncientBlocks.HIGHSPROOT_BOOKSHELF.get(), AncientBlocks.HIGHSPROOT_PLANKS.get());
        bookshelf(consumer, AncientBlocks.SAKURA_BOOKSHELF.get(), AncientBlocks.SAKURA_PLANKS.get());

        flowerToDye(consumer, Items.RED_DYE, AncientBlocks.SUNSET_ROSE.get(), "red");
        flowerToDye(consumer, Items.CYAN_DYE, AncientBlocks.SKY_BLUES.get(), "cyan");
        flowerToDye(consumer, Items.LIGHT_BLUE_DYE, AncientBlocks.WYND_THISTLE.get(), "light_blue");
        flowerToDye(consumer, Items.PURPLE_DYE, AncientBlocks.ELEVETIA.get(), "purple");

        vase(consumer, AncientBlocks.HOLYSTONE_VASE.get(), AetherBlocks.HOLYSTONE_BRICKS.get());
        vase(consumer, AncientBlocks.MOSSY_HOLYSTONE_VASE.get(), AetherBlocks.MOSSY_HOLYSTONE.get());
        vase(consumer, AncientBlocks.SENTRY_VASE.get(), AetherBlocks.CARVED_STONE.get());
        vase(consumer, AncientBlocks.ANGELIC_VASE.get(), AetherBlocks.ANGELIC_STONE.get());
        vase(consumer, AncientBlocks.HELLFIRE_VASE.get(), AetherBlocks.HELLFIRE_STONE.get());
        vase(consumer, AncientBlocks.AEROGETIC_VASE.get(), AncientBlocks.AEROGETIC_STONE.get());

        chiseled(consumer, RecipeCategory.BUILDING_BLOCKS, AncientBlocks.HOLYSTONE_BRICK_MOSAIC.get(), AetherBlocks.HOLYSTONE_BRICK_SLAB.get());
        chiseled(consumer, RecipeCategory.BUILDING_BLOCKS, AncientBlocks.CARVED_STONE_MOSAIC.get(), AetherBlocks.CARVED_SLAB.get());
        chiseled(consumer, RecipeCategory.BUILDING_BLOCKS, AncientBlocks.ANGELIC_STONE_MOSAIC.get(), AetherBlocks.ANGELIC_SLAB.get());
        chiseled(consumer, RecipeCategory.BUILDING_BLOCKS, AncientBlocks.HELLFIRE_STONE_MOSAIC.get(), AetherBlocks.HELLFIRE_SLAB.get());
        chiseled(consumer, RecipeCategory.BUILDING_BLOCKS, AncientBlocks.AEROGETIC_STONE_MOSAIC.get(), AncientBlocks.AEROGETIC_SLAB.get());
        chiseled(consumer, RecipeCategory.BUILDING_BLOCKS, AetherBlocks.PILLAR_TOP.get(), AncientBlocks.VALKYRIE_BRICK_SLAB.get());

        twoByTwoPacker(consumer, RecipeCategory.BUILDING_BLOCKS, AncientBlocks.VALKYRIE_CLAY.get(), AncientItems.VALKYRIE_CLAY_BALL.get());
        twoByTwoPacker(consumer, RecipeCategory.BUILDING_BLOCKS, AncientBlocks.VALKYRIE_BRICKS.get(), AncientItems.VALKYRIE_BRICK.get());

        oreBlockStorageRecipesRecipesWithCustomUnpacking(consumer, RecipeCategory.MISC, AncientItems.VALKYRUM.get(), RecipeCategory.BUILDING_BLOCKS, AncientBlocks.VALKYRUM_BLOCK.get(), "valkyrum_from_valkyrum_block", "valkyrum");

        polished(consumer, RecipeCategory.BUILDING_BLOCKS, AncientBlocks.CARVED_TILES.get(), AetherBlocks.CARVED_STONE.get());
        polished(consumer, RecipeCategory.BUILDING_BLOCKS, AncientBlocks.ANGELIC_CORNER_BRICK.get(), AetherBlocks.ANGELIC_STONE.get());
        polished(consumer, RecipeCategory.BUILDING_BLOCKS, AncientBlocks.VALKYRIE_TILES.get(), AncientBlocks.VALKYRIE_BRICKS.get());

        carpet(consumer, AncientBlocks.FLUFFALO_CARPET.get(), AncientBlocks.FLUFFALO_WOOL.get());

        makePickaxe(AncientItems.VALKYRUM_PICKAXE, AncientItems.VALKYRUM).save(consumer);
        makeAxe(AncientItems.VALKYRUM_AXE, AncientItems.VALKYRUM).save(consumer);
        makeShovel(AncientItems.VALKYRUM_SHOVEL, AncientItems.VALKYRUM).save(consumer);
        makeHoe(AncientItems.VALKYRUM_HOE, AncientItems.VALKYRUM).save(consumer);
        makeSword(AncientItems.VALKYRUM_SWORD, AncientItems.VALKYRUM).save(consumer);

        makeHelmet(AncientItems.VALKYRUM_HELMET, AncientItems.VALKYRUM).save(consumer);
        makeChestplate(AncientItems.VALKYRUM_CHESTPLATE, AncientItems.VALKYRUM).save(consumer);
        makeLeggings(AncientItems.VALKYRUM_LEGGINGS, AncientItems.VALKYRUM).save(consumer);
        makeBoots(AncientItems.VALKYRUM_BOOTS, AncientItems.VALKYRUM).save(consumer);
        makeGloves(AncientItems.VALKYRUM_GLOVES, AncientItems.VALKYRUM).save(consumer);

        makeRing(AncientItems.VALKYRUM_RING, AncientItems.VALKYRUM.get()).save(consumer);
        makePendant(AncientItems.VALKYRUM_PENDANT, AncientItems.VALKYRUM.get()).save(consumer);
        makeCape(AncientItems.PINK_CAPE, Blocks.PINK_WOOL.asItem()).save(consumer);

        copyAetherSmithingTemplate(consumer, AncientItems.WYND_ARMOR_TRIM_SMITHING_TEMPLATE.get(), AetherBlocks.HOLYSTONE.get());
        copyAetherSmithingTemplate(consumer, AncientItems.WHALE_ARMOR_TRIM_SMITHING_TEMPLATE.get(), AetherBlocks.HOLYSTONE.get());
        copyAetherSmithingTemplate(consumer, AncientItems.ASCENDED_ARMOR_TRIM_SMITHING_TEMPLATE.get(), AetherBlocks.HOLYSTONE.get());
        copyAetherSmithingTemplate(consumer, AncientItems.MYSTERIOUS_ARMOR_TRIM_SMITHING_TEMPLATE.get(), AetherBlocks.MOSSY_HOLYSTONE.get());
        copyAetherSmithingTemplate(consumer, AncientItems.MECHANICAL_ARMOR_TRIM_SMITHING_TEMPLATE.get(), AetherBlocks.ICESTONE.get());

        aetherSmithingTrimRecipe(consumer, AncientItems.WYND_ARMOR_TRIM_SMITHING_TEMPLATE.get());
        aetherSmithingTrimRecipe(consumer, AncientItems.WHALE_ARMOR_TRIM_SMITHING_TEMPLATE.get());
        aetherSmithingTrimRecipe(consumer, AncientItems.ASCENDED_ARMOR_TRIM_SMITHING_TEMPLATE.get());
        aetherSmithingTrimRecipe(consumer, AncientItems.MYSTERIOUS_ARMOR_TRIM_SMITHING_TEMPLATE.get());
        aetherSmithingTrimRecipe(consumer, AncientItems.MECHANICAL_ARMOR_TRIM_SMITHING_TEMPLATE.get());
        aetherSmithingTrimRecipe(consumer, AncientItems.MOSAIC_ARMOR_TRIM_SMITHING_TEMPLATE.get());
        aetherSmithingTrimRecipe(consumer, AncientItems.ROYAL_ARMOR_TRIM_SMITHING_TEMPLATE.get());
        aetherSmithingTrimRecipe(consumer, AncientItems.SOLAR_ARMOR_TRIM_SMITHING_TEMPLATE.get());
        aetherSmithingTrimRecipe(consumer, AncientItems.ANCIENT_ARMOR_TRIM_SMITHING_TEMPLATE.get());

        woodenBoat(consumer, AncientItems.HIGHSPROOT_BOAT.get(), AncientBlocks.HIGHSPROOT_PLANKS.get());
        woodenBoat(consumer, AncientItems.SAKURA_BOAT.get(), AncientBlocks.SAKURA_PLANKS.get());
        woodenChestBoat(consumer, AncientItems.HIGHSPROOT_CHEST_BOAT.get(), AncientItems.HIGHSPROOT_BOAT.get());
        woodenChestBoat(consumer, AncientItems.SAKURA_CHEST_BOAT.get(), AncientItems.SAKURA_BOAT.get());

        smeltingOreRecipe(AncientItems.VALKYRIE_BRICK.get(), AncientItems.VALKYRIE_CLAY_BALL.get(), 0.3F);
        smeltingOreRecipe(Items.QUARTZ, AncientBlocks.AETHER_QUARTZ_ORE.get(), 0.5F).save(consumer, name("quartz_from_smelting_aether_quartz_ore"));
        blastingOreRecipe(Items.QUARTZ, AncientBlocks.AETHER_QUARTZ_ORE.get(), 0.5F).save(consumer, name("quartz_from_blasting_aether_quartz_ore"));

        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientBlocks.HOLYSTONE_BRICK_MOSAIC.get(), AetherBlocks.HOLYSTONE_BRICKS.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientBlocks.CARVED_TILES.get(), AetherBlocks.CARVED_STONE.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientBlocks.CARVED_STONE_MOSAIC.get(), AetherBlocks.CARVED_STONE.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientBlocks.CARVED_TILE_STAIRS.get(), AetherBlocks.CARVED_STONE.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientBlocks.CARVED_TILE_SLAB.get(), AetherBlocks.CARVED_STONE.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientBlocks.CARVED_TILE_WALL.get(), AetherBlocks.CARVED_STONE.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientBlocks.CARVED_TILE_STAIRS.get(), AncientBlocks.CARVED_TILES.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientBlocks.CARVED_TILE_SLAB.get(), AncientBlocks.CARVED_TILES.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientBlocks.CARVED_TILE_WALL.get(), AncientBlocks.CARVED_TILES.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientBlocks.ANGELIC_CORNER_BRICK.get(), AetherBlocks.ANGELIC_STONE.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientBlocks.ANGELIC_STONE_MOSAIC.get(), AetherBlocks.ANGELIC_STONE.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientBlocks.VALKYRIE_BRICK_STAIRS.get(), AncientBlocks.VALKYRIE_BRICKS.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientBlocks.VALKYRIE_BRICK_SLAB.get(), AncientBlocks.VALKYRIE_BRICKS.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientBlocks.VALKYRIE_BRICK_WALL.get(), AncientBlocks.VALKYRIE_BRICKS.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientBlocks.VALKYRIE_TILES.get(), AncientBlocks.VALKYRIE_BRICKS.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientBlocks.VALKYRIE_TILE_STAIRS.get(), AncientBlocks.VALKYRIE_TILES.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientBlocks.VALKYRIE_TILE_SLAB.get(), AncientBlocks.VALKYRIE_TILES.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientBlocks.VALKYRIE_TILE_WALL.get(), AncientBlocks.VALKYRIE_TILES.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientBlocks.VALKYRIE_TILE_STAIRS.get(), AncientBlocks.VALKYRIE_BRICKS.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientBlocks.VALKYRIE_TILE_SLAB.get(), AncientBlocks.VALKYRIE_BRICKS.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientBlocks.VALKYRIE_TILE_WALL.get(), AncientBlocks.VALKYRIE_BRICKS.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientBlocks.VALKYRIE_BRICKS.get(), AetherBlocks.PILLAR.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientBlocks.VALKYRIE_BRICKS.get(), AetherBlocks.PILLAR_TOP.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientBlocks.HELLFIRE_STONE_MOSAIC.get(), AetherBlocks.HELLFIRE_STONE.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientBlocks.AEROGETIC_STAIRS.get(), AncientBlocks.AEROGETIC_STONE.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientBlocks.AEROGETIC_SLAB.get(), AncientBlocks.AEROGETIC_STONE.get(), 2);
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientBlocks.AEROGETIC_WALL.get(), AncientBlocks.AEROGETIC_STONE.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientBlocks.AEROGETIC_STONE.get(), AncientBlocks.AERONAUTIC_STONE.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientBlocks.AEROGETIC_STONE.get(), AncientBlocks.CORRUPTED_AERONAUTIC_STONE.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientBlocks.AERONAUTIC_STONE.get(), AncientBlocks.CORRUPTED_AERONAUTIC_STONE.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientBlocks.AERONAUTIC_STONE.get(), AncientBlocks.AEROGETIC_STONE.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientBlocks.CORRUPTED_AERONAUTIC_STONE.get(), AncientBlocks.AEROGETIC_STONE.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientBlocks.CORRUPTED_AERONAUTIC_STONE.get(), AncientBlocks.AERONAUTIC_STONE.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientBlocks.AEROGETIC_STONE_MOSAIC.get(), AncientBlocks.AEROGETIC_STONE.get());

        freezingRecipe(RecipeCategory.BUILDING_BLOCKS, AetherBlocks.HOLIDAY_LEAVES.get(), AncientBlocks.HIGHSPROOT_LEAVES.get(), 0.1F, 50).save(consumer);
        freezingRecipe(RecipeCategory.BUILDING_BLOCKS, AncientBlocks.WYND_SENTRY_STONE.get(), AetherBlocks.SENTRY_STONE.get(), 0.2F, 100).save(consumer);
        freezingRecipe(RecipeCategory.DECORATIONS, AncientBlocks.FROZEN_HOLYSTONE_VASE.get(), AncientBlocks.HOLYSTONE_VASE.get(), 0.2F, 100).save(consumer);

        enchantingRecipe(RecipeCategory.MISC, AncientItems.VALKYRUM.get(), AncientBlocks.VALKYRUM_ORE.get(), 1.5F, 1000).save(consumer);
        enchantingRecipe(RecipeCategory.BUILDING_BLOCKS, AncientBlocks.VIOLET_AERCLOUD.get(), AetherBlocks.BLUE_AERCLOUD.get(), 0.1F, 400).save(consumer, name("violet_aercloud_enchanting"));

        repairingRecipe(RecipeCategory.COMBAT, AncientItems.VALKYRUM_HELMET.get(), 3000).group("altar_helmet_repair").save(consumer, name("valkyrum_helmet_repairing"));
        repairingRecipe(RecipeCategory.COMBAT, AncientItems.VALKYRUM_CHESTPLATE.get(), 3000).group("altar_chestplate_repair").save(consumer, name("valkyrum_chestplate_repairing"));
        repairingRecipe(RecipeCategory.COMBAT, AncientItems.VALKYRUM_LEGGINGS.get(), 3000).group("altar_leggings_repair").save(consumer, name("valkyrum_leggings_repairing"));
        repairingRecipe(RecipeCategory.COMBAT, AncientItems.VALKYRUM_BOOTS.get(), 3000).group("altar_boots_repair").save(consumer, name("valkyrum_boots_repairing"));
        repairingRecipe(RecipeCategory.COMBAT, AncientItems.VALKYRUM_GLOVES.get(), 3000).group("altar_gloves_repair").save(consumer, name("valkyrum_gloves_repairing"));
        repairingRecipe(RecipeCategory.TOOLS, AncientItems.VALKYRUM_PICKAXE.get(), 3000).group("altar_pickaxe_repair").save(consumer, name("valkyrum_pickaxe_repairing"));
        repairingRecipe(RecipeCategory.TOOLS, AncientItems.VALKYRUM_AXE.get(), 3000).group("altar_axe_repair").save(consumer, name("valkyrum_axe_repairing"));
        repairingRecipe(RecipeCategory.TOOLS, AncientItems.VALKYRUM_SHOVEL.get(), 3000).group("altar_shovel_repair").save(consumer, name("valkyrum_shovel_repairing"));
        repairingRecipe(RecipeCategory.TOOLS, AncientItems.VALKYRUM_HOE.get(), 3000).group("altar_hoe_repair").save(consumer, name("valkyrum_hoe_repairing"));
        repairingRecipe(RecipeCategory.TOOLS, AncientItems.VALKYRUM_SWORD.get(), 3000).group("altar_sword_repair").save(consumer, name("valkyrum_sword_repairing"));
        repairingRecipe(RecipeCategory.TOOLS, AncientItems.VALKYRUM_LANCE.get(), 3000).group("altar_sword_repair").save(consumer, name("valkyrum_lance_repairing"));

        moaIncubationRecipe(AetherEntityTypes.MOA.get(), AncientMoaTypes.TURQUOISE, AncientItems.TURQUOISE_MOA_EGG.get()).save(consumer, name("turquoise_moa_incubation"));
        moaIncubationRecipe(AetherEntityTypes.MOA.get(), AncientMoaTypes.TEAL, AncientItems.TEAL_MOA_EGG.get()).save(consumer, name("teal_moa_incubation"));
        moaIncubationRecipe(AetherEntityTypes.MOA.get(), AncientMoaTypes.SKY_BLUE, AncientItems.SKY_BLUE_MOA_EGG.get()).save(consumer, name("sky_blue_moa_incubation"));
        moaIncubationRecipe(AetherEntityTypes.MOA.get(), AncientMoaTypes.LAVENDER, AncientItems.LAVENDER_MOA_EGG.get()).save(consumer, name("lavender_moa_incubation"));
        moaIncubationRecipe(AetherEntityTypes.MOA.get(), AncientMoaTypes.SAKURA, AncientItems.SAKURA_MOA_EGG.get()).save(consumer, name("sakura_moa_incubation"));
        moaIncubationRecipe(AetherEntityTypes.MOA.get(), AncientMoaTypes.BURGUNDY, AncientItems.BURGUNDY_MOA_EGG.get()).save(consumer, name("burgundy_moa_incubation"));
        moaIncubationRecipe(AetherEntityTypes.MOA.get(), AncientMoaTypes.VIOLET, AncientItems.VIOLET_MOA_EGG.get()).save(consumer, name("violet_moa_incubation"));

        swetBallConversionWithProperties(AetherBlocks.AETHER_GRASS_BLOCK.get(), Map.of(AncientBlockStateProperties.TYPE, AetherGrassType.FROZEN), AetherBlocks.AETHER_DIRT.get(), AncientTags.Biomes.HAS_FROZEN_AETHER_GRASS).save(consumer, name("swet_ball_frozen_aether_grass"));
        swetBallConversionWithProperties(AetherBlocks.AETHER_GRASS_BLOCK.get(), Map.of(AncientBlockStateProperties.TYPE, AetherGrassType.PALE), AetherBlocks.AETHER_DIRT.get(), AncientTags.Biomes.HAS_PALE_AETHER_GRASS).save(consumer, name("swet_ball_pale_aether_grass"));
        swetBallConversionWithProperties(AetherBlocks.AETHER_GRASS_BLOCK.get(), Map.of(AncientBlockStateProperties.TYPE, AetherGrassType.ENCHANTED), AetherBlocks.AETHER_DIRT.get(), AncientTags.Biomes.HAS_ENCHANTED_AETHER_GRASS).save(consumer, name("swet_ball_enchanted_aether_grass"));
    }
}