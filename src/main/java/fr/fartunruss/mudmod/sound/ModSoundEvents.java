package fr.fartunruss.mudmod.sound;

import fr.fartunruss.mudmod.MudMod;
import fr.fartunruss.mudmod.MudModGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModSoundEvents {

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MudMod.MOD_ID);

    public static final RegistryObject<SoundEvent> MUD_BREAK = registerSoundEvent("block.mud.break");
    public static final RegistryObject<SoundEvent> MUD_STEP = registerSoundEvent("block.mud.step");
    public static final RegistryObject<SoundEvent> MUD_PLACE = registerSoundEvent("block.mud.place");
    public static final RegistryObject<SoundEvent> MUD_HIT = registerSoundEvent("block.mud.hit");
    public static final RegistryObject<SoundEvent> MUD_FALL = registerSoundEvent("block.mud.fall");


    public static final RegistryObject<SoundEvent> PACKED_MUD_BREAK = registerSoundEvent("block.packed_mud.break");
    public static final RegistryObject<SoundEvent> PACKED_MUD_STEP = registerSoundEvent("block.packed_mud.step");
    public static final RegistryObject<SoundEvent> PACKED_MUD_PLACE = registerSoundEvent("block.packed_mud.place");
    public static final RegistryObject<SoundEvent> PACKED_MUD_HIT = registerSoundEvent("block.packed_mud.hit");
    public static final RegistryObject<SoundEvent> PACKED_MUD_FALL = registerSoundEvent("block.packed_mud.fall");


    public static final RegistryObject<SoundEvent> MUD_BRICKS_BREAK = registerSoundEvent("block.mud_bricks.break");
    public static final RegistryObject<SoundEvent> MUD_BRICKS_STEP = registerSoundEvent("block.mud_bricks.step");
    public static final RegistryObject<SoundEvent> MUD_BRICKS_PLACE = registerSoundEvent("block.mud_bricks.place");
    public static final RegistryObject<SoundEvent> MUD_BRICKS_HIT = registerSoundEvent("block.mud_bricks.hit");
    public static final RegistryObject<SoundEvent> MUD_BRICKS_FALL = registerSoundEvent("block.mud_bricks.fall");

    private static RegistryObject<SoundEvent> registerSoundEvent(String name){
        return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(MudMod.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus){
        SOUND_EVENTS.register(eventBus);
    }
}
