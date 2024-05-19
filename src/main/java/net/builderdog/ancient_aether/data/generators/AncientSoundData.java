package net.builderdog.ancient_aether.data.generators;

import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.client.AncientSoundEvents;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.SoundDefinitionsProvider;

public class AncientSoundData extends SoundDefinitionsProvider {
    public AncientSoundData(PackOutput output, ExistingFileHelper helper) {
        super(output, AncientAether.MODID, helper);
    }

    @Override
    public void registerSounds() {
        add(AncientSoundEvents.BLOCK_GRAPE_VINE_PICK_GRAPES, definition().with(
                        sound("item/sweet_berries/pick_from_bush1"),
                        sound("item/sweet_berries/pick_from_bush2"))
                .subtitle("subtitles.ancient_aether.block.grape_vine.pick_grapes")
        );
        add(AncientSoundEvents.BLOCK_OBELISK_ACTIVATION, definition().with(
                        sound("ancient_aether:block/obelisk_activation"))
                .subtitle("subtitles.ancient_aether.block.obelisk.activation")
        );

        add(AncientSoundEvents.ITEM_ACCESSORY_EQUIP_VALKYRUM_RING, definition().with(
                        sound("item/armor/equip_chain1"),
                        sound("item/armor/equip_chain2"),
                        sound("item/armor/equip_chain3"),
                        sound("item/armor/equip_chain4"),
                        sound("item/armor/equip_chain5"),
                        sound("item/armor/equip_chain6"))
                .subtitle("subtitles.ancient_aether.item.accessory.equip_valkyrum_ring")
        );
        add(AncientSoundEvents.ITEM_ACCESSORY_EQUIP_HERMES_RING, definition().with(
                        sound("item/armor/equip_chain1"),
                        sound("item/armor/equip_chain2"),
                        sound("item/armor/equip_chain3"),
                        sound("item/armor/equip_chain4"),
                        sound("item/armor/equip_chain5"),
                        sound("item/armor/equip_chain6"))
                .subtitle("subtitles.ancient_aether.item.accessory.equip_hermes_ring")
        );
        add(AncientSoundEvents.ITEM_ACCESSORY_EQUIP_WARRIOR_RING, definition().with(
                        sound("item/armor/equip_chain1"),
                        sound("item/armor/equip_chain2"),
                        sound("item/armor/equip_chain3"),
                        sound("item/armor/equip_chain4"),
                        sound("item/armor/equip_chain5"),
                        sound("item/armor/equip_chain6"))
                .subtitle("subtitles.ancient_aether.item.accessory.equip_warrior_ring")
        );
        add(AncientSoundEvents.ITEM_ACCESSORY_EQUIP_GROWTH_RING, definition().with(
                        sound("item/armor/equip_chain1"),
                        sound("item/armor/equip_chain2"),
                        sound("item/armor/equip_chain3"),
                        sound("item/armor/equip_chain4"),
                        sound("item/armor/equip_chain5"),
                        sound("item/armor/equip_chain6"))
                .subtitle("subtitles.ancient_aether.item.accessory.equip_growth_ring")
        );
        add(AncientSoundEvents.ITEM_ACCESSORY_EQUIP_ANCIENT_RING, definition().with(
                        sound("item/armor/equip_chain1"),
                        sound("item/armor/equip_chain2"),
                        sound("item/armor/equip_chain3"),
                        sound("item/armor/equip_chain4"),
                        sound("item/armor/equip_chain5"),
                        sound("item/armor/equip_chain6"))
                .subtitle("subtitles.ancient_aether.item.accessory.equip_ancient_ring")
        );
        add(AncientSoundEvents.ITEM_ACCESSORY_EQUIP_VALKYRUM_PENDANT, definition().with(
                        sound("item/armor/equip_chain1"),
                        sound("item/armor/equip_chain2"),
                        sound("item/armor/equip_chain3"),
                        sound("item/armor/equip_chain4"),
                        sound("item/armor/equip_chain5"),
                        sound("item/armor/equip_chain6"))
                .subtitle("subtitles.ancient_aether.item.accessory.equip_valkyrum_pendant")
        );
        add(AncientSoundEvents.ITEM_ACCESSORY_EQUIP_HERMES_PENDANT, definition().with(
                        sound("item/armor/equip_chain1"),
                        sound("item/armor/equip_chain2"),
                        sound("item/armor/equip_chain3"),
                        sound("item/armor/equip_chain4"),
                        sound("item/armor/equip_chain5"),
                        sound("item/armor/equip_chain6"))
                .subtitle("subtitles.ancient_aether.item.accessory.equip_hermes_pendant")
        );
        add(AncientSoundEvents.ITEM_ACCESSORY_EQUIP_WARRIOR_PENDANT, definition().with(
                        sound("item/armor/equip_chain1"),
                        sound("item/armor/equip_chain2"),
                        sound("item/armor/equip_chain3"),
                        sound("item/armor/equip_chain4"),
                        sound("item/armor/equip_chain5"),
                        sound("item/armor/equip_chain6"))
                .subtitle("subtitles.ancient_aether.item.accessory.equip_warrior_pendant")
        );
        add(AncientSoundEvents.ITEM_ACCESSORY_EQUIP_GROWTH_PENDANT, definition().with(
                        sound("item/armor/equip_chain1"),
                        sound("item/armor/equip_chain2"),
                        sound("item/armor/equip_chain3"),
                        sound("item/armor/equip_chain4"),
                        sound("item/armor/equip_chain5"),
                        sound("item/armor/equip_chain6"))
                .subtitle("subtitles.ancient_aether.item.accessory.equip_growth_pendant")
        );
        add(AncientSoundEvents.ITEM_ACCESSORY_EQUIP_ANCIENT_PENDANT, definition().with(
                        sound("item/armor/equip_chain1"),
                        sound("item/armor/equip_chain2"),
                        sound("item/armor/equip_chain3"),
                        sound("item/armor/equip_chain4"),
                        sound("item/armor/equip_chain5"),
                        sound("item/armor/equip_chain6"))
                .subtitle("subtitles.ancient_aether.item.accessory.equip_ancient_pendant")
        );

        add(AncientSoundEvents.ENTITY_FLUFFALO_AMBIENT, definition().with(
                        sound("ancient_aether:entity/fluffalo/idle"))
                .subtitle("subtitles.ancient_aether.entity.fluffalo.ambient")
        );
        add(AncientSoundEvents.ENTITY_FLUFFALO_MILK, definition().with(
                        sound("entity/cow/milk1"),
                        sound("entity/cow/milk2"),
                        sound("entity/cow/milk3"))
                .subtitle("subtitles.ancient_aether.entity.fluffalo.milk")
        );
        add(AncientSoundEvents.ENTITY_FLUFFALO_HURT, definition().with(
                        sound("ancient_aether:entity/fluffalo/hurt"))
                .subtitle("subtitles.ancient_aether.entity.fluffalo.hurt")
        );
        add(AncientSoundEvents.ENTITY_FLUFFALO_DEATH, definition().with(
                        sound("ancient_aether:entity/fluffalo/hurt"))
                .subtitle("subtitles.ancient_aether.entity.fluffalo.death")
        );
        add(AncientSoundEvents.ENTITY_SLAMMROOT_JUMP, definition().with(
                        sound("ancient_aether:entity/slammroot/hurt"))
                .subtitle("subtitles.ancient_aether.entity.slammroot.jump")
        );
        add(AncientSoundEvents.ENTITY_SLAMMROOT_HURT, definition().with(
                        sound("ancient_aether:entity/slammroot/hurt"))
                .subtitle("subtitles.ancient_aether.entity.slammroot.hurt")
        );
        add(AncientSoundEvents.ENTITY_SLAMMROOT_DEATH, definition().with(
                        sound("ancient_aether:entity/slammroot/hurt"))
                .subtitle("subtitles.ancient_aether.entity.slammroot.death")
        );
        add(AncientSoundEvents.ENTITY_AERONAUTIC_LEAPER_DEATH, definition().with(
                        sound("mob/slime/big1"),
                        sound("mob/slime/big2"),
                        sound("mob/slime/big3"),
                        sound("mob/slime/big4"))
                .subtitle("subtitles.ancient_aether.entity.aeronautic_leaper.death")
        );
        add(AncientSoundEvents.ENTITY_AERONAUTIC_LEAPER_HURT, definition().with(
                        sound("mob/slime/big1"),
                        sound("mob/slime/big2"),
                        sound("mob/slime/big3"),
                        sound("mob/slime/big4"))
                .subtitle("subtitles.ancient_aether.entity.aeronautic_leaper.hurt")
        );
        add(AncientSoundEvents.ENTITY_AERONAUTIC_LEAPER_JUMP, definition().with(
                        sound("mob/slime/big1"),
                        sound("mob/slime/big2"),
                        sound("mob/slime/big3"),
                        sound("mob/slime/big4"))
                .subtitle("subtitles.ancient_aether.entity.aeronautic_leaper.jump")
        );
        add(AncientSoundEvents.ENTITY_MUTATED_AECHOR_PLANT_SHOOT_NEEDLE, definition().with(
                        sound("random/bow"))
                .subtitle("subtitles.ancient_aether.entity.mutated_aechor_plant.shoot.needle")
        );
        add(AncientSoundEvents.ENTITY_MUTATED_AECHOR_PLANT_SHOOT_SPORE_BOMB, definition().with(
                sound("ancient_aether:entity/mutated_aechor_plant/shoot_spore_bomb")
                ).subtitle("subtitles.ancient_aether.entity.mutated_aechor_plant.shoot.spore_bomb")
        );
        add(AncientSoundEvents.ENTITY_MUTATED_AECHOR_PLANT_HURT, definition().with(
                sound("ancient_aether:entity/mutated_aechor_plant/hurt")
                ).subtitle("subtitles.ancient_aether.entity.mutated_aechor_plant.hurt")
        );
        add(AncientSoundEvents.ENTITY_MUTATED_AECHOR_PLANT_DEATH, definition().with(
                sound("ancient_aether:entity/mutated_aechor_plant/hurt")
                ).subtitle("subtitles.ancient_aether.entity.mutated_aechor_plant.death")
        );
        add(AncientSoundEvents.ENTITY_REMEDY_CRYSTAL_EXPLODE, definition().with(
                        sound("random/glass1"),
                        sound("random/glass2"),
                        sound("random/glass3")
                ).subtitle("subtitles.ancient_aether.entity.remedy_crystal.explode")
        );
    }
}