package net.builderdog.ancient_aether.entity.monster.dungeon.boss;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.util.RandomSource;

public final class AncientAetherBossNameGenerator {

    public static final String[] guardianNameFirst = { "Arkzenus", "Chro", "Ere", "Anu", "Ark", "Nim", "Celci", "Tera" };
    public static final String[] guardianNameLast = { "nos", "bus", "bis", "nor", ""};


    public static MutableComponent generateAncientGuardian(RandomSource random) {
        String result = "";
        int index = random.nextInt(guardianNameFirst.length);
        result += guardianNameFirst[index];
        if (index != 0) {
            result += guardianNameLast[random.nextInt(guardianNameLast.length)];
        }
        result += ", ";
        return Component.literal(result).append(Component.translatable("gui.ancient_aether.ancient_guardian.title"));
    }
}