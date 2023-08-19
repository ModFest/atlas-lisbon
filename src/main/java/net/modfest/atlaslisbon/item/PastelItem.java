package net.modfest.atlaslisbon.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class PastelItem extends Item {

	public static final String BASE_KEY = "item.atlaslisbon.pastel_de_nata";
	public static final String SINGULAR_KEY = BASE_KEY + ".singular";
	public static final String PLURAL_KEY = BASE_KEY + ".plural";

	public PastelItem(Settings settings) {
		super(settings);
	}

	@Override
	public String getTranslationKey(ItemStack stack) {
		return stack.getCount() == 1
			? SINGULAR_KEY
			: PLURAL_KEY;
	}
}
