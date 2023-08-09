package net.builderdog.ancient_aether.datagen;

import com.aetherteam.aether.data.providers.AetherItemModelProvider;
import net.builderdog.ancient_aether.AncientAether;
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
        this.simpleItem(AncientAetherItems.AECHOR_ICE_CREAM_BUCKET);
        this.simpleItem(AncientAetherItems.CACTUS_FLOWER_ICE_CREAM_BUCKET);
        this.simpleItem(AncientAetherItems.RAW_BUFFALO_RIBS);
        this.simpleItem(AncientAetherItems.COOKED_BUFFALO_RIBS);
        this.simpleItem(AncientAetherItems.BUFFALO_RIB);

        //Spawn Eggs
        this.eggItem(AncientAetherItems.HIGHLANDS_BUFFALO_SPAWN_EGG.get());
        this.eggItem(AncientAetherItems.ROOTLING_SPAWN_EGG.get());
        this.eggItem(AncientAetherItems.VELOX_ZEPHYR_SPAWN_EGG.get());
        this.eggItem(AncientAetherItems.VELOX_WHIRLWIND_SPAWN_EGG.get());

        //Music Discs
        this.simpleItem(AncientAetherItems.MUSIC_DISC_LABYRINTHS_VENGEANCE_BUILDERDOG_REMIX);
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
