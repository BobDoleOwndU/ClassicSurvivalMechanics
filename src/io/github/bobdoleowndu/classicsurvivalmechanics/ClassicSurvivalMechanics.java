package io.github.bobdoleowndu.classicsurvivalmechanics;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ClassicSurvivalMechanics extends JavaPlugin
{
	public static ArrayList<FoodItem> foodItems = new ArrayList<FoodItem>(0);
	public static final double cakeHealAmount = 2.0d;

	@Override
	public void onEnable()
	{
		// Initialize food.
		initializeFoodItems();

		// Register commands.
		this.getCommand("SetHealth").setExecutor(new CommandSetHealth());

		// Register Listeners
		getServer().getPluginManager().registerEvents(new EntityPickupItemListener(), this);
		getServer().getPluginManager().registerEvents(new EntityRegainHealthListener(), this);
		getServer().getPluginManager().registerEvents(new FoodLevelChangeListener(), this);
		getServer().getPluginManager().registerEvents(new PlayerInteractEventListener(), this);
	} // onEnable

	@Override
	public void onDisable()
	{

	} // onDisable

	private void initializeFoodItems()
	{
		PotionEffect[] goldenApplePotionEffects = { new PotionEffect(PotionEffectType.REGENERATION, 100, 1),
				new PotionEffect(PotionEffectType.ABSORPTION, 2400, 0) };
		PotionEffect[] enchantedGoldenApplePotionEffects = { new PotionEffect(PotionEffectType.REGENERATION, 400, 1),
				new PotionEffect(PotionEffectType.ABSORPTION, 2400, 3),
				new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 6000, 0),
				new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 6000, 0) };
		PotionEffect[] poisonousPotatoPotionEffects = { new PotionEffect(PotionEffectType.POISON, 80, 0) };
		PotionEffect[] pufferfishPotionEffects = { new PotionEffect(PotionEffectType.SLOW, 300, 2),
				new PotionEffect(PotionEffectType.CONFUSION, 300, 1),
				new PotionEffect(PotionEffectType.POISON, 1200, 3) };
		PotionEffect[] chickenPotionEffects = { new PotionEffect(PotionEffectType.POISON, 140, 0) };
		PotionEffect[] rottenFleshPotionEffects = { new PotionEffect(PotionEffectType.POISON, 140, 0) };
		PotionEffect[] spiderEyePotionEffects = { new PotionEffect(PotionEffectType.POISON, 80, 0) };

		foodItems.add(new FoodItem(Material.APPLE, 4.0d, false, false));
		foodItems.add(new FoodItem(Material.BAKED_POTATO, 5.0d, false, false));
		foodItems.add(new FoodItem(Material.BEETROOT, 1.0d, false, false));
		foodItems.add(new FoodItem(Material.BEETROOT_SOUP, 6.0d, false, false));
		foodItems.add(new FoodItem(Material.BREAD, 5.0d, false, false));
		foodItems.add(new FoodItem(Material.CARROT, 3.0d, false, true));
		foodItems.add(new FoodItem(Material.CHORUS_FRUIT, 4.0d, false, false));
		foodItems.add(new FoodItem(Material.COOKED_CHICKEN, 6.0d, false, false));
		foodItems.add(new FoodItem(Material.COOKED_COD, 5.0d, false, false));
		foodItems.add(new FoodItem(Material.COOKED_MUTTON, 6.0d, false, false));
		foodItems.add(new FoodItem(Material.COOKED_PORKCHOP, 8.0d, false, false));
		foodItems.add(new FoodItem(Material.COOKED_RABBIT, 5.0d, false, false));
		foodItems.add(new FoodItem(Material.COOKED_SALMON, 6.0d, false, false));
		foodItems.add(new FoodItem(Material.COOKIE, 2.0d, false, false));
		foodItems.add(new FoodItem(Material.DRIED_KELP, 1.0d, false, false));
		foodItems.add(new FoodItem(Material.GOLDEN_APPLE, 4.0d, true, false, 100, goldenApplePotionEffects));
		foodItems.add(new FoodItem(Material.ENCHANTED_GOLDEN_APPLE, 4.0d, true, false, 100,
				enchantedGoldenApplePotionEffects));
		foodItems.add(new FoodItem(Material.GOLDEN_CARROT, 6.0d, false, false));
		foodItems.add(new FoodItem(Material.MELON_SLICE, 2.0d, false, false));
		foodItems.add(new FoodItem(Material.MUSHROOM_STEW, 6.0d, false, false));
		foodItems.add(new FoodItem(Material.POISONOUS_POTATO, 2.0d, false, false, 60, poisonousPotatoPotionEffects));
		foodItems.add(new FoodItem(Material.POTATO, 1.0d, false, true));
		foodItems.add(new FoodItem(Material.PUFFERFISH, 1.0d, false, false, 100, pufferfishPotionEffects));
		foodItems.add(new FoodItem(Material.PUMPKIN_PIE, 8.0d, false, false));
		foodItems.add(new FoodItem(Material.RABBIT_STEW, 10.0d, false, false));
		foodItems.add(new FoodItem(Material.BEEF, 3.0d, false, false));
		foodItems.add(new FoodItem(Material.CHICKEN, 2.0d, false, false, 30, chickenPotionEffects));
		foodItems.add(new FoodItem(Material.COD, 2.0d, false, false));
		foodItems.add(new FoodItem(Material.MUTTON, 2.0d, false, false));
		foodItems.add(new FoodItem(Material.PORKCHOP, 3.0d, false, false));
		foodItems.add(new FoodItem(Material.RABBIT, 3.0d, false, false));
		foodItems.add(new FoodItem(Material.SALMON, 2.0d, false, false));
		foodItems.add(new FoodItem(Material.ROTTEN_FLESH, 4.0d, false, false, 80, rottenFleshPotionEffects));
		foodItems.add(new FoodItem(Material.SPIDER_EYE, 2.0d, false, false, 100, spiderEyePotionEffects));
		foodItems.add(new FoodItem(Material.COOKED_BEEF, 8.0d, false, false));
		foodItems.add(new FoodItem(Material.TROPICAL_FISH, 1.0d, false, false));
	} // initializeFoodItems

	public static boolean isFoodItem(Material material)
	{
		for (FoodItem f : foodItems)
			if (material == f.material)
				return true;

		return false;
	} // isFoodItem

	public static FoodItem getFoodItem(Material material)
	{
		for (FoodItem f : foodItems)
			if (material == f.material)
				return f;

		return null;
	} // getFoodItem
} // class
