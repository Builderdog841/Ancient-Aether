package net.builderdog.ancient_aether.item.trims;

import java.util.List;

import com.legacy.lost_aether.LostContentMod;
import com.legacy.structure_gel.api.events.RegisterArmorTrimTexturesEvent;
import com.legacy.structure_gel.api.registry.registrar.RegistrarHandler;

import net.builderdog.ancient_aether.item.AncientAetherItems;
import net.minecraft.Util;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimPattern;

public class AncientAetherArmorTrims
{
    public static final RegistrarHandler<TrimPattern> PATTERN_HANDLER = RegistrarHandler.getOrCreate(Registries.TRIM_PATTERN, LostContentMod.MODID).bootstrap(AncientAetherArmorTrims.Patterns::trimBootstrap);

    public interface Patterns
    {
        ResourceKey<TrimPattern> ROYAL = PATTERN_HANDLER.key("royal");

        private static void trimBootstrap(BootstapContext<TrimPattern> context)
        {
            register(context, ROYAL, AncientAetherItems.ROYAL_ARMOR_TRIM_SMITHING_TEMPLATE.get());
        }

        static List<ResourceKey<TrimPattern>> patterns()
        {
            return List.of(ROYAL);
        }

        private static void register(BootstapContext<TrimPattern> context, ResourceKey<TrimPattern> key, Item templateItem)
        {
            TrimPattern trimpattern = new TrimPattern(key.location(), BuiltInRegistries.ITEM.wrapAsHolder(templateItem), Component.translatable(Util.makeDescriptionId("trim_pattern", key.location())));
            context.register(key, trimpattern);
        }
    }

    public static void registerSpriteData(RegisterArmorTrimTexturesEvent event)
    {
        AncientAetherArmorTrims.Patterns.patterns().forEach(pattern -> event.registerPatternSprite(pattern));
    }
}

