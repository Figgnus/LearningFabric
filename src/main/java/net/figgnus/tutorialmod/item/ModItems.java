package net.figgnus.tutorialmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.figgnus.tutorialmod.TutorialMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    //new items
    public static final Item CITRINE = registerItem("citrine",
            new Item(new FabricItemSettings()));
    public static final Item RAW_CITRINE = registerItem("raw_citrine",
            new Item(new FabricItemSettings()));


    //registering
    private static Item registerItem(String name , Item item){
        return Registry.register(Registries.ITEM, new Identifier(TutorialMod.MOD_ID,name),item);
    }
    //adding items to both Ingredients and Custom Item group
    public static void addItemToItemGroup(){
       addToItemGroup(ItemGroups.INGREDIENTS,CITRINE);
       addToItemGroup(ItemGroups.INGREDIENTS,RAW_CITRINE);

       addToItemGroup(ModItemGroup.CITRINE,CITRINE);
       addToItemGroup(ModItemGroup.CITRINE,RAW_CITRINE);
    }
    //method for adding items to group
    private static void addToItemGroup(ItemGroup group,Item item){
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }
    //logger
    public static void registerModItems(){
        TutorialMod.LOGGER.info("Registering item for " + TutorialMod.MOD_ID);

        addItemToItemGroup();
    }
}
