package net.nasisawesome10.testmod.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.enchantment.MendingEnchantment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(MendingEnchantment.class)
    public class MendingEnchantmentMixin {
        @ModifyReturnValue(at = @At("RETURN"), method = "isTreasure")
        public boolean isTreasure(boolean original) {
            original = false;
            return original;
        }
}
