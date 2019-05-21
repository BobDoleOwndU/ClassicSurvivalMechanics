package io.github.bobdoleowndu.classicsurvivalmechanics;

import org.bukkit.Material;
import org.bukkit.potion.PotionEffect;

public class FoodItem
{
	Material material;
	double healAmount;
	boolean ignoreHealthCap;
	boolean isPlantable;
	int potionEffectActivationChance;
	PotionEffect[] potionEffects;

	public FoodItem(Material material, double healAmount, boolean ignoreHealthCap, boolean isPlantable)
	{
		this.material = material;
		this.healAmount = healAmount;
		this.ignoreHealthCap = ignoreHealthCap;
		this.isPlantable = isPlantable;
		this.potionEffectActivationChance = 0;
		this.potionEffects = new PotionEffect[0];
	} // constructor

	public FoodItem(Material material, double healAmount, boolean ignoreHealthCap, boolean isPlantable,
			int potionEffectActivationChance, PotionEffect[] potionEffects)
	{
		this.material = material;
		this.healAmount = healAmount;
		this.ignoreHealthCap = ignoreHealthCap;
		this.isPlantable = isPlantable;
		this.potionEffectActivationChance = potionEffectActivationChance;
		this.potionEffects = potionEffects;
	} // constructor
} // class
