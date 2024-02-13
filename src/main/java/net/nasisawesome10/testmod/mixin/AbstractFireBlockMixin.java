package net.nasisawesome10.testmod.mixin;

import net.minecraft.block.*;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.BlockView;
import net.nasisawesome10.testmod.block.CosmicFireBlock;
import net.nasisawesome10.testmod.block.ModBlocks;
import net.nasisawesome10.testmod.sound.ModSounds;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.Slice;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractFireBlock.class)
public class AbstractFireBlockMixin {
    /*
    @Inject(method = "getState", at = @At("TAIL"), cancellable = true)
    private static void getDragonFireState(BlockView world, BlockPos pos, CallbackInfoReturnable<BlockState> ci) {
        BlockPos blockPos = pos.down();
        BlockState blockState = world.getBlockState(blockPos);
        if(CosmicFireBlock.isCosmicBase(blockState)) {
            ci.setReturnValue(ModBlocks.COSMIC_FIRE.getDefaultState());
        }
    }

     */

}