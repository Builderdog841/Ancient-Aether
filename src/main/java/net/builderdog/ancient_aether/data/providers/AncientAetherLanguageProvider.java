package net.builderdog.ancient_aether.data.providers;

import com.aetherteam.aether.data.providers.AetherLanguageProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.ItemLike;

import java.util.function.Supplier;

public abstract class AncientAetherLanguageProvider extends AetherLanguageProvider {
    public AncientAetherLanguageProvider(PackOutput output, String id) {
        super(output, id);
    }

    public void addTrimPattern(String key, String name) {
        add("trim_pattern." + id + "." + key, name + " Armor Trim");
    }

    public void addTooltip(String key, String name) {
        add("tooltip." + id + "." + key, name);
    }

    public void addAccessorySubtitle(String key, String name) {
        add("subtitles." + id + ".item.accessory.equip_" + key, name + " jingles");
    }

    public void addMenu(String key, String name) {
        add("menu." + id + "." + key, name);
    }

    public void addCompatPackTitle(String packName, String description) {
        add("pack." + id + "." + packName + "_compat.title", description + " Compatibility");
    }

    public void addLeavesLore(Supplier<? extends ItemLike> key, String name) {
        add("lore." + key.get().asItem().getDescriptionId(), "These leaves generate with " + name + " Trees. They can drop " + name + " Saplings when decaying.");
    }

    public void addSaplingLore(Supplier<? extends ItemLike> key, String name, String color) {
        add("lore." + key.get().asItem().getDescriptionId(), "These small " + color + " saplings will grow into huge " + name + " Trees. They can be grown faster with Bone Meal");
    }

    public void addFlowerLore(Supplier<? extends ItemLike> key, String name, String type, String biomes) {
        add("lore." + key.get().asItem().getDescriptionId(), "These " + type + " flowers can be found in large numbers " + biomes + ". They can be crafted into " + name + " Dye when placed in a Crafting Table.");
    }

    public void addWoodBlockLore(Supplier<? extends ItemLike> key, String name, String description) {
        add("lore." + key.get().asItem().getDescriptionId(), description + ". When put in a Crafting Table they will provide 4 " + name + " Planks.");
    }

    public void addPlanksLore(Supplier<? extends ItemLike> key, String name) {
        add("lore." + key.get().asItem().getDescriptionId(), name + " Planks can be made into various tools, blocks and items. They are crafted from " + name + " Logs, and make a great building material.");
    }

    public void addStairsLore(Supplier<? extends ItemLike> key, String name) {
        add("lore." + key.get().asItem().getDescriptionId(), "Crafted from " + name + ". Stairs are useful for adding verticality to builds and are often used for decoration too!");
    }

    public void addSlabLore(Supplier<? extends ItemLike> key, String name) {
        add("lore." + key.get().asItem().getDescriptionId(), "Crafted from " + name + ". Slabs are half blocks, versatile for decoration and smooth slopes. Try adding some to a building's roofing!");
    }

    public void addWallLore(Supplier<? extends ItemLike> key, String name) {
        add("lore." + key.get().asItem().getDescriptionId(), "Crafted from " + name + ". Can be used for decorative enclosures and defenses. Great for keeping nasty intruders away!");
    }

    public void addFenceLore(Supplier<? extends ItemLike> key, String name) {
        add("lore." + key.get().asItem().getDescriptionId(), "Crafted from " + name + " Planks and Sticks. Great for keeping your livestock safe from wandering predators!");
    }

    public void addFenceGateLore(Supplier<? extends ItemLike> key, String name) {
        add("lore." + key.get().asItem().getDescriptionId(), "Crafted from Sticks and " + name + "Planks. Gives a homely entrance and exit to your precious enclosures.");
    }

    public void addDoorLore(Supplier<? extends ItemLike> key, String name) {
        add("lore." + key.get().asItem().getDescriptionId(), "Crafted from " + name + ", an ornate door helpful for keeping an enclosed and safe space without worry of monsters wandering in.");
    }

    public void addTrapdoorLore(Supplier<? extends ItemLike> key, String name) {
        add("lore." + key.get().asItem().getDescriptionId(), "Crafted from " + name + ". A Trapdoor useful for covering entryways one block wide. Often used to add extra protection to staircases.");
    }

    public void addButtonLore(Supplier<? extends ItemLike> key, String name) {
        add("lore." + key.get().asItem().getDescriptionId(), "Crafted from " + name + " Planks, a button used to activate mechanisms and Redstone.");
    }

    public void addPressurePlateLore(Supplier<? extends ItemLike> key, String name) {
        add("lore." + key.get().asItem().getDescriptionId(), "Crafted from " + name + " Planks. A wooden pressure plate used to activate mechanisms and Redstone.");
    }

    public void addSignLore(Supplier<? extends ItemLike> key, String name) {
        add("lore." + key.get().asItem().getDescriptionId(), "Crafted from " + name + " Planks and Sticks. A helpful sign perfect for writing messages and directions on.");
    }

    public void addHangingSignLore(Supplier<? extends ItemLike> key, String name) {
        add("lore." + key.get().asItem().getDescriptionId(), "Crafted from Stripped " + name + " Logs and Chains. A helpful sign perfect for writing messages and directions on.");
    }

    public void addBookshelfLore(Supplier<? extends ItemLike> key, String name) {
        add("lore." + key.get().asItem().getDescriptionId(), "Crafted from " + name + " Planks and Books. Bookshelves can be used to enhance the enchanting capabilities of an Enchanting Table.");
    }

    public void addMosaicLore(Supplier<? extends ItemLike> key, String name) {
        add("lore." + key.get().asItem().getDescriptionId(), "A fancy " + name + " variant that can be rotated in various different directions.");
    }

    public void addVaseLore(Supplier<? extends ItemLike> key, String name) {
        add("lore." + key.get().asItem().getDescriptionId(), "A piece of pottery crafted from " + name + " in a Stonecutter.");
    }

    public void addAncientVaseLore(Supplier<? extends ItemLike> key, String name) {
        add("lore." + key.get().asItem().getDescriptionId(), "A dusty relic found in " + name + ". Breaking it can yield you some shiny treasures.");
    }

    public void addValkyrumItemLore(Supplier<? extends ItemLike> key, String name, String description) {
        add("lore." + key.get().asItem().getDescriptionId(), "A noble " + name + " forged from Valkyrum. " + description);
    }

    public void addRewardLore(Supplier<? extends ItemLike> key, String name, String description) {
        add("lore." + key.get().asItem().getDescriptionId(), "A reward from defeating " + name + ". This " + description + ".");
    }

    public void addTemplateLore(String key, String name) {
        add("lore.item.ancient_aether." + key + "_armor_trim_smithing_template", "A stylish upgrade for your armor, rarely found in " + name + ".");
    }

    public void addBossTemplateLore(String key, String name) {
        add("lore.item.ancient_aether." + key + "_armor_trim_smithing_template", "A stylish upgrade for your armor, gained by defeating the " + name + ".");
    }

    public void addBoatLore(Supplier<? extends ItemLike> key) {
        add("lore." + key.get().asItem().getDescriptionId(), "While the Aether does not have many large bodies of water, a boat can occasionally be a useful tool for crossing large distances over ice!");
    }

    public void addChestBoatLore(Supplier<? extends ItemLike> key, String name) {
        add("lore." + key.get().asItem().getDescriptionId(), "A " + name + " Boat with a handy chest in the back. Helpful for transporting more items over long stretches of water, which are famously difficult to find in the Aether.");
    }

    public void addMoaEggLore(Supplier<? extends ItemLike> key, String name, String jumps, String description) {
        add("lore." + key.get().asItem().getDescriptionId(), "An egg laid by a " + name + " Moa. Hatching this provides a " + name + " Moa with " + jumps + " mid-air jumps" + description);
    }
}