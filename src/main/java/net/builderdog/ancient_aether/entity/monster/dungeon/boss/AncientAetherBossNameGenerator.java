package net.builderdog.ancient_aether.entity.monster.dungeon.boss;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.util.RandomSource;

public final class AncientAetherBossNameGenerator {

    public static final String[] guardianNameFirst = {"Arkzenus", "Chro", "Ere", "Anu", "Ark", "Nim", "Celci", "Tera", "Exa", "Mega", "Kilo", "Penta", "Hexa"};
    public static final String[] guardianNameLast = {"nos", "bus", "bis", "nor", "lus", "gos", "cos", "cus", ""};
    public static final String[] aechorNameFirst = {"Blighted Cabbage", "Xae", "Hyla", "Scae", "Yuxa", "Spra", "Aelia", "Guna", "Fau", "Pina"};
    public static final String[] aechorNameMiddle = {"be", "na", "li", "du", "gu", "ya", "co", ""};
    public static final String[] aechorNameLast = {"rata", "tia", "ria", "cia", "na", "lana", "syia", "dula", "sara", "lada"};

    public static MutableComponent generateAncientGuardianName(RandomSource random) {
        String result = "";
        int index = random.nextInt(guardianNameFirst.length);
        result += guardianNameFirst[index];
        if (index != 0) {
            result += guardianNameLast[random.nextInt(guardianNameLast.length)];
        }
        result += ", ";
        return Component.literal(result).append(Component.translatable("gui.ancient_aether.ancient_guardian.title"));
    }

    public static MutableComponent generateMutatedAechorName(RandomSource random) {
        String result = "";
        int index = random.nextInt(aechorNameFirst.length);
        result += aechorNameFirst[index];
        if (index != 0) {
            result += aechorNameMiddle[random.nextInt(aechorNameMiddle.length)];
            result += aechorNameLast[random.nextInt(aechorNameLast.length)];
        }
        result += ", ";
        return Component.literal(result).append(Component.translatable("gui.ancient_aether.mutated_aechor_plant.title"));
    }
}