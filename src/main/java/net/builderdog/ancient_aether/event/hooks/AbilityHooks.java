package net.builderdog.ancient_aether.event.hooks;

import com.aetherteam.aether.AetherConfig;
import com.aetherteam.aether.AetherTags;
import com.aetherteam.aether.attachment.AetherDataAttachments;
import com.aetherteam.aether.network.packet.clientbound.ToolDebuffPacket;
import com.aetherteam.nitrogen.network.PacketRelay;
import com.google.common.collect.ImmutableMap;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.builderdog.ancient_aether.item.EquipmentUtil;
import net.builderdog.ancient_aether.item.equipment.tools.abilities.DivineTool;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.ToolAction;
import net.neoforged.neoforge.common.ToolActions;

import javax.annotation.Nullable;
import java.util.Map;

public class AbilityHooks {

    public static class ArmorHooks {
        public static boolean fallCancellation(LivingEntity entity) {
            return EquipmentUtil.hasFullValkyrumSet(entity);
        }
    }

    public static class ToolHooks {
        public static final Map<Block, Block> STRIPPABLES = (new ImmutableMap.Builder<Block, Block>())
                .put(AncientAetherBlocks.HIGHSPROOT_LOG.get(), AncientAetherBlocks.STRIPPED_HIGHSPROOT_LOG.get())
                .put(AncientAetherBlocks.SAKURA_LOG.get(), AncientAetherBlocks.STRIPPED_SAKURA_LOG.get())
                .put(AncientAetherBlocks.HIGHSPROOT_WOOD.get(), AncientAetherBlocks.STRIPPED_HIGHSPROOT_WOOD.get())
                .put(AncientAetherBlocks.SAKURA_WOOD.get(), AncientAetherBlocks.STRIPPED_SAKURA_WOOD.get())
                .put(AncientAetherBlocks.HIGHSPROOT_LOG_WALL.get(), AncientAetherBlocks.STRIPPED_HIGHSPROOT_LOG_WALL.get())
                .put(AncientAetherBlocks.SAKURA_LOG_WALL.get(), AncientAetherBlocks.STRIPPED_SAKURA_LOG_WALL.get())
                .put(AncientAetherBlocks.HIGHSPROOT_WOOD_WALL.get(), AncientAetherBlocks.STRIPPED_HIGHSPROOT_WOOD_WALL.get())
                .put(AncientAetherBlocks.SAKURA_WOOD_WALL.get(), AncientAetherBlocks.STRIPPED_SAKURA_WOOD_WALL.get())
                .build();

        public static BlockState setupToolActions(BlockState old, ToolAction action) {
            Block oldBlock = old.getBlock();
            if (action == ToolActions.AXE_STRIP) {
                if (STRIPPABLES.containsKey(oldBlock)) {
                    return STRIPPABLES.get(oldBlock).withPropertiesOf(old);
                }
            }
            return old;
        }

        public static void handleDivineToolAbility(Player player, Level level, BlockPos pos, ItemStack stack, BlockState state) {
            if (stack.getItem() instanceof DivineTool divineTool) {
                divineTool.grantDivineProtectionBuff(player, level, pos, stack, state);
            }
        }

        public static boolean debuffTools;

        public static float reduceToolEffectiveness(Player player, BlockState state, ItemStack stack, float speed) {
            if (AetherConfig.SERVER.tools_debuff.get()) {
                if (!player.level().isClientSide()) {
                    debuffTools = true;
                    PacketRelay.sendToNear(new ToolDebuffPacket(true), player.getX(), player.getY(), player.getZ(), 10, player.level().dimension());
                }
            }
            if (debuffTools) {
                if ((state.getBlock().getDescriptionId().startsWith("block.ancient_aether.") && !state.is(AetherTags.Blocks.TREATED_AS_VANILLA_BLOCK))) {
                    if (!stack.isEmpty() && stack.isCorrectToolForDrops(state) && !stack.getItem().getDescriptionId().startsWith("item.aether.") && !stack.is(AetherTags.Items.TREATED_AS_AETHER_ITEM)) {
                        speed = 1.0F;
                    }
                }
            }
            return speed;
        }
    }

    public static class WeaponHooks {
        public static float reduceWeaponEffectiveness(LivingEntity target, Entity source, float damage) {
            if (AetherConfig.SERVER.tools_debuff.get() && !target.level().isClientSide()) {
                double pow = Math.max(Math.pow(damage, damage > 1.0 ? 0.6 : 1.6), 1.0);
                if (source instanceof LivingEntity livingEntity) {
                    ItemStack stack = livingEntity.getMainHandItem();
                    if ((target.getType().getDescriptionId().startsWith("entity.ancient_aether") && !target.getType().is(AetherTags.Entities.TREATED_AS_VANILLA_ENTITY))) {
                        if (!stack.isEmpty() && !stack.getAttributeModifiers(EquipmentSlot.MAINHAND).isEmpty() && !stack.getAttributeModifiers(EquipmentSlot.MAINHAND).get(Attributes.ATTACK_DAMAGE).isEmpty()) {
                            double value = stack.getAttributeModifiers(EquipmentSlot.MAINHAND).get(Attributes.ATTACK_DAMAGE).stream().mapToDouble(AttributeModifier::getAmount).sum();
                            if (value > livingEntity.getAttributeBaseValue(Attributes.ATTACK_DAMAGE) && !stack.getItem().getDescriptionId().startsWith("item.ancient_aether.")) {
                                damage = (float) pow;
                            }
                        }
                    }
                } else if (source instanceof Projectile) {
                    if ((target.getType().getDescriptionId().startsWith("entity.ancient_aether") && !target.getType().is(AetherTags.Entities.TREATED_AS_VANILLA_ENTITY))) {
                        if ((!source.getType().getDescriptionId().startsWith("entity.ancient_aether"))
                                && (!(source instanceof AbstractArrow abstractArrow) || !abstractArrow.hasData(AetherDataAttachments.PHOENIX_ARROW) || !abstractArrow.getData(AetherDataAttachments.PHOENIX_ARROW).isPhoenixArrow())) {
                            damage = (float) pow;
                        }
                    }
                }
            }
            return damage;
        }

        public static float reduceArmorEffectiveness(LivingEntity target, @Nullable Entity source, float damage) {
            if (source != null) {
                if ((source.getType().getDescriptionId().startsWith("entity.ancient_aether") && !source.getType().is(AetherTags.Entities.TREATED_AS_VANILLA_ENTITY))) {
                    for (ItemStack stack : target.getArmorSlots()) {
                        if (stack.getItem() instanceof ArmorItem armorItem && !stack.getItem().getDescriptionId().startsWith("item.ancient_aether.")) {
                            if (!stack.getAttributeModifiers(armorItem.getEquipmentSlot()).isEmpty() && !stack.getAttributeModifiers(armorItem.getEquipmentSlot()).get(Attributes.ARMOR).isEmpty()) {
                                double value = stack.getAttributeModifiers(armorItem.getEquipmentSlot()).get(Attributes.ARMOR).stream().mapToDouble((attributeModifier) -> attributeModifier.getAmount() / 15).sum();
                                damage += value;
                            }
                        }
                    }
                }
            }
            return damage;
        }
    }
}