package net.builderdog.ancient_aether.entity.monster.boss;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.util.RandomSource;

public final class AncientBossNameGenerator {
    public static final String[] aechorNameFirst = {"Blighted Cabbage", "Xae", "Hyla", "Scae", "Yuxa", "Spra", "Aelia", "Guna", "Fau", "Pina"};
    public static final String[] aechorNameMiddle = {"be", "na", "li", "du", "gu", "ya", "co", ""};
    public static final String[] aechorNameLast = {"rata", "tia", "ria", "cia", "na", "lana", "syia", "dula", "sara", "lada"};

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