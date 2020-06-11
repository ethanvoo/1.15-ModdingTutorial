package com.ethaniscool.tutorialmod.events;

import com.ethaniscool.tutorialmod.TutorialMod;

import net.minecraft.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID, bus = Bus.FORGE)
public class TestJumpEvent 
{
	@SubscribeEvent
	public static void testJumpEvent(LivingJumpEvent event)
	{
		
	}
}
