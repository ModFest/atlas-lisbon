package net.modfest.atlaslisbon.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;

public class BottleItem extends Item {

	public BottleItem(Settings settings) {
		super(settings);
	}

	@Override
	public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
		super.finishUsing(stack, world, user);
		ItemStack bottle = Items.GLASS_BOTTLE.getDefaultStack();
		if (stack.isEmpty()) {
			return bottle;
		}
		if (user instanceof PlayerEntity player && !player.getAbilities().creativeMode) {
			if (!player.getInventory().insertStack(bottle)) {
				player.dropItem(bottle, false);
			}
		}
		return stack;
	}

	@Override
	public SoundEvent getDrinkSound() {
		return SoundEvents.ITEM_HONEY_BOTTLE_DRINK;
	}

	@Override
	public SoundEvent getEatSound() {
		return SoundEvents.ITEM_HONEY_BOTTLE_DRINK;
	}
}
