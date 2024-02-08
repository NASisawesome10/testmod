package net.nasisawesome10.testmod.world;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.OverworldBiomeCreator;
import net.minecraft.world.gen.feature.*;
import net.nasisawesome10.testmod.TestMod;
import net.nasisawesome10.testmod.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> END_SAPPHIRE_ORE_KEY = registerKey("end_sapphire_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> END_SLATE_KEY = registerKey("end_slate");

    public static void boostrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest endReplacables = new BlockMatchRuleTest(Blocks.END_STONE);

        List<OreFeatureConfig.Target> endSapphireOres =
                List.of(OreFeatureConfig.createTarget(endReplacables, ModBlocks.END_SAPPHIRE_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> endSlate =
                List.of(OreFeatureConfig.createTarget(endReplacables, ModBlocks.END_SLATE.getDefaultState()));

        register(context, END_SAPPHIRE_ORE_KEY, Feature.ORE, new OreFeatureConfig(endSapphireOres, 12));
        register(context, END_SLATE_KEY, Feature.ORE, new OreFeatureConfig(endSlate, 12));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(TestMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}