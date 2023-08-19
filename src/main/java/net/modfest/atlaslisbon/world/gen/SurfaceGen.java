package net.modfest.atlaslisbon.world.gen;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Holder;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.ChunkRegion;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.modfest.atlaslisbon.AtlasLisbon;

public class SurfaceGen {

	public static final Identifier PAVED = AtlasLisbon.id("paved");
	public static final Identifier PODZOL = AtlasLisbon.id("podzol");

	public static Block getSurface(Holder<Biome> biome) {
		Identifier biomeKey = biome.getKey().orElseThrow().getValue();
		if (biomeKey.equals(PAVED)) {
			return Blocks.CYAN_TERRACOTTA;
		}
		if (biomeKey.equals(PODZOL)) {
			return Blocks.PODZOL;
		}
		return null;
	}

	public static void buildLisbonSurface(ChunkRegion region, Chunk chunk) {
		ChunkPos chunkPos = chunk.getPos();
		BlockPos.Mutable blockPos = new BlockPos.Mutable();
		for (int x = 0; x < 16; x++) {
			for (int z = 0; z < 16; z++) {
				int topY = chunk.sampleHeightmap(Heightmap.Type.WORLD_SURFACE_WG, x, z);
				blockPos.set((chunkPos.x << 4) + x, topY, (chunkPos.z << 4) + z);
				Holder<Biome> biome = region.getBiome(blockPos);
				Block surface = getSurface(biome);
				if (surface != null) {
					chunk.setBlockState(blockPos, surface.getDefaultState(), false);
				}
			}
		}
	}
}
