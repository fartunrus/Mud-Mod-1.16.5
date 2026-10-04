package fr.fartunruss.mudmod;

import fr.fartunruss.mudmod.block.util.RegistriesBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class MudModGroup {
    public static final ItemGroup MUDMOD_GROUP = new ItemGroup("MudMod") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(RegistriesBlocks.MUD.get());
        }
    };
}
