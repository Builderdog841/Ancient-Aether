package net.builderdog.ancient_aether.data.providers;

import com.aetherteam.aether.data.providers.AetherRecipeProvider;
import net.builderdog.ancient_aether.item.AncientAetherItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.SmithingTrimRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

public abstract class AncientAetherRecipeProvider extends AetherRecipeProvider {
    public AncientAetherRecipeProvider(PackOutput output, String id) {
        super(output, id);
    }

    protected static void bookshelf(Consumer<FinishedRecipe> consumer, ItemLike bookshelf, ItemLike planks) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, bookshelf)
                .define('P', planks)
                .define('B', Items.BOOK)
                .pattern("PPP")
                .pattern("BBB")
                .pattern("PPP")
                .unlockedBy(getHasName(Items.BOOK), has(Items.BOOK))
                .save(consumer);
    }

    protected static void sign(Consumer<FinishedRecipe> consumer, ItemLike sign, ItemLike planks) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, sign, 3)
                .group("sign")
                .define('#', planks)
                .define('X', Tags.Items.RODS_WOODEN)
                .pattern("###")
                .pattern("###")
                .pattern(" X ")
                .unlockedBy(getHasName(planks), has(planks))
                .save(consumer);
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
}