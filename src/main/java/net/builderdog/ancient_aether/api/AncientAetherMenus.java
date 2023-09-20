package net.builderdog.ancient_aether.api;

import com.aetherteam.cumulus.Cumulus;
import com.aetherteam.cumulus.CumulusConfig;
import com.aetherteam.cumulus.api.Menu;
import java.util.function.BooleanSupplier;
import net.builderdog.ancient_aether.gui.screen.menu.AncientAetherTitleScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class AncientAetherMenus {
    public static final DeferredRegister<Menu> MENUS;
    private static final ResourceLocation THE_AETHER_ICON;
    private static final Component ANCIENT_AETHER_NAME;
    private static final ResourceLocation THE_AETHER_REGULAR_BACKGROUND;
    private static final ResourceLocation THE_AETHER_DARK_BACKGROUND;
    private static final ResourceLocation THE_AETHER_HEADER_SEPARATOR;
    private static final ResourceLocation THE_AETHER_FOOTER_SEPARATOR;
    private static final ResourceLocation THE_AETHER_TAB_BUTTON;
    private static final Menu.Background THE_AETHER_BACKGROUND;
    private static final BooleanSupplier ANCIENT_AETHER_CONDITION;
    public static final RegistryObject<Menu> ANCIENT_AETHER;

    public AncientAetherMenus() {
    }

    static {
        MENUS = DeferredRegister.create(Cumulus.MENU_REGISTRY_KEY, "ancient_aether");
        THE_AETHER_ICON = new ResourceLocation("ancient_aether", "textures/gui/menu_api/menu_icon_aether.png");
        ANCIENT_AETHER_NAME = Component.translatable("ancient_aether.menu_title.ancient_aether");
        THE_AETHER_REGULAR_BACKGROUND = new ResourceLocation("ancient_aether", "textures/gui/title/options_background.png");
        THE_AETHER_DARK_BACKGROUND = new ResourceLocation("ancient_aether", "textures/gui/title/light_sentry_background.png");
        THE_AETHER_HEADER_SEPARATOR = new ResourceLocation("ancient_aether", "textures/gui/title/header_separator.png");
        THE_AETHER_FOOTER_SEPARATOR = new ResourceLocation("ancient_aether", "textures/gui/title/footer_separator.png");
        THE_AETHER_TAB_BUTTON = new ResourceLocation("ancient_aether", "textures/gui/title/tab_button.png");
        THE_AETHER_BACKGROUND = (new Menu.Background()).regularBackground(THE_AETHER_REGULAR_BACKGROUND).darkBackground(THE_AETHER_DARK_BACKGROUND).headerSeparator(THE_AETHER_HEADER_SEPARATOR).footerSeparator(THE_AETHER_FOOTER_SEPARATOR).tabButton(THE_AETHER_TAB_BUTTON);

        ANCIENT_AETHER_CONDITION = () -> {
            return (CumulusConfig.CLIENT.active_menu.get()).equals("ancient_aether:ancient_aether_menu");
        };

        ANCIENT_AETHER = MENUS.register("ancient_aether_menu", () -> {
            return new Menu(THE_AETHER_ICON, ANCIENT_AETHER_NAME, new AncientAetherTitleScreen(true), ANCIENT_AETHER_CONDITION, (new Menu.Properties()).music(AncientAetherTitleScreen.MENU).background(THE_AETHER_BACKGROUND));
        });
    }
}
