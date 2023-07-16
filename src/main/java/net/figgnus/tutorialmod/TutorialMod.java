package net.figgnus.tutorialmod;

import net.fabricmc.api.ModInitializer;

import net.figgnus.tutorialmod.block.ModBlocks;
import net.figgnus.tutorialmod.item.ModItems;
import net.figgnus.tutorialmod.item.ModItemGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";
    public static final Logger LOGGER = LoggerFactory.getLogger("tutorialmod");

	@Override
	public void onInitialize() {
		//reg itemGroup
		ModItemGroup.registerItemGroups();
		//reg item
		ModItems.registerModItems();
		//reg blocks
		ModBlocks.registerModBlocks();
	}
}