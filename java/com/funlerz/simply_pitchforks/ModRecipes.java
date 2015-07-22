package com.funlerz.simply_pitchforks;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {
	
	public static void loadRecipes() {
		
		// PITCHFORKS //
		GameRegistry.addRecipe(new ItemStack(ModItems.woodenPitchfork),
				" | ",
				"|||",
				" | ",
				'|', Items.stick);
		
		GameRegistry.addRecipe(new ItemStack(ModItems.stonePitchfork),
				" S ",
				"S|S",
				" | ",
				'S', Blocks.cobblestone, '|', Items.stick);
		
		GameRegistry.addRecipe(new ItemStack(ModItems.ironPitchfork),
				" I ",
				"I|I",
				" | ",
				'I', Items.iron_ingot, '|', Items.stick);
		
		GameRegistry.addRecipe(new ItemStack(ModItems.goldenPitchfork),
				" G ",
				"G|G",
				" | ",
				'G', Items.gold_ingot, '|', Items.stick);
		
		GameRegistry.addRecipe(new ItemStack(ModItems.diamondPitchfork),
				" D ",
				"D|D",
				" | ",
				'D', Items.diamond, '|', Items.stick);
		
	}
	
}
