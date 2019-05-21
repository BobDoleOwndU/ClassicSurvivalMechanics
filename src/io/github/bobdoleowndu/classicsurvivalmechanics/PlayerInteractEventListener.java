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

public class PlayerInteractEventListener implements Listener
{
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerInteract(PlayerInteractEvent event)
	{
		Action action = event.getAction();

		// Check if the player right-clicked.
		if (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK)
		{
			Player player = event.getPlayer();
			double maxHealth = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();
			double newHealth;
			Block block = event.getClickedBlock();
			Material material = event.getItem() != null ? event.getItem().getType() : null;
			FoodItem foodItem = ClassicSurvivalMechanics.getFoodItem(material);

			// Check if we're eating cake first.
			if (event.hasBlock())
			{
				if (block.getType() == Material.CAKE)
				{
					if (player.getHealth() != maxHealth)
					{
						// Update the BlockState if we can eat it.
						BlockState state = block.getState();
						BlockData data = state.getBlockData();
						Cake cake = (Cake) data;

						cake.setBites(cake.getBites() + 1);
						state.setBlockData(cake);
						state.update();

						if (cake.getBites() == cake.getMaximumBites())
							block.breakNaturally();

						newHealth = player.getHealth() + ClassicSurvivalMechanics.cakeHealAmount;

						if (newHealth > maxHealth)
							player.setHealth(maxHealth);
						else
							player.setHealth(newHealth);
					} // if

					return;
				} // if
				else if (foodItem != null && block.getType() == Material.FARMLAND)
					if (foodItem.isPlantable)
						return; // If the item is plantable, planting it
								// gets priority over eating it.
			} // if

			if (foodItem != null)
				// Only eat if the player is injured or if it ignores the health
				// cap.
				if (player.getHealth() != maxHealth || foodItem.ignoreHealthCap)
				{
					PlayerInventory inventory = player.getInventory();
					short i = (short) (Math.random() * 100);
					newHealth = player.getHealth() + foodItem.healAmount;

					inventory.remove(event.getItem());

					if (newHealth > maxHealth)
						player.setHealth(maxHealth);
					else
						player.setHealth(newHealth);

					// Apply item effects if the item has any.
					if (i < foodItem.potionEffectActivationChance)
						for (PotionEffect p : foodItem.potionEffects)
							player.addPotionEffect(p);
				} // if
		} // if
	} // onPlayerInteract
} // class