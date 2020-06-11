	package com.ethaniscool.tutorialmod.init;

import java.util.function.Supplier;

import com.ethaniscool.tutorialmod.TutorialMod;
import com.ethaniscool.tutorialmod.TutorialMod.TutorialItemGroup;
import com.ethaniscool.tutorialmod.objects.items.SpecialItem;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid=TutorialMod.MOD_ID, bus=Bus.MOD)
@ObjectHolder(TutorialMod.MOD_ID)
public class ItemInit {
	public static final Item ruby = null;
	public static final Item sapphire = null;
	public static final Item silver = null;
	
	public static final Item special_item = null;
	
	public static final Item ruby_sword = null;
	public static final Item ruby_axe = null;
	public static final Item ruby_pickaxe = null;
	
	public static final Item ruby_helmet = null;
	public static final Item ruby_chestplate = null;
	public static final Item ruby_leggings = null;
	public static final Item ruby_boots = null;
	
	
	
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) {
		// ore items
		event.getRegistry().register(new Item(new Item.Properties().group(TutorialItemGroup.instance)).setRegistryName("ruby"));
		event.getRegistry().register(new Item(new Item.Properties().group(TutorialItemGroup.instance)).setRegistryName("sapphire"));
		event.getRegistry().register(new Item(new Item.Properties().group(TutorialItemGroup.instance)).setRegistryName("silver"));

		//food stuff
		event.getRegistry().register(new Item(new Item.Properties().group(TutorialItemGroup.instance).food(new Food.Builder().hunger(6).saturation(1.2f).setAlwaysEdible().effect(new EffectInstance(Effects.REGENERATION, 6000, 100), 0.7f).effect(new EffectInstance(Effects.HEALTH_BOOST, 10000, 10), 1).effect(new EffectInstance(Effects.ABSORPTION, 10000, 20), 1).build())).setRegistryName("test_item"));

		// special items
		event.getRegistry().register(new SpecialItem(new Item.Properties().group(TutorialItemGroup.instance)).setRegistryName("special_item"));

		// Tools
		event.getRegistry().register(new SwordItem(ModItemTier.RUBY, 7, 5.0F, new Item.Properties().group(TutorialItemGroup.instance)).setRegistryName("ruby_sword"));
		event.getRegistry().register(new PickaxeItem(ModItemTier.RUBY, 4, 5.0f, new Item.Properties().group(TutorialItemGroup.instance)).setRegistryName("ruby_pickaxe"));
		event.getRegistry().register(new AxeItem(ModItemTier.RUBY, 11, 3.0f, new Item.Properties().group(TutorialItemGroup.instance)).setRegistryName("ruby_axe"));

		// Armor
		event.getRegistry().register(new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlotType.HEAD, new Item.Properties().group(TutorialItemGroup.instance)).setRegistryName("ruby_helmet"));
		event.getRegistry().register(new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlotType.CHEST, new Item.Properties().group(TutorialItemGroup.instance)).setRegistryName("ruby_chestplate"));
		event.getRegistry().register(new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlotType.LEGS, new Item.Properties().group(TutorialItemGroup.instance)).setRegistryName("ruby_leggings"));
		event.getRegistry().register(new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlotType.FEET, new Item.Properties().group(TutorialItemGroup.instance)).setRegistryName("ruby_boots"));
	}


	// Mod Item Tiers

	
	public enum ModItemTier implements IItemTier {
		RUBY(4, 1500, 15.0f, 7.0f, 250, () -> {
			return Ingredient.fromItems(ItemInit.ruby);
		}),

		SAPPHIRE(5, 1550, 16.0f, 8.0f, 260, () -> {
			return Ingredient.fromItems(ItemInit.sapphire);
		});


		private final int harvestLevel;
		private final int maxUses;
		private final float efficiency;
		private final float attackDamage;
		private final int enchantablility;
		private final LazyValue<Ingredient> repairMaterial;
		
		private ModItemTier (int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantablility, Supplier<Ingredient> repairMaterial) {
			this .harvestLevel = harvestLevel;
			this .maxUses = maxUses;
			this .efficiency = efficiency;
			this .attackDamage = attackDamage;
			this .enchantablility = enchantablility;
			this .repairMaterial = new LazyValue<>(repairMaterial);
			
		}

		@Override
		public int getMaxUses() {
			return this .maxUses;
		}

		@Override
		public float getEfficiency() {
			return this .efficiency;
	}

		@Override
		public float getAttackDamage() {
			return this .attackDamage;
		}

		@Override
		public int getHarvestLevel() {
			return this .harvestLevel;
		}

		@Override
		public int getEnchantability() {
			return this .enchantablility;
		}

		@Override
		public Ingredient getRepairMaterial() {
			return this.repairMaterial.getValue();
		}
		
	}

	// Mod Armor Tiers
	public enum ModArmorMaterial implements IArmorMaterial {
		RUBY(TutorialMod.MOD_ID + ":ruby", 80, new int[] { 7, 9, 11, 7 }, 420, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 6.9F, () -> {
			return Ingredient.fromItems(ruby);
		});


		private static final int[] MAX_DAMAGE_ARRAY = new int[] { 16, 16, 16, 16 };
		private final String name;
		private final int maxDamageFactor;
		private final int[] damageReductionAmountArray;
		private final int enchantability;
		private final SoundEvent soundEvent;
		private final float toughness;
		private final LazyValue<Ingredient> repairMaterial;
		private ModArmorMaterial(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountIn,
								 int enchantabilityIn, SoundEvent soundEventIn, float toughnessIn,
								 Supplier<Ingredient> repairMaterialIn) {
			this.name = nameIn;
			this.maxDamageFactor = maxDamageFactorIn;
			this.damageReductionAmountArray = damageReductionAmountIn;
			this.enchantability = enchantabilityIn;
			this.soundEvent = soundEventIn;
			this.toughness = toughnessIn;
			this.repairMaterial = new LazyValue<>(repairMaterialIn);
		}
		@Override
		public int getDurability(EquipmentSlotType slotIn) {
			return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
		}
		@Override
		public int getDamageReductionAmount(EquipmentSlotType slotIn) {
			return this.damageReductionAmountArray[slotIn.getIndex()];
		}
		@Override
		public int getEnchantability() {
			return this.enchantability;
		}
		@Override
		public SoundEvent getSoundEvent() {
			return this.soundEvent;
		}
		@Override
		public Ingredient getRepairMaterial() {
			return this.repairMaterial.getValue();
		}
		@OnlyIn(Dist.CLIENT)
		@Override
		public String getName() {
			return this.name;
		}
		@Override
		public float getToughness() {
			return this.toughness;
		}
	}
}
	
	








