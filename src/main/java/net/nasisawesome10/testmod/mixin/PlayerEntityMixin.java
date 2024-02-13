package net.nasisawesome10.testmod.mixin;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

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
}