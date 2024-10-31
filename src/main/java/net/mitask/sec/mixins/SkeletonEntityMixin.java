package net.mitask.sec.mixins;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.entity.mob.AbstractSkeletonEntity;
import net.mitask.sec.SEConfigModel;
import net.mitask.sec.Sec;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;

@Mixin(AbstractSkeletonEntity.class)
public class SkeletonEntityMixin {
    @WrapOperation(method = "initialize", at = @At(value = "INVOKE", target = "Ljava/time/LocalDate;get(Ljava/time/temporal/TemporalField;)I"))
    public int initialize(LocalDate instance, TemporalField field, Operation<Integer> original) {
        var halloween = Sec.CONFIG.Halloween();
        if(halloween == SEConfigModel.Choices.FORCE_ENABLE) return field == ChronoField.DAY_OF_MONTH ? 31 : 10;
        if(halloween == SEConfigModel.Choices.FORCE_DISABLE) return field == ChronoField.DAY_OF_MONTH ? 6 : 7;

        return original.call(instance, field);
    }
}
