package net.nasisawesome10.testmod.mixin;

import net.minecraft.item.ItemStack;
import net.minecraft.item.PotionItem;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin(PotionItem.class)
public abstract class PotionItemMixin {
    @Mutable
    @Shadow @Final private static int MAX_USE_TIME = 16;
    @Overwrite
    public int getMaxUseTime(ItemStack stack) {
        return 16;
    }
}

