package net.builderdog.ancient_aether.datagen;

import com.aetherteam.aether.data.providers.AetherItemModelProvider;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.builderdog.ancient_aether.item.AncientAetherItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AncientAetherItemModelProvider extends AetherItemModelProvider {
    public AncientAetherItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, AncientAether.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        //Food
        simpleItem(AncientAetherItems.AECHOR_ICE_CREAM_BUCKET);
        simpleItem(AncientAetherItems.CACTUS_FLOWER_ICE_CREAM_BUCKET);
        simpleItem(AncientAetherItems.RAW_BUFFALO_RIBS);
        simpleItem(AncientAetherItems.COOKED_BUFFALO_RIBS);
        simpleItem(AncientAetherItems.BUFFALO_RIB);

        //Spawn Eggs
        eggItem(AncientAetherItems.HIGHLANDS_BUFFALO_SPAWN_EGG.get());
        eggItem(AncientAetherItems.ROOTLING_SPAWN_EGG.get());
        eggItem(AncientAetherItems.VELOX_ZEPHYR_SPAWN_EGG.get());
        eggItem(AncientAetherItems.VELOX_WHIRLWIND_SPAWN_EGG.get());

        //Music Discs
        this.simpleItem(AncientAetherItems.MUSIC_DISC_LABYRINTHS_VENGEANCE_BUILDERDOG_REMIX);

        //Blocks
        this.itemFence(AncientAetherBlocks.HIGHLANDS_PINE_FENCE.get(), AncientAetherBlocks.HIGHLANDS_PINE_PLANKS.get(), "");
        this.itemBlock(AncientAetherBlocks.HIGHLANDS_PINE_FENCE_GATE.get());
        this.item(AncientAetherBlocks.HIGHLANDS_PINE_DOOR.get().asItem(), "");
        this.itemBlock(AncientAetherBlocks.HIGHLANDS_PINE_TRAPDOOR.get(), "_bottom");
        this.itemButton(AncientAetherBlocks.HIGHLANDS_PINE_BUTTON.get(), AncientAetherBlocks.HIGHLANDS_PINE_PLANKS.get(), "");
        this.itemBlock(AncientAetherBlocks.HIGHLANDS_PINE_PRESSURE_PLATE.get());

        this.itemFence(AncientAetherBlocks.SAKURA_FENCE.get(), AncientAetherBlocks.SAKURA_PLANKS.get(), "");
        this.itemBlock(AncientAetherBlocks.SAKURA_FENCE_GATE.get());
        this.item(AncientAetherBlocks.SAKURA_DOOR.get().asItem(), "");
        this.itemBlock(AncientAetherBlocks.SAKURA_TRAPDOOR.get(), "_bottom");
        this.itemButton(AncientAetherBlocks.SAKURA_BUTTON.get(), AncientAetherBlocks.SAKURA_PLANKS.get(), "");
        this.itemBlock(AncientAetherBlocks.SAKURA_PRESSURE_PLATE.get());
    }

    public String itemName(Item item) {
        ResourceLocation location = ForgeRegistries.ITEMS.getKey(item);
        if (location != null) {
            return location.getPath();
        } else {
            throw new IllegalStateException("Unknown item: " + item.toString());
        }
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(AncientAether.MOD_ID,"item/" + item.getId().getPath()));
    }
    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(AncientAether.MOD_ID, "item/" + item.getId().getPath()));
    }
        public void eggItem(Item item) {
            this.withExistingParent(this.itemName(item), this.mcLoc("item/template_spawn_egg"));
    }
}
