package net.builderdog.ancient_aether.client;

import com.aetherteam.aether.block.AetherBlocks;
import com.aetherteam.aether.mixin.mixins.client.accessor.BlockColorsAccessor;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.level.ColorResolver;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashMap;
import java.util.Map;

@Mod.EventBusSubscriber(
        value = {Dist.CLIENT},
        modid = "ancient_aether",
        bus = Mod.EventBusSubscriber.Bus.MOD
)
public class AncientAetherColorResolvers {
    private static final ColorResolver AETHER_GRASS = (biome, x, z) -> biome.getFoliageColor();

    public AncientAetherColorResolvers() {
    }

    @SubscribeEvent
    static void registerColorResolver(RegisterColorHandlersEvent.ColorResolvers event) {
        event.register(AETHER_GRASS);
    }

    @SubscribeEvent
    static void registerBlockColor(RegisterColorHandlersEvent.Block event) {
        Map<Block, BlockColor> map = new HashMap<>();
        Map<Holder.Reference<Block>, BlockColor> blockColors = ((BlockColorsAccessor)event.getBlockColors()).aether$getBlockColors();
        map.put(Blocks.GRASS, blockColors.get(ForgeRegistries.BLOCKS.getDelegateOrThrow(Blocks.GRASS)));
        map.put(Blocks.FERN, blockColors.get(ForgeRegistries.BLOCKS.getDelegateOrThrow(Blocks.FERN)));
        map.put(Blocks.TALL_GRASS, blockColors.get(ForgeRegistries.BLOCKS.getDelegateOrThrow(Blocks.TALL_GRASS)));
        map.put(Blocks.LARGE_FERN, blockColors.get(ForgeRegistries.BLOCKS.getDelegateOrThrow(Blocks.LARGE_FERN)));

        for (Map.Entry<Block, BlockColor> blockBlockColorEntry : map.entrySet()) {
            event.register((state, level, pos, tintIndex) -> {
                if (level != null && pos != null) {
                    BlockPos newPos = state.hasProperty(DoublePlantBlock.HALF) ? (state.getValue(DoublePlantBlock.HALF) == DoubleBlockHalf.UPPER ? pos.below() : pos) : pos;
                    if (level.getBlockState(newPos.below()).is( AetherBlocks.AETHER_GRASS_BLOCK.get())) {
                        return level.getBlockTint(newPos, AETHER_GRASS);
                    }
                }

                return (blockBlockColorEntry.getValue()).getColor(state, level, pos, tintIndex);
            }, blockBlockColorEntry.getKey());
        }
    }
}
