package net.nasisawesome10.testmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.nasisawesome10.testmod.block.ModBlocks;
import net.nasisawesome10.testmod.util.ModTags;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ModTags.Blocks.COSMIC_FIRE_BASE_BLOCKS)
                .add(Blocks.END_STONE)
                .add(ModBlocks.COSMIC_CLAY);
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.CHISELED_END_STONE_BRICKS)
                .add(ModBlocks.END_SAPPHIRE_ORE)
                .add(ModBlocks.SAPPHIRE_BLOCK)
                .add(ModBlocks.END_LAMINA)
                .add(ModBlocks.END_SLATE)
                .add(ModBlocks.END_STONE_SLAB)
                .add(ModBlocks.COSMIC_BRICKS);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.END_SAPPHIRE_ORE);

        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.COSMIC_BRICK_WALL);
    }
}