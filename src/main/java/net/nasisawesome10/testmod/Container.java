package net.nasisawesome10.testmod;

import net.minecraft.block.CropBlock;
import net.nasisawesome10.testmod.access.CropBlockAccess;

public class Container {
    public void slapHaykam(CropBlock instance) {
        ((CropBlockAccess)instance).access(); // Will print "Accessed!"
    }
}
