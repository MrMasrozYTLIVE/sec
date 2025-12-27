package net.mitask.sec;

import eu.midnightdust.lib.config.MidnightConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.MinecraftClient;

public class SEConfig extends MidnightConfig {
    @Entry public static Choices Halloween = Choices.VANILLA;
    @Entry public static Choices Christmas = Choices.VANILLA;

    @Override
    public void writeChanges() {
        super.writeChanges();
        if(FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT) MinecraftClient.getInstance().reloadResourcesConcurrently();
    }

    public enum Choices {
        FORCE_ENABLE, FORCE_DISABLE, VANILLA;
    }
}
