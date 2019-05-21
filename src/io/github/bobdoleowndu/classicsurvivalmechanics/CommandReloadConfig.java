package io.github.bobdoleowndu.classicsurvivalmechanics;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandReloadConfig implements CommandExecutor
{
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
		ClassicSurvivalMechanics instance = ClassicSurvivalMechanics.getInstance();

		instance.reloadConfig();
		instance.config = instance.getConfig();
		instance.initializeFoodItems();

		sender.sendMessage("Reloaded!");

		return true;
	} // onCommand
} //class