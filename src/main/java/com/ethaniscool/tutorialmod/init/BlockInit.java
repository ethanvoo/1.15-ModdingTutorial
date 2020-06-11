package com.ethaniscool.tutorialmod.init;

import com.ethaniscool.tutorialmod.TutorialMod;
import com.ethaniscool.tutorialmod.TutorialMod.TutorialItemGroup;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(TutorialMod.MOD_ID)
@Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID, bus = Bus.MOD)
public class BlockInit 
{
	public static final Block ruby_ore = null;
	
	@SubscribeEvent
	public static void registerItemBlocks(final RegistryEvent.Register<Block> event) 
	{
		event.getRegistry().register(new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F, 15.0F).sound(SoundType.METAL).harvestTool(ToolType.PICKAXE)).setRegistryName("ruby_ore"));
	}
	@SubscribeEvent
	public static void registerBlockItems(final RegistryEvent.Register<Item> event) 
	{
		event.getRegistry().register(new BlockItem(ruby_ore, new Item.Properties().maxStackSize(32).group(TutorialItemGroup.instance)).setRegistryName("ruby_ore"));
	}
}

