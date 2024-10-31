package net.mitask.sec;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import net.mitask.sec.SEConfig;

public class Sec implements ModInitializer {
    public static final SEConfig CONFIG = SEConfig.createAndLoad();

    @Override
    public void onInitialize() {
        CONFIG.subscribeToChristmas(choices -> MinecraftClient.getInstance().reloadResourcesConcurrently());
    }
}
