package net.nasisawesome10.testmod.mixin;

import net.minecraft.block.*;
import net.minecraft.block.FallingBlock;
import net.nasisawesome10.testmod.sound.ModSounds;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.*;


@Mixin(Blocks.class)
public abstract class BlocksMixin {
    /*
    @ModifyArg(
            method = "<clinit>",
            slice = @Slice(
                    from = @At(value = "CONSTANT", args = "stringValue=end_stone")
            ),
            at = @At(value = "INVOKE", target = "Lnet/minecraft/block/FlowerBlock;<init>" +
                    "(Lnet/minecraft/sound/BlockSoundGroup;ILnet/minecraft/block/AbstractBlock$Settings;)V", ordinal = 0)
    )

    private static Block.Settings endBlockSounds(AbstractBlock.Settings settings)
    {
        return settings.sounds(ModSounds.BLOCK_END_STONE_SOUNDS);
    }
    */
    /*
    @Redirect(
            method = "<clinit>",
            slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=netherite_block")),
            at = @At(value = "NEW", target = "(Lnet/minecraft/block/AbstractBlock$Settings;)Lnet/minecraft/block/Block;", ordinal = 0)
    )
    private static Block modifyNetheriteBlock(AbstractBlock.Settings settings) {
        return new Block(settings);
    }
    */
    @Redirect(
            method = "<clinit>",
            slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=end_stone")),
            at = @At(value = "NEW", target = "(Lnet/minecraft/block/AbstractBlock$Settings;)Lnet/minecraft/block/Block;", ordinal = 0)
    )
    private static Block endBlockSounds(AbstractBlock.Settings settings) {
        return new Block(settings.sounds(ModSounds.BLOCK_END_STONE_SOUNDS));
    }
}