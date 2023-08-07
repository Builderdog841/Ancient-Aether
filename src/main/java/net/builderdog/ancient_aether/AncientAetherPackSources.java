package net.builderdog.ancient_aether;

import java.util.function.UnaryOperator;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.repository.PackSource;

public class AncientAetherPackSources {
    public static final PackSource OPTIONAL_DATAPACK = PackSource.create(decorateWithSource("pack.source.optional_datapack"), false);
    public static final PackSource AUTO_APPLY_RESOURCE = PackSource.create(decorateWithSource("pack.source.auto_apply_resource"), true);

    public AncientAetherPackSources() {
    }

    public static UnaryOperator<Component> decorateWithSource(String pTranslationKey) {
        Component component = Component.translatable(pTranslationKey);
        return (p_10539_) -> {
            return Component.translatable("pack.nameAndSource", new Object[]{p_10539_, component}).withStyle(ChatFormatting.GRAY);
        };
    }
}
