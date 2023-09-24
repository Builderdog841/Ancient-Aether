package net.builderdog.ancient_aether.gui.menu;

import com.aetherteam.aether.Aether;
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
    private static final ResourceLocation THE_AETHER_ICON = new ResourceLocation(Aether.MODID, "textures/gui/menu_api/menu_icon_aether.png");

    // Names
    private static final Component ANCIENT_AETHER_NAME = Component.translatable("ancient_aether.menu_title.ancient_aether");

    // Backgrounds
    private static final ResourceLocation ANCIENT_AETHER_REGULAR_BACKGROUND = new ResourceLocation(Aether.MODID, "textures/gui/title/options_background.png");
    private static final ResourceLocation ANCIENT_AETHER_DARK_BACKGROUND = new ResourceLocation(Aether.MODID, "textures/gui/title/light_sentry_background.png");
    private static final ResourceLocation ANCIENT_AETHER_HEADER_SEPARATOR = new ResourceLocation(Aether.MODID, "textures/gui/title/header_separator.png");
    private static final ResourceLocation ANCIENT_AETHER_FOOTER_SEPARATOR = new ResourceLocation(Aether.MODID, "textures/gui/title/footer_separator.png");
    private static final ResourceLocation ANCIENT_AETHER_TAB_BUTTON = new ResourceLocation(Aether.MODID, "textures/gui/title/tab_button.png");
    private static final Menu.Background ANCIENT_AETHER_BACKGROUND = new Menu.Background()

            .regularBackground(ANCIENT_AETHER_REGULAR_BACKGROUND)
            .darkBackground(ANCIENT_AETHER_DARK_BACKGROUND)
            .headerSeparator(ANCIENT_AETHER_HEADER_SEPARATOR)
            .footerSeparator(ANCIENT_AETHER_FOOTER_SEPARATOR)
            .tabButton(ANCIENT_AETHER_TAB_BUTTON);

    // Behavior
    private static final BooleanSupplier ANCIENT_AETHER_CONDITION = () -> CumulusConfig.CLIENT.active_menu.get().equals("ancient_aether:ancient_aether_menu");

    // Menus
    //public static final RegistryObject<Menu> ANCIENT_AETHER = MENUS.register("ancient_aether_menu", () -> new Menu(THE_AETHER_ICON, ANCIENT_AETHER_NAME, new AetherTitleScreen(true), ANCIENT_AETHER_CONDITION, new Menu.Properties().music(AetherTitleScreen.MENU).background(ANCIENT_AETHER_BACKGROUND)));
}
