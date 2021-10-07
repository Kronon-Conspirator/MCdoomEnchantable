package net.krononc.mcdoomenchantable.mixin;

import org.spongepowered.asm.mixin.Mixin;

import mod.azure.doom.item.weapons.DoomBaseItem;
//import mod.azure.doom.*;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.network.GeckoLibNetwork;
import software.bernie.geckolib3.network.ISyncable;

@Mixin(value =  DoomBaseItem.class)
public abstract class DoomBaseItemMixin extends Item implements IAnimatable, ISyncable{

	public AnimationFactory factory = new AnimationFactory(this);
	public String controllerName = "controller";
	
	public DoomBaseItemMixin(Settings properties) {
		super(properties);
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