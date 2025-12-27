package net.mitask.sec;

import eu.midnightdust.lib.config.MidnightConfig;
import net.fabricmc.api.ModInitializer;

public class Sec implements ModInitializer {
    @Override
    public void onInitialize() {
        MidnightConfig.init("sec", SEConfig.class);
    }
}
