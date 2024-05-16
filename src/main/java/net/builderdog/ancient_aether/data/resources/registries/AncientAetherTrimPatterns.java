package net.builderdog.ancient_aether.data.resources.registries;

import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.item.AncientAetherItems;
import net.minecraft.Util;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimPattern;
import net.minecraft.world.item.armortrim.TrimPatterns;

public class AncientAetherTrimPatterns extends TrimPatterns {
    public static final ResourceKey<TrimPattern> WYND = createKey("wynd");
    public static final ResourceKey<TrimPattern> WHALE = createKey("whale");
    public static final ResourceKey<TrimPattern> ASCENDED = createKey("ascended");
    public static final ResourceKey<TrimPattern> MYSTERIOUS = createKey("mysterious");
    public static final ResourceKey<TrimPattern> MECHANICAL = createKey("mechanical");
    public static final ResourceKey<TrimPattern> MOSAIC = createKey("mosaic");
    public static final ResourceKey<TrimPattern> ROYAL = createKey("royal");
    public static final ResourceKey<TrimPattern> SOLAR = createKey("solar");
    public static final ResourceKey<TrimPattern> ANCIENT = createKey("ancient");

    private static ResourceKey<TrimPattern> createKey(String name) {
        return ResourceKey.create(Registries.TRIM_PATTERN, new ResourceLocation(AncientAether.MODID, name));
    }

    public static void bootstrap(BootstapContext<TrimPattern> context) {
        register(context, AncientAetherItems.WYND_ARMOR_TRIM_SMITHING_TEMPLATE.get(), WYND);
        register(context, AncientAetherItems.WHALE_ARMOR_TRIM_SMITHING_TEMPLATE.get(), WHALE);
        register(context, AncientAetherItems.ASCENDED_ARMOR_TRIM_SMITHING_TEMPLATE.get(), ASCENDED);
        register(context, AncientAetherItems.MYSTERIOUS_ARMOR_TRIM_SMITHING_TEMPLATE.get(), MYSTERIOUS);
        register(context, AncientAetherItems.MECHANICAL_ARMOR_TRIM_SMITHING_TEMPLATE.get(), MECHANICAL);
        register(context, AncientAetherItems.MOSAIC_ARMOR_TRIM_SMITHING_TEMPLATE.get(), MOSAIC);
        register(context, AncientAetherItems.ROYAL_ARMOR_TRIM_SMITHING_TEMPLATE.get(), ROYAL);
        register(context, AncientAetherItems.SOLAR_ARMOR_TRIM_SMITHING_TEMPLATE.get(), SOLAR);
        register(context, AncientAetherItems.ANCIENT_ARMOR_TRIM_SMITHING_TEMPLATE.get(), ANCIENT);
    }

    private static void register(BootstapContext<TrimPattern> context, Item item, ResourceKey<TrimPattern> patternKey) {
        TrimPattern trimpattern = new TrimPattern(patternKey.location(), BuiltInRegistries.ITEM.wrapAsHolder(item), Component.translatable(Util.makeDescriptionId("trim_pattern", patternKey.location())), false);
        context.register(patternKey, trimpattern);
    }
}