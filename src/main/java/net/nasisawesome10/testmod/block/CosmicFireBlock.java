/*
 * Decompiled with CFR 0.2.1 (FabricMC 53fa44c9).
 */
package net.nasisawesome10.testmod.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.nasisawesome10.testmod.util.ModTags;

public class CosmicFireBlock
        extends AbstractFireBlock {
    public static final MapCodec<CosmicFireBlock> CODEC = CosmicFireBlock.createCodec(CosmicFireBlock::new);

    public MapCodec<CosmicFireBlock> getCodec() {
        return CODEC;
    }

    public CosmicFireBlock(AbstractBlock.Settings settings) {
        super(settings, 2.0f);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (this.canPlaceAt(state, world, pos)) {
            return this.getDefaultState();
        }
        return Blocks.AIR.getDefaultState();
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return CosmicFireBlock.isCosmicBase(world.getBlockState(pos.down()));
    }

    public static boolean isCosmicBase(BlockState state) {
        return state.isIn(ModTags.COSMIC_FIRE_BASE_BLOCKS);
    }

    @Override
    protected boolean isFlammable(BlockState state) {
        return true;
    }
}

