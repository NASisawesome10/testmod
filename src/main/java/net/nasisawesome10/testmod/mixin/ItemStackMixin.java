package net.nasisawesome10.testmod.mixin;

import net.minecraft.item.ItemStack;
import net.nasisawesome10.testmod.TestMod;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {
    @Inject(method = "getRepairCost", at = @At("RETURN"), cancellable = true)
    private void getRepairCost(CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(0);
    }
}
