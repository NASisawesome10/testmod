package net.nasisawesome10.testmod.mixin;

import net.minecraft.block.SculkSensorBlock;
import net.nasisawesome10.testmod.access.CropBlockAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SculkSensorBlock.class)
public class CropBlockMixin implements CropBlockAccess {
    @Override
    public void access() {
        System.out.println("Accessed!");
    }
}