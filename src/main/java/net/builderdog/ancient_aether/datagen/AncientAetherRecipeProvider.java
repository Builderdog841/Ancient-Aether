package net.builderdog.ancient_aether.datagen;

import com.aetherteam.aether.Aether;
import com.aetherteam.aether.AetherTags;
import com.aetherteam.aether.block.AetherBlocks;
import com.aetherteam.aether.data.providers.AetherRecipeProvider;
import com.aetherteam.aether.entity.AetherEntityTypes;
import com.aetherteam.aether.item.AetherItems;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.builderdog.ancient_aether.entity.moa.AncientAetherMoaTypes;
import net.builderdog.ancient_aether.item.AncientAetherItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.*;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

public class AncientAetherRecipeProvider extends AetherRecipeProvider {
    public AncientAetherRecipeProvider(PackOutput output) {
        super(output, Aether.MODID);
    }

    @Override
    @SuppressWarnings("removal")
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {

        woodFromLogs(consumer, AetherBlocks.SKYROOT_WOOD.get(), AetherBlocks.SKYROOT_LOG.get());
        woodFromLogs(consumer, AetherBlocks.STRIPPED_SKYROOT_WOOD.get(), AetherBlocks.STRIPPED_SKYROOT_LOG.get());
        planksFromLogs(consumer, AetherBlocks.SKYROOT_PLANKS.get(), AetherTags.Items.CRAFTS_SKYROOT_PLANKS, 4);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AetherBlocks.INCUBATOR.get(), 1)
                .define('H', AetherBlocks.HOLYSTONE.get())
                .define('T', AetherBlocks.AMBROSIUM_TORCH.get())
                .pattern("HHH")
                .pattern("HTH")
                .pattern("HHH")
                .unlockedBy(getHasName(AetherBlocks.HOLYSTONE.get()), has(AetherBlocks.HOLYSTONE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AncientAetherItems.HIGHSPROOT_SIGN.get(), 3)
                .group("wooden_sign")
                .define('P', AncientAetherBlocks.HIGHSPROOT_PLANKS.get().asItem())
                .define('/', Tags.Items.RODS_WOODEN)
                .pattern("PPP")
                .pattern("PPP")
                .pattern(" / ")
                .unlockedBy(getHasName(AncientAetherBlocks.HIGHSPROOT_PLANKS.get()), has(AncientAetherBlocks.HIGHSPROOT_PLANKS.get()))
                .save(consumer);

        fence(AetherBlocks.SKYROOT_FENCE, AetherBlocks.SKYROOT_PLANKS).save(consumer);
        fenceGate(AetherBlocks.SKYROOT_FENCE_GATE, AetherBlocks.SKYROOT_PLANKS).save(consumer);

        wall(consumer, RecipeCategory.DECORATIONS, AncientAetherBlocks.QUICKSOIL_BRICK_WALL.get(), AncientAetherBlocks.QUICKSOIL_BRICKS.get());

        stairs(AetherBlocks.SKYROOT_STAIRS, AetherBlocks.SKYROOT_PLANKS).group("wooden_stairs").save(consumer);
        stairs(AetherBlocks.SKYROOT_STAIRS, AetherBlocks.SKYROOT_PLANKS).group("wooden_stairs").save(consumer);
        stairs(AetherBlocks.ANGELIC_STAIRS, AetherBlocks.ANGELIC_STONE).save(consumer);

        slabBuilder(RecipeCategory.BUILDING_BLOCKS, AetherBlocks.SKYROOT_SLAB.get(), Ingredient.of(AetherBlocks.SKYROOT_PLANKS.get()))
                .group("wooden_slab")
                .unlockedBy(getHasName(AetherBlocks.SKYROOT_PLANKS.get()), has(AetherBlocks.SKYROOT_PLANKS.get()))
                .save(consumer);
        slab(consumer, RecipeCategory.BUILDING_BLOCKS, AetherBlocks.CARVED_SLAB.get(), AetherBlocks.CARVED_STONE.get());

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

        woodenBoat(consumer, AetherItems.SKYROOT_BOAT.get(), AetherBlocks.SKYROOT_PLANKS.get());
        ShapelessRecipeBuilder.shapeless(RecipeCategory.TRANSPORTATION, AetherItems.SKYROOT_CHEST_BOAT.get())
                .group("chest_boat")
                .requires(Tags.Items.CHESTS_WOODEN)
                .requires(AetherItems.SKYROOT_BOAT.get())
                .unlockedBy("has_boat", has(ItemTags.BOATS))
                .save(consumer);

        doorBuilder(AetherBlocks.SKYROOT_DOOR.get(), Ingredient.of(AetherBlocks.SKYROOT_PLANKS.get())).unlockedBy(getHasName(AetherBlocks.SKYROOT_PLANKS.get()), has(AetherBlocks.SKYROOT_PLANKS.get())).group("wooden_door").save(consumer);
        trapdoorBuilder(AetherBlocks.SKYROOT_TRAPDOOR.get(), Ingredient.of(AetherBlocks.SKYROOT_PLANKS.get())).unlockedBy(getHasName(AetherBlocks.SKYROOT_PLANKS.get()), has(AetherBlocks.SKYROOT_PLANKS.get())).group("wooden_trapdoor").save(consumer);
        buttonBuilder(AetherBlocks.SKYROOT_BUTTON.get(), Ingredient.of(AetherBlocks.SKYROOT_PLANKS.get())).unlockedBy(getHasName(AetherBlocks.SKYROOT_PLANKS.get()), has(AetherBlocks.SKYROOT_PLANKS.get())).group("wooden_button").save(consumer);
        buttonBuilder(AetherBlocks.HOLYSTONE_BUTTON.get(), Ingredient.of(AetherBlocks.HOLYSTONE.get())).unlockedBy(getHasName(AetherBlocks.HOLYSTONE.get()), has(AetherBlocks.HOLYSTONE.get())).save(consumer);
        pressurePlateBuilder(RecipeCategory.REDSTONE, AetherBlocks.SKYROOT_PRESSURE_PLATE.get(), Ingredient.of(AetherBlocks.SKYROOT_PLANKS.get())).unlockedBy(getHasName(AetherBlocks.SKYROOT_PLANKS.get()), has(AetherBlocks.SKYROOT_PLANKS.get())).group("wooden_pressure_plate").save(consumer);

        smeltingOreRecipe(Items.QUARTZ, AncientAetherBlocks.AETHER_QUARTZ_ORE.get(), 0.7F).save(consumer, name("quartz_from_smelting_aether_quartz_ore"));
        blastingOreRecipe(Items.QUARTZ, AncientAetherBlocks.AETHER_QUARTZ_ORE.get(), 0.7F).save(consumer, name("quartz_from_blasting_aether_quartz_ore"));

        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AetherBlocks.SENTRY_STONE.get(), AetherBlocks.CARVED_STONE.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AetherBlocks.CARVED_STONE.get(), AncientAetherBlocks.ANCIENT_SENTRY_STONE.get());

        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AetherBlocks.PILLAR.get(), AetherBlocks.ANGELIC_STONE.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AetherBlocks.PILLAR_TOP.get(), AetherBlocks.ANGELIC_STONE.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AetherBlocks.ANGELIC_STONE.get(), AetherBlocks.PILLAR.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AetherBlocks.ANGELIC_STONE.get(), AetherBlocks.PILLAR_TOP.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AetherBlocks.PILLAR_TOP.get(), AetherBlocks.PILLAR.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AetherBlocks.PILLAR.get(), AetherBlocks.PILLAR_TOP.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AetherBlocks.LIGHT_ANGELIC_STONE.get(), AetherBlocks.ANGELIC_STONE.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AetherBlocks.ANGELIC_STONE.get(), AetherBlocks.LIGHT_ANGELIC_STONE.get());

        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AetherBlocks.LIGHT_HELLFIRE_STONE.get(), AetherBlocks.HELLFIRE_STONE.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AetherBlocks.HELLFIRE_STONE.get(), AetherBlocks.LIGHT_HELLFIRE_STONE.get());

        stonecuttingRecipe(consumer, RecipeCategory.DECORATIONS, AetherBlocks.HOLYSTONE_BRICK_WALL.get(), AetherBlocks.HOLYSTONE_BRICKS.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AetherBlocks.HOLYSTONE_BRICK_STAIRS.get(), AetherBlocks.HOLYSTONE_BRICKS.get());
        stonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, AetherBlocks.HOLYSTONE_BRICK_SLAB.get(), AetherBlocks.HOLYSTONE_BRICKS.get(), 2);

        enchantingRecipe(RecipeCategory.BUILDING_BLOCKS, Blocks.OBSIDIAN, AetherBlocks.AEROGEL.get(), 0.4F, 2000).save(consumer, name("obsidian_enchanting"));

        moaIncubationRecipe(AetherEntityTypes.MOA.get(), AncientAetherMoaTypes.SAKURA, AncientAetherItems.SAKURA_MOA_EGG.get()).save(consumer, name("sakura_moa_incubation"));
    }
}