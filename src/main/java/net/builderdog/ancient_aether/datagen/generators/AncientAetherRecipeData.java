package net.builderdog.ancient_aether.datagen.generators;

import com.aetherteam.aether.Aether;
import com.aetherteam.aether.block.AetherBlocks;
import com.aetherteam.aether.data.providers.AetherRecipeProvider;
import com.aetherteam.aether.entity.AetherEntityTypes;
import com.aetherteam.aether.item.AetherItems;
import net.builderdog.ancient_aether.AncientAetherTags;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.builderdog.ancient_aether.entity.moa.AncientAetherMoaTypes;
import net.builderdog.ancient_aether.item.AncientAetherItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

public class AncientAetherRecipeData extends AetherRecipeProvider {
    public AncientAetherRecipeData(PackOutput output) {
        super(output, Aether.MODID);
    }

    @Override
    @SuppressWarnings("removal")
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, AncientAetherItems.BUFFALO_RIB.get())
                .requires(AncientAetherItems.COOKED_BUFFALO_RIBS.get())
                .unlockedBy(getHasName(AncientAetherItems.COOKED_BUFFALO_RIBS.get()), has(AncientAetherItems.COOKED_BUFFALO_RIBS.get()))
                .save(consumer, name("buffalo_rib"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, AncientAetherItems.AECHOR_ICE_CREAM_BUCKET.get())
                .requires(AetherItems.AECHOR_PETAL.get())
                .requires(AetherItems.SKYROOT_BUCKET.get())
                .requires(AetherBlocks.ICESTONE.get())
                .requires(Items.SUGAR)
                .unlockedBy(getHasName(AetherItems.AECHOR_PETAL.get()), has(AetherItems.AECHOR_PETAL.get()))
                .save(consumer, name("aechor_ice_cream_bucket"));

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

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, AncientAetherItems.ANCIENT_SENTRY_RUNE.get(),2)
                .define('G', AetherBlocks.ENCHANTED_GRAVITITE.get())
                .define('R', AncientAetherItems.ANCIENT_SENTRY_RUNE.get())
                .define('S', AncientAetherBlocks.ANCIENT_SENTRY_STONE.get())
                .pattern("GGG")
                .pattern("GRG")
                .pattern("GSG")
                .unlockedBy(getHasName(AncientAetherItems.ANCIENT_SENTRY_RUNE.get()), has(AncientAetherItems.ANCIENT_SENTRY_RUNE.get()))
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

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Blocks.ANVIL)
                .define('Z', AetherItems.ZANITE_GEMSTONE.get())
                .define('B', AetherBlocks.ZANITE_BLOCK.get())
                .pattern("BBB")
                .pattern(" Z ")
                .pattern("ZZZ")
                .unlockedBy(getHasName(AetherBlocks.ZANITE_BLOCK.get()), has(AetherBlocks.ZANITE_BLOCK.get()))
                .save(consumer, name("zanite_anvil"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Items.SHEARS)
                .define('Z', AetherItems.ZANITE_GEMSTONE.get())
                .pattern("Z ")
                .pattern(" Z")
                .unlockedBy(getHasName(AetherItems.ZANITE_GEMSTONE.get()), has(AetherItems.ZANITE_GEMSTONE.get()))
                .save(consumer, name("zanite_shears"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, AncientAetherBlocks.AMBROSIUM_CAMPFIRE.get())
                .define('L', ItemTags.LOGS)
                .define('A', AetherItems.AMBROSIUM_SHARD.get())
                .define('S', Tags.Items.RODS_WOODEN)
                .pattern(" S ")
                .pattern("SAS")
                .pattern("LLL")
                .unlockedBy(getHasName(AetherItems.AMBROSIUM_SHARD.get()), has(AetherItems.AMBROSIUM_SHARD.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.PAPER, 3)
                .define('P', AetherItems.AECHOR_PETAL.get().asItem())
                .pattern("PPP")
                .unlockedBy(getHasName(AetherItems.AECHOR_PETAL.get()), has(AetherItems.AECHOR_PETAL.get()))
                .save(consumer ,name("paper_from_aechor_petals"));

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

        pressurePlateBuilder(RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.HOLYSTONE_BRICK_MOSAIC.get(), Ingredient.of(AetherBlocks.HOLYSTONE_BRICK_SLAB.get())).unlockedBy(getHasName(AetherBlocks.HOLYSTONE_BRICK_SLAB.get()), has(AetherBlocks.HOLYSTONE_BRICK_SLAB.get())).save(consumer);
        pressurePlateBuilder(RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.CARVED_STONE_MOSAIC.get(), Ingredient.of(AetherBlocks.CARVED_SLAB.get())).unlockedBy(getHasName(AetherBlocks.CARVED_SLAB.get()), has(AetherBlocks.CARVED_SLAB.get())).save(consumer);
        pressurePlateBuilder(RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.ANGELIC_STONE_MOSAIC.get(), Ingredient.of(AetherBlocks.ANGELIC_SLAB.get())).unlockedBy(getHasName(AetherBlocks.ANGELIC_SLAB.get()), has(AetherBlocks.ANGELIC_SLAB.get())).save(consumer);
        pressurePlateBuilder(RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.HELLFIRE_STONE_MOSAIC.get(), Ingredient.of(AetherBlocks.HELLFIRE_SLAB.get())).unlockedBy(getHasName(AetherBlocks.HELLFIRE_SLAB.get()), has(AetherBlocks.HELLFIRE_SLAB.get())).save(consumer);

        fence(AncientAetherBlocks.HIGHSPROOT_FENCE, AncientAetherBlocks.HIGHSPROOT_PLANKS).save(consumer);
        fenceGate(AncientAetherBlocks.HIGHSPROOT_FENCE_GATE, AncientAetherBlocks.HIGHSPROOT_PLANKS).save(consumer);

        fence(AncientAetherBlocks.SAKURA_FENCE, AncientAetherBlocks.SAKURA_PLANKS).save(consumer);
        fenceGate(AncientAetherBlocks.SAKURA_FENCE_GATE, AncientAetherBlocks.SAKURA_PLANKS).save(consumer);

        wall(consumer, RecipeCategory.DECORATIONS, AncientAetherBlocks.QUICKSOIL_BRICK_WALL.get(), AncientAetherBlocks.QUICKSOIL_BRICKS.get());

        stairs(AncientAetherBlocks.HIGHSPROOT_STAIRS, AncientAetherBlocks.HIGHSPROOT_PLANKS).group("wooden_stairs").save(consumer);
        stairs(AncientAetherBlocks.SAKURA_STAIRS, AncientAetherBlocks.SAKURA_PLANKS).group("wooden_stairs").save(consumer);
        stairs(AncientAetherBlocks.QUICKSOIL_BRICK_STAIRS, AncientAetherBlocks.QUICKSOIL_BRICKS).save(consumer);

        slabBuilder(RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.HIGHSPROOT_SLAB.get(), Ingredient.of(AncientAetherBlocks.HIGHSPROOT_PLANKS.get()))
                .group("wooden_slab")
                .unlockedBy(getHasName(AncientAetherBlocks.HIGHSPROOT_PLANKS.get()), has(AncientAetherBlocks.HIGHSPROOT_PLANKS.get()))
                .save(consumer);
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.SAKURA_SLAB.get(), Ingredient.of(AncientAetherBlocks.SAKURA_PLANKS.get()))
                .group("wooden_slab")
                .unlockedBy(getHasName(AncientAetherBlocks.SAKURA_PLANKS.get()), has(AncientAetherBlocks.SAKURA_PLANKS.get()))
                .save(consumer);

        slab(consumer, RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.QUICKSOIL_BRICK_SLAB.get(), AncientAetherBlocks.QUICKSOIL_BRICKS.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, AetherBlocks.SKYROOT_BOOKSHELF.get())
                .define('P', AncientAetherBlocks.HIGHSPROOT_PLANKS.get())
                .define('B', Items.BOOK)
                .pattern("PPP")
                .pattern("BBB")
                .pattern("PPP")
                .unlockedBy(getHasName(Items.BOOK), has(Items.BOOK))
                .save(consumer, name("highsproot_bookshelf"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, AetherBlocks.SKYROOT_BOOKSHELF.get())
                .define('P', AncientAetherBlocks.SAKURA_PLANKS.get())
                .define('B', Items.BOOK)
                .pattern("PPP")
                .pattern("BBB")
                .pattern("PPP")
                .unlockedBy(getHasName(Items.BOOK), has(Items.BOOK))
                .save(consumer, name("sakura_bookshelf"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.PURPLE_DYE)
                .group("purple_dye")
                .requires(AncientAetherBlocks.MOONLIT_WATERLILY.get())
                .unlockedBy(getHasName(AncientAetherBlocks.MOONLIT_WATERLILY.get()), has(AncientAetherBlocks.MOONLIT_WATERLILY.get()))
                .save(consumer, name("flower_to_purple_dye"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.BLUE_DYE)
                .group("blue_dye")
                .requires(AncientAetherBlocks.HIGHLAND_TULIP.get())
                .unlockedBy(getHasName(AncientAetherBlocks.HIGHLAND_TULIP.get()), has(AncientAetherBlocks.HIGHLAND_TULIP.get()))
                .save(consumer, name("flower_to_blue_dye"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.WHITE_DYE)
                .group("white_dye")
                .requires(AncientAetherBlocks.EDELWEISS.get())
                .unlockedBy(getHasName(AncientAetherBlocks.EDELWEISS.get()), has(AncientAetherBlocks.EDELWEISS.get()))
                .save(consumer, name("flower_to_white_dye"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.BLUE_DYE)
                .group("pink_dye")
                .requires(AncientAetherBlocks.SAKURA_BLOSSOMS.get())
                .unlockedBy(getHasName(AncientAetherBlocks.SAKURA_BLOSSOMS.get()), has(AncientAetherBlocks.SAKURA_BLOSSOMS.get()))
                .save(consumer, name("flower_to_pink_dye"));

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

        smeltingOreRecipe(Items.QUARTZ, AncientAetherBlocks.AETHER_QUARTZ_ORE.get(), 0.5F).save(consumer, name("quartz_from_smelting_aether_quartz_ore"));
        blastingOreRecipe(Items.QUARTZ, AncientAetherBlocks.AETHER_QUARTZ_ORE.get(), 0.5F).save(consumer, name("quartz_from_blasting_aether_quartz_ore"));

        smeltingOreRecipe(AncientAetherItems.COOKED_BUFFALO_RIBS.get(), AncientAetherItems.RAW_BUFFALO_RIBS.get(), 0.2F).save(consumer);
        smokingRecipe(AncientAetherItems.COOKED_BUFFALO_RIBS.get(), AncientAetherItems.RAW_BUFFALO_RIBS.get(), 0.2F).save(consumer, name("cooked_buffalo_ribs_from_smoking"));
        campfireCookingRecipe(AncientAetherItems.COOKED_BUFFALO_RIBS.get(), AncientAetherItems.RAW_BUFFALO_RIBS.get(), 0.2F).save(consumer, name("cooked_buffalo_ribs_from_campfire_cooking"));

        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.ANCIENT_SENTRY_STONE.get(), AetherBlocks.CARVED_STONE.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AetherBlocks.CARVED_STONE.get(), AncientAetherBlocks.ANCIENT_SENTRY_STONE.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.ANCIENT_SENTRY_STONE.get(), AetherBlocks.SENTRY_STONE.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AetherBlocks.SENTRY_STONE.get(), AncientAetherBlocks.ANCIENT_SENTRY_STONE.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.CARVED_STONE_MOSAIC.get(), AetherBlocks.CARVED_STONE.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AetherBlocks.CARVED_STONE.get(), AncientAetherBlocks.CARVED_STONE_MOSAIC.get());

        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.ANGELIC_STONE_MOSAIC.get(), AetherBlocks.ANGELIC_STONE.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AetherBlocks.ANGELIC_STONE.get(), AncientAetherBlocks.ANGELIC_STONE_MOSAIC.get());

        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.HELLFIRE_STONE_MOSAIC.get(), AetherBlocks.HELLFIRE_STONE.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AetherBlocks.HELLFIRE_STONE.get(), AncientAetherBlocks.HELLFIRE_STONE_MOSAIC.get());

        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.HOLYSTONE_BRICK_MOSAIC.get(), AetherBlocks.HOLYSTONE_BRICKS.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AetherBlocks.HOLYSTONE_BRICKS.get(), AncientAetherBlocks.HOLYSTONE_BRICK_MOSAIC.get());

        stonecuttingRecipe(consumer, RecipeCategory.DECORATIONS, AncientAetherBlocks.QUICKSOIL_BRICK_WALL.get(), AncientAetherBlocks.QUICKSOIL_BRICKS.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.QUICKSOIL_BRICK_STAIRS.get(), AncientAetherBlocks.QUICKSOIL_BRICKS.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AncientAetherBlocks.QUICKSOIL_BRICK_SLAB.get(), AncientAetherBlocks.QUICKSOIL_BRICKS.get(), 2);

        enchantingRecipe(RecipeCategory.BUILDING_BLOCKS, Blocks.OBSIDIAN, AetherBlocks.AEROGEL.get(), 0.4F, 2000).save(consumer, name("obsidian_enchanting"));

        moaIncubationRecipe(AetherEntityTypes.MOA.get(), AncientAetherMoaTypes.SAKURA, AncientAetherItems.SAKURA_MOA_EGG.get()).save(consumer, name("sakura_moa_incubation"));
    }
    protected static SimpleCookingRecipeBuilder smokingRecipe(ItemLike result, ItemLike ingredient, float experience) {
        return SimpleCookingRecipeBuilder.smoking(Ingredient.of(ingredient), RecipeCategory.MISC, result, experience, 100)
                .unlockedBy(getHasName(ingredient), has(ingredient));
    }
    protected static SimpleCookingRecipeBuilder campfireCookingRecipe(ItemLike result, ItemLike ingredient, float experience) {
        return SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(ingredient), RecipeCategory.MISC, result, experience, 100)
                .unlockedBy(getHasName(ingredient), has(ingredient));
    }
}