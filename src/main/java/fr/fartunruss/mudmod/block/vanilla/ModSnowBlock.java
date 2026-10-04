package fr.fartunruss.mudmod.block.vanilla;

import fr.fartunruss.mudmod.util.ModBlockTags;
import net.minecraft.block.*;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;

public class ModSnowBlock extends SnowBlock {
    public ModSnowBlock(AbstractBlock.Properties p_i48328_1_) {
        super(p_i48328_1_);
    }

    public float getShadeBrightness(BlockState p_222453_, IBlockReader p_222454_, BlockPos p_222455_) {
        return p_222453_.getValue(LAYERS) == 8 ? 0.2F : 1.0F;
    }
    @Override
    public boolean canSurvive(BlockState p_196260_1_, IWorldReader p_196260_2_, BlockPos p_196260_3_) {
        BlockState blockstate = p_196260_2_.getBlockState(p_196260_3_.below());
        if(blockstate.is(ModBlockTags.Blocks.SNOW_LAYER_CANNOT_SURVIVE_ON)){
            return false;
        } else if(blockstate.is(ModBlockTags.Blocks.SNOW_LAYER_CAN_SURVIVE_ON)){
            return true;
        } else
            return Block.isFaceFull(blockstate.getCollisionShape(p_196260_2_, p_196260_3_.below()), Direction.UP) || blockstate.is(this) && blockstate.getValue(LAYERS) == 8;
    }
}