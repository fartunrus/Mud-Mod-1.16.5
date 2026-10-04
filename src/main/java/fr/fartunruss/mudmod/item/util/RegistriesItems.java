package fr.fartunruss.mudmod.item.util;

import fr.fartunruss.mudmod.MudMod;
import fr.fartunruss.mudmod.MudModGroup;
import fr.fartunruss.mudmod.block.util.RegistriesBlocks;
import fr.fartunruss.mudmod.item.armor.MudArmorItem;
import fr.fartunruss.mudmod.item.vanilla.ModPotionItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistriesItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MudMod.MOD_ID);
    public static final DeferredRegister<Item> VANILLA_ITEM = DeferredRegister.create(ForgeRegistries.ITEMS, "minecraft");

    //tools
    
    /*             public static final RegistryObject<Item> MUD_PICKAXE =
            ITEMS.register("mud_pickaxe"
                    ,() -> new PickaxeItem(ModItemTier.PACKED_MUD, 2, -2.8f,
                            new Item.Properties().tab(MudModGroup.MUDMOD_GROUP)));
    public static final RegistryObject<Item> MUD_SHOVEL =
            ITEMS.register("mud_shovel"
                    ,() -> new ShovelItem(ModItemTier.PACKED_MUD, 1, -3f,
                            new Item.Properties().tab(MudModGroup.MUDMOD_GROUP)));
    public static final RegistryObject<Item> MUD_AXE =
            ITEMS.register("mud_axe"
                    ,() -> new AxeItem(ModItemTier.PACKED_MUD, 5, -3.1f,
                            new Item.Properties().tab(MudModGroup.MUDMOD_GROUP)));
    public static final RegistryObject<Item> MUD_HOE =
            ITEMS.register("mud_hoe"
                    ,() -> new HoeItem(ModItemTier.PACKED_MUD, -1, -1f,
                            new Item.Properties().tab(MudModGroup.MUDMOD_GROUP)));
    public static final RegistryObject<Item> MUD_SWORD =
            ITEMS.register("mud_sword"
                    ,() -> new SwordItem(ModItemTier.PACKED_MUD, 3, -2.4f,
                            new Item.Properties().tab(MudModGroup.MUDMOD_GROUP)));
    //armor
    public static final RegistryObject<Item> MUD_BOOTS =
            ITEMS.register("mud_boots"
                    ,() -> new MudArmorItem(ModArmorMaterial.PACKED_MUD, EquipmentSlotType.FEET,
                            new Item.Properties().tab(MudModGroup.MUDMOD_GROUP)));
    public static final RegistryObject<Item> MUD_CHEST =
            ITEMS.register("mud_chest"
                    ,() -> new MudArmorItem(ModArmorMaterial.PACKED_MUD, EquipmentSlotType.CHEST,
                            new Item.Properties().tab(MudModGroup.MUDMOD_GROUP)));
    public static final RegistryObject<Item> MUD_HELMET =
            ITEMS.register("mud_helmet"
                    ,() -> new MudArmorItem(ModArmorMaterial.PACKED_MUD, EquipmentSlotType.HEAD,
                            new Item.Properties().tab(MudModGroup.MUDMOD_GROUP)));
    public static final RegistryObject<Item> MUD_LEGGINGS =
            ITEMS.register("mud_leggings"
                    ,() -> new MudArmorItem(ModArmorMaterial.PACKED_MUD, EquipmentSlotType.LEGS,
                            new Item.Properties().tab(MudModGroup.MUDMOD_GROUP)));
    //plants
    public static final RegistryObject<Item> MUD_CROPS =
            ITEMS.register("mud_crops"
                    ,() -> new BlockItem(RegistriesBlocks.MUD_CROPS.get(), new Item.Properties()
                            .food(new Food.Builder()
                                    .nutrition(2)
                                    .saturationMod(0.2f)
                                    .fast().build())
                            .tab(MudModGroup.MUDMOD_GROUP))); */
    //vanilla
    public static final RegistryObject<Item> POTION = VANILLA_ITEM.register("potion", () -> new ModPotionItem((new Item.Properties()).stacksTo(1).tab(ItemGroup.TAB_BREWING)));

    public static void register(IEventBus eventbus){
        ITEMS.register(eventbus);
        VANILLA_ITEM.register(eventbus);
    }
}
