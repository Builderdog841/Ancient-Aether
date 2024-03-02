package net.builderdog.ancient_aether.client.gui.screen;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.gui.TitleScreenModUpdateIndicator;
import net.minecraftforge.client.loading.ClientModLoader;
import net.minecraftforge.common.ForgeI18n;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.VersionChecker;
import net.minecraftforge.fml.loading.FMLConfig;
import net.minecraftforge.versions.forge.ForgeVersion;

import javax.annotation.Nullable;

public class AncientAetherModUpdateIndicator extends TitleScreenModUpdateIndicator {
    private static final ResourceLocation VERSION_CHECK_ICONS = new ResourceLocation(ForgeVersion.MOD_ID, "textures/gui/version_check_icons.png");
    private final AncientAetherTitleScreen screen;
    @Nullable
    private VersionChecker.Status showNotification = null;
    private boolean hasCheckedForUpdates = false;

    public AncientAetherModUpdateIndicator(AncientAetherTitleScreen screen) {
        super(null);
        this.screen = screen;
    }

    @Override
    public void init() {
        if (!hasCheckedForUpdates) {
            showNotification = ClientModLoader.checkForUpdates();
            hasCheckedForUpdates = true;
        }
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
        if (showNotification != null && showNotification.shouldDraw() && !FMLConfig.getBoolConfigValue(FMLConfig.ConfigValue.VERSION_CHECK) && Minecraft.getInstance().screen != null) {
            width = Minecraft.getInstance().screen.width;
            height = Minecraft.getInstance().screen.height;
            font = Minecraft.getInstance().font;
            int modCount = ModList.get().size();
            String modText = ForgeI18n.parseMessage("fml.menu.loadingmods", modCount);

            int x = width - font.width(modText) - 11;
            int y = height - font.lineHeight - 11;

            if (!screen.isAlignedLeft()) {
                x = font.width(modText) + 4;
                y = height - font.lineHeight - 1;
            }
            graphics.blit(VERSION_CHECK_ICONS, x, y, showNotification.getSheetOffset() * 8, (showNotification.isAnimated() && ((System.currentTimeMillis() / 800 & 1) == 1)) ? 8 : 0, 8, 8, 64, 16);
        }
    }
}