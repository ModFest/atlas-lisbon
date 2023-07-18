package net.modfest.atlaslisbon;

import net.minecraft.block.Blocks;
import net.minecraft.registry.Holder;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.ChunkRegion;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;

public class SurfaceGen {
	public static void buildLisbonSurface(ChunkRegion region, Chunk chunk) {
		ChunkPos cpos = chunk.getPos();

		BlockPos.Mutable mutable = new BlockPos.Mutable();
		for (int x = 0; x < 16; x++) {
			for (int z = 0; z < 16; z++) {
				int topY = chunk.sampleHeightmap(Heightmap.Type.WORLD_SURFACE_WG, x, z);
				mutable.set((cpos.x << 4) + x, topY, (cpos.z << 4) + z);
				Holder<Biome> biome = region.getBiome(mutable);
				
				if (biome.getKey().orElseThrow().getValue().equals(AtlasLisbon.PAVED)) {
					chunk.setBlockState(mutable, Blocks.LIGHT_GRAY_CONCRETE.getDefaultState(), false);
				}
			}
		}
	}
}
