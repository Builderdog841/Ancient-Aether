package net.builderdog.ancient_aether.block.natural;

import net.builderdog.ancient_aether.block.blockstate.AetherGrassType;
import net.builderdog.ancient_aether.block.blockstate.AetherTallGrassLength;
import net.builderdog.ancient_aether.block.blockstate.AncientAetherBlockStateProperties;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.TallGrassBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;

public class SkyGrassBlock extends TallGrassBlock {
    public static final EnumProperty<AetherTallGrassLength> LENGTH = AncientAetherBlockStateProperties.LENGTH;
    public static final EnumProperty<AetherGrassType> TYPE = AncientAetherBlockStateProperties.TYPE;
    public SkyGrassBlock(Properties properties) {
        super(properties);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> blockBlockStateBuilder) {
        blockBlockStateBuilder.add(LENGTH);
        blockBlockStateBuilder.add(TYPE);
    }
}