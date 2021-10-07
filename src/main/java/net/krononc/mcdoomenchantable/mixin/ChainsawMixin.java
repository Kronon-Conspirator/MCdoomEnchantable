package net.krononc.mcdoomenchantable.mixin;

import org.spongepowered.asm.mixin.Mixin;

import mod.azure.doom.DoomMod;
import mod.azure.doom.item.weapons.Chainsaw;
//import mod.azure.doom.*;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


@Mixin(value =  Chainsaw.class)
public abstract class ChainsawMixin extends Item {

	public ChainsawMixin() {
		super(new Item.Settings().group(DoomMod.DoomWeaponItemGroup).maxCount(1).maxDamage(601));
	}

	@Override
	public boolean isEnchantable(ItemStack stack) {
		return true;
	}
}