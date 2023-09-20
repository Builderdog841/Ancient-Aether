package net.builderdog.ancient_aether.gui.screen.menu;

import java.util.Objects;
import javax.annotation.Nullable;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.gui.TitleScreenModUpdateIndicator;
import net.minecraftforge.client.loading.ClientModLoader;
import net.minecraftforge.common.ForgeI18n;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.VersionChecker;
import net.minecraftforge.fml.loading.FMLConfig;
import net.minecraftforge.fml.loading.FMLConfig.ConfigValue;

public class AncientAetherModUpdateIndicator extends TitleScreenModUpdateIndicator {
    private static final ResourceLocation VERSION_CHECK_ICONS = new ResourceLocation("forge", "textures/gui/version_check_icons.png");
    private final AncientAetherTitleScreen screen;
    @Nullable
    private VersionChecker.Status showNotification = null;
    private boolean hasCheckedForUpdates = false;

    public AncientAetherModUpdateIndicator(AncientAetherTitleScreen screen) {
        super(null);
        this.screen = screen;
    }

    public void init() {
        if (!this.hasCheckedForUpdates) {
            this.showNotification = ClientModLoader.checkForUpdates();
            this.hasCheckedForUpdates = true;
        }

    }

    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
        if (this.showNotification != null && this.showNotification.shouldDraw() && !FMLConfig.getBoolConfigValue(ConfigValue.VERSION_CHECK) && Minecraft.getInstance().screen != null) {
            this.width = Minecraft.getInstance().screen.width;
            this.height = Minecraft.getInstance().screen.height;
            this.font = Minecraft.getInstance().font;
            int modCount = ModList.get().size();
            String modText = ForgeI18n.parseMessage("fml.menu.loadingmods", new Object[]{modCount});
            int x = this.width - this.font.width(modText) - 11;
            int var10000 = this.height;
            Objects.requireNonNull(this.font);
            int y = var10000 - 9 - 11;
            if (!this.screen.isAlignedLeft()) {
                x = this.font.width(modText) + 4;
                var10000 = this.height;
                Objects.requireNonNull(this.font);
                y = var10000 - 9 - 1;
            }

            graphics.blit(VERSION_CHECK_ICONS, x, y, (float)(this.showNotification.getSheetOffset() * 8), this.showNotification.isAnimated() && (System.currentTimeMillis() / 800L & 1L) == 1L ? 8.0F : 0.0F, 8, 8, 64, 16);
        }

    }
}
