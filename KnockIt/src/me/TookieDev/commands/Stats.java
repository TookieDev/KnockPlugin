package me.TookieDev.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.TookieDev.utils.KillsAPI;
import me.TookieDev.utils.ShopCoinsAPI;
import me.TookieDev.utils.TodesAPI;
import me.TookieDev.utils.Var;

public class Stats implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if ((sender instanceof Player)) {
			double kills = KillsAPI.getKills(p.getUniqueId().toString());
			double tode = TodesAPI.getTode(p.getUniqueId().toString());
			p.sendMessage("§7-------" + Var.pr + "§7-------");
			p.sendMessage(Var.pr + "§aDu hast: " + kills + "§a Kills");
			p.sendMessage(Var.pr + "§aDu hast: " + tode + "§a Tode");
			p.sendMessage(Var.pr + "§aDu hast: " + ShopCoinsAPI.getCoins(p.getUniqueId().toString()) + "§a Coins");
			p.sendMessage(Var.pr + "§a Du haste eine: " + round(kills / tode, 2) + "§a K/D");
			p.sendMessage("§7-------" + Var.pr + "§7-------");
		} else {
			sender.sendMessage(Var.pr + "§cDu musst ein Spieler sein!!!!!!");
		}
		return false;
	}

	public double round(double value, int places) {
		if (places < 0) {
			throw new IllegalArgumentException();
		}
		double factor = Math.pow(10.0D, places);
		value *= factor;
		long tmp = Math.round(value);
		return tmp / factor;
	}
}
