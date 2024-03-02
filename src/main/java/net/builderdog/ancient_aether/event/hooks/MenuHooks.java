package net.builderdog.ancient_aether.event.hooks;

import com.aetherteam.cumulus.api.MenuHelper;
import net.builderdog.ancient_aether.client.gui.AncientAetherMenus;

public class MenuHooks {
    public static void prepareCustomMenus(MenuHelper menuHelper) {
        menuHelper.prepareMenu(AncientAetherMenus.ANCIENT_AETHER.get());
    }
}