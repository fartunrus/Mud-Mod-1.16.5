package fr.fartunruss.mudmod;

import fr.fartunruss.mudmod.block.util.RegistriesBlocks;
import fr.fartunruss.mudmod.item.util.RegistriesItems;
import fr.fartunruss.mudmod.sound.ModSoundEvents;
import net.minecraft.block.Blocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//This mod was created when a person called YT_Colman say that he wouldn't add mud on his server.
//Of course he had to add, otherwise I would stop doing anything :)

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MudMod.MOD_ID)
public class MudMod
{
    public static final String MOD_ID = "mudmod";

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public MudMod() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        RegistriesItems.register(eventBus);
        RegistriesBlocks.register(eventBus);

        ModSoundEvents.register(eventBus);

        // Register the setup method for modloading
        eventBus.addListener(this::setup);
        // Register the enqueueIMC method for modloading
        // Register the onClientSetup method for modloading
        eventBus.addListener(this::onClientSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void onClientSetup(final FMLClientSetupEvent event){
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(RegistriesBlocks.MUD_BRICK_DOOR.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(RegistriesBlocks.MUD_BRICK_TRAPDOOR.get(), RenderType.cutout());

            //RenderTypeLookup.setRenderLayer(RegistriesBlocks.MUD_CROPS.get(), RenderType.cutout());
        });
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("Hello everyone on WorldOfCountries :>");
    }
}
