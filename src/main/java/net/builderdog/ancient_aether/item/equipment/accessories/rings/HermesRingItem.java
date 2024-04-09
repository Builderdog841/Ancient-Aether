package net.builderdog.ancient_aether.item.equipment.accessories.rings;

import com.aetherteam.aether.item.accessories.ring.RingItem;
import net.builderdog.ancient_aether.client.AncientAetherSoundEvents;

public class HermesRingItem extends RingItem {

    public HermesRingItem(Properties properties) {
        super(AncientAetherSoundEvents.ITEM_ACCESSORY_EQUIP_HERMES_RING, properties);
    }

    /*
    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext context, UUID uuid, ItemStack stack) {
        if (context.entity() instanceof Player player) {
            float foodLevel = player.getFoodData().getFoodLevel();
            Multimap<Attribute, AttributeModifier> attributes = HashMultimap.create();
            attributes.put(Attributes.MOVEMENT_SPEED, new AttributeModifier(uuid, "Hermes Ring Ability", foodLevel * 0.001, AttributeModifier.Operation.ADDITION));
            return attributes;
        }
        return null;
    }
     */
}