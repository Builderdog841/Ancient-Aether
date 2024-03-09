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

    public void addMosaicLore(Supplier<? extends ItemLike> key, String name) {
        add("lore." + key.get().asItem().getDescriptionId(), "A fancy" + name + "variant that can be rotated in various different directions.");
    }

    public void addAccessorySubtitle(String key, String name) {
        add("subtitles." + id + ".item.accessory.equip_" + key, name + " jingles");
    }

    public void addCompatPackTitle(String packName, String description) {
        add("pack." + id + "." + packName + "_compat.title", description + " Compatibility");
    }
}