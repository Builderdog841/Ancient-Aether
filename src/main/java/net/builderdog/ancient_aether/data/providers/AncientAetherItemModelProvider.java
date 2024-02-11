package net.builderdog.ancient_aether.data.providers;

import com.aetherteam.aether.data.providers.AetherItemModelProvider;
import net.builderdog.ancient_aether.AncientAether;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public abstract class AncientAetherItemModelProvider extends AetherItemModelProvider {
    public AncientAetherItemModelProvider(PackOutput output, String id, ExistingFileHelper helper) {
        super(output, id, helper);
    }

    public String itemName(Item item) {
        ResourceLocation location = ForgeRegistries.ITEMS.getKey(item);
        if (location != null) {
            return location.getPath();
        } else {
            throw new IllegalStateException("Unknown item: " + item.toString());
        }
    }
    public void simpleItem(RegistryObject<Item> item) {
        withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated"))
                .texture("layer0", new ResourceLocation(AncientAether.MOD_ID, "item/" + item.getId().getPath()));
    }

    public void untintedMoaEggItem(Item item) {
        (withExistingParent(itemName(item), modLoc("item/untinted_moa_egg")))
                .texture("egg", modLoc( "item/" + itemName(item)))
                .texture("particle", modLoc( "item/" + itemName(item)));
    }

    public void itemLogWallBlock(Block block, Block baseBlock, String location, String modid) {
        ResourceLocation baseTexture = new ResourceLocation(modid, "block/" + location + blockName(baseBlock));
        (((((withExistingParent(blockName(block), mcLoc("block/block"))).transforms().transform(ItemDisplayContext.GUI).rotation(30.0F, 135.0F, 0.0F).translation(0.0F, 0.0F, 0.0F).scale(0.625F, 0.625F, 0.625F).end().transform(ItemDisplayContext.FIXED).rotation(0.0F, 90.0F, 0.0F).translation(0.0F, 0.0F, 0.0F).scale(0.5F, 0.5F, 0.5F).end().end()).texture("top", baseTexture + "_top")).texture("side", baseTexture)).element().from(4.0F, 0.0F, 4.0F).to(12.0F, 16.0F, 12.0F).face(Direction.DOWN).uvs(4.0F, 4.0F, 12.0F, 12.0F).texture("#top").cullface(Direction.DOWN).end().face(Direction.UP).uvs(4.0F, 4.0F, 12.0F, 12.0F).texture("#top").end().face(Direction.NORTH).uvs(4.0F, 0.0F, 12.0F, 16.0F).texture("#side").end().face(Direction.SOUTH).uvs(4.0F, 0.0F, 12.0F, 16.0F).texture("#side").end().face(Direction.WEST).uvs(4.0F, 0.0F, 12.0F, 16.0F).texture("#side").end().face(Direction.EAST).uvs(4.0F, 0.0F, 12.0F, 16.0F).texture("#side").end().end()).element().from(5.0F, 0.0F, 0.0F).to(11.0F, 13.0F, 16.0F).face(Direction.DOWN).uvs(5.0F, 0.0F, 11.0F, 16.0F).texture("#top").cullface(Direction.DOWN).end().face(Direction.UP).uvs(5.0F, 0.0F, 11.0F, 16.0F).texture("#top").end().face(Direction.NORTH).uvs(5.0F, 3.0F, 11.0F, 16.0F).texture("#side").cullface(Direction.NORTH).end().face(Direction.SOUTH).uvs(5.0F, 3.0F, 11.0F, 16.0F).texture("#side").cullface(Direction.SOUTH).end().face(Direction.WEST).uvs(0.0F, 3.0F, 16.0F, 16.0F).texture("#side").end().face(Direction.EAST).uvs(0.0F, 3.0F, 16.0F, 16.0F).texture("#side").end().end();
    }
    public void itemWoodWallBlock(Block block, Block baseBlock, String location, String modid) {
        wallInventory(blockName(block), new ResourceLocation(modid, "block/" + location + blockName(baseBlock)));
    }
}