package io.github.bobdoleowndu.classicsurvivalmechanics;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class FoodLevelChangeListener implements Listener
{
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onFoodLevelChange(FoodLevelChangeEvent event)
	{
		// Stop the food level from ever changing.
		event.setCancelled(true);
	} // onFoodLevelChange
} // class
