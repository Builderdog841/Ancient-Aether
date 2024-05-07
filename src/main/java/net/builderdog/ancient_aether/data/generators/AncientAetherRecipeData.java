package net.builderdog.ancient_aether.data.generators;

import com.aetherteam.aether.AetherTags;
import com.aetherteam.aether.block.AetherBlocks;
import com.aetherteam.aether.entity.AetherEntityTypes;
import com.aetherteam.aether.item.AetherItems;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.AncientAetherTags;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.builderdog.ancient_aether.block.blockstate.AetherGrassType;
import net.builderdog.ancient_aether.block.blockstate.AncientAetherBlockStateProperties;
import net.builderdog.ancient_aether.data.providers.AncientAetherRecipeProvider;
import net.builderdog.ancient_aether.entity.AncientAetherMoaTypes;
import net.builderdog.ancient_aether.item.AncientAetherItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.function.Consumer;

public class AncientAetherRecipeData extends AncientAetherRecipeProvider {
    public AncientAetherRecipeData(PackOutput output) {
        super(output, AncientAether.MODID);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, AncientAetherBlocks.WYND_LANTERN.get())
                .requires(AncientAetherBlocks.AMBROSIUM_LANTERN.get())
                .requires(AncientAetherBlocks.WYND_SENTRY_STONE.get())
                .unlockedBy(getHasName(AncientAetherBlocks.WYND_SENTRY_STONE.get()), has(AncientAetherBlocks.WYND_SENTRY_STONE.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, AncientAetherBlocks.SUN_LANTERN.get())
                .requires(AncientAetherBlocks.AMBROSIUM_LANTERN.get())
                .requires(AetherBlocks.LIGHT_HELLFIRE_STONE.get())
                .unlockedBy(getHasName(AetherBlocks.LIGHT_HELLFIRE_STONE.get()), has(AetherBlocks.LIGHT_HELLFIRE_STONE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.AEROGEL_GLASS.get(), 8)
                .define('#', AetherBlocks.AEROGEL.get())
                .define('X', AetherBlocks.SKYROOT_PLANKS.get())
                .pattern("###")
                .pattern("#X#")
                .pattern("###")
                .unlockedBy(getHasName(AetherBlocks.AEROGEL.get()), has(AetherBlocks.AEROGEL.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.AEROGEL_GLASS_PANE.get(),16)
                .define('#', AncientAetherBlocks.AEROGEL_GLASS.get())
                .pattern("###")
                .pattern("###")
                .unlockedBy(getHasName(AncientAetherBlocks.AEROGEL_GLASS.get()), has(AncientAetherBlocks.AEROGEL_GLASS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.AEROGEL_GLASS_TRAPDOOR.get(),2)
                .define('#', AncientAetherBlocks.AEROGEL_GLASS.get())
                .pattern("##")
                .pattern("##")
                .unlockedBy(getHasName(AncientAetherBlocks.AEROGEL_GLASS.get()), has(AncientAetherBlocks.AEROGEL_GLASS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AncientAetherBlocks.AMBROSIUM_LANTERN.get())
                .define('H', AetherBlocks.HOLYSTONE.get())
                .define('S', Tags.Items.RODS_WOODEN)
                .define('T', AetherBlocks.AMBROSIUM_TORCH.get())
                .pattern("SHS")
                .pattern("STS")
                .pattern("SHS")
                .unlockedBy(getHasName(AetherBlocks.AMBROSIUM_TORCH.get()), has(AetherBlocks.AMBROSIUM_TORCH.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, AncientAetherBlocks.AMBROSIUM_CAMPFIRE.get())
                .define('L', ItemTags.LOGS)
                .define('A', AetherItems.AMBROSIUM_SHARD.get())
                .define('S', Tags.Items.RODS_WOODEN)
                .pattern(" S ")
                .pattern("SAS")
                .pattern("LLL")
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
                .define('Z', AetherTags.Items.GEMS_ZANITE)
                .define('P', AetherTags.Items.PLANKS_CRAFTING)
                .pattern("ZZ")
                .pattern("PP")
                .pattern("PP")
                .unlockedBy(getHasName(AetherItems.ZANITE_GEMSTONE.get()), has(AetherTags.Items.GEMS_ZANITE))
                .save(consumer, name("skyroot_smithing_table_from_zanite"));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, Blocks.ANVIL)
                .define('B', AetherBlocks.ZANITE_BLOCK.get())
                .define('Z', AetherTags.Items.GEMS_ZANITE)
                .pattern("BBB")
                .pattern(" Z ")
                .pattern("ZZZ")
                .unlockedBy(getHasName(AetherBlocks.ZANITE_BLOCK.get()), has(AetherBlocks.ZANITE_BLOCK.get()))
                .save(consumer, name("anvil_from_zanite"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Blocks.ENCHANTING_TABLE)
                .define('G', AetherTags.Items.PROCESSED_GRAVITITE)
                .define('O', Blocks.OBSIDIAN)
                .define('B', Items.BOOK)
                .pattern(" B ")
                .pattern("GOG")
                .pattern("OOO")
                .unlockedBy(getHasName(AetherBlocks.ENCHANTED_GRAVITITE.get()), has(AetherTags.Items.PROCESSED_GRAVITITE))
                .save(consumer, name("enchanting_table_from_gravitite"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.WIND_BLOWER.get())
                .define('W', AetherBlocks.COLD_AERCLOUD.get())
                .define('C', AncientAetherTags.Items.WINDBLOWER_INGREDIENTS)
                .pattern("WWW")
                .pattern("WCW")
                .pattern("WWW")
                .unlockedBy(getHasName(AetherBlocks.BLUE_AERCLOUD.get()), has(AncientAetherTags.Items.WINDBLOWER_INGREDIENTS))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, Items.ARMOR_STAND)
                .define('/', Tags.Items.RODS_WOODEN)
                .define('#', AetherBlocks.HOLYSTONE_SLAB.get())
                .pattern("///")
                .pattern(" / ")
                .pattern("/#/")
                .unlockedBy(getHasName(AetherBlocks.HOLYSTONE_SLAB.get()), has(AetherBlocks.HOLYSTONE_SLAB.get()))
                .save(consumer, name("armor_stand_from_holystone"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, AncientAetherItems.ANCIENT_RUNE.get(),2)
                .define('G', AetherTags.Items.PROCESSED_GRAVITITE)
                .define('R', AncientAetherItems.ANCIENT_RUNE.get())
                .define('A', AetherBlocks.AEROGEL.get())
                .pattern("GRG")
                .pattern("GAG")
                .pattern("GGG")
                .unlockedBy(getHasName(AncientAetherItems.ANCIENT_RUNE.get()), has(AncientAetherItems.ANCIENT_RUNE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AncientAetherItems.VALKYRUM_LANCE.get())
                .define('/', Tags.Items.RODS_WOODEN)
                .define('V', AncientAetherItems.VALKYRUM.get())
                .pattern("V  ")
                .pattern(" V ")
                .pattern("  /")
                .unlockedBy(getHasName(AncientAetherItems.VALKYRUM.get()), has(AncientAetherItems.VALKYRUM.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, Items.SHEARS)
                .define('Z', AetherTags.Items.GEMS_ZANITE)
                .pattern(" Z")
                .pattern("Z ")
                .unlockedBy(getHasName(AetherItems.ZANITE_GEMSTONE.get()), has(AetherTags.Items.GEMS_ZANITE))
                .save(consumer, name("shears_from_zanite"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.PAPER, 3)
                .define('#', AetherItems.AECHOR_PETAL.get())
                .pattern("###")
                .unlockedBy(getHasName(AetherItems.AECHOR_PETAL.get()), has(AetherItems.AECHOR_PETAL.get()))
                .save(consumer, name("paper_from_aechor_petals"));

        woodFromLogs(consumer, AncientAetherBlocks.HIGHSPROOT_WOOD.get(), AncientAetherBlocks.HIGHSPROOT_LOG.get());
        woodFromLogs(consumer, AncientAetherBlocks.STRIPPED_HIGHSPROOT_WOOD.get(), AncientAetherBlocks.STRIPPED_HIGHSPROOT_LOG.get());
        woodFromLogs(consumer, AncientAetherBlocks.SAKURA_WOOD.get(), AncientAetherBlocks.SAKURA_LOG.get());
        woodFromLogs(consumer, AncientAetherBlocks.STRIPPED_SAKURA_WOOD.get(), AncientAetherBlocks.STRIPPED_SAKURA_LOG.get());

        planksFromLogs(consumer, AncientAetherBlocks.HIGHSPROOT_PLANKS.get(), AncientAetherTags.Items.HIGHSPROOT_LOGS, 4);
        planksFromLogs(consumer, AncientAetherBlocks.SAKURA_PLANKS.get(), AncientAetherTags.Items.SAKURA_LOGS, 4);

        stairs(AncientAetherBlocks.HIGHSPROOT_STAIRS, AncientAetherBlocks.HIGHSPROOT_PLANKS).group("wooden_stairs").save(consumer);
        stairs(AncientAetherBlocks.SAKURA_STAIRS, AncientAetherBlocks.SAKURA_PLANKS).group("wooden_stairs").save(consumer);
        stairs(AncientAetherBlocks.CARVED_TILE_STAIRS, AncientAetherBlocks.CARVED_TILES).save(consumer);
        stairs(AncientAetherBlocks.AEROGETIC_STAIRS, AncientAetherBlocks.AEROGETIC_STONE).save(consumer);

        slabBuilder(RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.HIGHSPROOT_SLAB.get(), Ingredient.of(AncientAetherBlocks.HIGHSPROOT_PLANKS.get()))
                .group("wooden_slab")
                .unlockedBy(getHasName(AncientAetherBlocks.HIGHSPROOT_PLANKS.get()), has(AncientAetherBlocks.HIGHSPROOT_PLANKS.get()))
                .save(consumer);
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.SAKURA_SLAB.get(), Ingredient.of(AncientAetherBlocks.SAKURA_PLANKS.get()))
                .group("wooden_slab")
                .unlockedBy(getHasName(AncientAetherBlocks.SAKURA_PLANKS.get()), has(AncientAetherBlocks.SAKURA_PLANKS.get()))
                .save(consumer);

        slab(consumer, RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.CARVED_TILE_SLAB.get(), AncientAetherBlocks.CARVED_TILES.get());
        slab(consumer, RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.AEROGETIC_SLAB.get(), AncientAetherBlocks.AEROGETIC_STONE.get());

        fence(AncientAetherBlocks.HIGHSPROOT_FENCE, AncientAetherBlocks.HIGHSPROOT_PLANKS).save(consumer);
        fence(AncientAetherBlocks.SAKURA_FENCE, AncientAetherBlocks.SAKURA_PLANKS).save(consumer);

        fenceGate(AncientAetherBlocks.HIGHSPROOT_FENCE_GATE, AncientAetherBlocks.HIGHSPROOT_PLANKS).save(consumer);
        fenceGate(AncientAetherBlocks.SAKURA_FENCE_GATE, AncientAetherBlocks.SAKURA_PLANKS).save(consumer);

        wall(consumer, RecipeCategory.DECORATIONS, AncientAetherBlocks.CARVED_TILE_WALL.get(), AncientAetherBlocks.CARVED_TILES.get());
        wall(consumer, RecipeCategory.DECORATIONS, AncientAetherBlocks.AEROGETIC_WALL.get(), AncientAetherBlocks.AEROGETIC_STONE.get());

        doorBuilder(AncientAetherBlocks.HIGHSPROOT_DOOR.get(), Ingredient.of(AncientAetherBlocks.HIGHSPROOT_PLANKS.get())).unlockedBy(getHasName(AncientAetherBlocks.HIGHSPROOT_PLANKS.get()), has(AncientAetherBlocks.HIGHSPROOT_PLANKS.get())).group("wooden_door").save(consumer);
        doorBuilder(AncientAetherBlocks.SAKURA_DOOR.get(), Ingredient.of(AncientAetherBlocks.SAKURA_PLANKS.get())).unlockedBy(getHasName(AncientAetherBlocks.SAKURA_PLANKS.get()), has(AncientAetherBlocks.SAKURA_PLANKS.get())).group("wooden_door").save(consumer);
        doorBuilder(AncientAetherBlocks.AEROGEL_GLASS_DOOR.get(), Ingredient.of(AncientAetherBlocks.AEROGEL_GLASS.get())).unlockedBy(getHasName(AncientAetherBlocks.AEROGEL_GLASS.get()), has(AncientAetherBlocks.AEROGEL_GLASS.get())).save(consumer);

        trapdoorBuilder(AncientAetherBlocks.HIGHSPROOT_TRAPDOOR.get(), Ingredient.of(AncientAetherBlocks.HIGHSPROOT_PLANKS.get())).unlockedBy(getHasName(AncientAetherBlocks.HIGHSPROOT_PLANKS.get()), has(AncientAetherBlocks.HIGHSPROOT_PLANKS.get())).group("wooden_trapdoor").save(consumer);
        trapdoorBuilder(AncientAetherBlocks.SAKURA_TRAPDOOR.get(), Ingredient.of(AncientAetherBlocks.SAKURA_PLANKS.get())).unlockedBy(getHasName(AncientAetherBlocks.SAKURA_PLANKS.get()), has(AncientAetherBlocks.SAKURA_PLANKS.get())).group("wooden_trapdoor").save(consumer);

        pressurePlateBuilder(RecipeCategory.REDSTONE, AncientAetherBlocks.HIGHSPROOT_PRESSURE_PLATE.get(), Ingredient.of(AncientAetherBlocks.HIGHSPROOT_PLANKS.get())).unlockedBy(getHasName(AncientAetherBlocks.HIGHSPROOT_PLANKS.get()), has(AncientAetherBlocks.HIGHSPROOT_PLANKS.get())).group("wooden_pressure_plate").save(consumer);
        pressurePlateBuilder(RecipeCategory.REDSTONE, AncientAetherBlocks.SAKURA_PRESSURE_PLATE.get(), Ingredient.of(AncientAetherBlocks.SAKURA_PLANKS.get())).unlockedBy(getHasName(AncientAetherBlocks.SAKURA_PLANKS.get()), has(AncientAetherBlocks.SAKURA_PLANKS.get())).group("wooden_pressure_plate").save(consumer);

        buttonBuilder(AncientAetherBlocks.HIGHSPROOT_BUTTON.get(), Ingredient.of(AncientAetherBlocks.HIGHSPROOT_PLANKS.get())).unlockedBy(getHasName(AncientAetherBlocks.HIGHSPROOT_PLANKS.get()), has(AncientAetherBlocks.HIGHSPROOT_PLANKS.get())).group("wooden_button").save(consumer);
        buttonBuilder(AncientAetherBlocks.SAKURA_BUTTON.get(), Ingredient.of(AncientAetherBlocks.SAKURA_PLANKS.get())).unlockedBy(getHasName(AncientAetherBlocks.SAKURA_PLANKS.get()), has(AncientAetherBlocks.SAKURA_PLANKS.get())).group("wooden_button").save(consumer);

        sign(consumer, AncientAetherBlocks.HIGHSPROOT_SIGN.get(), AncientAetherBlocks.HIGHSPROOT_PLANKS.get());
        sign(consumer, AncientAetherBlocks.SAKURA_SIGN.get(), AncientAetherBlocks.SAKURA_PLANKS.get());

        hangingSign(consumer, AncientAetherBlocks.HIGHSPROOT_HANGING_SIGN.get(), AncientAetherBlocks.STRIPPED_HIGHSPROOT_LOG.get());
        hangingSign(consumer, AncientAetherBlocks.SAKURA_HANGING_SIGN.get(), AncientAetherBlocks.STRIPPED_SAKURA_LOG.get());

        bookshelf(consumer, AncientAetherBlocks.HIGHSPROOT_BOOKSHELF.get(), AncientAetherBlocks.HIGHSPROOT_PLANKS.get());
        bookshelf(consumer, AncientAetherBlocks.SAKURA_BOOKSHELF.get(), AncientAetherBlocks.SAKURA_PLANKS.get());

        flowerToDye(consumer, Items.RED_DYE, AncientAetherBlocks.SUNSET_ROSE.get(), "red");
        flowerToDye(consumer, Items.CYAN_DYE, AncientAetherBlocks.SKY_BLUES.get(), "cyan");
        flowerToDye(consumer, Items.LIGHT_BLUE_DYE, AncientAetherBlocks.WYND_THISTLE.get(), "light_blue");
        flowerToDye(consumer, Items.PURPLE_DYE, AncientAetherBlocks.ELEVETIA.get(), "purple");

        chiseled(consumer, RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.HOLYSTONE_BRICK_MOSAIC.get(), AetherBlocks.HOLYSTONE_BRICK_SLAB.get());
        chiseled(consumer, RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.CARVED_STONE_MOSAIC.get(), AetherBlocks.CARVED_SLAB.get());
        chiseled(consumer, RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.ANGELIC_STONE_MOSAIC.get(), AetherBlocks.ANGELIC_SLAB.get());
        chiseled(consumer, RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.HELLFIRE_STONE_MOSAIC.get(), AetherBlocks.HELLFIRE_SLAB.get());
        chiseled(consumer, RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.AEROGETIC_STONE_MOSAIC.get(), AncientAetherBlocks.AEROGETIC_SLAB.get());

        polished(consumer, RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.CARVED_TILES.get(), AetherBlocks.CARVED_STONE.get());
        carpet(consumer, AncientAetherBlocks.FLUFFALO_CARPET.get(), AncientAetherBlocks.FLUFFALO_WOOL.get());
        oreBlockStorageRecipesRecipesWithCustomUnpacking(consumer, RecipeCategory.MISC, AncientAetherItems.VALKYRUM.get(), RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.VALKYRUM_BLOCK.get(), "valkyrum_from_valkyrum_block", "valkyrum");

        makePickaxe(AncientAetherItems.VALKYRUM_PICKAXE, AncientAetherItems.VALKYRUM).save(consumer);
        makeAxe(AncientAetherItems.VALKYRUM_AXE, AncientAetherItems.VALKYRUM).save(consumer);
        makeShovel(AncientAetherItems.VALKYRUM_SHOVEL, AncientAetherItems.VALKYRUM).save(consumer);
        makeHoe(AncientAetherItems.VALKYRUM_HOE, AncientAetherItems.VALKYRUM).save(consumer);
        makeSword(AncientAetherItems.VALKYRUM_SWORD, AncientAetherItems.VALKYRUM).save(consumer);

        makeHelmet(AncientAetherItems.VALKYRUM_HELMET, AncientAetherItems.VALKYRUM).save(consumer);
        makeChestplate(AncientAetherItems.VALKYRUM_CHESTPLATE, AncientAetherItems.VALKYRUM).save(consumer);
        makeLeggings(AncientAetherItems.VALKYRUM_LEGGINGS, AncientAetherItems.VALKYRUM).save(consumer);
        makeBoots(AncientAetherItems.VALKYRUM_BOOTS, AncientAetherItems.VALKYRUM).save(consumer);
        makeGloves(AncientAetherItems.VALKYRUM_GLOVES, AncientAetherItems.VALKYRUM).save(consumer);

        makeRing(AncientAetherItems.VALKYRUM_RING, AncientAetherItems.VALKYRUM.get()).save(consumer);
        makePendant(AncientAetherItems.VALKYRUM_PENDANT, AncientAetherItems.VALKYRUM.get()).save(consumer);
        makeCape(AncientAetherItems.PINK_CAPE, Blocks.PINK_WOOL.asItem()).save(consumer);

        copyAetherSmithingTemplate(consumer, AncientAetherItems.WYND_ARMOR_TRIM_SMITHING_TEMPLATE.get(), AetherBlocks.HOLYSTONE.get());
        copyAetherSmithingTemplate(consumer, AncientAetherItems.WHALE_ARMOR_TRIM_SMITHING_TEMPLATE.get(), AetherBlocks.HOLYSTONE.get());
        copyAetherSmithingTemplate(consumer, AncientAetherItems.ASCENDED_ARMOR_TRIM_SMITHING_TEMPLATE.get(), AetherBlocks.HOLYSTONE.get());
        copyAetherSmithingTemplate(consumer, AncientAetherItems.MYSTERIOUS_ARMOR_TRIM_SMITHING_TEMPLATE.get(), AetherBlocks.MOSSY_HOLYSTONE.get());
        copyAetherSmithingTemplate(consumer, AncientAetherItems.MECHANICAL_ARMOR_TRIM_SMITHING_TEMPLATE.get(), AetherBlocks.ICESTONE.get());

        aetherSmithingTrimRecipe(consumer, AncientAetherItems.WYND_ARMOR_TRIM_SMITHING_TEMPLATE.get());
        aetherSmithingTrimRecipe(consumer, AncientAetherItems.WHALE_ARMOR_TRIM_SMITHING_TEMPLATE.get());
        aetherSmithingTrimRecipe(consumer, AncientAetherItems.ASCENDED_ARMOR_TRIM_SMITHING_TEMPLATE.get());
        aetherSmithingTrimRecipe(consumer, AncientAetherItems.MYSTERIOUS_ARMOR_TRIM_SMITHING_TEMPLATE.get());
        aetherSmithingTrimRecipe(consumer, AncientAetherItems.MECHANICAL_ARMOR_TRIM_SMITHING_TEMPLATE.get());
        aetherSmithingTrimRecipe(consumer, AncientAetherItems.MOSAIC_ARMOR_TRIM_SMITHING_TEMPLATE.get());
        aetherSmithingTrimRecipe(consumer, AncientAetherItems.ROYAL_ARMOR_TRIM_SMITHING_TEMPLATE.get());
        aetherSmithingTrimRecipe(consumer, AncientAetherItems.SOLAR_ARMOR_TRIM_SMITHING_TEMPLATE.get());
        aetherSmithingTrimRecipe(consumer, AncientAetherItems.ANCIENT_ARMOR_TRIM_SMITHING_TEMPLATE.get());

        woodenBoat(consumer, AncientAetherItems.HIGHSPROOT_BOAT.get(), AncientAetherBlocks.HIGHSPROOT_PLANKS.get());
        woodenBoat(consumer, AncientAetherItems.SAKURA_BOAT.get(), AncientAetherBlocks.SAKURA_PLANKS.get());
        woodenChestBoat(consumer, AncientAetherItems.HIGHSPROOT_CHEST_BOAT.get(), AncientAetherItems.HIGHSPROOT_BOAT.get());
        woodenChestBoat(consumer, AncientAetherItems.SAKURA_CHEST_BOAT.get(), AncientAetherItems.SAKURA_BOAT.get());

        smeltingOreRecipe(Items.QUARTZ, AncientAetherBlocks.AETHER_QUARTZ_ORE.get(), 0.5F).save(consumer, name("quartz_from_smelting_aether_quartz_ore"));
        blastingOreRecipe(Items.QUARTZ, AncientAetherBlocks.AETHER_QUARTZ_ORE.get(), 0.5F).save(consumer, name("quartz_from_blasting_aether_quartz_ore"));

        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.AEROGETIC_STAIRS.get(), AncientAetherBlocks.AEROGETIC_STONE.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.AEROGETIC_SLAB.get(), AncientAetherBlocks.AEROGETIC_STONE.get(), 2);
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.AEROGETIC_WALL.get(), AncientAetherBlocks.AEROGETIC_STONE.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.AEROGETIC_STONE.get(), AncientAetherBlocks.AERONAUTIC_STONE.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.AEROGETIC_STONE.get(), AncientAetherBlocks.CORRUPTED_AERONAUTIC_STONE.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.AERONAUTIC_STONE.get(), AncientAetherBlocks.CORRUPTED_AERONAUTIC_STONE.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.AERONAUTIC_STONE.get(), AncientAetherBlocks.AEROGETIC_STONE.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.CORRUPTED_AERONAUTIC_STONE.get(), AncientAetherBlocks.AEROGETIC_STONE.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.CORRUPTED_AERONAUTIC_STONE.get(), AncientAetherBlocks.AERONAUTIC_STONE.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.CARVED_STONE_MOSAIC.get(), AetherBlocks.CARVED_STONE.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.CARVED_TILES.get(), AetherBlocks.CARVED_STONE.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AetherBlocks.CARVED_STONE.get(), AncientAetherBlocks.CARVED_STONE_MOSAIC.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AetherBlocks.CARVED_STONE.get(), AncientAetherBlocks.CARVED_TILES.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.CARVED_TILE_STAIRS.get(), AetherBlocks.CARVED_STONE.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.CARVED_TILE_SLAB.get(), AetherBlocks.CARVED_STONE.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.CARVED_TILE_WALL.get(), AetherBlocks.CARVED_STONE.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.CARVED_TILE_STAIRS.get(), AncientAetherBlocks.CARVED_TILES.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.CARVED_TILE_SLAB.get(), AncientAetherBlocks.CARVED_TILES.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.CARVED_TILE_WALL.get(), AncientAetherBlocks.CARVED_TILES.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.ANGELIC_STONE_MOSAIC.get(), AetherBlocks.ANGELIC_STONE.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AetherBlocks.ANGELIC_STONE.get(), AncientAetherBlocks.ANGELIC_STONE_MOSAIC.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.HELLFIRE_STONE_MOSAIC.get(), AetherBlocks.HELLFIRE_STONE.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AetherBlocks.HELLFIRE_STONE.get(), AncientAetherBlocks.HELLFIRE_STONE_MOSAIC.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.HOLYSTONE_BRICK_MOSAIC.get(), AetherBlocks.HOLYSTONE_BRICKS.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AetherBlocks.HOLYSTONE_BRICKS.get(), AncientAetherBlocks.HOLYSTONE_BRICK_MOSAIC.get());
        stonecuttingRecipe(consumer, RecipeCategory.DECORATIONS, AncientAetherBlocks.HOLYSTONE_VASE.get(),  AetherBlocks.HOLYSTONE.get());
        stonecuttingRecipe(consumer, RecipeCategory.DECORATIONS, AncientAetherBlocks.HOLYSTONE_VASE.get(), AetherBlocks.HOLYSTONE_BRICKS.get());
        stonecuttingRecipe(consumer, RecipeCategory.DECORATIONS, AncientAetherBlocks.MOSSY_HOLYSTONE_VASE.get(), AetherBlocks.MOSSY_HOLYSTONE.get());
        stonecuttingRecipe(consumer, RecipeCategory.DECORATIONS, AncientAetherBlocks.SENTRY_VASE.get(), AetherBlocks.CARVED_STONE.get());
        stonecuttingRecipe(consumer, RecipeCategory.DECORATIONS, AncientAetherBlocks.ANGELIC_VASE.get(), AetherBlocks.ANGELIC_STONE.get());
        stonecuttingRecipe(consumer, RecipeCategory.DECORATIONS, AncientAetherBlocks.HELLFIRE_VASE.get(), AetherBlocks.HELLFIRE_STONE.get());
        stonecuttingRecipe(consumer, RecipeCategory.DECORATIONS, AncientAetherBlocks.AEROGETIC_VASE.get(), AncientAetherBlocks.AEROGETIC_STONE.get());

        freezingRecipe(RecipeCategory.BUILDING_BLOCKS, AetherBlocks.HOLIDAY_LEAVES.get(), AncientAetherBlocks.HIGHSPROOT_LEAVES.get(), 0.1F, 50).save(consumer);
        freezingRecipe(RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.WYND_SENTRY_STONE.get(), AetherBlocks.SENTRY_STONE.get(), 0.2F, 100).save(consumer);
        freezingRecipe(RecipeCategory.DECORATIONS, AncientAetherBlocks.FROZEN_HOLYSTONE_VASE.get(), AncientAetherBlocks.HOLYSTONE_VASE.get(), 0.2F, 100).save(consumer);

        enchantingRecipe(RecipeCategory.MISC, AncientAetherItems.VALKYRUM.get(), AncientAetherBlocks.VALKYRUM_ORE.get(), 1.5F, 1000).save(consumer);
        enchantingRecipe(RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.VIOLET_AERCLOUD.get(), AetherBlocks.BLUE_AERCLOUD.get(), 0.1F, 400).save(consumer, name("violet_aercloud_enchanting"));

        repairingRecipe(RecipeCategory.COMBAT, AncientAetherItems.VALKYRUM_HELMET.get(), 3000).group("altar_helmet_repair").save(consumer, name("valkyrum_helmet_repairing"));
        repairingRecipe(RecipeCategory.COMBAT, AncientAetherItems.VALKYRUM_CHESTPLATE.get(), 3000).group("altar_chestplate_repair").save(consumer, name("valkyrum_chestplate_repairing"));
        repairingRecipe(RecipeCategory.COMBAT, AncientAetherItems.VALKYRUM_LEGGINGS.get(), 3000).group("altar_leggings_repair").save(consumer, name("valkyrum_leggings_repairing"));
        repairingRecipe(RecipeCategory.COMBAT, AncientAetherItems.VALKYRUM_BOOTS.get(), 3000).group("altar_boots_repair").save(consumer, name("valkyrum_boots_repairing"));
        repairingRecipe(RecipeCategory.COMBAT, AncientAetherItems.VALKYRUM_GLOVES.get(), 3000).group("altar_gloves_repair").save(consumer, name("valkyrum_gloves_repairing"));
        repairingRecipe(RecipeCategory.TOOLS, AncientAetherItems.VALKYRUM_PICKAXE.get(), 3000).group("altar_pickaxe_repair").save(consumer, name("valkyrum_pickaxe_repairing"));
        repairingRecipe(RecipeCategory.TOOLS, AncientAetherItems.VALKYRUM_AXE.get(), 3000).group("altar_axe_repair").save(consumer, name("valkyrum_axe_repairing"));
        repairingRecipe(RecipeCategory.TOOLS, AncientAetherItems.VALKYRUM_SHOVEL.get(), 3000).group("altar_shovel_repair").save(consumer, name("valkyrum_shovel_repairing"));
        repairingRecipe(RecipeCategory.TOOLS, AncientAetherItems.VALKYRUM_HOE.get(), 3000).group("altar_hoe_repair").save(consumer, name("valkyrum_hoe_repairing"));
        repairingRecipe(RecipeCategory.TOOLS, AncientAetherItems.VALKYRUM_SWORD.get(), 3000).group("altar_sword_repair").save(consumer, name("valkyrum_sword_repairing"));
        repairingRecipe(RecipeCategory.TOOLS, AncientAetherItems.VALKYRUM_LANCE.get(), 3000).group("altar_sword_repair").save(consumer, name("valkyrum_lance_repairing"));

        moaIncubationRecipe(AetherEntityTypes.MOA.get(), AncientAetherMoaTypes.TURQUOISE, AncientAetherItems.TURQUOISE_MOA_EGG.get()).save(consumer, name("turquoise_moa_incubation"));
        moaIncubationRecipe(AetherEntityTypes.MOA.get(), AncientAetherMoaTypes.TEAL, AncientAetherItems.TEAL_MOA_EGG.get()).save(consumer, name("teal_moa_incubation"));
        moaIncubationRecipe(AetherEntityTypes.MOA.get(), AncientAetherMoaTypes.SKY_BLUE, AncientAetherItems.SKY_BLUE_MOA_EGG.get()).save(consumer, name("sky_blue_moa_incubation"));
        moaIncubationRecipe(AetherEntityTypes.MOA.get(), AncientAetherMoaTypes.LAVENDER, AncientAetherItems.LAVENDER_MOA_EGG.get()).save(consumer, name("lavender_moa_incubation"));
        moaIncubationRecipe(AetherEntityTypes.MOA.get(), AncientAetherMoaTypes.SAKURA, AncientAetherItems.SAKURA_MOA_EGG.get()).save(consumer, name("sakura_moa_incubation"));
        moaIncubationRecipe(AetherEntityTypes.MOA.get(), AncientAetherMoaTypes.BURGUNDY, AncientAetherItems.BURGUNDY_MOA_EGG.get()).save(consumer, name("burgundy_moa_incubation"));
        moaIncubationRecipe(AetherEntityTypes.MOA.get(), AncientAetherMoaTypes.VIOLET, AncientAetherItems.VIOLET_MOA_EGG.get()).save(consumer, name("violet_moa_incubation"));

        swetBallConversionWithProperties(AetherBlocks.AETHER_GRASS_BLOCK.get(), Map.of(AncientAetherBlockStateProperties.TYPE, AetherGrassType.FROZEN), AetherBlocks.AETHER_DIRT.get(), AncientAetherTags.Biomes.HAS_FROZEN_AETHER_GRASS).save(consumer, name("swet_ball_frozen_aether_grass"));
        swetBallConversionWithProperties(AetherBlocks.AETHER_GRASS_BLOCK.get(), Map.of(AncientAetherBlockStateProperties.TYPE, AetherGrassType.PALE), AetherBlocks.AETHER_DIRT.get(), AncientAetherTags.Biomes.HAS_PALE_AETHER_GRASS).save(consumer, name("swet_ball_pale_aether_grass"));
        swetBallConversionWithProperties(AetherBlocks.AETHER_GRASS_BLOCK.get(), Map.of(AncientAetherBlockStateProperties.TYPE, AetherGrassType.ENCHANTED), AetherBlocks.AETHER_DIRT.get(), AncientAetherTags.Biomes.HAS_ENCHANTED_AETHER_GRASS).save(consumer, name("swet_ball_enchanted_aether_grass"));
    }
}