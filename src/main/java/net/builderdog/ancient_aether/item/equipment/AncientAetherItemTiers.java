package net.builderdog.ancient_aether.item.equipment;

import net.builderdog.ancient_aether.AncientAetherTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public enum AncientAetherItemTiers implements Tier {

    ANCIENT(3, 2031, 8.0F, 3.0F, 10, () -> Ingredient.of(AncientAetherTags.Items.ANCIENT_REPAIRING)),
    ARKZENUS(5, 1561, 8.0F, 3.0F, 20, () -> Ingredient.of(AncientAetherTags.Items.ARKZENUS_REPAIRING)),
    VALKYRUM(5, 2031, 9.0F, 4.0F, 15, () -> Ingredient.of(AncientAetherTags.Items.VALKYRUM_REPAIRING));

    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairMaterial;

    AncientAetherItemTiers(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
        this.harvestLevel = harvestLevel;
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairMaterial = repairMaterial;
    }

    @Override
    public int getUses() {
        return maxUses;
    }

    @Override
    public float getSpeed() {
        return efficiency;
    }

    @Override
    public float getAttackDamageBonus() {
        return attackDamage;
    }

    @Override
    public int getLevel() {
        return harvestLevel;
    }

    @Override
    public int getEnchantmentValue() {
        return enchantability;
    }

    @Override
    public @NotNull Ingredient getRepairIngredient() {
        return repairMaterial.get();
    }
}