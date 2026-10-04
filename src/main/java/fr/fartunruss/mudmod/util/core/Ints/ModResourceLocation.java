package fr.fartunruss.mudmod.util.core.Ints;

import com.mojang.serialization.DataResult;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.ResourceLocationException;

public class ModResourceLocation extends ResourceLocation{
    public ModResourceLocation(String p_i1292_1_, String p_i1292_2_) {
        super(p_i1292_1_, p_i1292_2_);
    }

    public static DataResult<ResourceLocation> read(String p_240911_0_) {
        try {
            return DataResult.success(new ResourceLocation(p_240911_0_));
        } catch (ResourceLocationException resourcelocationexception) {
            return DataResult.error("Not a valid resource location: " + p_240911_0_ + " " + resourcelocationexception.getMessage());
        }
    }
}
