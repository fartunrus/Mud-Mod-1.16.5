package fr.fartunruss.mudmod.block;

import fr.fartunruss.mudmod.MudMod;
import fr.fartunruss.mudmod.MudModGroup;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;
import java.util.List;

public class MudBlock extends Block {
    protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D);

    @Override
    public void appendHoverText(ItemStack p_190948_1_, @Nullable IBlockReader p_190948_2_, List<ITextComponent> tooltip, ITooltipFlag p_190948_4_) {
        if (Screen.hasShiftDown()) {
            tooltip.add(new TranslationTextComponent("tooltip." + MudMod.MOD_ID + ".mud"));
        } else
            tooltip.add(new TranslationTextComponent("tooltip." + MudMod.MOD_ID + ".hidden"));
        super.appendHoverText(p_190948_1_, p_190948_2_, tooltip, p_190948_4_);
    }

    public MudBlock(AbstractBlock.Properties properties){
        super(properties);
    }

    public VoxelShape getCollisionShape(BlockState blockState, IBlockReader iBlockReader, BlockPos blockPos, ISelectionContext iSelectionContext) {
        return SHAPE;
    }

    public VoxelShape getBlockSupportShape(BlockState blockState, IBlockReader iBlockReader, BlockPos blockPos) {
        return VoxelShapes.block();
    }

    public VoxelShape getVisualShape(BlockState blockState, IBlockReader iBlockReader, BlockPos blockPos, ISelectionContext iSelectionContext) {
        return VoxelShapes.block();
    }

    public boolean isPathfindable(BlockState blockState, IBlockReader iBlockReader, BlockPos blockPos, PathType pathType) {
        return false;
    }

    public float getShadeBrightness(BlockState blockState, IBlockReader iBlockReader, BlockPos blockPos) {
        return 0.2F;
    }
}