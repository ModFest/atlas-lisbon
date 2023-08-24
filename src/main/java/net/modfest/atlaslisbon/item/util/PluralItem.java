package net.modfest.atlaslisbon.item.util;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class PluralItem extends Item {

	private final String singularKey;
	private final String pluralKey;

	public PluralItem(Settings settings, String key) {
		super(settings);
		singularKey = key + ".singular";
		pluralKey = key + ".plural";
	}

	@Override
	public String getTranslationKey(ItemStack stack) {
		return stack.getCount() == 1
			? singularKey
			: pluralKey;
	}
}
