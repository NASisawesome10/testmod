package net.nasisawesome10.testmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.util.InputUtil;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.noise.DoublePerlinNoiseSampler;
import net.minecraft.world.gen.chunk.NoiseChunkGenerator;
import net.minecraft.world.gen.densityfunction.DensityFunction;
import net.minecraft.world.gen.noise.NoiseConfig;
import net.minecraft.world.gen.noise.NoiseRouter;
import net.nasisawesome10.testmod.block.ModBlocks;
import net.nasisawesome10.testmod.particle.CosmicFireFlame;
import net.nasisawesome10.testmod.particle.ModParticleTypes;
import org.lwjgl.glfw.GLFW;

import java.awt.*;

public class TestModClient implements ClientModInitializer {
    public static int stamina = 200;

    private static final MinecraftClient client = MinecraftClient.getInstance();
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.COSMIC_TORCH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.COSMIC_WALL_TORCH, RenderLayer.getCutout());
        //BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.COSMIC_FIRE, RenderLayer.getCutout());
        ParticleFactoryRegistry.getInstance().register(ModParticleTypes.COSMIC_FIRE_FLAME, CosmicFireFlame.Factory::new);

        ClientTickEvents.END_WORLD_TICK.register(client -> {

        ClientPlayNetworking.registerGlobalReceiver(TestMod.id("stamina"), (client1, handler, buf, responseSender) -> {
            stamina = buf.readInt();
        });
    });
};
}