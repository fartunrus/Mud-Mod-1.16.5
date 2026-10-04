package fr.fartunruss.mudmod.entity;

import net.minecraft.world.GameRules;
import net.minecraft.world.server.ServerWorld;

import java.util.concurrent.TimeUnit;

public class DontStopMud {
    public static boolean isStopped = false;
    public static void IfThereStoppedMud(ServerWorld world){
        if(isStopped){
            world.setDayTime(18000);
            world.getGameRules().getRule(GameRules.RULE_DAYLIGHT).set(false, world.getServer());
            DOINGIT(world);
        }
    }
    public static void DOINGIT(ServerWorld world){
        if(isStopped){
            world.getGameRules().getRule(GameRules.RULE_DAYLIGHT).set(false, world.getServer());
            System.out.println("BRING THE MUD BACK!!!!!!!!!!");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            DOINGIT(world);
        }
    }
}
