package net.builderdog.ancient_aether.data.providers;

import com.aetherteam.aether.data.providers.AetherRecipeProvider;
import com.aetherteam.aether.recipe.AetherRecipeSerializers;
import com.aetherteam.aether.recipe.builder.BiomeParameterRecipeBuilder;
import com.aetherteam.nitrogen.recipe.BlockStateIngredient;
import com.aetherteam.nitrogen.recipe.builder.BlockStateRecipeBuilder;
import net.builderdog.ancient_aether.item.AncientAetherItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.common.Tags;

import java.util.Map;
import java.util.function.Consumer;

public abstract class AncientAetherRecipeProvider extends AetherRecipeProvider {
    public AncientAetherRecipeProvider(PackOutput output, String id) {
        super(output, id);
    }

    protected static void bookshelf(Consumer<FinishedRecipe> consumer, ItemLike result, ItemLike planks) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result)
                .define('#', planks)
                .define('X', Items.BOOK)
                .pattern("###")
                .pattern("XXX")
                .pattern("###")
                .unlockedBy(getHasName(Items.BOOK), has(Items.BOOK))
                .save(consumer);
    }

    protected static void sign(Consumer<FinishedRecipe> consumer, ItemLike result, ItemLike planks) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, result, 3)
                .group("sign")
                .define('#', planks)
                .define('X', Tags.Items.RODS_WOODEN)
                .pattern("###")
                .pattern("###")
                .pattern(" X ")
                .unlockedBy(getHasName(planks), has(planks))
                .save(consumer);
    }

    protected static void woodenChestBoat(Consumer<FinishedRecipe> consumer, ItemLike result, ItemLike boat) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.TRANSPORTATION, result)
                .group("chest_boat")
                .requires(Tags.Items.CHESTS_WOODEN)
                .requires(boat)
                .unlockedBy("has_boat", has(ItemTags.BOATS))
                .save(consumer);
    }

    protected void flowerToDye(Consumer<FinishedRecipe> consumer, ItemLike result, ItemLike flower, String color) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, result)
                .group(color + "_dye")
                .requires(flower)
                .unlockedBy(getHasName(flower), has(flower))
                .save(consumer, name(getItemName(flower) + "_to_" + color + "_dye"));
    }

    protected static void copyAetherSmithingTemplate(Consumer<FinishedRecipe> consumer, ItemLike template, ItemLike block) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, template, 2)
                .define('#', AncientAetherItems.VALKYRUM.get())
                .define('C', block)
                .define('S', template)
                .pattern("#S#")
                .pattern("#C#")
                .pattern("###")
                .unlockedBy(getHasName(template), has(template))
                .save(consumer);
    }

    protected void aetherSmithingTrimRecipe(Consumer<FinishedRecipe> consumer, Item armorTrim) {
        SmithingTrimRecipeBuilder.smithingTrim(Ingredient.of(armorTrim),
                        Ingredient.of(ItemTags.TRIMMABLE_ARMOR),
                        Ingredient.of(ItemTags.TRIM_MATERIALS), RecipeCategory.MISC)
                .unlocks("smithing_templates",
                        has(armorTrim)).save(consumer, new ResourceLocation(id, getItemName(armorTrim) + "_smithing_trim"));
    }

    protected BlockStateRecipeBuilder swetBallConversionWithProperties(Block result, Map<Property<?>, Comparable<?>> resultProperties, Block ingredient, TagKey<Biome> tagKey) {
        return BiomeParameterRecipeBuilder.recipe(BlockStateIngredient.of(ingredient), result, resultProperties, tagKey, AetherRecipeSerializers.SWET_BALL_CONVERSION.get());
    }
}