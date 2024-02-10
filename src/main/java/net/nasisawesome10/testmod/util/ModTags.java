package net.nasisawesome10.testmod.util;

import net.nasisawesome10.testmod.TestMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static TagKey<Block> COSMIC_FIRE_BASE_BLOCKS;

    public static class Blocks {
        public static final TagKey<Block> COSMIC_FIRE_BASE_BLOCKS =
                createTag("cosmic_fire_base_blocks");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(TestMod.MOD_ID, name));
        }
    }

    public static class Items {


        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(TestMod.MOD_ID, name));
        }
    }
}