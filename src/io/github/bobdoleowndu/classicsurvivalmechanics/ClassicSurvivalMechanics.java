package io.github.bobdoleowndu.classicsurvivalmechanics;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ClassicSurvivalMechanics extends JavaPlugin
{
	public FileConfiguration config;
	public static ArrayList<FoodItem> foodItems;
	public static double cakeHealAmount;

	private static ClassicSurvivalMechanics instance;

	@Override
	public void onEnable()
	{
		// This allows us to get this instance of the plugin through other
		// classes.
		instance = this;

		// If our config file doesn't exist, save the default one. Then load it!
		this.saveDefaultConfig();
		config = this.getConfig();

		// Initialize food.
		initializeFoodItems();

		// Register commands.
		this.getCommand("CsmReloadConfig").setExecutor(new CommandReloadConfig());
		this.getCommand("CsmSetHealth").setExecutor(new CommandSetHealth());

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

	public void initializeFoodItems()
	{
		foodItems = new ArrayList<FoodItem>(0);

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

		foodItems.add(new FoodItem(Material.APPLE, config.getDouble("apple"), false, false, false));
		foodItems.add(new FoodItem(Material.BAKED_POTATO, config.getDouble("baked_potato"), false, false, false));
		foodItems.add(new FoodItem(Material.BEETROOT, config.getDouble("beetroot"), false, false, false));
		foodItems.add(new FoodItem(Material.BEETROOT_SOUP, config.getDouble("beetroot_soup"), true, false, false));
		foodItems.add(new FoodItem(Material.BREAD, config.getDouble("bread"), false, false, false));
		foodItems.add(new FoodItem(Material.CARROT, config.getDouble("carrot"), false, false, true));
		foodItems.add(new FoodItem(Material.CHORUS_FRUIT, config.getDouble("chorus_fruit"), false, false, false));
		foodItems.add(new FoodItem(Material.COOKED_CHICKEN, config.getDouble("cooked_chicken"), false, false, false));
		foodItems.add(new FoodItem(Material.COOKED_COD, config.getDouble("cooked_cod"), false, false, false));
		foodItems.add(new FoodItem(Material.COOKED_MUTTON, config.getDouble("cooked_mutton"), false, false, false));
		foodItems.add(new FoodItem(Material.COOKED_PORKCHOP, config.getDouble("cooked_porkchop"), false, false, false));
		foodItems.add(new FoodItem(Material.COOKED_RABBIT, config.getDouble("cooked_rabbit"), false, false, false));
		foodItems.add(new FoodItem(Material.COOKED_SALMON, config.getDouble("cooked_salmon"), false, false, false));
		foodItems.add(new FoodItem(Material.COOKIE, config.getDouble("cookie"), false, false, false));
		foodItems.add(new FoodItem(Material.DRIED_KELP, config.getDouble("dried_kelp"), false, false, false));
		foodItems.add(new FoodItem(Material.GOLDEN_APPLE, config.getDouble("golden_apple"), false, true, false, 100,
				goldenApplePotionEffects));
		foodItems.add(new FoodItem(Material.ENCHANTED_GOLDEN_APPLE, config.getDouble("enchanted_golden_apple"), false,
				true, false, 100, enchantedGoldenApplePotionEffects));
		foodItems.add(new FoodItem(Material.GOLDEN_CARROT, config.getDouble("golden_carrot"), false, false, false));
		foodItems.add(new FoodItem(Material.MELON_SLICE, config.getDouble("melon_slice"), false, false, false));
		foodItems.add(new FoodItem(Material.MUSHROOM_STEW, config.getDouble("mushroom_stew"), true, false, false));
		foodItems.add(new FoodItem(Material.POISONOUS_POTATO, config.getDouble("poisonous_potato"), false, false, false,
				60, poisonousPotatoPotionEffects));
		foodItems.add(new FoodItem(Material.POTATO, config.getDouble("potato"), false, false, true));
		foodItems.add(new FoodItem(Material.PUFFERFISH, config.getDouble("pufferfish"), false, false, false, 100,
				pufferfishPotionEffects));
		foodItems.add(new FoodItem(Material.PUMPKIN_PIE, config.getDouble("pumpkin_pie"), false, false, false));
		foodItems.add(new FoodItem(Material.RABBIT_STEW, config.getDouble("rabbit_stew"), true, false, false));
		foodItems.add(new FoodItem(Material.BEEF, config.getDouble("beef"), false, false, false));
		foodItems.add(new FoodItem(Material.CHICKEN, config.getDouble("chicken"), false, false, false, 30,
				chickenPotionEffects));
		foodItems.add(new FoodItem(Material.COD, config.getDouble("cod"), false, false, false));
		foodItems.add(new FoodItem(Material.MUTTON, config.getDouble("mutton"), false, false, false));
		foodItems.add(new FoodItem(Material.PORKCHOP, config.getDouble("porkchop"), false, false, false));
		foodItems.add(new FoodItem(Material.RABBIT, config.getDouble("rabbit"), false, false, false));
		foodItems.add(new FoodItem(Material.SALMON, config.getDouble("salmon"), false, false, false));
		foodItems.add(new FoodItem(Material.ROTTEN_FLESH, config.getDouble("rotten_flesh"), false, false, false, 80,
				rottenFleshPotionEffects));
		foodItems.add(new FoodItem(Material.SPIDER_EYE, config.getDouble("spider_eye"), false, false, false, 100,
				spiderEyePotionEffects));
		foodItems.add(new FoodItem(Material.COOKED_BEEF, config.getDouble("cooked_beef"), false, false, false));
		foodItems.add(new FoodItem(Material.TROPICAL_FISH, config.getDouble("tropical_fish"), false, false, false));

		cakeHealAmount = config.getDouble("cake");
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

	public static ClassicSurvivalMechanics getInstance()
	{
		return instance;
	} // getInstance
} // class
