package net.nasisawesome10.testmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.nasisawesome10.testmod.block.CosmicFireBlock;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.client.sound.Sound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.nasisawesome10.testmod.TestMod;
import net.minecraft.block.*;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.nasisawesome10.testmod.particle.ModParticleTypes;
import net.nasisawesome10.testmod.sound.ModSounds;

public class ModBlocks {
    public static final Block SAPPHIRE_BLOCK = registerBlock("sapphire_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block CHISELED_END_STONE_BRICKS = registerBlock("chiseled_end_stone_bricks",
            new Block(FabricBlockSettings.copyOf(Blocks.END_STONE_BRICKS).sounds(BlockSoundGroup.STONE)));;
    public static final Block COSMIC_CLAY = registerBlock("cosmic_clay",
            new Block(FabricBlockSettings.copyOf(Blocks.CLAY).sounds(BlockSoundGroup.GRAVEL)));
    public static final Block END_LAMINA = registerBlock("end_lamina",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.STONE)));
    public static final Block END_SLATE = registerBlock("end_slate",
            new Block(FabricBlockSettings.copyOf(Blocks.END_STONE).sounds(ModSounds.BLOCK_END_STONE_SOUNDS)));
    public static final Block END_STONE_SLAB = registerBlock("end_stone_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.END_STONE).sounds(BlockSoundGroup.STONE)));
    public static final Block END_SAPPHIRE_ORE = registerBlock("end_sapphire_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(4, 7), FabricBlockSettings.copyOf(Blocks.END_STONE).strength(4f)));
    public static final Block COSMIC_BRICKS = registerBlock("cosmic_bricks",
            new Block(FabricBlockSettings.copyOf(Blocks.BRICKS).sounds(BlockSoundGroup.STONE)));

    public static final Block COSMIC_BRICK_STAIRS = registerBlock("cosmic_brick_stairs",
            new StairsBlock(ModBlocks.COSMIC_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.BRICK_STAIRS)));
    public static final Block COSMIC_BRICK_SLAB = registerBlock("cosmic_brick_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.BRICK_SLAB)));
    public static final Block COSMIC_BRICK_WALL = registerBlock("cosmic_brick_wall",
            new WallBlock(FabricBlockSettings.copyOf(Blocks.BRICK_WALL)));
    public static final Block COSMIC_TORCH = registerBlock("cosmic_torch",
            new TorchBlock(ModParticleTypes.COSMIC_FIRE_FLAME, AbstractBlock.Settings.create().noCollision().breakInstantly().luminance(state -> 15).sounds(BlockSoundGroup.WOOD).pistonBehavior(PistonBehavior.DESTROY).nonOpaque()));
    public static final Block COSMIC_WALL_TORCH = registerBlock("cosmic_wall_torch",
            new WallTorchBlock(ModParticleTypes.COSMIC_FIRE_FLAME, AbstractBlock.Settings.create().noCollision().breakInstantly().luminance(state -> 15).sounds(BlockSoundGroup.WOOD).dropsLike(COSMIC_TORCH).pistonBehavior(PistonBehavior.DESTROY).nonOpaque()));
    /*
    public static final Block COSMIC_FIRE = registerBlock("cosmic_fire",
            new CosmicFireBlock(AbstractBlock.Settings.create().mapColor(MapColor.MAGENTA).replaceable().noCollision().breakInstantly().luminance((state) -> {
                return 15;
            }).sounds(BlockSoundGroup.WOOL).pistonBehavior(PistonBehavior.DESTROY)));
     */
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(TestMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(TestMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        TestMod.LOGGER.info("Registering ModBlocks for " + TestMod.MOD_ID);
    }
}