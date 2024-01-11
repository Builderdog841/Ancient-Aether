package net.builderdog.ancient_aether.block.blockstate;

import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;

public enum AetherTallGrassLength implements StringRepresentable {
    VERY_SHORT("very_short"),
    SHORT("short"),
    MEDIUM("medium"),
    TALL("tall"),
    VERY_TALL("very_tall");

    private final String name;

    AetherTallGrassLength(String string) {
        name = string;
    }

    public String toString() {
        return getSerializedName();
    }

    public @NotNull String getSerializedName() {
        return name;
    }
}