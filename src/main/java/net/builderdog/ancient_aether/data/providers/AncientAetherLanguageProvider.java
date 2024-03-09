package net.builderdog.ancient_aether.data.providers;

import com.aetherteam.aether.data.providers.AetherLanguageProvider;
import net.minecraft.data.PackOutput;

public abstract class AncientAetherLanguageProvider extends AetherLanguageProvider {
    public AncientAetherLanguageProvider(PackOutput output, String id) {
        super(output, id);
    }

    public void addTrimPattern(String key, String name) {
        add("trim_pattern." + id + "." + key, name + " Armor Trim");
    }
}