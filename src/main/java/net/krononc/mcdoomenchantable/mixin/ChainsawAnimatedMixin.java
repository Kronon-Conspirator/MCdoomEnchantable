package net.krononc.mcdoomenchantable.mixin;

import org.spongepowered.asm.mixin.Mixin;

import mod.azure.doom.DoomMod;
import mod.azure.doom.item.weapons.ChainsawAnimated;

//import mod.azure.doom.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationFactory;




@Mixin(value =  ChainsawAnimated.class)
public abstract class ChainsawAnimatedMixin extends Item implements IAnimatable {

	public AnimationFactory factory = new AnimationFactory(this);
	
	@Override
	public AnimationFactory getFactory() {
		return this.factory;
	}

	public ChainsawAnimatedMixin() {
		super(new Item.Settings().group(DoomMod.DoomWeaponItemGroup).maxCount(1).maxDamage(601));
	}

	@Override
	public boolean isEnchantable(ItemStack stack) {
		return true;
	}
}