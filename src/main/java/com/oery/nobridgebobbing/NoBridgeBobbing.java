package com.oery.nobridgebobbing;

import net.weavemc.loader.api.ModInitializer;
import net.weavemc.loader.api.event.*;
import net.minecraft.client.Minecraft;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class NoBridgeBobbing implements ModInitializer {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void preInit() {
        LOGGER.info("Initializing NoBridgeBobbing");

        EventBus.subscribe(TickEvent.Pre.INSTANCE.getClass(), event -> {
            Minecraft mc = Minecraft.getMinecraft();
            if (mc.thePlayer != null && mc.theWorld != null) {
                mc.gameSettings.viewBobbing = mc.thePlayer.getLookVec().yCoord > -0.95F;
            }
        });
    }
}