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

public class LibsonSurfaceRules implements SurfaceRuleEvents.OverworldModifierCallback {
	@Override
	public void modifyOverworldRules(SurfaceRuleContext.@NotNull Overworld context) {
		context.materialRules().add(0,
			SurfaceRules.condition(
				SurfaceRules.abovePreliminarySurface(),
				SurfaceRules.sequence(
					SurfaceRules.condition(
						SurfaceRules.ON_FLOOR,
						SurfaceRules.sequence(
							SurfaceRules.condition(
								SurfaceRules.biome(RegistryKey.of(RegistryKeys.BIOME, new Identifier("atlaslisbon", "paved"))),
								SurfaceRules.block(Blocks.LIGHT_GRAY_CONCRETE.getDefaultState())
							)
						)
					),
					//
					SurfaceRules.condition(
						SurfaceRules.UNDER_FLOOR,
						SurfaceRules.sequence(
							SurfaceRules.condition(
								SurfaceRules.biome(RegistryKey.of(RegistryKeys.BIOME, new Identifier("atlaslisbon", "paved"))),
								SurfaceRules.block(Blocks.STONE.getDefaultState())
							),
							SurfaceRules.condition(SurfaceRules.noiseThreshold(NoiseParametersKeys.ICE, -0.0625, 0.025),
								SurfaceRules.condition(
									SurfaceRules.biome(RegistryKey.of(RegistryKeys.BIOME, new Identifier("atlaslisbon", "paved"))),
									SurfaceRules.block(Blocks.GRAVEL.getDefaultState())
								)
							)
						)
					)
				)
			)
		);
	}
}
