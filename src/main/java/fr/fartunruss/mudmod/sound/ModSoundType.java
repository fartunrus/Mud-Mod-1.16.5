package fr.fartunruss.mudmod.sound;

import net.minecraftforge.common.util.ForgeSoundType;


public class ModSoundType {
    public static final ForgeSoundType MUD = new ForgeSoundType(1.0F, 1.0F, ModSoundEvents.MUD_BREAK, ModSoundEvents.MUD_STEP, ModSoundEvents.MUD_PLACE, ModSoundEvents.MUD_HIT, ModSoundEvents.MUD_FALL);
    public static final ForgeSoundType PACKED_MUD = new ForgeSoundType(1.0F, 1.0F, ModSoundEvents.PACKED_MUD_BREAK, ModSoundEvents.PACKED_MUD_STEP, ModSoundEvents.PACKED_MUD_PLACE, ModSoundEvents.PACKED_MUD_HIT, ModSoundEvents.PACKED_MUD_FALL);
    public static final ForgeSoundType MUD_BRICKS = new ForgeSoundType(1.0F, 1.0F, ModSoundEvents.MUD_BRICKS_BREAK, ModSoundEvents.MUD_BRICKS_STEP, ModSoundEvents.MUD_BRICKS_PLACE, ModSoundEvents.MUD_BRICKS_HIT, ModSoundEvents.MUD_BRICKS_FALL);

}
