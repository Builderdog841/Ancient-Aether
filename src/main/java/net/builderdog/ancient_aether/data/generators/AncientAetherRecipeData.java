package net.builderdog.ancient_aether.data.generators;

import com.aetherteam.aether.AetherTags;
import com.aetherteam.aether.block.AetherBlocks;
import com.aetherteam.aether.data.providers.AetherRecipeProvider;
import com.aetherteam.aether.entity.AetherEntityTypes;
import com.aetherteam.aether.item.AetherItems;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.AncientAetherTags;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.builderdog.ancient_aether.entity.moa.AncientAetherMoaTypes;
import net.builderdog.ancient_aether.item.AncientAetherItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class AncientAetherRecipeData extends AetherRecipeProvider {
    public AncientAetherRecipeData(PackOutput output) {
        super(output, AncientAether.MOD_ID);
    }

    protected static void copyAetherSmithingTemplate(Consumer<FinishedRecipe> consumer, ItemLike material, ItemLike template, TagKey<Item> block) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, template, 2)
                .define('#', material)
                .define('C', block)
                .define('S', template)
                .pattern("#S#")
                .pattern("#C#")
                .pattern("###")
                .unlockedBy(getHasName(template), has(template))
                .save(consumer);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> consumer) {

        woodFromLogs(consumer, AncientAetherBlocks.HIGHSPROOT_WOOD.get(), AncientAetherBlocks.HIGHSPROOT_LOG.get());
        woodFromLogs(consumer, AncientAetherBlocks.STRIPPED_HIGHSPROOT_WOOD.get(), AncientAetherBlocks.STRIPPED_HIGHSPROOT_LOG.get());
        planksFromLogs(consumer, AncientAetherBlocks.HIGHSPROOT_PLANKS.get(), AncientAetherTags.Items.CRAFTS_HIGHSPROOT_PLANKS, 4);

        woodFromLogs(consumer, AncientAetherBlocks.SAKURA_WOOD.get(), AncientAetherBlocks.SAKURA_LOG.get());
        woodFromLogs(consumer, AncientAetherBlocks.STRIPPED_SAKURA_WOOD.get(), AncientAetherBlocks.STRIPPED_SAKURA_LOG.get());
        planksFromLogs(consumer, AncientAetherBlocks.SAKURA_PLANKS.get(), AncientAetherTags.Items.CRAFTS_SAKURA_PLANKS, 4);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AncientAetherBlocks.HOLYSTONE_LANTERN.get())
                .define('H', AetherBlocks.HOLYSTONE.get())
                .define('S', Tags.Items.RODS_WOODEN)
                .define('T', AetherBlocks.AMBROSIUM_TORCH.get())
                .pattern("HHH")
                .pattern("STS")
                .pattern("HHH")
                .unlockedBy(getHasName(AetherBlocks.AMBROSIUM_TORCH.get()), has(AetherBlocks.AMBROSIUM_TORCH.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AncientAetherBlocks.SENTRY_LANTERN.get())
                .define('C', AetherBlocks.CARVED_STONE.get())
                .define('S', AetherBlocks.SENTRY_STONE.get())
                .define('T', AetherBlocks.AMBROSIUM_TORCH.get())
                .pattern("CCC")
                .pattern("STS")
                .pattern("CCC")
                .unlockedBy(getHasName(AetherBlocks.AMBROSIUM_TORCH.get()), has(AetherBlocks.AMBROSIUM_TORCH.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AncientAetherBlocks.ANGELIC_LANTERN.get())
                .define('A', AetherBlocks.ANGELIC_STONE.get())
                .define('L', AetherBlocks.LIGHT_ANGELIC_STONE.get())
                .define('T', AetherBlocks.AMBROSIUM_TORCH.get())
                .pattern("AAA")
                .pattern("LTL")
                .pattern("AAA")
                .unlockedBy(getHasName(AetherBlocks.AMBROSIUM_TORCH.get()), has(AetherBlocks.AMBROSIUM_TORCH.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AncientAetherBlocks.HELLFIRE_LANTERN.get())
                .define('H', AetherBlocks.HELLFIRE_STONE.get())
                .define('L', AetherBlocks.LIGHT_HELLFIRE_STONE.get())
                .define('T', AetherBlocks.AMBROSIUM_TORCH.get())
                .pattern("HHH")
                .pattern("LTL")
                .pattern("HHH")
                .unlockedBy(getHasName(AetherBlocks.AMBROSIUM_TORCH.get()), has(AetherBlocks.AMBROSIUM_TORCH.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AncientAetherBlocks.AEROGETIC_LANTERN.get())
                .define('A', AncientAetherBlocks.AEROGETIC_STONE.get())
                .define('L', AncientAetherBlocks.LIGHT_AEROGETIC_STONE.get())
                .define('T', AetherBlocks.AMBROSIUM_TORCH.get())
                .pattern("AAA")
                .pattern("LTL")
                .pattern("AAA")
                .unlockedBy(getHasName(AetherBlocks.AMBROSIUM_TORCH.get()), has(AetherBlocks.AMBROSIUM_TORCH.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, AncientAetherItems.ANCIENT_RUNE.get(),2)
                .define('G', AetherBlocks.ENCHANTED_GRAVITITE.get())
                .define('R', AncientAetherItems.ANCIENT_RUNE.get())
                .define('A', AetherBlocks.AEROGEL.get())
                .pattern("GRG")
                .pattern("GAG")
                .pattern("GGG")
                .unlockedBy(getHasName(AncientAetherItems.ANCIENT_RUNE.get()), has(AncientAetherItems.ANCIENT_RUNE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, AncientAetherItems.WYND_ARMOR_TRIM_SMITHING_TEMPLATE.get(),2)
                .define('V', AncientAetherItems.VALKYRUM.get())
                .define('T', AncientAetherItems.WYND_ARMOR_TRIM_SMITHING_TEMPLATE.get())
                .define('M', AetherBlocks.HOLYSTONE.get())
                .pattern("VTV")
                .pattern("VMV")
                .pattern("VVV")
                .unlockedBy(getHasName(AncientAetherItems.WYND_ARMOR_TRIM_SMITHING_TEMPLATE.get()), has(AncientAetherItems.WYND_ARMOR_TRIM_SMITHING_TEMPLATE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, AncientAetherItems.WHALE_ARMOR_TRIM_SMITHING_TEMPLATE.get(),2)
                .define('V', AncientAetherItems.VALKYRUM.get())
                .define('T', AncientAetherItems.WHALE_ARMOR_TRIM_SMITHING_TEMPLATE.get())
                .define('M', AetherBlocks.HOLYSTONE.get())
                .pattern("VTV")
                .pattern("VMV")
                .pattern("VVV")
                .unlockedBy(getHasName(AncientAetherItems.WHALE_ARMOR_TRIM_SMITHING_TEMPLATE.get()), has(AncientAetherItems.WHALE_ARMOR_TRIM_SMITHING_TEMPLATE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, AncientAetherItems.ASCENDED_ARMOR_TRIM_SMITHING_TEMPLATE.get(),2)
                .define('V', AncientAetherItems.VALKYRUM.get())
                .define('T', AncientAetherItems.ASCENDED_ARMOR_TRIM_SMITHING_TEMPLATE.get())
                .define('M', AetherBlocks.HOLYSTONE.get())
                .pattern("VTV")
                .pattern("VMV")
                .pattern("VVV")
                .unlockedBy(getHasName(AncientAetherItems.ASCENDED_ARMOR_TRIM_SMITHING_TEMPLATE.get()), has(AncientAetherItems.ASCENDED_ARMOR_TRIM_SMITHING_TEMPLATE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, AncientAetherItems.MYSTERIOUS_ARMOR_TRIM_SMITHING_TEMPLATE.get(),2)
                .define('V', AncientAetherItems.VALKYRUM.get())
                .define('T', AncientAetherItems.MYSTERIOUS_ARMOR_TRIM_SMITHING_TEMPLATE.get())
                .define('M', AetherBlocks.MOSSY_HOLYSTONE.get())
                .pattern("VTV")
                .pattern("VMV")
                .pattern("VVV")
                .unlockedBy(getHasName(AncientAetherItems.MYSTERIOUS_ARMOR_TRIM_SMITHING_TEMPLATE.get()), has(AncientAetherItems.MYSTERIOUS_ARMOR_TRIM_SMITHING_TEMPLATE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, AncientAetherItems.MECHANICAL_ARMOR_TRIM_SMITHING_TEMPLATE.get(),2)
                .define('V', AncientAetherItems.VALKYRUM.get())
                .define('T', AncientAetherItems.MECHANICAL_ARMOR_TRIM_SMITHING_TEMPLATE.get())
                .define('M', AetherBlocks.ICESTONE.get())
                .pattern("VTV")
                .pattern("VMV")
                .pattern("VVV")
                .unlockedBy(getHasName(AncientAetherItems.MECHANICAL_ARMOR_TRIM_SMITHING_TEMPLATE.get()), has(AncientAetherItems.MECHANICAL_ARMOR_TRIM_SMITHING_TEMPLATE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Blocks.ENCHANTING_TABLE)
                .define('G', AetherBlocks.ENCHANTED_GRAVITITE.get())
                .define('O', Blocks.OBSIDIAN)
                .define('B', Items.BOOK)
                .pattern(" B ")
                .pattern("GOG")
                .pattern("OOO")
                .unlockedBy(getHasName(AetherBlocks.ENCHANTED_GRAVITITE.get()), has(AetherBlocks.ENCHANTED_GRAVITITE.get()))
                .save(consumer, name("enchanting_table_from_gravitite"));

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
                .group("minecraft:stonecutter")
                .define('Z', AetherItems.ZANITE_GEMSTONE.get())
                .define('#', AetherBlocks.HOLYSTONE.get())
                .pattern(" Z ")
                .pattern("###")
                .unlockedBy("has_holystone", has(AetherBlocks.HOLYSTONE.get()))
                .save(consumer, name("holystone_stonecutter_from_zanite"));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, Blocks.SMITHING_TABLE)
                .group("minecraft:smithing_table")
                .define('Z', AetherItems.ZANITE_GEMSTONE.get())
                .define('P', AetherTags.Items.PLANKS_CRAFTING)
                .pattern("ZZ")
                .pattern("PP")
                .pattern("PP")
                .unlockedBy(getHasName(AetherItems.ZANITE_GEMSTONE.get()), has(AetherItems.ZANITE_GEMSTONE.get()))
                .save(consumer, name("skyroot_smithing_table_from_zanite"));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, Blocks.ANVIL)
                .define('B', AetherBlocks.ZANITE_BLOCK.get())
                .define('Z', AetherItems.ZANITE_GEMSTONE.get())
                .pattern("BBB")
                .pattern(" Z ")
                .pattern("ZZZ")
                .unlockedBy(getHasName(AetherBlocks.ZANITE_BLOCK.get()), has(AetherBlocks.ZANITE_BLOCK.get()))
                .save(consumer, name("anvil_from_zanite"));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, Items.SHEARS)
                .define('Z', AetherItems.ZANITE_GEMSTONE.get())
                .pattern(" Z")
                .pattern("Z ")
                .unlockedBy(getHasName(AetherItems.ZANITE_GEMSTONE.get()), has(AetherItems.ZANITE_GEMSTONE.get()))
                .save(consumer, name("shears_from_zanite"));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AncientAetherItems.HIGHSPROOT_SIGN.get(), 3)
                .group("wooden_sign")
                .define('P', AncientAetherBlocks.HIGHSPROOT_PLANKS.get().asItem())
                .define('/', Tags.Items.RODS_WOODEN)
                .pattern("PPP")
                .pattern("PPP")
                .pattern(" / ")
                .unlockedBy(getHasName(AncientAetherBlocks.HIGHSPROOT_PLANKS.get()), has(AncientAetherBlocks.HIGHSPROOT_PLANKS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AncientAetherItems.SAKURA_SIGN.get(), 3)
                .group("wooden_sign")
                .define('P', AncientAetherBlocks.SAKURA_PLANKS.get().asItem())
                .define('/', Tags.Items.RODS_WOODEN)
                .pattern("PPP")
                .pattern("PPP")
                .pattern(" / ")
                .unlockedBy(getHasName(AncientAetherBlocks.SAKURA_PLANKS.get()), has(AncientAetherBlocks.SAKURA_PLANKS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AncientAetherBlocks.HIGHSPROOT_HANGING_SIGN.get(), 6)
                .group("hanging_sign")
                .define('#', AncientAetherBlocks.STRIPPED_HIGHSPROOT_LOG.get())
                .define('X', Items.CHAIN)
                .pattern("X X")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_stripped_logs", has(AncientAetherBlocks.STRIPPED_HIGHSPROOT_LOG.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AncientAetherBlocks.SAKURA_HANGING_SIGN.get(), 6)
                .group("hanging_sign")
                .define('#', AncientAetherBlocks.STRIPPED_SAKURA_LOG.get())
                .define('X', Items.CHAIN)
                .pattern("X X")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_stripped_logs", has(AncientAetherBlocks.STRIPPED_SAKURA_LOG.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.BUFFALO_CARPET.get(), 3)
                .group("carpet")
                .define('#', AncientAetherBlocks.BUFFALO_WOOL.get())
                .pattern("##")
                .unlockedBy(getHasName(AncientAetherBlocks.BUFFALO_WOOL.get()), has(AncientAetherBlocks.BUFFALO_WOOL.get()))
                .save(consumer);

        makePickaxe(AncientAetherItems.VALKYRUM_PICKAXE, AncientAetherItems.VALKYRUM).save(consumer);
        makeAxe(AncientAetherItems.VALKYRUM_AXE, AncientAetherItems.VALKYRUM).save(consumer);
        makeShovel(AncientAetherItems.VALKYRUM_SHOVEL, AncientAetherItems.VALKYRUM).save(consumer);
        makeHoe(AncientAetherItems.VALKYRUM_HOE, AncientAetherItems.VALKYRUM).save(consumer);
        makeSword(AncientAetherItems.VALKYRUM_SWORD, AncientAetherItems.VALKYRUM).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AncientAetherItems.VALKYRUM_LANCE.get())
                .define('S', Tags.Items.RODS_WOODEN)
                .define('V', AncientAetherItems.VALKYRUM.get())
                .pattern("V  ")
                .pattern(" V ")
                .pattern("  S")
                .unlockedBy(getHasName(AncientAetherItems.VALKYRUM.get()), has(AncientAetherItems.VALKYRUM.get()))
                .save(consumer);

        makeHelmet(AncientAetherItems.VALKYRUM_HELMET, AncientAetherItems.VALKYRUM).save(consumer);
        makeChestplate(AncientAetherItems.VALKYRUM_CHESTPLATE, AncientAetherItems.VALKYRUM).save(consumer);
        makeLeggings(AncientAetherItems.VALKYRUM_LEGGINGS, AncientAetherItems.VALKYRUM).save(consumer);
        makeBoots(AncientAetherItems.VALKYRUM_BOOTS, AncientAetherItems.VALKYRUM).save(consumer);
        makeGloves(AncientAetherItems.VALKYRUM_GLOVES, AncientAetherItems.VALKYRUM).save(consumer);

        makeRing(AncientAetherItems.VALKYRUM_RING, AncientAetherItems.VALKYRUM.get()).save(consumer);
        makePendant(AncientAetherItems.VALKYRUM_PENDANT, AncientAetherItems.VALKYRUM.get()).save(consumer);

        makeCape(AncientAetherItems.PINK_CAPE, Blocks.PINK_WOOL.asItem()).save(consumer);

        pressurePlateBuilder(RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.HOLYSTONE_BRICK_MOSAIC.get(), Ingredient.of(AetherBlocks.HOLYSTONE_BRICK_SLAB.get())).unlockedBy(getHasName(AetherBlocks.HOLYSTONE_BRICK_SLAB.get()), has(AetherBlocks.HOLYSTONE_BRICK_SLAB.get())).save(consumer);
        pressurePlateBuilder(RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.CARVED_STONE_MOSAIC.get(), Ingredient.of(AetherBlocks.CARVED_SLAB.get())).unlockedBy(getHasName(AetherBlocks.CARVED_SLAB.get()), has(AetherBlocks.CARVED_SLAB.get())).save(consumer);
        pressurePlateBuilder(RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.ANGELIC_STONE_MOSAIC.get(), Ingredient.of(AetherBlocks.ANGELIC_SLAB.get())).unlockedBy(getHasName(AetherBlocks.ANGELIC_SLAB.get()), has(AetherBlocks.ANGELIC_SLAB.get())).save(consumer);
        pressurePlateBuilder(RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.HELLFIRE_STONE_MOSAIC.get(), Ingredient.of(AetherBlocks.HELLFIRE_SLAB.get())).unlockedBy(getHasName(AetherBlocks.HELLFIRE_SLAB.get()), has(AetherBlocks.HELLFIRE_SLAB.get())).save(consumer);
        pressurePlateBuilder(RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.AEROGETIC_STONE_MOSAIC.get(), Ingredient.of(AncientAetherBlocks.AEROGETIC_SLAB.get())).unlockedBy(getHasName(AncientAetherBlocks.AEROGETIC_SLAB.get()), has(AncientAetherBlocks.AEROGETIC_SLAB.get())).save(consumer);

        fence(AncientAetherBlocks.HIGHSPROOT_FENCE, AncientAetherBlocks.HIGHSPROOT_PLANKS).save(consumer);
        fenceGate(AncientAetherBlocks.HIGHSPROOT_FENCE_GATE, AncientAetherBlocks.HIGHSPROOT_PLANKS).save(consumer);

        fence(AncientAetherBlocks.SAKURA_FENCE, AncientAetherBlocks.SAKURA_PLANKS).save(consumer);
        fenceGate(AncientAetherBlocks.SAKURA_FENCE_GATE, AncientAetherBlocks.SAKURA_PLANKS).save(consumer);

        stairs(AncientAetherBlocks.HIGHSPROOT_STAIRS, AncientAetherBlocks.HIGHSPROOT_PLANKS).group("wooden_stairs").save(consumer);
        stairs(AncientAetherBlocks.SAKURA_STAIRS, AncientAetherBlocks.SAKURA_PLANKS).group("wooden_stairs").save(consumer);
        stairs(AncientAetherBlocks.CARVED_TILE_STAIRS, AncientAetherBlocks.CARVED_TILES).save(consumer);
        stairs(AncientAetherBlocks.AEROGETIC_STAIRS, AncientAetherBlocks.AEROGETIC_STONE).save(consumer);

        wall(consumer, RecipeCategory.DECORATIONS, AncientAetherBlocks.CARVED_TILE_WALL.get(), AncientAetherBlocks.CARVED_TILES.get());
        wall(consumer, RecipeCategory.DECORATIONS, AncientAetherBlocks.AEROGETIC_WALL.get(), AncientAetherBlocks.AEROGETIC_STONE.get());

        oreBlockStorageRecipesRecipesWithCustomUnpacking(consumer, RecipeCategory.MISC, AncientAetherItems.VALKYRUM.get(), RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.VALKYRUM_BLOCK.get(), "valkyrum_from_valkyrum_block", "valkyrum");

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

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.WIND_BLOWER.get())
                .define('W', AetherBlocks.COLD_AERCLOUD.get())
                .define('C', AncientAetherTags.Items.WINDBLOWER_INGREDIENT)
                .pattern("WWW")
                .pattern("WCW")
                .pattern("WWW")
                .unlockedBy("ancient_aether:windblower_ingredient", has(AncientAetherTags.Items.WINDBLOWER_INGREDIENT))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.AEROGEL_GLASS.get(),8)
                .define('A', AetherBlocks.AEROGEL.get())
                .define('P', AetherTags.Items.PLANKS_CRAFTING)
                .pattern("AAA")
                .pattern("APA")
                .pattern("AAA")
                .unlockedBy(getHasName(AetherBlocks.AEROGEL.get()), has(AetherBlocks.AEROGEL.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.HIGHSPROOT_BOOKSHELF.get())
                .define('P', AncientAetherBlocks.HIGHSPROOT_PLANKS.get())
                .define('B', Items.BOOK)
                .pattern("PPP")
                .pattern("BBB")
                .pattern("PPP")
                .unlockedBy(getHasName(Items.BOOK), has(Items.BOOK))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.SAKURA_BOOKSHELF.get())
                .define('P', AncientAetherBlocks.SAKURA_PLANKS.get())
                .define('B', Items.BOOK)
                .pattern("PPP")
                .pattern("BBB")
                .pattern("PPP")
                .unlockedBy(getHasName(Items.BOOK), has(Items.BOOK))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.MAGENTA_DYE)
                .group("magenta_dye")
                .requires(AncientAetherBlocks.HIGHLAND_VIOLA.get())
                .unlockedBy(getHasName(AncientAetherBlocks.HIGHLAND_VIOLA.get()), has(AncientAetherBlocks.HIGHLAND_VIOLA.get()))
                .save(consumer, name("highland_viola_to_magenta_dye"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.CYAN_DYE)
                .group("cyan_dye")
                .requires(AncientAetherBlocks.SKY_BLUES.get())
                .unlockedBy(getHasName(AncientAetherBlocks.SKY_BLUES.get()), has(AncientAetherBlocks.SKY_BLUES.get()))
                .save(consumer, name("sky_blues_to_cyan_dye"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.LIGHT_BLUE_DYE)
                .group("light_blue_dye")
                .requires(AncientAetherBlocks.WYND_THISTLE.get())
                .unlockedBy(getHasName(AncientAetherBlocks.WYND_THISTLE.get()), has(AncientAetherBlocks.WYND_THISTLE.get()))
                .save(consumer, name("wynd_thistle_to_light_blue_dye"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.PINK_DYE)
                .group("pink_dye")
                .requires(AncientAetherBlocks.SAKURA_BLOSSOMS.get())
                .unlockedBy(getHasName(AncientAetherBlocks.SAKURA_BLOSSOMS.get()), has(AncientAetherBlocks.SAKURA_BLOSSOMS.get()))
                .save(consumer, name("sakura_blossom_to_pink_dye"));

        woodenBoat(consumer, AncientAetherItems.HIGHSPROOT_BOAT.get(), AncientAetherBlocks.HIGHSPROOT_PLANKS.get());
        ShapelessRecipeBuilder.shapeless(RecipeCategory.TRANSPORTATION, AncientAetherItems.HIGHSPROOT_CHEST_BOAT.get())
                .group("chest_boat")
                .requires(Tags.Items.CHESTS_WOODEN)
                .requires(AncientAetherItems.HIGHSPROOT_BOAT.get())
                .unlockedBy("has_boat", has(ItemTags.BOATS))
                .save(consumer);

        woodenBoat(consumer, AncientAetherItems.SAKURA_BOAT.get(), AncientAetherBlocks.SAKURA_PLANKS.get());
        ShapelessRecipeBuilder.shapeless(RecipeCategory.TRANSPORTATION, AncientAetherItems.SAKURA_CHEST_BOAT.get())
                .group("chest_boat")
                .requires(Tags.Items.CHESTS_WOODEN)
                .requires(AncientAetherItems.SAKURA_BOAT.get())
                .unlockedBy("has_boat", has(ItemTags.BOATS))
                .save(consumer);

        doorBuilder(AncientAetherBlocks.HIGHSPROOT_DOOR.get(), Ingredient.of(AncientAetherBlocks.HIGHSPROOT_PLANKS.get())).unlockedBy(getHasName(AncientAetherBlocks.HIGHSPROOT_PLANKS.get()), has(AncientAetherBlocks.HIGHSPROOT_PLANKS.get())).group("wooden_door").save(consumer);
        trapdoorBuilder(AncientAetherBlocks.HIGHSPROOT_TRAPDOOR.get(), Ingredient.of(AncientAetherBlocks.HIGHSPROOT_PLANKS.get())).unlockedBy(getHasName(AncientAetherBlocks.HIGHSPROOT_PLANKS.get()), has(AncientAetherBlocks.HIGHSPROOT_PLANKS.get())).group("wooden_trapdoor").save(consumer);
        buttonBuilder(AncientAetherBlocks.HIGHSPROOT_BUTTON.get(), Ingredient.of(AncientAetherBlocks.HIGHSPROOT_PLANKS.get())).unlockedBy(getHasName(AncientAetherBlocks.HIGHSPROOT_PLANKS.get()), has(AncientAetherBlocks.HIGHSPROOT_PLANKS.get())).group("wooden_button").save(consumer);
        pressurePlateBuilder(RecipeCategory.REDSTONE, AncientAetherBlocks.HIGHSPROOT_PRESSURE_PLATE.get(), Ingredient.of(AncientAetherBlocks.HIGHSPROOT_PLANKS.get())).unlockedBy(getHasName(AncientAetherBlocks.HIGHSPROOT_PLANKS.get()), has(AncientAetherBlocks.HIGHSPROOT_PLANKS.get())).group("wooden_pressure_plate").save(consumer);

        doorBuilder(AncientAetherBlocks.SAKURA_DOOR.get(), Ingredient.of(AncientAetherBlocks.SAKURA_PLANKS.get())).unlockedBy(getHasName(AncientAetherBlocks.SAKURA_PLANKS.get()), has(AncientAetherBlocks.SAKURA_PLANKS.get())).group("wooden_door").save(consumer);
        trapdoorBuilder(AncientAetherBlocks.SAKURA_TRAPDOOR.get(), Ingredient.of(AncientAetherBlocks.SAKURA_PLANKS.get())).unlockedBy(getHasName(AncientAetherBlocks.SAKURA_PLANKS.get()), has(AncientAetherBlocks.SAKURA_PLANKS.get())).group("wooden_trapdoor").save(consumer);
        buttonBuilder(AncientAetherBlocks.SAKURA_BUTTON.get(), Ingredient.of(AncientAetherBlocks.SAKURA_PLANKS.get())).unlockedBy(getHasName(AncientAetherBlocks.SAKURA_PLANKS.get()), has(AncientAetherBlocks.SAKURA_PLANKS.get())).group("wooden_button").save(consumer);
        pressurePlateBuilder(RecipeCategory.REDSTONE, AncientAetherBlocks.SAKURA_PRESSURE_PLATE.get(), Ingredient.of(AncientAetherBlocks.SAKURA_PLANKS.get())).unlockedBy(getHasName(AncientAetherBlocks.SAKURA_PLANKS.get()), has(AncientAetherBlocks.SAKURA_PLANKS.get())).group("wooden_pressure_plate").save(consumer);

        doorBuilder(AncientAetherBlocks.AEROGEL_GLASS_DOOR.get(), Ingredient.of(AncientAetherBlocks.AEROGEL_GLASS.get())).unlockedBy(getHasName(AncientAetherBlocks.AEROGEL_GLASS.get()), has(AncientAetherBlocks.AEROGEL_GLASS.get())).save(consumer);

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

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.CARVED_TILES.get(),4)
                    .define('#', AetherBlocks.CARVED_STONE.get())
                .pattern("##")
                .pattern("##")
                .unlockedBy(getHasName(AncientAetherBlocks.CARVED_TILES.get()), has(AncientAetherBlocks.CARVED_TILES.get()))
                .save(consumer);

        smeltingOreRecipe(Items.QUARTZ, AncientAetherBlocks.AETHER_QUARTZ_ORE.get(), 0.5F).save(consumer, name("quartz_from_smelting_aether_quartz_ore"));
        blastingOreRecipe(Items.QUARTZ, AncientAetherBlocks.AETHER_QUARTZ_ORE.get(), 0.5F).save(consumer, name("quartz_from_blasting_aether_quartz_ore"));

        stonecuttingRecipe(consumer, RecipeCategory.DECORATIONS, AncientAetherBlocks.AEROGETIC_WALL.get(), AncientAetherBlocks.AEROGETIC_STONE.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.AEROGETIC_STAIRS.get(), AncientAetherBlocks.AEROGETIC_STONE.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.AEROGETIC_SLAB.get(), AncientAetherBlocks.AEROGETIC_STONE.get(), 2);
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.AEROGETIC_STONE.get(), AncientAetherBlocks.LIGHT_AEROGETIC_STONE.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.AEROGETIC_STONE.get(), AncientAetherBlocks.CORRUPTED_LIGHT_AEROGETIC_STONE.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.LIGHT_AEROGETIC_STONE.get(), AncientAetherBlocks.CORRUPTED_LIGHT_AEROGETIC_STONE.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.LIGHT_AEROGETIC_STONE.get(), AncientAetherBlocks.AEROGETIC_STONE.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.CORRUPTED_LIGHT_AEROGETIC_STONE.get(), AncientAetherBlocks.AEROGETIC_STONE.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.CORRUPTED_LIGHT_AEROGETIC_STONE.get(), AncientAetherBlocks.LIGHT_AEROGETIC_STONE.get());

        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.CARVED_STONE_MOSAIC.get(), AetherBlocks.CARVED_STONE.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.CARVED_TILES.get(), AetherBlocks.CARVED_STONE.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AetherBlocks.CARVED_STONE.get(), AncientAetherBlocks.CARVED_STONE_MOSAIC.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AetherBlocks.CARVED_STONE.get(), AncientAetherBlocks.CARVED_TILES.get());

        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.ANGELIC_STONE_MOSAIC.get(), AetherBlocks.ANGELIC_STONE.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AetherBlocks.ANGELIC_STONE.get(), AncientAetherBlocks.ANGELIC_STONE_MOSAIC.get());

        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.HELLFIRE_STONE_MOSAIC.get(), AetherBlocks.HELLFIRE_STONE.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AetherBlocks.HELLFIRE_STONE.get(), AncientAetherBlocks.HELLFIRE_STONE_MOSAIC.get());

        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.HOLYSTONE_BRICK_MOSAIC.get(), AetherBlocks.HOLYSTONE_BRICKS.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AetherBlocks.HOLYSTONE_BRICKS.get(), AncientAetherBlocks.HOLYSTONE_BRICK_MOSAIC.get());

        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.HOLYSTONE_VASE.get(),  AetherBlocks.HOLYSTONE.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.HOLYSTONE_VASE.get(), AetherBlocks.HOLYSTONE_BRICKS.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.MOSSY_HOLYSTONE_VASE.get(), AetherBlocks.MOSSY_HOLYSTONE.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.SENTRY_VASE.get(), AetherBlocks.CARVED_STONE.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.ANGELIC_VASE.get(), AetherBlocks.ANGELIC_STONE.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.HELLFIRE_VASE.get(), AetherBlocks.HELLFIRE_STONE.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.AEROGETIC_VASE.get(), AncientAetherBlocks.AEROGETIC_STONE.get());

        freezingRecipe(RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.FROZEN_HOLYSTONE_VASE.get(), AncientAetherBlocks.HOLYSTONE_VASE.get(), 0.2F, 100).save(consumer);

        freezingRecipe(RecipeCategory.BUILDING_BLOCKS, AetherBlocks.HOLIDAY_LEAVES.get(), AncientAetherBlocks.HIGHSPROOT_LEAVES.get(), 0.1F, 50).save(consumer);

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
    }
}