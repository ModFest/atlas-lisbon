package net.modfest.atlaslisbon;

import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.noise.NoiseParametersKeys;
import net.minecraft.world.gen.surfacebuilder.SurfaceRules;
import org.jetbrains.annotations.NotNull;
import org.quiltmc.qsl.worldgen.surface_rule.api.SurfaceRuleContext;
import org.quiltmc.qsl.worldgen.surface_rule.api.SurfaceRuleEvents;

public class LisbonSurfaceRules implements SurfaceRuleEvents.OverworldModifierCallback {
	@Override
	public void modifyOverworldRules(SurfaceRuleContext.@NotNull Overworld context) {
		context.materialRules().add(0,
			SurfaceRules.condition(
				SurfaceRules.biome(RegistryKey.of(RegistryKeys.BIOME, AtlasLisbon.PAVED)),
				SurfaceRules.condition(
					SurfaceRules.ON_FLOOR,
					SurfaceRules.condition(
						SurfaceRules.abovePreliminarySurface(),
						SurfaceRules.sequence(
							SurfaceRules.condition(
								SurfaceRules.water(0, 0),
								SurfaceRules.block(Blocks.LIGHT_GRAY_CONCRETE.getDefaultState())
							),
							SurfaceRules.block(Blocks.GRAVEL.getDefaultState())
						)
					)
				)
			)
		);
	}
}
