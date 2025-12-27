package net.mitask.sec.mixins;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.util.Holidays;
import net.mitask.sec.SEConfig;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Holidays.class)
public class HolidaysMixin {
    @WrapMethod(method = "isHalloween")
    private static boolean isHalloween(Operation<Boolean> original) {
        return switch(SEConfig.Halloween) {
            case FORCE_ENABLE -> true;
            case FORCE_DISABLE -> false;
            case VANILLA -> original.call();
        };
    }

    @WrapMethod(method = "isAroundChristmas")
    private static boolean isAroundChristmas(Operation<Boolean> original) {
        return switch(SEConfig.Christmas) {
            case FORCE_ENABLE -> true;
            case FORCE_DISABLE -> false;
            case VANILLA -> original.call();
        };
    }
}
