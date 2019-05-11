package io.github.bobdoleowndu.classicsurvivalmechanics;

import org.bukkit.plugin.java.JavaPlugin;

public class ClassicSurvivalMechanics extends JavaPlugin
{
	@Override
	public void onEnable()
	{
		//Register commands.
		this.getCommand("SetHealth").setExecutor(new CommandSetHealth());
		
		//Register Listeners
		getServer().getPluginManager().registerEvents(new EntityPickupItemListener(), this);
		getServer().getPluginManager().registerEvents(new EntityRegainHealthListener(), this);
		getServer().getPluginManager().registerEvents(new FoodLevelChangeListener(), this);
		getServer().getPluginManager().registerEvents(new PlayerInteractEventListener(), this);
	} //onEnable
	
	@Override
	public void onDisable()
	{
		
	} //onDisable
} //class
