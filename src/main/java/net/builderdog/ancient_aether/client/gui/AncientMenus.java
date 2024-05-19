package net.builderdog.ancient_aether.client.gui;

import com.aetherteam.cumulus.Cumulus;
import com.aetherteam.cumulus.CumulusConfig;
import com.aetherteam.cumulus.api.Menu;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.client.gui.screen.AncientAetherTitleScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

public class AncientMenus {
    public static final DeferredRegister<Menu> MENUS = DeferredRegister.create(Cumulus.MENU_REGISTRY_KEY, AncientAether.MODID);

    private static final ResourceLocation ANCIENT_AETHER_ICON = new ResourceLocation(AncientAether.MODID, "textures/gui/menu_api/menu_icon_ancient_aether.png");
    private static final Component ANCIENT_AETHER_NAME = Component.translatable("ancient_aether.menu_title.ancient_aether");

    private static final ResourceLocation ANCIENT_AETHER_REGULAR_BACKGROUND = new ResourceLocation(AncientAether.MODID, "textures/gui/title/options_background.png");
    private static final ResourceLocation ANCIENT_AETHER_DARK_BACKGROUND = new ResourceLocation(AncientAether.MODID, "textures/gui/title/dark_options_background.png");
    private static final ResourceLocation ANCIENT_AETHER_HEADER_SEPARATOR = new ResourceLocation(AncientAether.MODID, "textures/sprites/gui/title/header_separator.png");
    private static final ResourceLocation ANCIENT_AETHER_FOOTER_SEPARATOR = new ResourceLocation(AncientAether.MODID, "textures/sprites/gui/title/footer_separator.png");
    private static final WidgetSprites  ANCIENT_AETHER_TAB_BUTTON = new WidgetSprites(
            new ResourceLocation(AncientAether.MODID, "title/tab_selected"),
            new ResourceLocation(AncientAether.MODID, "title/tab"),
            new ResourceLocation(AncientAether.MODID, "title/tab_selected_highlighted"),
            new ResourceLocation(AncientAether.MODID, "title/tab_highlighted"));
    private static final Menu.Background ANCIENT_AETHER_BACKGROUND = new Menu.Background()
            .regularBackground(ANCIENT_AETHER_REGULAR_BACKGROUND)
            .darkBackground(ANCIENT_AETHER_DARK_BACKGROUND)
            .headerSeparator(ANCIENT_AETHER_HEADER_SEPARATOR)
            .footerSeparator(ANCIENT_AETHER_FOOTER_SEPARATOR)
            .tabButton(ANCIENT_AETHER_TAB_BUTTON);

    private static final BooleanSupplier ANCIENT_AETHER_CONDITION = () -> CumulusConfig.CLIENT.active_menu.get().equals("ancient_aether:ancient_aether");

    public static final Supplier<Menu> ANCIENT_AETHER = MENUS.register("ancient_aether", () -> new Menu(ANCIENT_AETHER_ICON, ANCIENT_AETHER_NAME, new AncientAetherTitleScreen(true), ANCIENT_AETHER_CONDITION, new Menu.Properties().music(AncientAetherTitleScreen.MENU).background(ANCIENT_AETHER_BACKGROUND)));
}