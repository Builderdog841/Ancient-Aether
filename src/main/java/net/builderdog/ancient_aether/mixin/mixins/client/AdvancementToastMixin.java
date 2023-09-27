package net.builderdog.ancient_aether.mixin.mixins.client;

import com.aetherteam.aether.Aether;
import com.aetherteam.aether.client.AetherSoundEvents;
import net.builderdog.ancient_aether.client.AncientAetherSoundEvents;
import net.minecraft.advancements.Advancement;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.toasts.AdvancementToast;
import net.minecraft.client.gui.components.toasts.Toast;
import net.minecraft.client.gui.components.toasts.ToastComponent;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AdvancementToast.class)
public class AdvancementToastMixin {
    @Final
    @Shadow
    private Advancement advancement;
    @Shadow
    private boolean playedSound;



    @Inject(at = @At(value = "FIELD", target = "net/minecraft/client/gui/components/toasts/AdvancementToast.playedSound:Z"), method = "render(Lnet/minecraft/client/gui/GuiGraphics;Lnet/minecraft/client/gui/components/toasts/ToastComponent;J)Lnet/minecraft/client/gui/components/toasts/Toast$Visibility;")
    private void render(GuiGraphics guiGraphics, ToastComponent toastComponent, long timeSinceLastVisible, CallbackInfoReturnable<Toast.Visibility> cir) {
        if (!playedSound) {
                switch (this.advancement.getId().getPath()) {
                    case "cracked_slider":
                        toastComponent.getMinecraft().getSoundManager().play(SimpleSoundInstance.forUI(AncientAetherSoundEvents.UI_TOAST_AETHER_GOLD.get(), 1.0F, 1.0F));
                        break;
                    default:
                        toastComponent.getMinecraft().getSoundManager().play(SimpleSoundInstance.forUI(AetherSoundEvents.UI_TOAST_AETHER_GENERAL.get(), 1.0F, 1.0F));
                }
        }
    }

    @Unique
    private boolean checkRoot() {
        ResourceLocation enterAether = new ResourceLocation(Aether.MODID, "enter_aether");
        for (Advancement advancement = this.advancement; advancement != null; advancement = advancement.getParent()) {
            if (advancement.getId().equals(enterAether)) {
                return true;
            }
        }
        return false;
    }
}