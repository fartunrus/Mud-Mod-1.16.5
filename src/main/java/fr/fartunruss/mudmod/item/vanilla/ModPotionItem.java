package fr.fartunruss.mudmod.item.vanilla;

import fr.fartunruss.mudmod.block.util.RegistriesBlocks;
import fr.fartunruss.mudmod.util.ModBlockTags;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.stats.Stats;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class ModPotionItem extends PotionItem {
    public ModPotionItem(Properties p_i48476_1_) {
        super(p_i48476_1_);
    }
    public ActionResultType useOn(ItemUseContext p_220235_) {
        World level = p_220235_.getLevel();
        BlockPos blockpos = p_220235_.getClickedPos();
        PlayerEntity player = p_220235_.getPlayer();
        ItemStack itemstack = p_220235_.getItemInHand();
        BlockState blockstate = level.getBlockState(blockpos);
        if (p_220235_.getClickedFace() != Direction.DOWN && blockstate.is(ModBlockTags.Blocks.CONVERTABLE_TO_MUD) && PotionUtils.getPotion(itemstack) == Potions.WATER) {
            level.playSound((PlayerEntity) null, blockpos, SoundEvents.GENERIC_SPLASH, SoundCategory.PLAYERS, 1.0F, 1.0F);
            player.setItemInHand(p_220235_.getHand(), DrinkHelper.createFilledResult(itemstack, player, new ItemStack(Items.GLASS_BOTTLE)));
            player.awardStat(Stats.ITEM_USED.get(itemstack.getItem()));
            if (!level.isClientSide) {
                ServerWorld serverlevel = (ServerWorld) level;

                for(int i = 0; i < 5; ++i) {
                    serverlevel.sendParticles(ParticleTypes.SPLASH, (double)blockpos.getX() + level.random.nextDouble(), (double)(blockpos.getY() + 1), (double)blockpos.getZ() + level.random.nextDouble(), 1, 0.0D, 0.0D, 0.0D, 1.0D);
                }
            }

            level.playSound((PlayerEntity) null, blockpos, SoundEvents.BOTTLE_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);
            level.setBlockAndUpdate(blockpos, RegistriesBlocks.MUD.get().defaultBlockState());
            return ActionResultType.sidedSuccess(level.isClientSide);
        } else {
            return ActionResultType.PASS;
        }
    }
}