package net.builderdog.ancient_aether.event.hooks;

import com.aetherteam.cumulus.api.MenuHelper;
import net.builderdog.ancient_aether.client.gui.AncientMenus;

public class MenuHooks {
    public static void prepareCustomMenus(MenuHelper menuHelper) {
        menuHelper.prepareMenu(AncientMenus.ANCIENT_AETHER.get());
    }
}