package net.modfest.atlaslisbon;

import net.minecraft.util.Identifier;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AtlasLisbon implements ModInitializer {

	public static final String ID = "atlaslibon";

	public static final Logger LOGGER = LoggerFactory.getLogger(ID);

	public static Identifier id(String path) {
		return new Identifier(ID, path);
	}

	@Override
	public void onInitialize(ModContainer mod) {
		LOGGER.info("Atlas Lisbon: Mui Nobre e Sempre Leal");
	}
}
