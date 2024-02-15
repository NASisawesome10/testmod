package net.nasisawesome10.testmod.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.server.MinecraftServer;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MobEntity.class)
public class MobEntityMixin {
    @Shadow private @Nullable LivingEntity target;

    @Inject(method = "getXpToDrop", at = @At("RETURN"), cancellable = true)
    public void getXpToDrop(CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(cir.getReturnValue() * 2);
    }
}
