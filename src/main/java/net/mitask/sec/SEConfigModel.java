package net.mitask.sec;

import io.wispforest.owo.config.Option;
import io.wispforest.owo.config.annotation.Config;
import io.wispforest.owo.config.annotation.Hook;
import io.wispforest.owo.config.annotation.Modmenu;
import io.wispforest.owo.config.annotation.Sync;

@Modmenu(modId = "sec")
@Config(wrapperName = "SEConfig", name = "secontroller")
@Sync(Option.SyncMode.NONE)
public class SEConfigModel {
    @Hook
    public Choices Halloween = Choices.VANILLA;
    @Hook
    public Choices Christmas = Choices.VANILLA;

    public enum Choices {
        FORCE_ENABLE, FORCE_DISABLE, VANILLA;
    }
}
