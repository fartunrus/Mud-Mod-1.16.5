package fr.fartunruss.mudmod.block.util;

import fr.fartunruss.mudmod.MudMod;
import fr.fartunruss.mudmod.MudModGroup;
//import fr.fartunruss.mudmod.block.MudCropsBlock;
import fr.fartunruss.mudmod.block.vanilla.ModSnowBlock;
import fr.fartunruss.mudmod.block.MudBlock;
import fr.fartunruss.mudmod.item.util.RegistriesItems;
import fr.fartunruss.mudmod.sound.ModSoundType;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class RegistriesBlocks {

    private static Boolean always(BlockState blockState, IBlockReader iBlockReader, BlockPos blockPos, EntityType<?> entityType) {
        return true;
    }

    private static boolean always(BlockState blockState, IBlockReader iBlockReader, BlockPos blockPos) {
        return true;
    }

    private static Boolean ocelotOrParrot(BlockState p_50822_, IBlockReader p_50823_, BlockPos p_50824_, EntityType<?> p_50825_) {
        return (boolean)(p_50825_ == EntityType.OCELOT || p_50825_ == EntityType.PARROT);
    }
    private static boolean never(BlockState p_50806_, IBlockReader p_50807_, BlockPos p_50808_) {
        return false;
    }
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MudMod.MOD_ID);
    public static final DeferredRegister<Block> VANILLA_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "minecraft");


    //blocks
    public static final RegistryObject<Block> MUD =
            registerBlock("mud"
                    , () -> new MudBlock(AbstractBlock.Properties.of(Material.DIRT, MaterialColor.TERRACOTTA_CYAN)
                            .isValidSpawn(RegistriesBlocks::always)
                            .isRedstoneConductor(RegistriesBlocks::always)
                            .isViewBlocking(RegistriesBlocks::always)
                            .isSuffocating(RegistriesBlocks::always)
                            .strength(0.5F, 0.5F) //hardness, blast resistance
                            .sound(ModSoundType.MUD)
                            .harvestTool(ToolType.SHOVEL)
                            .harvestLevel(0)
                    ));
    public static final RegistryObject<Block> PACKED_MUD =
            registerBlock("packed_mud"
                    , () -> new Block(AbstractBlock.Properties.copy(Blocks.DIRT)
                            .strength(1.0F, 3.0F)
                            .sound(ModSoundType.PACKED_MUD)
                            .harvestTool(ToolType.PICKAXE)
                            .harvestLevel(0)));
    public static final RegistryObject<Block> MUD_BRICKS =
            registerBlock("mud_bricks"
            , () -> new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_LIGHT_GRAY)
                            .requiresCorrectToolForDrops()
                            .strength(1.5F, 3.0F)
                            .sound(ModSoundType.MUD_BRICKS)
                            .harvestTool(ToolType.PICKAXE)
                            .harvestLevel(1)));
    //:noFull
    public static final RegistryObject<Block> MUD_BRICK_STAIRS =
            registerBlock("mud_brick_stairs"
            , () -> new StairsBlock(() -> MUD_BRICKS.get().defaultBlockState(),
                            AbstractBlock.Properties.copy(MUD_BRICKS.get())));
    public static final RegistryObject<Block> MUD_BRICK_SLAB =
            registerBlock("mud_brick_slab"
                    , () -> new SlabBlock(AbstractBlock.Properties.copy(MUD_BRICKS.get())));
    public static final RegistryObject<Block> MUD_BRICK_WALL =
            registerBlock("mud_brick_wall"
                    , () -> new WallBlock(AbstractBlock.Properties.copy(MUD_BRICKS.get())));
    public static final RegistryObject<Block> MUD_BRICK_FENCE =
            registerBlock("mud_brick_fence"
                    , () -> new FenceBlock(AbstractBlock.Properties.copy(MUD_BRICKS.get())));
    public static final RegistryObject<Block> MUD_BRICK_FENCE_GATE =
            registerBlock("mud_brick_fence_gate"
                    , () -> new FenceGateBlock(AbstractBlock.Properties.copy(MUD_BRICKS.get())));
    public static final RegistryObject<Block> MUD_BUTTON =
            registerBlock("packed_mud_button"
                    , () -> new WoodButtonBlock(AbstractBlock.Properties.copy(PACKED_MUD.get())
                            .noCollission()));
    public static final RegistryObject<Block> MUD_PRESSURE_PLATE =
            registerBlock("packed_mud_pressure_plate"
                    , () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING
                            ,AbstractBlock.Properties.copy(PACKED_MUD.get())));
    public static final RegistryObject<Block> MUD_BRICK_DOOR =
            registerBlock("mud_brick_door"
                    , () -> new DoorBlock(AbstractBlock.Properties.copy(MUD_BRICKS.get())
                            .noOcclusion()));
    public static final RegistryObject<Block> MUD_BRICK_TRAPDOOR =
            registerBlock("mud_brick_trapdoor"
                    , () -> new TrapDoorBlock(AbstractBlock.Properties.copy(MUD_BRICKS.get())
                            .noOcclusion()));
    private static RotatedPillarBlock log(MaterialColor p_235430_0_, MaterialColor p_235430_1_) {
        return new RotatedPillarBlock(AbstractBlock.Properties.of(Material.WOOD, (p_235431_2_) -> {
            return p_235431_2_.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? p_235430_0_ : p_235430_1_;
        }).strength(2.0F).sound(SoundType.WOOD));
    }
    //plants
/*    public static final RegistryObject<Block> MUD_CROPS =
            BLOCKS.register("mud_crops"
            ,() -> new MudCropsBlock(AbstractBlock.Properties.copy(Blocks.WHEAT)));*/
    //vanilla
    /**public static final Block SCULK_SENSOR =
            registerBlock("sculk_sensor"
                    , () -> new SculkSensorBlock(AbstractBlock.Properties.of(Material.SCULK, MaterialColor.COLOR_CYAN)
                            .strength(1.5F)
                            .sound(SoundType.SCULK_SENSOR)
                            .lightLevel((p_187406_) -> {
        return 1;
    }).emissiveRendering((p_187412_, p_187413_, p_187414_) -> {
        return SculkSensorBlock.getPhase(p_187412_) == SculkSensorPhase.ACTIVE;
    }), 8));*/



    public static final RegistryObject<Block> SNOW =
            registerVanillaBlock("snow"
                    , () -> new ModSnowBlock(AbstractBlock.Properties.of(Material.TOP_SNOW)
                            .randomTicks()
                            .strength(0.1F)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.SNOW)), ItemGroup.TAB_DECORATIONS);


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<T> registerVanillaBlock(String name, Supplier<T> block, ItemGroup itemGroup) {
        RegistryObject<T> toReturn = VANILLA_BLOCKS.register(name, block);
        registerVanillaBlockItem(name, toReturn, itemGroup);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
            RegistriesItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                    new Item.Properties().tab(MudModGroup.MUDMOD_GROUP)));
    }
    private static <T extends Block> void registerVanillaBlockItem(String name, RegistryObject<T> block, ItemGroup itemGroup) {
            RegistriesItems.VANILLA_ITEM.register(name, () -> new BlockItem(block.get(),
                    new Item.Properties().tab(itemGroup)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        VANILLA_BLOCKS.register(eventBus);
    }
}
