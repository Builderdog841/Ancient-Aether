package net.builderdog.ancient_aether.block.functional;

import com.aetherteam.aether.item.AetherItems;
import net.builderdog.ancient_aether.AncientAetherTags;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class AncientHolystoneVaseBlock extends HolystoneVaseBlock {

    public AncientHolystoneVaseBlock(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResult use(@NotNull BlockState blockstate, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hit) {
        super.use(blockstate, level, pos, player, hand, hit);
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();

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
                        ItemEntity entityToSpawn = new ItemEntity(serverLevel, x, y, z, new ItemStack((Objects.requireNonNull(ForgeRegistries.ITEMS.tags()).getTag(AncientAetherTags.Items.ANCIENT_HOLYSTONE_VASE_LOOT).getRandomElement(RandomSource.create()).orElse(Items.AIR))));
                        entityToSpawn.setPickUpDelay(10);
                        serverLevel.addFreshEntity(entityToSpawn);
                }
        }
        return InteractionResult.SUCCESS;
    }
}
