package net.krononc.mcdoomenchantable.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

import io.netty.buffer.Unpooled;


import mod.azure.doom.DoomMod;
import mod.azure.doom.item.weapons.AxeMarauderItem;
import mod.azure.doom.util.enums.DoomTier;
import mod.azure.doom.util.registry.DoomBlocks;
//import mod.azure.doom.*;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

@Mixin(value =  AxeMarauderItem.class)
public abstract class AxeMarauderItemMixin extends AxeItem{

	public AxeMarauderItemMixin() {
		super(DoomTier.DOOM_HIGHTEIR, 36, -2.4F,
				new Item.Settings().group(DoomMod.DoomWeaponItemGroup).maxCount(1).maxDamage(5));
	}

	@Override
	public boolean isEnchantable(ItemStack stack) {
		return true;
	}

	@Override
	public void appendStacks(ItemGroup group, DefaultedList<ItemStack> stacks) {
		ItemStack stack = new ItemStack(this);
		stack.hasNbt();
		if ((group == DoomMod.DoomWeaponItemGroup) || (group == ItemGroup.SEARCH)) {
			stacks.add(stack);
		}
	}

	@Override
	public void onCraft(ItemStack stack, World world, PlayerEntity player) {
		stack.hasNbt();
	}
}