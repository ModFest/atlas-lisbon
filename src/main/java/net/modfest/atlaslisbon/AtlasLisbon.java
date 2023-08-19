package net.modfest.atlaslisbon;

import net.minecraft.util.Identifier;
import net.modfest.atlaslisbon.item.LisbonItems;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.quiltmc.qsl.resource.loader.api.ResourceLoader;
import org.quiltmc.qsl.resource.loader.api.ResourcePackActivationType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AtlasLisbon implements ModInitializer {

	public static final String ID = "atlaslisbon";
	public static final Identifier PAVED = id("paved");
	public static final Identifier PODZOL = id("podzol");

	public static final Logger LOGGER = LoggerFactory.getLogger(ID);

	public static Identifier id(String path) {
		return new Identifier(ID, path);
	}

	@Override
	public void onInitialize(ModContainer mod) {
		LOGGER.info("Atlas Lisbon: Mui Nobre e Sempre Leal");
		LisbonItems.register();
		registerPack(mod);
	}

	public static void registerPack(ModContainer mod) {
		ResourceLoader.registerBuiltinResourcePack(id("dimension"), mod, ResourcePackActivationType.DEFAULT_ENABLED);
	}
}
