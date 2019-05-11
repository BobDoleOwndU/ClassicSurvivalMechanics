package io.github.bobdoleowndu.classicsurvivalmechanics;

import java.util.ArrayList;

import org.bukkit.Material;

public class Food
{
	//Unfortunately, Java lacks a Pair class. So it's easier to just make two ArrayLists.
	static private ArrayList<Material> foodTypes = new ArrayList<Material>(0);
	static private ArrayList<Double> foodValues = new ArrayList<Double>(0);
	
	public Food()
	{
		//Add food materials.
		foodTypes.add(Material.APPLE);
		foodTypes.add(Material.BAKED_POTATO);
		foodTypes.add(Material.BEETROOT);
		foodTypes.add(Material.BEETROOT_SOUP);
		foodTypes.add(Material.BREAD);
		//foodTypes.add(Material.CAKE);
		foodTypes.add(Material.CARROT);
		foodTypes.add(Material.CHORUS_FRUIT);
		foodTypes.add(Material.COOKED_CHICKEN);
		foodTypes.add(Material.COOKED_COD);
		foodTypes.add(Material.COOKED_MUTTON);
		foodTypes.add(Material.COOKED_PORKCHOP);
		foodTypes.add(Material.COOKED_RABBIT);
		foodTypes.add(Material.COOKED_SALMON);
		foodTypes.add(Material.COOKIE);
		foodTypes.add(Material.DRIED_KELP);
		foodTypes.add(Material.GOLDEN_APPLE);
		foodTypes.add(Material.ENCHANTED_GOLDEN_APPLE);
		foodTypes.add(Material.GOLDEN_CARROT);
		foodTypes.add(Material.MELON_SLICE);
		foodTypes.add(Material.MUSHROOM_STEW);
		foodTypes.add(Material.POISONOUS_POTATO);
		foodTypes.add(Material.POTATO);
		foodTypes.add(Material.PUFFERFISH);
		foodTypes.add(Material.PUMPKIN_PIE);
		foodTypes.add(Material.RABBIT_STEW);
		foodTypes.add(Material.BEEF);
		foodTypes.add(Material.CHICKEN);
		foodTypes.add(Material.COD);
		foodTypes.add(Material.MUTTON);
		foodTypes.add(Material.PORKCHOP);
		foodTypes.add(Material.RABBIT);
		foodTypes.add(Material.SALMON);
		foodTypes.add(Material.ROTTEN_FLESH);
		foodTypes.add(Material.SPIDER_EYE);
		foodTypes.add(Material.COOKED_BEEF);
		foodTypes.add(Material.TROPICAL_FISH);
		
		//Add food health values
		foodValues.add(4.0); //Apple
		foodValues.add(5.0); //Baked Potato
		foodValues.add(1.0); //Beetroot
		foodValues.add(6.0); //Beetroot Soup
		foodValues.add(5.0); //Bread
		//foodValues.add(2.0); //Cake
		foodValues.add(3.0); //Carrot
		foodValues.add(4.0); //Chorus Fruit
		foodValues.add(6.0); //Cooked Chicken
		foodValues.add(5.0); //Cooked Cod
		foodValues.add(6.0); //Cooked Mutton
		foodValues.add(8.0); //Cooked Porkchop
		foodValues.add(5.0); //Cooked Rabbit
		foodValues.add(6.0); //Cooked Salmon
		foodValues.add(2.0); //Cookie
		foodValues.add(1.0); //Dried Kelp
		foodValues.add(4.0); //Golden Apple
		foodValues.add(4.0); //Enchanted Golden Apple
		foodValues.add(6.0); //Golden Carrot
		foodValues.add(2.0); //Melon Slice
		foodValues.add(6.0); //Mushroom Stew
		foodValues.add(2.0); //Posionous Potato
		foodValues.add(1.0); //Potato
		foodValues.add(1.0); //Pufferfish
		foodValues.add(8.0); //Pumpkin Pie
		foodValues.add(10.0); //Rabbit Stew
		foodValues.add(3.0); //Beef
		foodValues.add(2.0); //Chicken
		foodValues.add(2.0); //Cod
		foodValues.add(2.0); //Mutton
		foodValues.add(3.0); //Porkchop
		foodValues.add(3.0); //Rabbit
		foodValues.add(2.0); //Salmon
		foodValues.add(4.0); //Rotten Flesh
		foodValues.add(2.0); //Spider Eye
		foodValues.add(8.0); //Cooked Beef
		foodValues.add(1.0); //Tropical Fish
	} //constructor
	
	public boolean isFoodType(Material material)
	{
		return foodTypes.contains(material);
	} //isFoodType
	
	public double getHealthValue(Material material)
	{
		return foodValues.get(foodTypes.indexOf(material));
	} //getHealthValue
} //class
