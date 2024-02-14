package net.nasisawesome10.testmod.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.projectile.thrown.ExperienceBottleEntity;
import net.minecraft.util.hit.HitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(ExperienceOrbEntity.class)
public class ExperienceOrbEntityMixin {

    @ModifyReturnValue(method = "getMendingRepairAmount", at = @At("RETURN"))
    private int randomMending(int experienceAmount) {
        return experienceAmount * (int) Math.floor(Math.random() *(1 - 5 + 1) + 1);
    }
}