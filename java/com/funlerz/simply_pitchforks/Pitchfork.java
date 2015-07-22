package com.funlerz.simply_pitchforks;

import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.google.common.collect.Sets;

public class Pitchfork extends ItemTool {
	
	private final String name;
	private Item.ToolMaterial pitchforkMaterial;
	private static final Set EFFECTIVE_ON = Sets.newHashSet(new Block[] {Blocks.wheat, Blocks.potatoes, Blocks.carrots, Blocks.nether_wart});
	
	public Pitchfork(String name, float attackDamage, Item.ToolMaterial pitchforkMaterial) {
		super(attackDamage, pitchforkMaterial, EFFECTIVE_ON);
		this.name = name;
		
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(ModInfo.ID + "_" + name);
	}
	
	/**
     * Called when a Block is right-clicked with this Item
     *  
     * @param pos The block being right-clicked
     * @param side The side being right-clicked
     */
	public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if (!playerIn.canPlayerEdit(pos.offset(side), side, stack))
        {
            return false;
        }
        else
        {
            int hook = net.minecraftforge.event.ForgeEventFactory.onHoeUse(stack, playerIn, worldIn, pos);
            if (hook != 0) return hook > 0;

            IBlockState iblockstate = worldIn.getBlockState(pos);
            Block block = iblockstate.getBlock();

            if (side != EnumFacing.DOWN && worldIn.isAirBlock(pos.up()))
            {
                if (block == Blocks.wheat)
                {
                	int age = block.getMetaFromState(iblockstate);
                	if (age == 7)
                	{
                        return this.usePitchfork(stack, playerIn, worldIn, pos, iblockstate, Blocks.wheat.getDefaultState(), block);
                	}
                }
                
                if (block == Blocks.potatoes)
                {
                	int age = block.getMetaFromState(iblockstate);
                	if (age == 7)
                	{
                        return this.usePitchfork(stack, playerIn, worldIn, pos, iblockstate, Blocks.potatoes.getDefaultState(), block);
                	}
                }
                
                if (block == Blocks.carrots)
                {
                	int age = block.getMetaFromState(iblockstate);
                	if (age == 7)
                	{
                        return this.usePitchfork(stack, playerIn, worldIn, pos, iblockstate, Blocks.carrots.getDefaultState(), block);
                	}
                }
                
                if (block == Blocks.nether_wart)
                {
                	int age = block.getMetaFromState(iblockstate);
                	if (age == 3)
                	{
                        return this.usePitchfork(stack, playerIn, worldIn, pos, iblockstate, Blocks.nether_wart.getDefaultState(), block);
                	}
                }
            }

            return false;
        }
    }
	
	protected boolean usePitchfork(ItemStack stack, EntityPlayer player, World worldIn, BlockPos target, IBlockState oldState, IBlockState newState, Block block)
    {
        worldIn.playSoundEffect((double)((float)target.getX() + 0.5F), (double)((float)target.getY() + 0.5F), (double)((float)target.getZ() + 0.5F), newState.getBlock().stepSound.getStepSound(), (newState.getBlock().stepSound.getVolume() + 1.0F) / 2.0F, newState.getBlock().stepSound.getFrequency() * 0.8F);

        if (worldIn.isRemote)
        {
            return true;
        }
        else
        {
        	block.dropBlockAsItem(worldIn, target, oldState, 0);
            worldIn.setBlockState(target, newState);
            stack.damageItem(1, player);
            return true;
        }
    }
	
	public String getName() {
		return name;
	}
	
	public String getMaterialName()
    {
        return this.pitchforkMaterial.toString();
    }
	
}
