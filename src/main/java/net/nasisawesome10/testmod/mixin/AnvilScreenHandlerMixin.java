package net.nasisawesome10.testmod.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.entity.player.PlayerAbilities;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.*;
import net.minecraft.util.ActionResult;
import net.nasisawesome10.testmod.event.UpdateAnvilCallback;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(AnvilScreenHandler.class)
public abstract class AnvilScreenHandlerMixin extends ForgingScreenHandler {
    @Shadow
    public abstract int getLevelCost();

    @Shadow private String newItemName;

    public AnvilScreenHandlerMixin(@Nullable ScreenHandlerType<?> type, int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(type, syncId, playerInventory, context);
    }
    @Shadow @Final
    private Property levelCost;

    @Shadow private int repairItemUsage;
    @ModifyConstant(method = "updateResult", constant = @Constant(intValue = 40))
    private int tooExpensiveRemoval(int constant) {
        constant = 80;
        System.out.println(constant);
        return constant;
    }

    @ModifyConstant(method = "updateResult", constant = @Constant(intValue = 39))
    private int tooExpensiveRemovalMinusOne(int constant) {
        constant = 79;
        System.out.println(constant);
        return constant;
    }

    @Redirect(at = @At(value = "INVOKE", target = "Lnet/minecraft/screen/Property;get()I"), method = "canTakeOutput")
    private int canTakeOutput(Property property) {
        return Math.min(Math.abs(property.get()), 80);
    }

    @Redirect(at = @At(value = "INVOKE", target = "Lnet/minecraft/screen/Property;get()I"), method = "onTakeOutput")
    private int onTakeOutput(Property property) {
        return Math.min(Math.abs(property.get()), 80);
    }

    @Redirect(at = @At(value = "INVOKE", target = "Lnet/minecraft/screen/Property;get()I"), method = "updateResult")
    private int get(Property property) {
        return Math.min(Math.abs(property.get()), 80);
    }

    @Redirect(
            method = "updateResult",
            at = @At(
                    value = "FIELD",
                    target = "Lnet/minecraft/entity/player/PlayerAbilities;creativeMode:Z",
                    ordinal = 1
            )
    )
    private boolean hookUpdateResultTooExpensive(PlayerAbilities abilities) {
        return abilities.creativeMode;
    }
    /*
    @Inject(
            method = "updateResult",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/item/ItemStack;isDamageable()Z"
            ),
            cancellable = true,
            locals = LocalCapture.CAPTURE_FAILHARD
    )

    private void hookUpdateResultUpdateAnvil(CallbackInfo ci, ItemStack left, int i, int baseCost, int k, ItemStack itemStack2, ItemStack right) {
        ActionResult result = UpdateAnvilCallback.EVENT.invoker().interact((AnvilScreenHandler)(Object)this, left, right, this.output, this.newItemName, baseCost, this::applyUpdateAnvil);
        if (result == ActionResult.SUCCESS)
            ci.cancel();
    }

    private void applyUpdateAnvil(ItemStack out, int xpCost, int materialCost) {
        output.setStack(0, out);
        levelCost.set(xpCost);
        repairItemUsage = materialCost;
    }

     */

    @Redirect(at = @At(value = "INVOKE", target = "Lnet/minecraft/screen/Property;get()I"), method = "getLevelCost")
    private int getLevelCost(Property property) {
        return Math.min(Math.abs(property.get()), 80);
    }



    @ModifyReturnValue(method = "getNextCost", at = @At("RETURN"))
    private static int flatCost(int newCost) {
        return newCost = 3;
    }
    // OLD: public static int getNextCost(int cost) { return cost * 2 + 1; }
}