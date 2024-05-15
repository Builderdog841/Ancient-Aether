package net.builderdog.ancient_aether.item.equipment;

import com.aetherteam.aether.client.AetherSoundEvents;
import net.builderdog.ancient_aether.AncientAetherTags;
import net.minecraft.Util;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

import java.util.EnumMap;
import java.util.function.Supplier;

public enum AncientAetherArmorTiers implements ArmorMaterial {
    VALKYRUM("valkyrum", 33, Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
        map.put(ArmorItem.Type.BOOTS, 3);
        map.put(ArmorItem.Type.LEGGINGS, 6);
        map.put(ArmorItem.Type.CHESTPLATE, 8);
        map.put(ArmorItem.Type.HELMET, 3);
    }), 10, AetherSoundEvents.ITEM_ARMOR_EQUIP_VALKYRIE, 2.0F, () -> Ingredient.of(AncientAetherTags.Items.VALKYRUM_REPAIRING));

    private static final EnumMap<ArmorItem.Type, Integer> DURABILITY_MAP = Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
        map.put(ArmorItem.Type.BOOTS, 13);
        map.put(ArmorItem.Type.LEGGINGS, 15);
        map.put(ArmorItem.Type.CHESTPLATE, 16);
        map.put(ArmorItem.Type.HELMET, 11);
    });
    private final String name;
    private final int maxDamageFactor;
    private final EnumMap<ArmorItem.Type, Integer> protectionAmountMap;
    private final int enchantability;
    private final Supplier<SoundEvent> soundEvent;
    private final float toughness;
    private final Supplier<Ingredient> repairMaterial;

    AncientAetherArmorTiers(String name, int maxDamageFactor, EnumMap<ArmorItem.Type, Integer> protectionAmountMap, int enchantability, Supplier<SoundEvent> soundEvent, float toughness, Supplier<Ingredient> repairMaterial) {
        this.name = name;
        this.maxDamageFactor = maxDamageFactor;
        this.protectionAmountMap = protectionAmountMap;
        this.enchantability = enchantability;
        this.soundEvent = soundEvent;
        this.toughness = toughness;
        this.repairMaterial = repairMaterial;
    }

    @Override
    public int getDurabilityForType(ArmorItem.@NotNull Type type) {
        return DURABILITY_MAP.get(type) * maxDamageFactor;
    }

    @Override
    public int getDefenseForType(ArmorItem.@NotNull Type type) {
        return protectionAmountMap.get(type);
    }

    @Override
    public int getEnchantmentValue() {
        return enchantability;
    }

    @Override
    public @NotNull SoundEvent getEquipSound() {
        return soundEvent.get();
    }

    @Override
    public @NotNull Ingredient getRepairIngredient() {
        return repairMaterial.get();
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public @NotNull String getName() {
        return name;
    }

    @Override
    public float getToughness() {
        return toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return 0;
    }
}