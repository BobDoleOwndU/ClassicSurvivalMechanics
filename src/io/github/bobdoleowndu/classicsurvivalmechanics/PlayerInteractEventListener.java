package io.github.bobdoleowndu.classicsurvivalmechanics;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.type.Cake;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerInteractEventListener implements Listener
{
	private Food food = new Food();
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerInteract(PlayerInteractEvent event)
	{
		Action action = event.getAction();
		
		
		//Check if the player right-clicked.
		if(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK)
		{
			Player player = event.getPlayer();
			double maxHealth = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();
			double newHealth;
			Block block = event.getClickedBlock();
			Material material = event.getItem() != null ? event.getItem().getType() : null;
			
			//Check if we're eating cake first.
			if(event.hasBlock())
			{
				if(block.getType() == Material.CAKE)
				{
					if(player.getHealth() != maxHealth)
					{
						//Update the BlockState if we can eat it.
						BlockState state = block.getState();
						BlockData data = state.getBlockData();
						Cake cake = (Cake)data;
						
						cake.setBites(cake.getBites() + 1);
						state.setBlockData(cake);
						state.update();
						
						if(cake.getBites() == cake.getMaximumBites())
							block.breakNaturally();
						
						newHealth = player.getHealth() + 2;
						
						if(newHealth > maxHealth)
							player.setHealth(maxHealth);
						else
							player.setHealth(newHealth);
						
						return;
					} //if
				} // if
			} //if
			
			//If our item is null, we just return.
			if(material == null)
				return;
			
			//Make sure we're holding food.
			if(food.isFoodType(material))
			{
				//Only eat if the player is injured or if it's a(n enchanted) golden apple.
				if(player.getHealth() != maxHealth
						|| material == Material.GOLDEN_APPLE || material == Material.ENCHANTED_GOLDEN_APPLE)
				{
					//If the item is a potato or carrot, planting it gets priority over eating it.
					if(event.hasBlock())
					{
						if(block.getType() == Material.FARMLAND)
						{
							if(material == Material.POTATO || material == Material.CARROT)
							{
								return;
							} //if
						} //if
					} //if
					
					PlayerInventory inventory = player.getInventory();
					short i = (short)(Math.random() * 100);
					newHealth = player.getHealth() + food.getHealthValue(material);
					
					inventory.remove(event.getItem());
					
					if(newHealth > maxHealth)
						player.setHealth(maxHealth);
					else
						player.setHealth(newHealth);
					
					//Apply item effects if the item has any.
					switch(material)
					{
						case GOLDEN_APPLE:
							player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 100, 1));
							player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 2400, 0));
						case ENCHANTED_GOLDEN_APPLE:
							player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 400, 1));
							player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 2400, 3));
							player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 6000, 0));
							player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 6000, 0));
							break;
						case POISONOUS_POTATO:
							if(i < 60)
								player.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 80, 0));
							break;
						case PUFFERFISH:
							player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 300, 2));
							player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 300, 1));
							player.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 1200, 3));
							break;
						case CHICKEN:
							if(i < 30)
								player.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 140, 0));
							break;
						case ROTTEN_FLESH:
							if(i < 80)
								player.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 140, 0));
							break;
						case SPIDER_EYE:
								player.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 80, 0));
							break;
						default:
							break;
					} //switch
				} //if
			} //if
		} //if
	} //onPlayerInteract
} //class