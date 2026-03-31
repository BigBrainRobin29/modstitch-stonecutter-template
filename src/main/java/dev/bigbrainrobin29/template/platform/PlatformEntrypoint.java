package dev.bigbrainrobin29.template.platform;

import dev.bigbrainrobin29.template.TemplateMod;

//? if fabric {
import net.fabricmc.api.ModInitializer;

public class PlatformEntrypoint implements ModInitializer {
    @Override
    public void onInitialize() {
        TemplateMod.LOGGER.info("Hello from Fabric!");
        TemplateMod.initialize();
    }
}
//?} else {
/*import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod("template")
public class PlatformEntrypoint {
    public PlatformEntrypoint(IEventBus modBus, ModContainer container) {
        TemplateMod.LOGGER.info("Hello from NeoForge!");
        TemplateMod.initialize();
    }
}
*///?}