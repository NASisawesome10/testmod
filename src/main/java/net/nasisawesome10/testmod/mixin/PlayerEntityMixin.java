package net.nasisawesome10.testmod.mixin;
import net.minecraft.entity.player.PlayerAbilities;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {
    @Shadow
    public int experienceLevel;
    /**
     * @author
     * @reason
     *      Creates a set amount of points needed to move to the next level.
     */
    @Overwrite()
    public int getNextLevelExperience() {
        return 100;
    }

    @ModifyConstant(method = "jump", constant = @Constant (floatValue = 0.2f))
    public float jumpSprintingExhaustion(float jSExhaustion) {
        return jSExhaustion = 0.1f;
    }

    @ModifyConstant(method = "jump", constant = @Constant (floatValue = 0.05f))
    public float jumpExhaustion(float exhaustion) {
        return exhaustion = 0.025f;
    }

}