package net.modfest.atlaslisbon.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.modfest.atlaslisbon.AtlasLisbon;
import net.modfest.atlaslisbon.item.util.BottleItem;
import net.modfest.atlaslisbon.item.util.PluralItem;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class LisbonItems {

	public static final Item PASTEL_DE_NATA = new PluralItem(new QuiltItemSettings()
		.food(new FoodComponent.Builder()
			.alwaysEdible()
			.snack()
			.hunger(3)
			.saturationModifier(0.3f)
			.statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 100), 1.0f)
			.build()),
		"item.atlaslisbon.pastel_de_nata");

	public static final Item QUEIJO_DE_AZEITAO = new Item(new QuiltItemSettings()
		.food(new FoodComponent.Builder()
			.alwaysEdible()
			.hunger(4)
			.saturationModifier(0.6f)
			.build()));

	public static final Item GINJINHA_BOTTLE = new BottleItem(new QuiltItemSettings()
		.food(new FoodComponent.Builder()
			.alwaysEdible()
			.hunger(6)
			.saturationModifier(0.2f)
			.statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 100), 0.75f)
			.statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 100), 0.75f)
			.build()));

	public static final Item QUEIJADA_DA_GRACIOSA = new PluralItem(new QuiltItemSettings()
		.food(new FoodComponent.Builder()
			.alwaysEdible()
			.snack()
			.hunger(2)
			.saturationModifier(0.5f)
			.statusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 500), 1.0f)
			.build()),
		"item.atlaslisbon.queijada_da_graciosa");

	public static void registerItem(Item item, String name) {
		Registry.register(Registries.ITEM, AtlasLisbon.id(name), item);
	}

	public static void register() {
		registerItem(PASTEL_DE_NATA, "pastel_de_nata");
		registerItem(QUEIJO_DE_AZEITAO, "queijo_de_azeitao");
		registerItem(GINJINHA_BOTTLE, "ginjinha_bottle");
		registerItem(QUEIJADA_DA_GRACIOSA, "queijada_da_graciosa");
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINKS).register(entries -> {
			entries.addAfter(Items.PUMPKIN_PIE, PASTEL_DE_NATA, QUEIJO_DE_AZEITAO, QUEIJADA_DA_GRACIOSA);
			entries.addAfter(Items.HONEY_BOTTLE, GINJINHA_BOTTLE);
		});
	}
}
