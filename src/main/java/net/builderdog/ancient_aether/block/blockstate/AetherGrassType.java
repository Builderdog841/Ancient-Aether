package net.builderdog.ancient_aether.block.blockstate;

import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;

public enum AetherGrassType implements StringRepresentable {
    NORMAL("normal"),
    FROZEN("frozen"),
    PALE("pale");

    private final String name;

    AetherGrassType(String string) {
        name = string;
    }

    public String toString() {
        return getSerializedName();
    }

    public @NotNull String getSerializedName() {
        return name;
    }
}