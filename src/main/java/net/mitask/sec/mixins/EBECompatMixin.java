package net.mitask.sec.mixins;

import foundationgames.enhancedblockentities.util.DateUtil;
import net.mitask.sec.SEConfigModel;
import net.mitask.sec.Sec;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DateUtil.class)
public class EBECompatMixin {
    @Inject(method = "isChristmas", at = @At("RETURN"), cancellable = true, remap = false)
    private static void isChristmas(CallbackInfoReturnable<Boolean> cir) {
        var sec = Sec.CONFIG.Christmas();

        if (sec == SEConfigModel.Choices.FORCE_ENABLE) cir.setReturnValue(true);
        if (sec == SEConfigModel.Choices.FORCE_DISABLE) cir.setReturnValue(false);
    }
}
