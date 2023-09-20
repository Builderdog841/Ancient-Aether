package net.builderdog.ancient_aether.gui.screen.menu;

import com.aetherteam.cumulus.CumulusConfig;
import net.builderdog.ancient_aether.api.AncientAetherMenus;

public class AncientAetherMenuUtil {
    public AncientAetherMenuUtil() {
    }

    public static boolean isAncientAetherMenu() {
        return (CumulusConfig.CLIENT.active_menu.get()).equals((AncientAetherMenus.ANCIENT_AETHER.get()).toString()) || (CumulusConfig.CLIENT.active_menu.get()).equals((AncientAetherMenus.ANCIENT_AETHER.get()).toString());
    }
}
