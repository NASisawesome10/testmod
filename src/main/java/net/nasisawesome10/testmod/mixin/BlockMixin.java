package net.nasisawesome10.testmod.mixin;

import net.minecraft.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(Block.class)
public class BlockMixin {
    @ModifyConstant(method = "afterBreak", constant = @Constant(floatValue = 0.005f))
    public float afterBreakExhaustion(float aBExhaustion) {
        return aBExhaustion = 0.002f;
    }
}
