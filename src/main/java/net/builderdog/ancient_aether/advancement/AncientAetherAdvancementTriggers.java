package net.builderdog.ancient_aether.advancement;

import net.minecraft.advancements.CriteriaTriggers;

public class AncientAetherAdvancementTriggers {
    public static void init() {
        CriteriaTriggers.register(ObeliskTrigger.INSTANCE);
    }
}