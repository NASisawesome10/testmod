package net.nasisawesome10.testmod.mixin;

import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.projectile.thrown.ExperienceBottleEntity;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.WorldEvents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(ExperienceBottleEntity.class)
public class ExperienceBottleEntityMixin {

    @Inject(method = "onCollision", at = @At("HEAD"))
    protected void onCollision(HitResult hitResult, CallbackInfo callbackInfo) {
        ExperienceBottleEntity thi = (ExperienceBottleEntity)(Object)this;

        if (!thi.getWorld().isClient) {
            int i = 15 + thi.getWorld().random.nextInt(100) + thi.getWorld().random.nextInt(100);

            while(i > 0) {
                int j = ExperienceOrbEntity.roundToOrbSize(i);
                i -= j;
                thi.getWorld().spawnEntity(new ExperienceOrbEntity(thi.getWorld(), thi.getX(), thi.getY(), thi.getZ(), j));
            }
        }
    }
}