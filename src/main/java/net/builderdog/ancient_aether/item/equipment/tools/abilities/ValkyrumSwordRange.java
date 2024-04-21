package net.builderdog.ancient_aether.item.equipment.tools.abilities;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraftforge.common.ForgeMod;

import java.util.UUID;

public interface ValkyrumSwordRange {
    UUID REACH_DISTANCE_MODIFIER_UUID = UUID.fromString("0A87A51E-A43F-4EEF-A770-07C2160D373D");
    UUID ATTACK_RANGE_MODIFIER_UUID = UUID.fromString("3B9D1CB7-D7E4-453E-BD7D-37D7F7846736");

    default Multimap<Attribute, AttributeModifier> extendReachModifier(Multimap<Attribute, AttributeModifier> map, EquipmentSlot slot) {
        if (slot == EquipmentSlot.MAINHAND) {
            ImmutableMultimap.Builder<Attribute, AttributeModifier> attributeBuilder = ImmutableMultimap.builder();
            attributeBuilder.putAll(map);
            attributeBuilder.put(ForgeMod.BLOCK_REACH.get(), new AttributeModifier(REACH_DISTANCE_MODIFIER_UUID, "Reach distance modifier", getModifier(), Operation.ADDITION));
            attributeBuilder.put(ForgeMod.ENTITY_REACH.get(), new AttributeModifier(ATTACK_RANGE_MODIFIER_UUID, "Attack range modifier", getModifier(), Operation.ADDITION));
            map = attributeBuilder.build();
        }

        return map;
    }

    private double getModifier() {
        return 1;
    }
}
