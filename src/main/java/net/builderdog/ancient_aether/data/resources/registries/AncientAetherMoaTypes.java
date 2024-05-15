package net.builderdog.ancient_aether.data.resources.registries;

import com.aetherteam.aether.Aether;
import com.aetherteam.aether.api.registers.MoaType;
import com.aetherteam.aether.data.resources.registries.AetherMoaTypes;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.item.AncientAetherItems;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class AncientAetherMoaTypes {
    public static final ResourceKey<Registry<MoaType>> MOA_TYPE_REGISTRY_KEY = ResourceKey.createRegistryKey(new ResourceLocation(AncientAether.MODID, "moa_type"));

    public static final ResourceKey<MoaType> TURQUOISE = createKey("turquoise");
    public static final ResourceKey<MoaType> TEAL = createKey("teal");
    public static final ResourceKey<MoaType> SKY_BLUE = createKey("sky_blue");
    public static final ResourceKey<MoaType> LAVENDER = createKey("lavender");
    public static final ResourceKey<MoaType> SAKURA = createKey("sakura");
    public static final ResourceKey<MoaType> VIOLET = createKey("violet");
    public static final ResourceKey<MoaType> BURGUNDY = createKey("burgundy");

    private static ResourceKey<MoaType> createKey(String name) {
        return ResourceKey.create(AetherMoaTypes.MOA_TYPE_REGISTRY_KEY, new ResourceLocation(AncientAether.MODID, name));
    }

    public static void bootstrap(BootstapContext<MoaType> context) {
        context.register(TURQUOISE, new MoaType(new ItemStack(AncientAetherItems.TURQUOISE_MOA_EGG.get()), 7, 0.155F, 40, new ResourceLocation(AncientAether.MODID, "textures/entity/mobs/moa/turquoise_moa.png"), new ResourceLocation(Aether.MODID, "textures/entity/mobs/moa/moa_saddle.png")));
        context.register(TEAL, new MoaType(new ItemStack(AncientAetherItems.TEAL_MOA_EGG.get()), 6, 0.175F, 20, new ResourceLocation(AncientAether.MODID, "textures/entity/mobs/moa/teal_moa.png"), new ResourceLocation(Aether.MODID, "textures/entity/mobs/moa/moa_saddle.png")));
        context.register(SKY_BLUE, new MoaType(new ItemStack(AncientAetherItems.SKY_BLUE_MOA_EGG.get()), 5, 0.175F, 40, new ResourceLocation(AncientAether.MODID, "textures/entity/mobs/moa/sky_blue_moa.png"), new ResourceLocation(Aether.MODID, "textures/entity/mobs/moa/moa_saddle.png")));
        context.register(LAVENDER, new MoaType(new ItemStack(AncientAetherItems.LAVENDER_MOA_EGG.get()), 3, 0.2F, 20, new ResourceLocation(AncientAether.MODID, "textures/entity/mobs/moa/lavender_moa.png"), new ResourceLocation(Aether.MODID, "textures/entity/mobs/moa/moa_saddle.png")));
        context.register(SAKURA, new MoaType(new ItemStack(AncientAetherItems.SAKURA_MOA_EGG.get()), 12, 0.135F, 5, new ResourceLocation(AncientAether.MODID, "textures/entity/mobs/moa/sakura_moa.png"), new ResourceLocation(Aether.MODID, "textures/entity/mobs/moa/moa_saddle.png")));
        context.register(VIOLET, new MoaType(new ItemStack(AncientAetherItems.VIOLET_MOA_EGG.get()), 4, 0.2F, 10, new ResourceLocation(AncientAether.MODID, "textures/entity/mobs/moa/violet_moa.png"), new ResourceLocation(Aether.MODID, "textures/entity/mobs/moa/moa_saddle.png")));
        context.register(BURGUNDY, new MoaType(new ItemStack(AncientAetherItems.BURGUNDY_MOA_EGG.get()), 10, 0.155F, 30, new ResourceLocation(AncientAether.MODID, "textures/entity/mobs/moa/burgundy_moa.png"), new ResourceLocation(Aether.MODID, "textures/entity/mobs/moa/moa_saddle.png")));
    }
}