package net.builderdog.ancient_aether.block.functional;

import com.aetherteam.aether.item.AetherItems;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.builderdog.ancient_aether.datagen.resources.AncientAetherLoot;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;

public class AncientHolystoneVaseBlock extends HolystoneVaseBlock {

    public AncientHolystoneVaseBlock(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResult use(@NotNull BlockState blockstate, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hit) {
        super.use(blockstate, level, pos, player, hand, hit);

        if ((player instanceof ServerPlayer serverPlayer ? serverPlayer.getMainHandItem() : ItemStack.EMPTY).getItem() == AetherItems.AMBROSIUM_SHARD.get()) {
            level.setBlockAndUpdate(pos, AncientAetherBlocks.HOLYSTONE_VASE.get().defaultBlockState().setValue(FACING, blockstate.getValue(FACING)));
            assert player instanceof ServerPlayer;
            ServerPlayer livingEntity = (ServerPlayer) player;
            ItemStack stack = player.getMainHandItem();
            if (!livingEntity.getAbilities().instabuild) {
                player.awardStat(Stats.ITEM_USED.get(stack.getItem()));
                stack.shrink(1);
            }

            if (level instanceof ServerLevel serverLevel) {

                LootParams parameters = new LootParams.Builder(serverLevel).withParameter(LootContextParams.BLOCK_STATE, blockstate).withParameter(LootContextParams.TOOL, player.getMainHandItem()).withParameter(LootContextParams.ORIGIN, position()).withParameter(LootContextParams.THIS_ENTITY, player).create(LootContextParamSets.BLOCK);
                LootTable lootTable = serverLevel.getServer().getLootData().getLootTable(AncientAetherLoot.ANCIENT_HOLYSTONE_VASE_LOOT);
                List<ItemStack> list = lootTable.getRandomItems(parameters);
                for (ItemStack itemstack : list) {
                    this.spawnAtLocation(itemstack, pos, level);
                }
            }
        }
        return InteractionResult.SUCCESS;
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
