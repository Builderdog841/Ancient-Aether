package net.builderdog.ancient_aether.client;

import com.aetherteam.aether.block.AetherBlocks;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.MapColor;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.Map;
import java.util.Set;

public class AncientAetherBlockColors extends BlockColors {
    private static final int DEFAULT = -1;
    // FORGE: Use registry delegate as non-Vanilla block ids are not constant
    private final java.util.Map<net.minecraft.core.Holder.Reference<Block>, BlockColor> blockColors = new java.util.HashMap<>();
    private final Map<Block, Set<Property<?>>> coloringStates = Maps.newHashMap();
    public static BlockColors createDefault() {
        BlockColors blockcolors = new BlockColors();
        blockcolors.register((p_276233_, p_276234_, p_276235_, p_276236_) -> {
            return p_276234_ != null && p_276235_ != null ? BiomeColors.getAverageGrassColor(p_276234_, p_276233_.getValue(DoublePlantBlock.HALF) == DoubleBlockHalf.UPPER ? p_276235_.below() : p_276235_) : GrassColor.getDefaultColor();
        },
                AetherBlocks.AETHER_GRASS_BLOCK.get(), Blocks.FERN, Blocks.GRASS, Blocks.POTTED_FERN);
        blockcolors.register((p_276241_, p_276242_, p_276243_, p_276244_) -> {
            if (p_276244_ != 0) {
                return p_276242_ != null && p_276243_ != null ? BiomeColors.getAverageGrassColor(p_276242_, p_276243_) : GrassColor.getDefaultColor();
            } else {
                return -1;
            }
        },
                Blocks.LILY_PAD);
        net.minecraftforge.client.ForgeHooksClient.onBlockColorsInit(blockcolors);
        return blockcolors;
    }

    public int getColor(BlockState p_92583_, Level p_92584_, BlockPos p_92585_) {
        BlockColor blockcolor = this.blockColors.get(net.minecraftforge.registries.ForgeRegistries.BLOCKS.getDelegateOrThrow(p_92583_.getBlock()));
        if (blockcolor != null) {
            return blockcolor.getColor(p_92583_, (BlockAndTintGetter)null, (BlockPos)null, 0);
        } else {
            MapColor mapcolor = p_92583_.getMapColor(p_92584_, p_92585_);
            return mapcolor != null ? mapcolor.col : -1;
        }
    }

    public int getColor(BlockState p_92578_, @Nullable BlockAndTintGetter p_92579_, @Nullable BlockPos p_92580_, int p_92581_) {
        BlockColor blockcolor = this.blockColors.get(net.minecraftforge.registries.ForgeRegistries.BLOCKS.getDelegateOrThrow(p_92578_.getBlock()));
        return blockcolor == null ? -1 : blockcolor.getColor(p_92578_, p_92579_, p_92580_, p_92581_);
    }

    /** @deprecated Register via {@link net.minecraftforge.client.event.RegisterColorHandlersEvent.Block} */
    @Deprecated
    public void register(@NotNull BlockColor p_92590_, Block... p_92591_) {
        for(Block block : p_92591_) {
            this.blockColors.put(net.minecraftforge.registries.ForgeRegistries.BLOCKS.getDelegateOrThrow(block), p_92590_);
        }

    }

    private void addColoringStates(Set<Property<?>> p_92593_, Block... p_92594_) {
        for(Block block : p_92594_) {
            this.coloringStates.put(block, p_92593_);
        }

    }

    private void addColoringState(Property<?> p_92587_, Block... p_92588_) {
        this.addColoringStates(ImmutableSet.of(p_92587_), p_92588_);
    }

    public Set<Property<?>> getColoringProperties(Block p_92576_) {
        return this.coloringStates.getOrDefault(p_92576_, ImmutableSet.of());
    }
}
