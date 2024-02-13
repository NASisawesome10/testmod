package net.nasisawesome10.testmod.datagen;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.tag.ValueLookupTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModBlockTags {
    public static final TagKey<Block> COSMIC_FIRE_BASE_BLOCKS = TagKey.of(RegistryKeys.BLOCK, new Identifier("cosmic_fire_base_blocks"));
}