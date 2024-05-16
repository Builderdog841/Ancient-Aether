package net.builderdog.ancient_aether.data.providers;

import com.aetherteam.aether.Aether;
import com.aetherteam.aether.data.providers.AetherItemModelProvider;
import com.aetherteam.nitrogen.data.providers.NitrogenItemModelProvider;
import net.builderdog.ancient_aether.AncientAether;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.loaders.ItemLayerModelBuilder;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredItem;

public abstract class AncientAetherItemModelProvider extends AetherItemModelProvider {
    public AncientAetherItemModelProvider(PackOutput output, String id, ExistingFileHelper helper) {
        super(output, id, helper);
    }

    public void simpleItem(DeferredItem<Item> item) {
        withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated"))
                .texture("layer0", new ResourceLocation(AncientAether.MODID, "item/" + item.getId().getPath()));
    }

    public void itemBlockCopy(Block block, Block blockCopy) {
        withExistingParent(blockName(block), modLoc(blockName(blockCopy)));
    }

    public void AAGlovesItem(Item item, String location) {
        ItemModelBuilder builder = withExistingParent(itemName(item), mcLoc("item/generated")).texture("layer0", modLoc("item/" + location + itemName(item)));
        double index = 0.1;
        for (ResourceKey<TrimMaterial> trimMaterial : NitrogenItemModelProvider.VANILLA_TRIM_MATERIALS) {
            String material = trimMaterial.location().getPath();
            String name = itemName(item) + "_" + material + "_trim";
            withExistingParent(name, mcLoc("item/generated"))
                    .texture("layer0", modLoc("item/" + location + itemName(item)))
                    .texture("layer1", new ResourceLocation(Aether.MODID, "trims/items/gloves_trim_" + material));
            builder.override().predicate(new ResourceLocation("trim_type"), (float) index).model(getExistingFile(modLoc("item/" + name))).end();
            index += 0.1;
        }
    }

    public void untintedMoaEggItem(Item item) {
        (withExistingParent(itemName(item), modLoc("item/template_untinted_moa_egg")))
                .texture("egg", modLoc("item/" + itemName(item)));
    }

    public void ancientRuneItem(Item item) {
        withExistingParent(itemName(item), mcLoc("item/generated"))
                .texture("layer1", "item/" + (itemName(item)))
                .texture("layer0", "item/" + (itemName(item) + "_eye"))
                .customLoader((itemModelBuilder, existingFileHelper) -> ItemLayerModelBuilder
                        .begin(itemModelBuilder, existingFileHelper)
                        .emissive(15, 15, 0)).end();
    }

    public void skyGrassItem(Block block) {
        withExistingParent(blockName(block), mcLoc("item/generated"))
                .texture("layer0", texture(blockName(block) + "_medium"));
    }

    public void AAItemLockedDungeonBlock(Block block, Block baseBlock) {
        AAItemOverlayDungeonBlock(block, baseBlock, "lock");
    }

    public void AAItemTrappedDungeonBlock(Block block, Block baseBlock) {
        AAItemOverlayDungeonBlock(block, baseBlock, "exclamation");
    }

    public void AAItemBossDoorwayDungeonBlock(Block block, Block baseBlock) {
        AAItemOverlayDungeonBlock(block, baseBlock, "door");
    }

    public void AAItemTreasureDoorwayDungeonBlock(Block block, Block baseBlock) {
        AAItemOverlayDungeonBlock(block, baseBlock, "treasure");
    }

    public void AAItemOverlayDungeonBlock(Block block, Block baseBlock, String overlay) {
        withExistingParent(blockName(block), mcLoc("block/cube"))
                .texture("overlay", new ResourceLocation(Aether.MODID, "block/dungeon/" + overlay)).texture("face", texture(blockName(baseBlock)))
                .element().from(0.0F, 0.0F, 0.0F).to(16.0F, 16.0F, 16.0F).allFaces((direction, builder) -> builder.texture("#face").cullface(direction).end()).end()
                .element().from(0.0F, 0.0F, -0.1F).to(16.0F, 16.0F, -0.1F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 6.9F).end().face(Direction.NORTH).texture("#overlay").emissivity(15, 15).end().end()
                .transforms()
                .transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND).rotation(75.0F, 45.0F, 0.0F).translation(0.0F, 2.5F, 0.0F).scale(0.375F, 0.375F, 0.375F).end()
                .transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND).rotation(75.0F, 45.0F, 0.0F).translation(0.0F, 2.5F, 0.0F).scale(0.375F, 0.375F, 0.375F).end()
                .transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND).rotation(-90.0F, -180.0F, -45.0F).scale(0.4F, 0.4F, 0.4F).end()
                .transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND).rotation(-90.0F, -180.0F, -45.0F).scale(0.4F, 0.4F, 0.4F).end()
                .transform(ItemDisplayContext.GROUND).rotation(90.0F, 0.0F, 0.0F).translation(0.0F, 3.0F, 0.0F).scale(0.25F, 0.25F, 0.25F).end()
                .transform(ItemDisplayContext.GUI).rotation(30.0F, 135.0F, 0.0F).scale(0.625F, 0.625F, 0.625F).end()
                .transform(ItemDisplayContext.FIXED).scale(0.5F, 0.5F, 0.5F).end()
                .end();
    }

    public void itemBossDoorwayDungeonBlock(Block block, Block baseBlock) {
        withExistingParent(blockName(block), mcLoc("block/cube"))
                .texture("overlay", new ResourceLocation(Aether.MODID, "block/dungeon/door")).texture("face", new ResourceLocation(Aether.MODID, "block/dungeon/" + blockName(baseBlock)))
                .element().from(0.0F, 0.0F, 0.0F).to(16.0F, 16.0F, 16.0F).allFaces((direction, builder) -> builder.texture("#face").cullface(direction).end()).end()
                .element().from(0.0F, 0.0F, -0.1F).to(16.0F, 16.0F, -0.1F).rotation().angle(0.0F).axis(Direction.Axis.Y).origin(8.0F, 8.0F, 6.9F).end().face(Direction.NORTH).texture("#overlay").emissivity(15, 15).end().end()
                .transforms()
                .transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND).rotation(75.0F, 45.0F, 0.0F).translation(0.0F, 2.5F, 0.0F).scale(0.375F, 0.375F, 0.375F).end()
                .transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND).rotation(75.0F, 45.0F, 0.0F).translation(0.0F, 2.5F, 0.0F).scale(0.375F, 0.375F, 0.375F).end()
                .transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND).rotation(-90.0F, -180.0F, -45.0F).scale(0.4F, 0.4F, 0.4F).end()
                .transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND).rotation(-90.0F, -180.0F, -45.0F).scale(0.4F, 0.4F, 0.4F).end()
                .transform(ItemDisplayContext.GROUND).rotation(90.0F, 0.0F, 0.0F).translation(0.0F, 3.0F, 0.0F).scale(0.25F, 0.25F, 0.25F).end()
                .transform(ItemDisplayContext.GUI).rotation(30.0F, 135.0F, 0.0F).scale(0.625F, 0.625F, 0.625F).end()
                .transform(ItemDisplayContext.FIXED).scale(0.5F, 0.5F, 0.5F).end()
                .end();
    }

    public void itemLockedMosaicBlock(Block block, Block baseBlock) {
        (withExistingParent(blockName(block), modLoc("item/template_item_locked_mosaic_block")))
                .texture("end", modLoc("block/" + blockName(baseBlock) + "_top"))
                .texture("side", modLoc("block/" + blockName(baseBlock)));
    }

}