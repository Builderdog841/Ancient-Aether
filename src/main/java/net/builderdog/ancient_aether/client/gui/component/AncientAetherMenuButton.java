package net.builderdog.ancient_aether.client.gui.component;

import com.aetherteam.aether.mixin.mixins.client.accessor.ButtonAccessor;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.client.gui.screen.AncientAetherTitleScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class AncientAetherMenuButton extends Button {
    private static final ResourceLocation AETHER_WIDGETS = new ResourceLocation(AncientAether.MODID, "textures/gui/sprites/title/buttons.png");
    private static final int BUTTON_WIDTH = 400;
    private static final int BUTTON_HEIGHT = 40;
    private static final int BUTTON_SEPARATION = 50;
    private static final int INITIAL_X_OFFSET = 16;
    private static final int INITIAL_Y_OFFSET = 100;
    private static final int TEXTURE_SIZE = 512;
    private final AncientAetherTitleScreen screen;
    public final int originalX;
    public final int originalY;
    public final int originalWidth;
    public final int originalHeight;
    public int hoverOffset;
    public int buttonCountOffset;
    public boolean serverButton;

    public AncientAetherMenuButton(AncientAetherTitleScreen screen, Builder builder) {
        super(builder);
        this.screen = screen;
        originalX = getX();
        originalY = getY();
        originalWidth = getWidth();
        originalHeight = getHeight();
        hoverOffset = 0;
    }

    public AncientAetherMenuButton(AncientAetherTitleScreen screen, Button oldButton) {
        this(screen, new Builder(oldButton.getMessage(), (button) -> oldButton.onPress()).bounds( oldButton.getX(), oldButton.getY(), oldButton.getWidth(), oldButton.getHeight()).createNarration((button) -> ((ButtonAccessor) oldButton).callCreateNarrationMessage()));
        oldButton.visible = false;
        oldButton.active = false;
    }

    @Override
    public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        PoseStack poseStack = guiGraphics.pose();
        Minecraft minecraft = Minecraft.getInstance();
        Font font = minecraft.font;
        int i = getTextureY();

        float scale = AncientAetherTitleScreen.getScale(screen, minecraft);
        if (screen.isAlignedLeft()) {
            setX(INITIAL_X_OFFSET);
            setY((int) ((INITIAL_Y_OFFSET / scale) + buttonCountOffset * (BUTTON_SEPARATION / scale)));
            setWidth((int) (BUTTON_WIDTH / scale));
        } else {
            setX(originalX);
            setY((int) (10 + (height / 2 + (96 / scale)) + (BUTTON_SEPARATION / scale) * buttonCountOffset));
            setWidth(originalWidth);
        }
        setHeight((int) (BUTTON_HEIGHT / scale));

        RenderSystem.enableBlend();
        guiGraphics.setColor(1.0F, 1.0F, 1.0F, alpha);
        guiGraphics.blit(AETHER_WIDGETS, getX() + hoverOffset, getY(), 0, Mth.ceil(i / scale), getWidth(), getHeight(), (int) (TEXTURE_SIZE / scale), (int) (TEXTURE_SIZE / scale));
        RenderSystem.disableBlend();

        poseStack.pushPose();
        float textScale = getTextScale(screen, minecraft);
        float textX = getX() + (35 * textScale) + hoverOffset;
        float textY = getY() + (height - (8 * textScale)) / 2.0F;
        poseStack.translate(textX, textY, 0.0F);
        poseStack.scale(textScale, textScale, textScale);
        guiGraphics.drawString(font, getMessage(), 0, 0, getTextColor(mouseX, mouseY) | Mth.ceil(this.alpha * 255.0F) << 24);
        poseStack.popPose();
    }

    public static float getTextScale(AncientAetherTitleScreen screen, Minecraft minecraft) {
        int guiScale = minecraft.getWindow().calculateScale(minecraft.options.guiScale().get(), minecraft.isEnforceUnicode());
        float elementScale = AncientAetherTitleScreen.getScale(screen, minecraft);
        float elementPixelWidth = (int) (guiScale / elementScale);
        float textPixelWidth = elementPixelWidth + 2.0F;
        if (elementPixelWidth <= 1) {
            textPixelWidth = 2.0F;
        }
        return textPixelWidth / guiScale;
    }

    private int getTextureY() {
        int i = 1;
        if (!isActive()) {
            i = 0;
        } else if (isHoveredOrFocused()) {
            i = 2;
        }
        return i * 40;
    }

    public int getTextColor(int mouseX, int mouseY) {
        return isMouseOver(mouseX, mouseY) ? 16043927 : 11711154;
    }

    public static int totalHeightRange(int buttonCount, float scale) {
        return (int) ((INITIAL_Y_OFFSET / scale) + ((buttonCount) * ((BUTTON_SEPARATION + 10) / scale)));
    }
}