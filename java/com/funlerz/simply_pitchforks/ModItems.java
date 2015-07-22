package com.funlerz.simply_pitchforks;

import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class ModItems {
	
	// PITCHFORKS //
	public static Item woodenPitchfork;
	public static Item stonePitchfork;
	public static Item ironPitchfork;
	public static Item goldenPitchfork;
	public static Item diamondPitchfork;
	
	public static void loadItems() {
		
		// PITCHFORKS //
		woodenPitchfork = new WoodenPitchfork();
		stonePitchfork = new StonePitchfork();
		ironPitchfork = new IronPitchfork();
		goldenPitchfork = new GoldenPitchfork();
		diamondPitchfork = new DiamondPitchfork();
		
	}
	
	public static void initItemRenders(RenderItem renderItem) {
		
		// PITCHFORKS //
		renderItem.getItemModelMesher().register(woodenPitchfork, 0, new ModelResourceLocation(ModInfo.ID + ":" + ((WoodenPitchfork) woodenPitchfork).getName(), "inventory"));
		renderItem.getItemModelMesher().register(stonePitchfork, 0, new ModelResourceLocation(ModInfo.ID + ":" + ((StonePitchfork) stonePitchfork).getName(), "inventory"));
		renderItem.getItemModelMesher().register(ironPitchfork, 0, new ModelResourceLocation(ModInfo.ID + ":" + ((IronPitchfork) ironPitchfork).getName(), "inventory"));
		renderItem.getItemModelMesher().register(goldenPitchfork, 0, new ModelResourceLocation(ModInfo.ID + ":" + ((GoldenPitchfork) goldenPitchfork).getName(), "inventory"));
		renderItem.getItemModelMesher().register(diamondPitchfork, 0, new ModelResourceLocation(ModInfo.ID + ":" + ((DiamondPitchfork) diamondPitchfork).getName(), "inventory"));
		
	}
	
}
