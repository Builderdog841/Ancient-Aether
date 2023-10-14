package net.builderdog.ancient_aether;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.repository.PackSource;

import java.util.function.UnaryOperator;

public class AncientAetherPackSources {
    public static final PackSource AUTO_APPLY_RESOURCE = PackSource.create(decorateWithSource("pack.source.auto_apply_resource"), true);

    public AncientAetherPackSources() {
    }

    public static UnaryOperator<Component> decorateWithSource(String pTranslationKey) {
        Component component = Component.translatable(pTranslationKey);
        return (p_10539_) -> {
            return Component.translatable("pack.nameAndSource", p_10539_, component).withStyle(ChatFormatting.GRAY);
        };
    }
}
