package net.nasisawesome10.testmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.item.VerticallyAttachableBlockItem;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.Direction;
import net.nasisawesome10.testmod.TestMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.nasisawesome10.testmod.block.ModBlocks;

public class ModItems {
    public static final Item SAPPHIRE = registerItem("sapphire",
            new Item(new FabricItemSettings()));
    public static final Item HEART_STONE = registerItem("heart_stone",
            new Item(new FabricItemSettings().rarity(Rarity.RARE)));
    public static final Item COSMIC_CLAY_BALL = registerItem("cosmic_clay_ball",
            new Item(new FabricItemSettings()));
    public static final Item COSMIC_BRICK = registerItem("cosmic_brick",
            new Item(new FabricItemSettings()));

    public static final Item COSMIC_TORCH_ITEM = registerItem("cosmic_torch_item",
            new VerticallyAttachableBlockItem(ModBlocks.COSMIC_TORCH, ModBlocks.COSMIC_WALL_TORCH, new Item.Settings(), Direction.DOWN));


    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(SAPPHIRE);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(TestMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TestMod.LOGGER.info("Registering Mod Items for " + TestMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}