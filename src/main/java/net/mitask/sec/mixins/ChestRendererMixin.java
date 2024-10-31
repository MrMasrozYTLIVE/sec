package net.mitask.sec.mixins;

import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.block.entity.ChestBlockEntityRenderer;
import net.mitask.sec.SEConfigModel;
import net.mitask.sec.Sec;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ChestBlockEntityRenderer.class)
public class ChestRendererMixin {
    @Shadow private boolean christmas;

    @Inject(method = "<init>", at = @At("TAIL"))
    public void init(BlockEntityRendererFactory.Context ctx, CallbackInfo ci) {
        if(Sec.CONFIG.Christmas() == SEConfigModel.Choices.FORCE_DISABLE) christmas = false;
        if(Sec.CONFIG.Christmas() == SEConfigModel.Choices.FORCE_ENABLE) christmas = true;
    }
}
