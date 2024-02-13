package net.nasisawesome10.testmod.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.nasisawesome10.testmod.datagen.ModBlockTags;
import net.nasisawesome10.testmod.util.ModTags;

public class CosmicFireBlock extends AbstractFireBlock {
    public static final MapCodec<CosmicFireBlock> CODEC = CosmicFireBlock.createCodec(CosmicFireBlock::new);

    public MapCodec<CosmicFireBlock> getCodec() {
        return CODEC;
    }
    public CosmicFireBlock(Block.Settings settings) {
        super(settings, 0.5f);
    }


    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState newState, WorldAccess world, BlockPos pos, BlockPos posFrom) {
        return this.canPlaceAt(state, world, pos) ? this.getDefaultState() : Blocks.AIR.getDefaultState();
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return CosmicFireBlock.isCosmicBase(world.getBlockState(pos.down()));
    }

    public static boolean isCosmicBase(BlockState state) {
        return state.isIn(ModBlockTags.COSMIC_FIRE_BASE_BLOCKS);
    }


    @Override
    public boolean isFlammable(BlockState state) {
        return true;
    }
}