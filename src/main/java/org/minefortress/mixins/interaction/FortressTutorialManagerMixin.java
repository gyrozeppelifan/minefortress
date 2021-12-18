package org.minefortress.mixins.interaction;

import com.chocohead.mm.api.ClassTinkerers;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.tutorial.TutorialManager;
import net.minecraft.world.GameMode;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TutorialManager.class)
public class FortressTutorialManagerMixin {

    @Shadow @Final private MinecraftClient client;

    @Inject(method = "onInventoryOpened", at = @At("HEAD"), cancellable = true)
    public void onOpenInventory(CallbackInfo ci) {
        if(client.interactionManager != null && client.interactionManager.getCurrentGameMode() == ClassTinkerers.getEnum(GameMode.class, "FORTRESS")) {
            if(client.options.keySprint.isPressed())
                ci.cancel();
        }
    }

}
