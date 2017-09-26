package me.TookieDev.commands;

import java.io.File;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import me.TookieDev.utils.LocationAPI;
import me.TookieDev.utils.Var;

public class Spawn implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if ((sender instanceof Player)) {
			if (cmd.getName().equalsIgnoreCase("setspawn")) {
				Player p = (Player) sender;
				if ((p.isOp()) || (p.hasPermission("KnockIT.setspawn"))) {
					File file = Var.cfgFile;
					YamlConfiguration cfg = Var.cfg;
					if (args.length == 1) {
						if (args[0].equalsIgnoreCase("Spawn")) {
							LocationAPI.createConfigLocation(p.getLocation(), "Location.Spawn", file, cfg);
							p.sendMessage(Var.pr + "§aDer  Spawn wurde gesetzt!");
						} else {
							p.sendMessage(Var.pr + "§cBitte benutz /setspawn <Spawn>");
						}
					} else {
						p.sendMessage(Var.noperm);
					}
				} else {
					sender.sendMessage(Var.noperm);
				}
			}
		} else {
			sender.sendMessage(Var.pr + "§cBitte benutz /setspawn <Spawn>");
		}
		return false;
	}
}
