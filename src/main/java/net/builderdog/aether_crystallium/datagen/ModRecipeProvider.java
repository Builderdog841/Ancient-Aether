package net.builderdog.aether_crystallium.datagen;

import net.builderdog.aether_crystallium.block.ModBlocks;
import net.builderdog.aether_crystallium.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        oreSmelting(consumer, List.of(ModItems.RAW_CRYSTAL_GOLD.get()), RecipeCategory.MISC,
        ModItems.CRYSTAL_GOLD_INGOT.get(), 0.7f, 200, "crystal_gold_ingot");
    }
}
