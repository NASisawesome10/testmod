package net.nasisawesome10.testmod.sound;

import net.nasisawesome10.testmod.TestMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent BLOCK_END_STONE_BREAK = registerSoundEvent("block.end_stone.break");
    public static final SoundEvent BLOCK_END_STONE_STEP = registerSoundEvent("block.end_stone.step");
    public static final SoundEvent BLOCK_END_STONE_PLACE = registerSoundEvent("block.end_stone.place");
    public static final SoundEvent BLOCK_END_STONE_HIT = registerSoundEvent("block.end_stone.hit");
    public static final SoundEvent BLOCK_END_STONE_FALL = registerSoundEvent("block.end_stone.fall");
    public static final BlockSoundGroup BLOCK_END_STONE_SOUNDS = new BlockSoundGroup(0.8f, 1.0f,
            ModSounds.BLOCK_END_STONE_BREAK, ModSounds.BLOCK_END_STONE_STEP, ModSounds.BLOCK_END_STONE_PLACE,
            ModSounds.BLOCK_END_STONE_HIT, ModSounds.BLOCK_END_STONE_FALL);

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(TestMod.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        TestMod.LOGGER.info("Registering Sounds for " + TestMod.MOD_ID);
    }
}