package net.figgnus.tutorialmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.figgnus.tutorialmod.TutorialMod;
import net.figgnus.tutorialmod.item.ModItemGroup;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    //adding block
    public static final Block CITRINE_BLOCK = registerBlocks("citrine_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool()), ModItemGroup.CITRINE);

    public static final Block CITRINE_ORE = registerBlocks("citrine_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE)
                    .strength(4.0f)
                    .requiresTool(),
                    UniformIntProvider.create(3, 7)),
                    ModItemGroup.CITRINE);
    public static final Block DEEPSLATE_CITRINE_ORE = registerBlocks("deepslate_citrine_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE)
                    .strength(4.0f)
                    .requiresTool(),
                    UniformIntProvider.create(3, 7)),
                    ModItemGroup.CITRINE);




    //block reg
    private static Block registerBlocks(String name, Block block, ItemGroup group){
        registerBlockItem(name, block , group);
        return Registry.register(Registries.BLOCK, new Identifier(TutorialMod.MOD_ID, name), block);
    }
    //item reg
    private static Item registerBlockItem(String name, Block block, ItemGroup group){
        Item item = Registry.register(Registries.ITEM, new Identifier(TutorialMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
        return item;
    }
    //log
    public static void registerModBlocks(){
        TutorialMod.LOGGER.info("Registering Blocks for " + TutorialMod.MOD_ID);
    }
}
