package net.builderdog.ancient_aether.data.generators;

import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.client.AncientAetherSoundEvents;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.SoundDefinitionsProvider;

public class AncientAetherSoundData extends SoundDefinitionsProvider {
    public AncientAetherSoundData(PackOutput output, ExistingFileHelper helper) {
        super(output, AncientAether.MODID, helper);
    }

    @Override
    public void registerSounds() {
        add(AncientAetherSoundEvents.BLOCK_GRAPE_VINE_PICK_GRAPES, definition().with(
                        sound("item/sweet_berries/pick_from_bush1"),
                        sound("item/sweet_berries/pick_from_bush2"))
                .subtitle("subtitles.ancient_aether.block.grape_vine.pick_grapes")
        );

        add(AncientAetherSoundEvents.BLOCK_OBELISK_ACTIVATION, definition().with(
                        sound("ancient_aether:block/obelisk_activation"))
                .subtitle("subtitles.ancient_aether.block.obelisk.activation")
        );

        add(AncientAetherSoundEvents.ITEM_ACCESSORY_EQUIP_VALKYRUM_RING, definition().with(
                        sound("item/armor/equip_chain1"),
                        sound("item/armor/equip_chain2"),
                        sound("item/armor/equip_chain3"),
                        sound("item/armor/equip_chain4"),
                        sound("item/armor/equip_chain5"),
                        sound("item/armor/equip_chain6"))
                .subtitle("subtitles.ancient_aether.item.accessory.equip_valkyrum_ring")
        );
        add(AncientAetherSoundEvents.ITEM_ACCESSORY_EQUIP_HERMES_RING, definition().with(
                        sound("item/armor/equip_chain1"),
                        sound("item/armor/equip_chain2"),
                        sound("item/armor/equip_chain3"),
                        sound("item/armor/equip_chain4"),
                        sound("item/armor/equip_chain5"),
                        sound("item/armor/equip_chain6"))
                .subtitle("subtitles.ancient_aether.item.accessory.equip_hermes_ring")
        );
        add(AncientAetherSoundEvents.ITEM_ACCESSORY_EQUIP_ARKENIUM_RING, definition().with(
                        sound("item/armor/equip_chain1"),
                        sound("item/armor/equip_chain2"),
                        sound("item/armor/equip_chain3"),
                        sound("item/armor/equip_chain4"),
                        sound("item/armor/equip_chain5"),
                        sound("item/armor/equip_chain6"))
                .subtitle("subtitles.ancient_aether.item.accessory.equip_arkenium_ring")
        );
        add(AncientAetherSoundEvents.ITEM_ACCESSORY_EQUIP_HEALTH_RING, definition().with(
                        sound("item/armor/equip_chain1"),
                        sound("item/armor/equip_chain2"),
                        sound("item/armor/equip_chain3"),
                        sound("item/armor/equip_chain4"),
                        sound("item/armor/equip_chain5"),
                        sound("item/armor/equip_chain6"))
                .subtitle("subtitles.ancient_aether.item.accessory.equip_health_ring")
        );
        add(AncientAetherSoundEvents.ITEM_ACCESSORY_EQUIP_ANCIENT_RING, definition().with(
                        sound("item/armor/equip_chain1"),
                        sound("item/armor/equip_chain2"),
                        sound("item/armor/equip_chain3"),
                        sound("item/armor/equip_chain4"),
                        sound("item/armor/equip_chain5"),
                        sound("item/armor/equip_chain6"))
                .subtitle("subtitles.ancient_aether.item.accessory.equip_ancient_ring")
        );
        add(AncientAetherSoundEvents.ITEM_ACCESSORY_EQUIP_VALKYRUM_PENDANT, definition().with(
                        sound("item/armor/equip_chain1"),
                        sound("item/armor/equip_chain2"),
                        sound("item/armor/equip_chain3"),
                        sound("item/armor/equip_chain4"),
                        sound("item/armor/equip_chain5"),
                        sound("item/armor/equip_chain6"))
                .subtitle("subtitles.ancient_aether.item.accessory.equip_valkyrum_pendant")
        );
        add(AncientAetherSoundEvents.ITEM_ACCESSORY_EQUIP_HERMES_PENDANT, definition().with(
                        sound("item/armor/equip_chain1"),
                        sound("item/armor/equip_chain2"),
                        sound("item/armor/equip_chain3"),
                        sound("item/armor/equip_chain4"),
                        sound("item/armor/equip_chain5"),
                        sound("item/armor/equip_chain6"))
                .subtitle("subtitles.ancient_aether.item.accessory.equip_hermes_pendant")
        );
        add(AncientAetherSoundEvents.ITEM_ACCESSORY_EQUIP_ARKENIUM_PENDANT, definition().with(
                        sound("item/armor/equip_chain1"),
                        sound("item/armor/equip_chain2"),
                        sound("item/armor/equip_chain3"),
                        sound("item/armor/equip_chain4"),
                        sound("item/armor/equip_chain5"),
                        sound("item/armor/equip_chain6"))
                .subtitle("subtitles.ancient_aether.item.accessory.equip_arkenium_pendant")
        );
        add(AncientAetherSoundEvents.ITEM_ACCESSORY_EQUIP_HEALTH_PENDANT, definition().with(
                        sound("item/armor/equip_chain1"),
                        sound("item/armor/equip_chain2"),
                        sound("item/armor/equip_chain3"),
                        sound("item/armor/equip_chain4"),
                        sound("item/armor/equip_chain5"),
                        sound("item/armor/equip_chain6"))
                .subtitle("subtitles.ancient_aether.item.accessory.equip_health_pendant")
        );
        add(AncientAetherSoundEvents.ITEM_ACCESSORY_EQUIP_ANCIENT_PENDANT, definition().with(
                        sound("item/armor/equip_chain1"),
                        sound("item/armor/equip_chain2"),
                        sound("item/armor/equip_chain3"),
                        sound("item/armor/equip_chain4"),
                        sound("item/armor/equip_chain5"),
                        sound("item/armor/equip_chain6"))
                .subtitle("subtitles.ancient_aether.item.accessory.equip_ancient_pendant")
        );

        add(AncientAetherSoundEvents.ENTITY_FLUFFALO_AMBIENT, definition().with(
                        sound("ancient_aether:entity/fluffalo/fluffalo_idle"))
                .subtitle("subtitles.ancient_aether.entity.fluffalo.ambient")
        );
        add(AncientAetherSoundEvents.ENTITY_FLUFFALO_MILK, definition().with(
                        sound("entity/cow/milk1"),
                        sound("entity/cow/milk2"),
                        sound("entity/cow/milk3"))
                .subtitle("subtitles.ancient_aether.entity.fluffalo.milk")
        );
        add(AncientAetherSoundEvents.ENTITY_FLUFFALO_HURT, definition().with(
                        sound("ancient_aether:entity/fluffalo/fluffalo_hurt"))
                .subtitle("subtitles.ancient_aether.entity.fluffalo.hurt")
        );
        add(AncientAetherSoundEvents.ENTITY_FLUFFALO_DEATH, definition().with(
                        sound("ancient_aether:entity/fluffalo/fluffalo_hurt"))
                .subtitle("subtitles.ancient_aether.entity.fluffalo.death")
        );
        add(AncientAetherSoundEvents.ENTITY_SLAMMROOT_HURT, definition().with(
                        sound("ancient_aether:entity/slammroot/slammroot_hurt"))
                .subtitle("subtitles.ancient_aether.entity.slammroot.hurt")
        );
        add(AncientAetherSoundEvents.ENTITY_SLAMMROOT_DEATH, definition().with(
                        sound("ancient_aether:entity/slammroot/slammroot_hurt"))
                .subtitle("subtitles.ancient_aether.entity.slammroot.death")
        );
        add(AncientAetherSoundEvents.ENTITY_AERONAUTIC_LEAPER_DEATH, definition().with(
                        sound("mob/slime/big1"),
                        sound("mob/slime/big2"),
                        sound("mob/slime/big3"),
                        sound("mob/slime/big4"))
                .subtitle("subtitles.ancient_aether.entity.aeronautic_leaper.death")
        );
        add(AncientAetherSoundEvents.ENTITY_AERONAUTIC_LEAPER_HURT, definition().with(
                        sound("mob/slime/big1"),
                        sound("mob/slime/big2"),
                        sound("mob/slime/big3"),
                        sound("mob/slime/big4"))
                .subtitle("subtitles.ancient_aether.entity.aeronautic_leaper.hurt")
        );
        add(AncientAetherSoundEvents.ENTITY_AERONAUTIC_LEAPER_JUMP, definition().with(
                        sound("mob/slime/big1"),
                        sound("mob/slime/big2"),
                        sound("mob/slime/big3"),
                        sound("mob/slime/big4"))
                .subtitle("subtitles.ancient_aether.entity.aeronautic_leaper.jump")
        );
        add(AncientAetherSoundEvents.ENTITY_MUTATED_AECHOR_PLANT_SHOOT, definition().with(
                        sound("random/bow"))
                .subtitle("subtitles.ancient_aether.entity.mutated_aechor_plant.shoot")
        );
        add(AncientAetherSoundEvents.ENTITY_MUTATED_AECHOR_PLANT_HURT, definition().with(
                        sound("damage/hit1"),
                        sound("damage/hit2"),
                        sound("damage/hit3"))
                .subtitle("subtitles.ancient_aether.entity.mutated_aechor_plant.hurt")
        );
        add(AncientAetherSoundEvents.ENTITY_MUTATED_AECHOR_PLANT_DEATH, definition().with(
                        sound("damage/fallbig"))
                .subtitle("subtitles.ancient_aether.entity.mutated_aechor_plant.death")
        );
    }
}