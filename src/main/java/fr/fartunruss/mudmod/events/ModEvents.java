package fr.fartunruss.mudmod.events;

import fr.fartunruss.mudmod.MudMod;
import fr.fartunruss.mudmod.commands.SetMudStopped;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.ConfigCommand;

@Mod.EventBusSubscriber(modid = MudMod.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void onCommandsRegister(RegisterCommandsEvent event){
        new SetMudStopped(event.getDispatcher());
        ConfigCommand.register(event.getDispatcher());
    }
}
