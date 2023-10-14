package net.builderdog.ancient_aether.entity.monster.boss;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.util.RandomSource;

public final class AncientAetherBossNameGenerator {

    public static final String[] guardianNameFirst = { "Arkzenus", "Chro", "Ere", "Anu", "Ark", "Nim" };
    public static final String[] guardianNameLast = { "nos", "bus", "bis", "nor", ""};

    public static final String[] coreNameFirst = { "Aeronor", "Gra", "Pla", "Si", "Go", "Au", "Stra" };
    public static final String[] coreNameMiddle = { "v", "m", "n", "t"};
    public static final String[] coreNameLast = { "ium", "ite", "on", "us", "or"};

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

    public static MutableComponent generateAncientCore(RandomSource random) {
        String result = "";
        int index = random.nextInt(coreNameFirst.length);
        result += coreNameFirst[index];
        if (index != 0) {
            result += coreNameMiddle[random.nextInt(coreNameMiddle.length)];
            result += coreNameLast[random.nextInt(coreNameLast.length)];
        }
        result += ", ";
        return Component.literal(result).append(Component.translatable("gui.ancient_aether.ancient_core.title"));
    }
}