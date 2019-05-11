package io.github.bobdoleowndu.classicsurvivalmechanics;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSetHealth implements CommandExecutor
{
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
		try
		{
			Player player = Bukkit.getPlayer(args[0]);
			player.setHealth(Double.parseDouble(args[1]));
			
			return true;
		} //try
		catch(Exception e)
		{
			return false;
		} //catch
	} //onCommand
} //class
