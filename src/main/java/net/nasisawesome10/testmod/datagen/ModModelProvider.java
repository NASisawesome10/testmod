package net.nasisawesome10.testmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.nasisawesome10.testmod.block.ModBlocks;
import net.nasisawesome10.testmod.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool cosmicBrickPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SAPPHIRE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_END_STONE_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_SAPPHIRE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SAPPHIRE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_LAMINA);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_SLATE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_STONE_SLAB);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COSMIC_BRICKS);

        cosmicBrickPool.wall(ModBlocks.COSMIC_BRICK_WALL);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.SAPPHIRE, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEART_STONE, Models.GENERATED);
        itemModelGenerator.register(ModItems.COSMIC_TORCH_ITEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.COSMIC_BRICK, Models.GENERATED);
        itemModelGenerator.register(ModItems.COSMIC_CLAY_BALL, Models.GENERATED);
    }
}