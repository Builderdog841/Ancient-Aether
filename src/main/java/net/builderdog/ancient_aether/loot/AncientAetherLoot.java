package net.builderdog.ancient_aether.loot;

import com.aetherteam.aether.Aether;
import net.builderdog.ancient_aether.AncientAether;
import net.minecraft.resources.ResourceLocation;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class AncientAetherLoot {
    private static final Set<ResourceLocation> LOOT_TABLES = new HashSet<>();
    public static final Set<ResourceLocation> IMMUTABLE_LOOT_TABLES = Collections.unmodifiableSet(LOOT_TABLES);
    public static final ResourceLocation VELOX_WHIRLWIND_JUNK = register("selectors/velox_whirlwind_junk");

    private static ResourceLocation register(String id) {
        return register(new ResourceLocation(AncientAether.MOD_ID, id));
    }

    private static ResourceLocation register(ResourceLocation id) {
        if (LOOT_TABLES.add(id)) {
            return id;
        } else {
            throw new IllegalArgumentException(id + " is already a registered built-in loot table");
        }
    }
}
