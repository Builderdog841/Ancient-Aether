package net.builderdog.ancient_aether.item.equipment.accessories.pendants;

import com.aetherteam.aether.item.accessories.pendant.PendantItem;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.client.AncientAetherSoundEvents;
import net.minecraft.resources.ResourceLocation;

public class HermesPendantItem extends PendantItem {

    public HermesPendantItem(Properties properties) {
        super(new ResourceLocation(AncientAether.MODID, "hermes_pendant"), AncientAetherSoundEvents.ITEM_ACCESSORY_EQUIP_HERMES_PENDANT, properties);
    }

    /*
    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext context, UUID uuid, ItemStack stack) {
        if (context.entity() instanceof Player player) {
            float foodLevel = player.getFoodData().getFoodLevel();
            Multimap<Attribute, AttributeModifier> attributes = HashMultimap.create();
            attributes.put(Attributes.MOVEMENT_SPEED, new AttributeModifier(uuid, "Hermes Pendant Ability", foodLevel * 0.002, AttributeModifier.Operation.ADDITION));
            return attributes;
        }
        return null;
    }
     */
}