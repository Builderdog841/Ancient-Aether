package net.builderdog.ancient_aether.gui.screen.menu;

import com.aetherteam.aether.client.AetherSoundEvents;
import com.aetherteam.aether.client.gui.component.menu.AetherMenuButton;
import com.aetherteam.aether.client.gui.component.menu.DynamicMenuButton;
import com.aetherteam.aether.client.gui.screen.menu.AetherTitleScreen;
import com.aetherteam.aether.client.gui.screen.menu.TitleScreenBehavior;
import com.aetherteam.aether.mixin.mixins.client.accessor.TitleScreenAccessor;
import com.aetherteam.cumulus.mixin.mixins.client.accessor.SplashRendererAccessor;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import java.util.Objects;
import net.builderdog.ancient_aether.api.AncientAetherMenus;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.Renderable;
import net.minecraft.client.renderer.CubeMap;
import net.minecraft.client.renderer.PanoramaRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.Music;
import net.minecraft.util.Mth;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.internal.BrandingControl;
import org.jetbrains.annotations.Nullable;

public class AncientAetherTitleScreen extends AetherTitleScreen {
    private static final ResourceLocation PANORAMA_OVERLAY = new ResourceLocation("textures/gui/title/background/panorama_overlay.png");
    private static final ResourceLocation AETHER_LOGO = new ResourceLocation("aether", "textures/gui/title/aether.png");
    public static final Music MENU;
    private final PanoramaRenderer panorama;
    private AncientAetherModUpdateIndicator modUpdateNotification;
    private boolean alignedLeft;
    private int rows;

    public AncientAetherTitleScreen() {
        this.panorama = new PanoramaRenderer(new CubeMap(new ResourceLocation("aether", "textures/gui/title/panorama/panorama")));
        ((TitleScreenAccessor)this).aether$setFading(true);
    }

    public AncientAetherTitleScreen(boolean alignedLeft) {
        this();
        this.alignedLeft = alignedLeft;
    }

    protected void init() {
        super.init();
        this.setupButtons();
        this.modUpdateNotification = new AncientAetherModUpdateIndicator(this);
        this.modUpdateNotification.init();
    }

    public void setupButtons() {
        int buttonRows = 0;
        int lastY = 0;

        for (Renderable renderable : this.renderables) {
            if (renderable instanceof AbstractWidget abstractWidget) {
                if (TitleScreenBehavior.isImageButton(abstractWidget.getMessage())) {
                    abstractWidget.visible = false;
                }

                if (abstractWidget instanceof AetherMenuButton aetherMenuButton) {
                    if (this.isAlignedLeft()) {
                        ++buttonRows;
                    } else if (lastY < aetherMenuButton.originalY) {
                        lastY = aetherMenuButton.originalY;
                        ++buttonRows;
                    }

                    aetherMenuButton.buttonCountOffset = buttonRows;
                }
            }
        }

        this.rows = this.alignedLeft ? buttonRows : buttonRows - 1;
    }

    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        TitleScreenAccessor titleScreenAccessor = (TitleScreenAccessor)this;
        if (this.minecraft != null && titleScreenAccessor.aether$getSplash() == null) {
            titleScreenAccessor.aether$setSplash(this.minecraft.getSplashManager().getSplash());
        }

        float fadeAmount = super.handleFading(guiGraphics, this, titleScreenAccessor, this.panorama, PANORAMA_OVERLAY, partialTicks);
        float scale = getScale(this, this.getMinecraft());
        this.setupLogo(guiGraphics, fadeAmount, scale);
        int roundedFadeAmount = Mth.ceil(fadeAmount * 255.0F) << 24;
        if ((roundedFadeAmount & -67108864) != 0) {
            ForgeHooksClient.renderMainMenu(this, guiGraphics, this.font, this.width, this.height, roundedFadeAmount);
            if (titleScreenAccessor.aether$getSplash() != null) {
                SplashRendererAccessor splashRendererAccessor = (SplashRendererAccessor)titleScreenAccessor.aether$getSplash();
                if (splashRendererAccessor.cumulus$getSplash() != null && !splashRendererAccessor.cumulus$getSplash().isEmpty()) {
                    PoseStack poseStack = guiGraphics.pose();
                    float splashX = this.alignedLeft ? 400.0F / scale : (float)this.width / 2.0F + 175.0F / scale;
                    float splashY = this.alignedLeft ? 100.0F / scale : (float)((int)(20.0F + 76.0F / scale));
                    poseStack.pushPose();
                    poseStack.translate(splashX, splashY, 0.0F);
                    poseStack.mulPose(Axis.ZP.rotationDegrees(-20.0F));
                    float textSize = 1.8F - Mth.abs(Mth.sin((float)(Util.getMillis() % 1000L) / 1000.0F * 6.2831855F) * 0.1F);
                    textSize = textSize * (200.0F / scale) / ((float)this.font.width(splashRendererAccessor.cumulus$getSplash()) + 64.0F / scale);
                    poseStack.scale(textSize, textSize, textSize);
                    guiGraphics.drawCenteredString(this.font, splashRendererAccessor.cumulus$getSplash(), 0, (int)(-16.0F / scale), 16776960 | roundedFadeAmount);
                    poseStack.popPose();
                }
            }

            if (this.alignedLeft) {
                super.renderRightBranding(guiGraphics, this, this.font, roundedFadeAmount);
            } else {
                BrandingControl.forEachLine(true, true, (brandingLine, branding) -> {
                    Font var10001 = this.font;
                    int var10004 = this.height;
                    int var10006 = brandingLine;
                    Objects.requireNonNull(this.font);
                    guiGraphics.drawString(var10001, branding, 2, var10004 - (10 + var10006 * (9 + 1)), 16777215 | roundedFadeAmount);
                });
                BrandingControl.forEachAboveCopyrightLine((brandingLine, branding) -> {
                    Font var10001 = this.font;
                    int var10003 = this.width - this.font.width(branding);
                    int var10004 = this.height;
                    int var10006 = brandingLine + 1;
                    Objects.requireNonNull(this.font);
                    guiGraphics.drawString(var10001, branding, var10003, var10004 - (10 + var10006 * (9 + 1)), 16777215 | roundedFadeAmount);
                });
            }
        }

        int xOffset = super.handleButtonVisibility(this, fadeAmount);

        for (Renderable renderable : this.renderables) {
            renderable.render(guiGraphics, mouseX, mouseY, partialTicks);
            if (renderable instanceof AetherMenuButton aetherButton) {
                if (aetherButton.isMouseOver( mouseX, mouseY)) {
                    if (aetherButton.hoverOffset < 15) {
                        aetherButton.hoverOffset += 4;
                    }
                } else if (aetherButton.hoverOffset > 0) {
                    aetherButton.hoverOffset -= 4;
                }
            }

            if (renderable instanceof DynamicMenuButton dynamicMenuButton) {
                if (dynamicMenuButton.enabled) {
                    xOffset -= 24;
                }
            }
        }

        super.handleImageButtons(this, xOffset);
        if (fadeAmount >= 1.0F) {
            this.modUpdateNotification.render(guiGraphics, mouseX, mouseY, partialTicks);
        }

    }

    private void setupLogo(GuiGraphics guiGraphics, float transparency, float scale) {
        int width = (int)(350.0F / scale);
        int height = (int)(76.0F / scale);
        int logoX = this.alignedLeft ? (int)(10.0F + 18.0F / scale) : (int)((float)(this.width / 2) - 200.0F / scale);
        int logoY = this.alignedLeft ? (int)(15.0F + 10.0F / scale) : (int)(25.0F + 10.0F / scale);
        guiGraphics.setColor(1.0F, 1.0F, 1.0F, transparency);
        guiGraphics.blit(AETHER_LOGO, logoX, logoY, 0.0F, 0.0F, width, height, width, height);
    }

    public static float getScale(AncientAetherTitleScreen screen, Minecraft minecraft) {
        int guiScale = minecraft.getWindow().calculateScale(minecraft.options.guiScale().get(), minecraft.isEnforceUnicode());
        return calculateScale(screen, (float)guiScale, (float)(guiScale - 1));
    }

    public static float calculateScale(AncientAetherTitleScreen screen, float guiScale, float lowerScale) {
        float scale = 1.0F;
        if (guiScale > 1.0F) {
            scale = guiScale / lowerScale;
        }

        int range = AetherMenuButton.totalHeightRange(screen.rows, scale);
        return range > screen.height && scale != 1.0F ? calculateScale(screen, guiScale, lowerScale - 1.0F) : scale;
    }


    public boolean isAlignedLeft() {
        return this.alignedLeft;
    }

    public @Nullable Music getBackgroundMusic() {
        return (AncientAetherMenus.ANCIENT_AETHER.get()).getMusic();
    }

    static {
        MENU = new Music(AetherSoundEvents.MUSIC_MENU.getHolder().orElseThrow(), 20, 600, true);
    }
}
