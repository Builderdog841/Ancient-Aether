package net.builderdog.ancient_aether.gui.menu;

import com.aetherteam.aether.AetherConfig;
import com.aetherteam.aether.client.WorldDisplayHelper;
import com.aetherteam.aether.client.gui.screen.menu.AetherTitleScreen;
import com.aetherteam.cumulus.Cumulus;
import com.aetherteam.cumulus.CumulusConfig;
import com.aetherteam.cumulus.api.Menu;
import net.builderdog.ancient_aether.AncientAether;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.BooleanSupplier;

public class AncientAetherMenus {
    public static final DeferredRegister<Menu> MENUS = DeferredRegister.create(Cumulus.MENU_REGISTRY_KEY, AncientAether.MOD_ID);

    // Icons
    private static final ResourceLocation THE_AETHER_ICON = new ResourceLocation(AncientAether.MOD_ID, "textures/gui/menu_api/menu_icon_aether.png");

    // Names
    private static final Component MINECRAFT_LEFT_NAME = Component.translatable("aether.menu_title.minecraft_left");
    private static final Component THE_AETHER_NAME = Component.translatable("aether.menu_title.the_aether");
    private static final Component THE_AETHER_LEFT_NAME = Component.translatable("aether.menu_title.the_aether_left");

    // Backgrounds
    private static final ResourceLocation THE_AETHER_REGULAR_BACKGROUND = new ResourceLocation(AncientAether.MOD_ID, "textures/gui/title/options_background.png");
    private static final ResourceLocation THE_AETHER_DARK_BACKGROUND = new ResourceLocation(AncientAether.MOD_ID, "textures/gui/title/light_sentry_background.png");
    private static final ResourceLocation THE_AETHER_HEADER_SEPARATOR = new ResourceLocation(AncientAether.MOD_ID, "textures/gui/title/header_separator.png");
    private static final ResourceLocation THE_AETHER_FOOTER_SEPARATOR = new ResourceLocation(AncientAether.MOD_ID, "textures/gui/title/footer_separator.png");
    private static final ResourceLocation THE_AETHER_TAB_BUTTON = new ResourceLocation(AncientAether.MOD_ID, "textures/gui/title/tab_button.png");
    private static final Menu.Background THE_AETHER_BACKGROUND = new Menu.Background()
            .regularBackground(THE_AETHER_REGULAR_BACKGROUND)
            .darkBackground(THE_AETHER_DARK_BACKGROUND)
            .headerSeparator(THE_AETHER_HEADER_SEPARATOR)
            .footerSeparator(THE_AETHER_FOOTER_SEPARATOR)
            .tabButton(THE_AETHER_TAB_BUTTON);

    // Behavior
    private static final BooleanSupplier THE_AETHER_LEFT_CONDITION = () -> CumulusConfig.CLIENT.active_menu.get().equals("aether:the_aether_left") || (CumulusConfig.CLIENT.active_menu.get().equals("aether:the_aether") && AetherConfig.CLIENT.menu_type_toggles_alignment.get() && WorldDisplayHelper.isActive());

    // Menus
    public static final RegistryObject<Menu> THE_AETHER_LEFT = MENUS.register("the_aether_left", () -> new Menu(THE_AETHER_ICON, THE_AETHER_LEFT_NAME, new AetherTitleScreen(true), THE_AETHER_LEFT_CONDITION, new Menu.Properties().music(AetherTitleScreen.MENU).background(THE_AETHER_BACKGROUND)));
}