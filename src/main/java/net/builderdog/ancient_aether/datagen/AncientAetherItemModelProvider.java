package net.builderdog.ancient_aether.datagen;

import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.item.AncientAetherItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class AncientAetherItemModelProvider extends ItemModelProvider {
    public AncientAetherItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, AncientAether.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(AncientAetherItems.AECHOR_PETAL_ICE_CREAM_BUCKET);
        simpleItem(AncientAetherItems.CACTUS_FLOWER_PETAL_ICE_CREAM_BUCKET);
        simpleItem(AncientAetherItems.CACTUS_FLOWER_PETAL);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(AncientAether.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
        new ResourceLocation(AncientAether.MOD_ID,"item/" + item.getId().getPath()));
    }
}
