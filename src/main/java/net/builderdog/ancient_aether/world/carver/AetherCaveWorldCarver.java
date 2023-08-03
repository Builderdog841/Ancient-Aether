package net.builderdog.ancient_aether.world.carver;

import com.mojang.serialization.Codec;
import java.util.function.Function;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.chunk.CarvingMask;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.Aquifer;
import net.minecraft.world.level.levelgen.carver.CarverConfiguration;
import net.minecraft.world.level.levelgen.carver.CarvingContext;
import net.minecraft.world.level.levelgen.carver.CaveCarverConfiguration;
import net.minecraft.world.level.levelgen.carver.CaveWorldCarver;
import org.apache.commons.lang3.mutable.MutableBoolean;

//public class AetherCaveWorldCarver extends CaveWorldCarver {
 //   public AetherCaveWorldCarver(Codec<CaveCarverConfiguration> pCodec) {
      //  super(pCodec);
  //  }

  //  protected boolean carveBlock(CarvingContext pContext, CaveCarverConfiguration pConfig, ChunkAccess pChunk, Function<BlockPos, Holder<Biome>> pBiomeGetter, CarvingMask pCarvingMask, BlockPos.MutableBlockPos pPos, BlockPos.MutableBlockPos pCheckPos, Aquifer pAquifer, MutableBoolean pReachedSurface) {
    //    BlockState blockstate = pChunk.m_8055_(pPos);
     //   if (blockstate.m_60713_(Blocks.f_50440_) || blockstate.m_60713_(Blocks.f_50195_)) {
     //       pReachedSurface.setTrue();
    //    }

     //   if (!this.m_224910_(pConfig, blockstate) && !isDebugEnabled(pConfig)) {
      //      return false;
      //  } else {
         //   BlockState blockstate1 = this.getCarveState(pContext, pConfig, pPos, pAquifer);
        //    if (blockstate1 == null) {
       //         return false;
        //    } else {
       //         pChunk.m_6978_(pPos, blockstate1, false);
        //        if (pAquifer.m_142203_() && !blockstate1.m_60819_().m_76178_()) {
       //             pChunk.m_8113_(pPos);
       //         }

        //        if (pReachedSurface.isTrue()) {
       //             pCheckPos.m_122159_(pPos, Direction.DOWN);
         //           if (pChunk.m_8055_(pCheckPos).m_60713_(Blocks.f_50493_)) {
        //                pContext.m_190646_(pBiomeGetter, pChunk, pCheckPos, !blockstate1.m_60819_().m_76178_()).ifPresent((p_272572_) -> {
         //                   pChunk.m_6978_(pCheckPos, p_272572_, false);
        //                    if (!p_272572_.m_60819_().m_76178_()) {
          //                      pChunk.m_8113_(pCheckPos);
         //                   }

          //              });
          //          }
          //      }

            //    return true;
         //   }
       // }
   // }

   // protected static boolean isDebugEnabled(CarverConfiguration pConfig) {
     //   return pConfig.f_159092_.m_159128_();
    //}

   // protected static BlockState getDebugState(CarverConfiguration pConfig, BlockState pState) {
     //   if (pState.m_60713_(Blocks.f_50016_)) {
      //      return pConfig.f_159092_.m_159145_();
      //  } else if (pState.m_60713_(Blocks.f_49990_)) {
       //     BlockState blockstate = pConfig.f_159092_.m_159146_();
       //     return blockstate.m_61138_(BlockStateProperties.f_61362_) ? (BlockState)blockstate.m_61124_(BlockStateProperties.f_61362_, true) : blockstate;
      //  } else {
      //      return pState.m_60713_(Blocks.f_49991_) ? pConfig.f_159092_.m_159147_() : pState;
     //   }
   // }

   // @Nullable
   // private BlockState getCarveState(CarvingContext pContext, CaveCarverConfiguration pConfig, BlockPos pPos, Aquifer pAquifer) {
     //   BlockState blockstate = Blocks.f_50627_.m_49966_();
     //   if (blockstate == null) {
     //       return isDebugEnabled(pConfig) ? pConfig.f_159092_.m_159148_() : null;
     //   } else {
     //       return isDebugEnabled(pConfig) ? getDebugState(pConfig, blockstate) : blockstate;
     //   }
  //  }
//}
