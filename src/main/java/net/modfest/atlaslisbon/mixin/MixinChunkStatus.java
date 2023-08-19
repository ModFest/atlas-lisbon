package net.modfest.atlaslisbon.mixin;

import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.ChunkRegion;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkStatus;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.modfest.atlaslisbon.world.gen.SurfaceGen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.List;

@Mixin(ChunkStatus.class)
public class MixinChunkStatus {
	@Inject(method = "method_16569", at = @At("TAIL"), locals = LocalCapture.CAPTURE_FAILHARD)
	private static void handleBuildSurface(ChunkStatus targetStatus, ServerWorld world, ChunkGenerator chunkGenerator, List chunks, Chunk chunk, CallbackInfo ci, ChunkRegion region) {
		// The nuclear option -- i'm sorry

		SurfaceGen.buildLisbonSurface(region, chunk);
	}
}
