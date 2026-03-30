package dev.bigbrainrobin29.template.mixin;

import dev.bigbrainrobin29.template.TemplateMod;
import net.minecraft.client.gui.screens.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class TitleScreenMixin {
    @Inject(method = "init", at = @At("HEAD"))
    public void initMixinExample(CallbackInfo ci) {
        String baseString = "Hello from %LOADER% on Minecraft %MINECRAFT%";

        //? if fabric {
        /*baseString = baseString.replace("%LOADER%", "Fabric Loader");
        *///?} else if neoforge {
        baseString = baseString.replace("%LOADER%", "NeoForge");
        //?}

        //? if 1.21 {
        /*baseString = baseString.replace("%MINECRAFT%", "1.21-1.21.11");
        *///?} else if >= 26 {
        /*baseString = baseString.replace("%MINECRAFT%", "26+");
        *///?}

        TemplateMod.LOGGER.info(baseString);
    }
}