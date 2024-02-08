package net.nasisawesome10.testmod.mixin;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.DamageUtil;
import net.minecraft.util.math.MathHelper;
import net.nasisawesome10.testmod.sound.ModSounds;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.Slice;


@Mixin(DamageUtil.class)
public abstract class DamageUtilMixin {
    @Overwrite(remap = true)
    public static float getDamageLeft(float damage, float armor, float armorToughness) {
        float f = 2.0f + armorToughness / 4.0f;
        float g = MathHelper.clamp(armor - damage / f, armor * 0.2f, 20.0f);
        return damage * (1.0f - g / 30.0f);
    }
    @Overwrite(remap = true)
    public static float getInflictedDamage(float damageDealt, float protection) {
        float f = MathHelper.clamp(protection, 0.0f, 20.0f);
        return damageDealt * (1.0f - f / 45.0f);
    }
}