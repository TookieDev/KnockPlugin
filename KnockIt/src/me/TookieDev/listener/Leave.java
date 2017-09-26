package me.TookieDev.listener;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.PlayerInventory;

import me.TookieDev.utils.Var;

public class Leave implements Listener {
	@EventHandler
	public void onLeave(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		e.setQuitMessage(null);
		p.getInventory().clear();
		if (Var.con.getString("language").equals("DE")) {
			String Leave = Var.decfg.getString("Message.Quit");
			Leave = Leave.replace("%Player%", p.getDisplayName());
			Leave = ChatColor.translateAlternateColorCodes('&', Leave);
			e.setQuitMessage(Var.pr + Leave);
		}
	}
}
