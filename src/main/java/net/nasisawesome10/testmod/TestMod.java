package net.nasisawesome10.testmod;

import net.fabricmc.api.ModInitializer;

import net.nasisawesome10.testmod.block.ModBlocks;
import net.nasisawesome10.testmod.item.ModItemGroups;
import net.nasisawesome10.testmod.item.ModItems;
import net.nasisawesome10.testmod.sound.ModSounds;
import net.nasisawesome10.testmod.util.ModTags;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.nasisawesome10.testmod.world.gen.ModWorldGeneration;

public class TestMod implements ModInitializer {
    public static final String MOD_ID = "testmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModSounds.registerSounds();

		ModWorldGeneration.generateModWorldGen();
	}
}