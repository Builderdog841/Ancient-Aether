package net.builderdog.ancient_aether.item.equipment.armor;

import net.builderdog.ancient_aether.AncientAether;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class AncientAetherArmorItem extends ArmorItem {
    public AncientAetherArmorItem(ArmorMaterial material, Type type, Properties properties) {
        super(material, type, properties);
    }

    @Nullable
    @Override
    public String getArmorTexture(@NotNull ItemStack stack, @NotNull Entity entity, @NotNull EquipmentSlot slot, @NotNull String type) {
        return String.format("%s:textures/models/armor/%s_layer_%s.png", AncientAether.MODID, getMaterial().getName(), slot == EquipmentSlot.LEGS ? 2 : 1);
    }
}