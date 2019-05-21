package io.github.bobdoleowndu.classicsurvivalmechanics;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class EntityPickupItemListener implements Listener
{
	private long i = (long) (Math.random() * Long.MAX_VALUE);

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onItemSpawn(ItemSpawnEvent event)
	{
		Item item = event.getEntity();
		ItemStack stack = item.getItemStack();
		Material material = stack.getType();

		if (ClassicSurvivalMechanics.isFoodItem(material))
		{
			// If the stack if greater than one, we want to replace it with
			// individual stacks of one. Else, we add a randomly generated long
			// to the food's lore, making it a unique item. Technically these
			// items can still be stacked; but the chance of an item that's
			// stackable spawning with them is one in 2,147,483,647.
			if (stack.getAmount() > 1)
			{
				for (int i = 0; i < stack.getAmount(); i++)
				{
					Location location = item.getLocation();
					ItemStack newStack = new ItemStack(material);
					location.getWorld().dropItemNaturally(location, newStack);
				} // for

				item.remove();
			} // if
			else
			{
				ItemMeta meta = stack.getItemMeta();
				List<String> lore = new ArrayList<String>(0);
				lore.add(Long.toString(i));
				meta.setLore(lore);
				stack.setItemMeta(meta);
				i = (long) (Math.random() * Long.MAX_VALUE);
			} // else
		} // if
	} // onEntityPickupItem
} // class
