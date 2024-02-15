package net.nasisawesome10.testmod.mixin;


import net.minecraft.entity.player.HungerManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(HungerManager.class)
public class HungerManagerMixin {
    @ModifyConstant(method = "update", constant = @Constant(intValue = 18))
    public int foodHealing(int foodToHeal) {
        return foodToHeal = 11;
    }
    // Removes Fast Healing
    @ModifyConstant(method = "update", constant = @Constant(intValue = 20))
    public int removeFastHealing(int foodToFastHeal) {
        return foodToFastHeal = Integer.MAX_VALUE;
    }
    @ModifyConstant(method = "update", constant = @Constant(intValue = 80))
    public int foodHealingDifficulty(int foodToFastHeal, PlayerEntity player) {
        Difficulty difficulty = player.getWorld().getDifficulty();
        return switch (difficulty) {
            case HARD -> foodToFastHeal = 60;
            case NORMAL -> foodToFastHeal /= 4;
            case EASY -> foodToFastHeal /= 6;
            default -> foodToFastHeal /= 2;
        };
    }
}

