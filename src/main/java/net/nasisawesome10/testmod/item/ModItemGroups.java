package net.nasisawesome10.testmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Blocks;
import net.nasisawesome10.testmod.TestMod;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.nasisawesome10.testmod.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup SAPPHIRE_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(TestMod.MOD_ID, "sapphire"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.sapphire"))
                    .icon(() -> new ItemStack(ModItems.SAPPHIRE)).entries((displayContext, entries) -> {
                        entries.add(ModItems.SAPPHIRE);
                        entries.add(ModItems.HEART_STONE);
                        entries.add(ModItems.COSMIC_CLAY_BALL);
                        entries.add(ModItems.COSMIC_BRICK);
                        entries.add(ModItems.COSMIC_TORCH_ITEM);

                        entries.add(ModBlocks.CHISELED_END_STONE_BRICKS);
                        entries.add(ModBlocks.COSMIC_CLAY);
                        entries.add(ModBlocks.END_LAMINA);
                        entries.add(ModBlocks.END_SLATE);
                        entries.add(ModBlocks.SAPPHIRE_BLOCK);
                        entries.add(ModBlocks.END_SAPPHIRE_ORE);
                        entries.add(ModBlocks.END_STONE_SLAB);
                        entries.add(ModBlocks.COSMIC_BRICKS);
                        entries.add(ModBlocks.COSMIC_BRICK_STAIRS);
                        entries.add(ModBlocks.COSMIC_BRICK_SLAB);
                        entries.add(ModBlocks.COSMIC_BRICK_WALL);


                        //entries.add(Items.DIAMOND);


                    }).build());


    public static void registerItemGroups() {
        TestMod.LOGGER.info("Registering Item Groups for " + TestMod.MOD_ID);
    }
}