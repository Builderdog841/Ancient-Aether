package net.builderdog.ancient_aether.block.dungeon;

import net.builderdog.ancient_aether.block.utility.VaseBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;

public class AncientVaseBlock extends VaseBlock {
    private final ResourceLocation vaseLootTable;

    public AncientVaseBlock(ResourceLocation vaseLootTable, Properties properties) {
        super(properties);
        this.vaseLootTable = vaseLootTable;
    }

    public void playerDestroy(@NotNull Level level, @NotNull Player player, @NotNull BlockPos pos, @NotNull BlockState state, @Nullable BlockEntity blockEntity, @NotNull ItemStack tool) {
        super.playerDestroy(level, player, pos, state, blockEntity, tool);
            if (level instanceof ServerLevel serverLevel) {
                LootParams parameters = new LootParams.Builder(serverLevel).withParameter(LootContextParams.BLOCK_STATE, state).withParameter(LootContextParams.TOOL, player.getMainHandItem()).withParameter(LootContextParams.ORIGIN, position()).withParameter(LootContextParams.THIS_ENTITY, player).create(LootContextParamSets.BLOCK);
                LootTable lootTable = serverLevel.getServer().getLootData().getLootTable(this.vaseLootTable);
                List<ItemStack> list = lootTable.getRandomItems(parameters);
                for (ItemStack itemstack : list) {
                    spawnAtLocation(itemstack, pos, level);
                }
            }
    }

    @Nullable
    public ItemEntity spawnAtLocation(ItemStack itemStack, BlockPos pos, Level level) {
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        if (itemStack.isEmpty()) {
            return null;
        } else if (level.isClientSide) {
            return null;
        } else {
            ItemEntity itementity = new ItemEntity(level, x, y + 0.5, z, itemStack);
            itementity.setDefaultPickUpDelay();
            level.addFreshEntity(itementity);
            return itementity;
        }
    }

    private Vec3 position;

    public Vec3 position() {
        return position;
    }
}
