package com.gmail.tomahawkmissile2.WaterSplash;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class CommandHandler implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player))
			sender.sendMessage(ChatColor.RED+"You cannot use this command as console!");
		Player player = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("splash")) {
			if(args.length==0) {
				player.setFireTicks(0);
				player.sendMessage(ChatColor.GREEN+"You just saved yourself!");
			} else if(args.length==1) {
				Player other = Main.plugin.getServer().getPlayer(args[0]);
				if(other==null)
					player.sendMessage(ChatColor.RED+"That player is not on the server!");
				else {
					player.sendMessage(ChatColor.GREEN+"You just saved "+args[0]+"!");
					other.sendMessage(ChatColor.GREEN+player.getName()+" just saved you!");
					other.setFireTicks(0);
				}
			} else {
				player.sendMessage(ChatColor.RED+"Invalid command! Use \'/splash <player>\'");
			}
			return true;
		}
		return false;
	}
}
