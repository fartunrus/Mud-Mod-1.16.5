package fr.fartunruss.mudmod.util;

import fr.fartunruss.mudmod.MudMod;
import fr.fartunruss.mudmod.MudModGroup;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;

public class ModBlockTags {


    public static class Blocks{

        public static final Tags.IOptionalNamedTag<Block> CONVERTABLE_TO_MUD =
                createTag("convertable_to_mud");
        public static final Tags.IOptionalNamedTag<Block> MANGROVE_LOGS_CAN_GROW_THROUGH =
                createTag("mangrove_logs_can_grow_through");
        public static final Tags.IOptionalNamedTag<Block> SNOW_LAYER_CANNOT_SURVIVE_ON =
                vanillaCreateTag("snow_layer_cannot_survive_on");
        public static final Tags.IOptionalNamedTag<Block> SNOW_LAYER_CAN_SURVIVE_ON =
                vanillaCreateTag("snow_layer_can_survive_on");
        private static Tags.IOptionalNamedTag<Block> createTag(String name){
            return BlockTags.createOptional(new ResourceLocation(MudMod.MOD_ID, name));
        }
        private static Tags.IOptionalNamedTag<Block> vanillaCreateTag(String name){
            return BlockTags.createOptional(new ResourceLocation("minecraft", name));
        }
        private static Tags.IOptionalNamedTag<Block> forgeCreateTag(String name){
            return BlockTags.createOptional(new ResourceLocation("forge", name));
        }
    }
    public static class Items{

        private static Tags.IOptionalNamedTag<Item> createTag(String name){
            return ItemTags.createOptional(new ResourceLocation(MudMod.MOD_ID, name));
        }
        private static Tags.IOptionalNamedTag<Item> forgeCreateTag(String name){
            return ItemTags.createOptional(new ResourceLocation("forge", name));
        }
    }
}
