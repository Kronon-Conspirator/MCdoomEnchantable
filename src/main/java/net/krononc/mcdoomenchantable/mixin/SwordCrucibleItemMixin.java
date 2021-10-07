package net.krononc.mcdoomenchantable.mixin;

import org.spongepowered.asm.mixin.Mixin;

import mod.azure.doom.DoomMod;
import mod.azure.doom.item.weapons.SwordCrucibleItem;
//import mod.azure.doom.*;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.network.GeckoLibNetwork;
import software.bernie.geckolib3.network.ISyncable;

@Mixin(value =  SwordCrucibleItem.class)
public abstract class SwordCrucibleItemMixin extends Item implements IAnimatable, ISyncable{

	public AnimationFactory factory = new AnimationFactory(this);

	public SwordCrucibleItemMixin() {
		super(new Item.Settings().group(DoomMod.DoomWeaponItemGroup).maxCount(1).maxDamage(5));
		GeckoLibNetwork.registerSyncable(this);
	}
	
	@Override
	public AnimationFactory getFactory() {
		return this.factory;
	}

	@Override
	public boolean isEnchantable(ItemStack stack) {
		return true;
	}
}