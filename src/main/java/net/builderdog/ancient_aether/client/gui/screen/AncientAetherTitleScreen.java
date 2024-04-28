package net.builderdog.ancient_aether.client.gui.screen;

import com.aetherteam.aether.AetherConfig;
import com.aetherteam.aether.client.AetherSoundEvents;
import com.aetherteam.aether.client.gui.component.menu.DynamicMenuButton;
import com.aetherteam.aether.client.gui.screen.menu.TitleScreenBehavior;
import com.aetherteam.aether.mixin.mixins.client.accessor.TitleScreenAccessor;
import com.aetherteam.cumulus.mixin.mixins.client.accessor.SplashRendererAccessor;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.AncientAetherConfig;
import net.builderdog.ancient_aether.client.gui.component.AncientAetherMenuButton;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Renderable;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.narration.NarratableEntry;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.client.renderer.CubeMap;
import net.minecraft.client.renderer.PanoramaRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.Music;
import net.minecraft.util.Mth;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.internal.BrandingControl;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unchecked")
public class AncientAetherTitleScreen extends TitleScreen implements TitleScreenBehavior {
    private static final ResourceLocation PANORAMA_OVERLAY = new ResourceLocation("textures/gui/title/background/panorama_overlay.png");
    private static final ResourceLocation ANCIENT_AETHER_LOGO = new ResourceLocation(AncientAether.MODID, "textures/gui/title/ancient_aether.png");
    private static final ResourceLocation THE_AETHER_LOGO = new ResourceLocation(AncientAether.MODID, "textures/gui/title/the_aether.png");
    public static final Music MENU = new Music(AetherSoundEvents.MUSIC_MENU.getHolder().orElseThrow(), 20, 600, true);
    private final PanoramaRenderer panorama = new PanoramaRenderer(new CubeMap(new ResourceLocation(AncientAether.MODID, "textures/gui/title/panorama/panorama")));
    private AncientAetherModUpdateIndicator modUpdateNotification;
    private boolean alignedLeft;
    private int rows;

    public AncientAetherTitleScreen() {
        ((TitleScreenAccessor) this).aether$setFading(true);
    }

    public AncientAetherTitleScreen(boolean alignedLeft) {
        this();
        this.alignedLeft = alignedLeft;
    }

    @Override
    protected void init() {
        super.init();
        setupButtons();
        modUpdateNotification = new AncientAetherModUpdateIndicator(this);
        modUpdateNotification.init();
    }

    public void setupButtons() {
        int buttonRows = 0;
        int lastY = 0;
        for (Renderable renderable : renderables) {
            if (renderable instanceof AbstractWidget abstractWidget) {
                Component buttonText = abstractWidget.getMessage();
                if (TitleScreenBehavior.isImageButton(buttonText)) {
                    abstractWidget.visible = false;
                }
                if (abstractWidget instanceof AncientAetherMenuButton ancientAetherButton) {
                    if (isAlignedLeft()) {
                        buttonRows++;
                    } else {
                        if (lastY < ancientAetherButton.originalY) {
                            lastY = ancientAetherButton.originalY;
                            buttonRows++;
                        }
                    }
                    if (buttonText.equals(Component.translatable("gui.aether.menu.server"))) {
                        ancientAetherButton.serverButton = true;
                        ancientAetherButton.buttonCountOffset = 2;
                    } else {
                        ancientAetherButton.buttonCountOffset = buttonRows;
                    }
                    if (AetherConfig.CLIENT.enable_server_button.get() && buttonText.equals(Component.translatable("menu.singleplayer"))) {
                        buttonRows++;
                    }
                }
            }
        }
        rows = alignedLeft ? buttonRows : buttonRows - 1;
    }

    @Override
    public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        TitleScreenAccessor titleScreenAccessor = (TitleScreenAccessor) this;
        if (minecraft != null && titleScreenAccessor.aether$getSplash() == null) {
            titleScreenAccessor.aether$setSplash(minecraft.getSplashManager().getSplash());
        }
        float fadeAmount = TitleScreenBehavior.super.handleFading(guiGraphics, this, titleScreenAccessor, panorama, PANORAMA_OVERLAY, partialTicks);
        float scale = getScale(this, getMinecraft());

        if (AncientAetherConfig.CLIENT.the_aether_title.get()) {
            setupLogoConfig(guiGraphics, fadeAmount, scale);
        }
        else setupLogo(guiGraphics, fadeAmount, scale);

        int roundedFadeAmount = Mth.ceil(fadeAmount * 255.0F) << 24;
        if ((roundedFadeAmount & -67108864) != 0) {
            ForgeHooksClient.renderMainMenu(this, guiGraphics, font, width, height, roundedFadeAmount);
            if (titleScreenAccessor.aether$getSplash() != null) {
                SplashRendererAccessor splashRendererAccessor = (SplashRendererAccessor) titleScreenAccessor.aether$getSplash();
                if (splashRendererAccessor.cumulus$getSplash() != null && !splashRendererAccessor.cumulus$getSplash().isEmpty()) {
                    PoseStack poseStack = guiGraphics.pose();
                    float splashX = alignedLeft ? 400.0F / scale : (float) width / 2 + (175 / scale);
                    float splashY = alignedLeft ? 100.0F / scale : (int) (20 + (76 / scale));
                    poseStack.pushPose();
                    poseStack.translate(splashX, splashY, 0.0F);
                    poseStack.mulPose(Axis.ZP.rotationDegrees(-20.0F));
                    float textSize = 1.8F - Mth.abs(Mth.sin((float) (Util.getMillis() % 1000L) / 1000.0F * Mth.TWO_PI) * 0.1F);
                    textSize = textSize * (120.0F / scale) / (font.width(splashRendererAccessor.cumulus$getSplash()) + (64 / scale));
                    poseStack.scale(textSize, textSize, textSize);
                    guiGraphics.drawCenteredString(font, splashRendererAccessor.cumulus$getSplash(), 0, (int) (-16 / scale), 16043927 | roundedFadeAmount);
                    poseStack.popPose();
                }
            }

            if (alignedLeft) {
                TitleScreenBehavior.super.renderRightBranding(guiGraphics, this, font, roundedFadeAmount);
            } else {
                BrandingControl.forEachLine(true, true, (brandingLine, branding) ->
                        guiGraphics.drawString(font, branding, 2, height - (10 + brandingLine * (font.lineHeight + 1)), 16777215 | roundedFadeAmount)
                );
                BrandingControl.forEachAboveCopyrightLine((brandingLine, branding) ->
                        guiGraphics.drawString(font, branding, width - font.width(branding), height - (10 + (brandingLine + 1) * (font.lineHeight + 1)), 16777215 | roundedFadeAmount)
                );
            }
        }

        int xOffset = TitleScreenBehavior.super.handleButtonVisibility(this, fadeAmount);
        for (Renderable renderable : renderables) {
            renderable.render(guiGraphics, mouseX, mouseY, partialTicks);
            if (renderable instanceof AncientAetherMenuButton ancientAetherButton) {
                if (ancientAetherButton.isMouseOver(mouseX, mouseY)) {
                    if (ancientAetherButton.hoverOffset < 15) {
                        ancientAetherButton.hoverOffset += 4;
                    }
                } else {
                    if (ancientAetherButton.hoverOffset > 0) {
                        ancientAetherButton.hoverOffset -= 4;
                    }
                }
            }
            if (renderable instanceof DynamicMenuButton dynamicMenuButton) {
                if (dynamicMenuButton.enabled) {
                    xOffset -= 24;
                }
            }
        }
        TitleScreenBehavior.super.handleImageButtons(this, xOffset);

        if (fadeAmount >= 1.0F) {
            modUpdateNotification.render(guiGraphics, mouseX, mouseY, partialTicks);
        }
    }

    private void setupLogo(GuiGraphics guiGraphics, float transparency, float scale) {
        int width = (int) (400 / scale);
        int height = (int) (75 / scale);
        int logoX = alignedLeft ? (int) (10 + (18 / scale)) : (int) ((width / 2 - 175 / scale));
        int logoY = alignedLeft ? (int) (15 + (10 / scale)) : (int) (25 + (10 / scale));
        guiGraphics.setColor(1.0F, 1.0F, 1.0F, transparency);
        guiGraphics.blit(ANCIENT_AETHER_LOGO, logoX, logoY, 0, 0, width, height, width, height);
        guiGraphics.setColor(1.0F, 1.0F, 1.0F, 1.0F);
    }

    private void setupLogoConfig(GuiGraphics guiGraphics, float transparency, float scale) {
        int width = (int) (375 / scale);
        int height = (int) (112.5 / scale);
        int logoX = alignedLeft ? (int) (10 + (18 / scale)) : (int) ((width / 2 - 175 / scale));
        int logoY = alignedLeft ? (int) (15 + (10 / scale)) : (int) (25 + (10 / scale));
        guiGraphics.setColor(1.0F, 1.0F, 1.0F, transparency);
        guiGraphics.blit(THE_AETHER_LOGO, logoX, logoY, 0, 0, width, height, width, height);
        guiGraphics.setColor(1.0F, 1.0F, 1.0F, 1.0F);
    }

    public static float getScale(AncientAetherTitleScreen screen, Minecraft minecraft) {
        int guiScale = minecraft.getWindow().calculateScale(minecraft.options.guiScale().get(), minecraft.isEnforceUnicode());
        return calculateScale(screen, guiScale, guiScale - 1);
    }

    public static float calculateScale(AncientAetherTitleScreen screen, float guiScale, float lowerScale) {
        float scale = 1.0F;
        if (guiScale > 1) {
            scale = guiScale / lowerScale;
        }
        int range = AncientAetherMenuButton.totalHeightRange(screen.rows, scale);
        if (range > screen.height && scale != 1.0F) {
            return calculateScale(screen, guiScale, lowerScale - 1);
        } else {
            return scale;
        }
    }

    @Override
    protected <T extends GuiEventListener & Renderable & NarratableEntry> @NotNull T addRenderableWidget(@NotNull T renderable) {
        if (renderable instanceof Button button) {
            if (TitleScreenBehavior.isMainButton(button.getMessage())) {
                AncientAetherMenuButton ancientAetherButton = new AncientAetherMenuButton(this, button);
                return (T) super.addRenderableWidget(ancientAetherButton);
            }
        }
        return super.addRenderableWidget(renderable);
    }

    public boolean isAlignedLeft() {
        return alignedLeft;
    }
}