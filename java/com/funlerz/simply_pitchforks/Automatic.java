package com.funlerz.simply_pitchforks;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION, acceptedMinecraftVersions = ModInfo.MCVERSIONS)
public class Automatic
{
	@Instance(value = ModInfo.ID)
	public static Automatic instance;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		ModItems.loadItems();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		ModRecipes.loadRecipes();
		if (event.getSide() == Side.CLIENT) {
			RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
			ModItems.initItemRenders(renderItem);
		}
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		// Post initialize all the things.
	}
}
