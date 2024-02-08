package net.nasisawesome10.testmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.nasisawesome10.testmod.block.ModBlocks;
import net.nasisawesome10.testmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.AnyOfLootCondition;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.SAPPHIRE_BLOCK);
        addDrop(ModBlocks.CHISELED_END_STONE_BRICKS);
        addDrop(ModBlocks.COSMIC_BRICKS);

        addDrop(ModBlocks.END_SAPPHIRE_ORE, copperLikeOreDrops(ModBlocks.END_SAPPHIRE_ORE, ModItems.SAPPHIRE));


        addDrop(ModBlocks.COSMIC_BRICK_WALL);

        addDrop(ModBlocks.END_STONE_SLAB, slabDrops(ModBlocks.END_STONE_SLAB));
        addDrop(ModBlocks.COSMIC_BRICK_SLAB, slabDrops(ModBlocks.COSMIC_BRICK_SLAB));
    }

    public LootTable.Builder copperLikeOreDrops(Block drop, Item item) {
        return BlockLootTableGenerator.dropsWithSilkTouch(drop, (LootPoolEntry.Builder)this.applyExplosionDecay(drop,
                ((LeafEntry.Builder)
                        ItemEntry.builder(item)
                                .apply(SetCountLootFunction
                                        .builder(UniformLootNumberProvider
                                                .create(2.0f, 5.0f))))
                        .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    }
}