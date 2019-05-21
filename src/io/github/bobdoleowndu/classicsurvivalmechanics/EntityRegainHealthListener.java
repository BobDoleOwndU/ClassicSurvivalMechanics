package io.github.bobdoleowndu.classicsurvivalmechanics;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityRegainHealthEvent;

public class EntityRegainHealthListener implements Listener
{
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onEntityRegainHealth(EntityRegainHealthEvent event)
	{
		// Disable auto-healing from a filled hunger bar.
		if (event.getRegainReason() == EntityRegainHealthEvent.RegainReason.SATIATED)
			event.setCancelled(true);
	} // onEntityRegainHealth
} // class
