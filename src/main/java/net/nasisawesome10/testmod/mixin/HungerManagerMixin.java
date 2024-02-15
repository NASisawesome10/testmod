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
        return foodToHeal = 10;
    }
    // Removes Fast Healing
    @ModifyConstant(method = "update", constant = @Constant(intValue = 20))
    public int removeFastHealing(int foodToFastHeal) {
        return foodToFastHeal = -1;
    }
    @ModifyConstant(method = "update", constant = @Constant(intValue = 80))
    public int foodHealingDifficulty(int foodToFastHeal, PlayerEntity player) {
        Difficulty difficulty = player.getWorld().getDifficulty();
        return switch (difficulty) {
            case HARD -> foodToFastHeal;
            case NORMAL -> foodToFastHeal /= 2;
            case EASY -> foodToFastHeal /= 4;
            default -> foodToFastHeal /= 2;
        };
    }
}

