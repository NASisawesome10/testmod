package net.nasisawesome10.testmod.particle;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.particle.ParticleType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.nasisawesome10.testmod.TestMod;

public class ModParticleTypes {
    public static final DefaultParticleType COSMIC_FIRE_FLAME = registerParticleType("cosmic_fire_flame",
            FabricParticleTypes.simple());

    private static DefaultParticleType registerParticleType(String name, DefaultParticleType particleType) {
        return Registry.register(Registries.PARTICLE_TYPE, new Identifier(TestMod.MOD_ID, name), particleType);
    }
}
