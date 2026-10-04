package fr.fartunruss.mudmod.commands;

import com.mojang.brigadier.CommandDispatcher;
import fr.fartunruss.mudmod.entity.DontStopMud;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;

import java.util.concurrent.TimeUnit;

public class SetMudStopped {
    public SetMudStopped(CommandDispatcher<CommandSource> dispatcher){
        dispatcher.register(Commands.literal("mm").then(Commands.literal("true").executes((context -> {
            DontStopMud.isStopped = true;
            return 0;
        }))));
    }
}
