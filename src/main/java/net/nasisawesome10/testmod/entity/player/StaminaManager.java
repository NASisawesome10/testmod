package net.nasisawesome10.testmod.entity.player;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;

public class StaminaManager {
    private int staminaLevel = 100;
    private boolean decreaseStamina = false;
    private int prevStaminaLevel = 100;

    // Add this to PlayerEntity
    public void readNbt(NbtCompound nbt) {
        if (nbt.contains("foodLevel", NbtElement.NUMBER_TYPE)) {
            this.staminaLevel = nbt.getInt("staminaLevel");
        }
    }

    private int changeStamina() {
        if (!this.decreaseStamina) {
            this.staminaLevel -= 1;
        }
        return 1;
    }

    public int getFoodLevel() {
        return this.staminaLevel;
    }

    public int getPrevFoodLevel() {
        return this.prevStaminaLevel;
    }
}
