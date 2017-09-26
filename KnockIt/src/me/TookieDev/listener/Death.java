package me.TookieDev.listener;

import java.util.List;
import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import me.TookieDev.utils.KillsAPI;
import me.TookieDev.utils.ScoreboardC;
import me.TookieDev.utils.ShopCoinsAPI;
import me.TookieDev.utils.TodesAPI;
import me.TookieDev.utils.Var;

public class Death implements Listener {
	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		Player p = e.getEntity();
		Player k = p.getKiller();

		e.setDeathMessage(null);
		e.setDroppedExp(0);
		e.getDrops().clear();
		if (Var.con.getString("language").equals("DE")) {
			if (k != null) {
				String Killer = Var.decfg.getString("Tod.Killer");
				Killer = Killer.replace("%Player%", p.getDisplayName());
				Killer = ChatColor.translateAlternateColorCodes('&', Killer);
				p.sendMessage(Var.pr + Killer);

				String Spieler = Var.decfg.getString("Tod.Spieler");
				Spieler = Spieler.replace("%Player%", p.getDisplayName());
				Spieler = ChatColor.translateAlternateColorCodes('&', Spieler);
				p.sendMessage(Var.pr + Killer);

				ShopCoinsAPI.addCoins(k.getUniqueId().toString(), 1);
				k.sendMessage(Var.pr + Killer);
				if (ShopCoinsAPI.getCoins(p.getUniqueId().toString()) >= 1) {
					ShopCoinsAPI.removeCoins(p.getUniqueId().toString(), 1);
				}
				TodesAPI.addTode(p.getUniqueId().toString(), 1);
				KillsAPI.addKills(k.getUniqueId().toString(), 1);
				ScoreboardC.sendScoreboard(p);
				ScoreboardC.sendScoreboard(k);
			}
			String Luft = Var.decfg.getString("Tod.Nichts");
			Luft = ChatColor.translateAlternateColorCodes('&', Luft);
			p.sendMessage(Var.pr + Luft);
			if (ShopCoinsAPI.getCoins(p.getUniqueId().toString()) >= 1) {
				ShopCoinsAPI.removeCoins(p.getUniqueId().toString(), 1);
			}
			TodesAPI.addTode(p.getUniqueId().toString(), 1);
			ScoreboardC.sendScoreboard(p);
			}
		
			//Hier kann mann noch Englische Nachrichten reinschreiben!
			if (ShopCoinsAPI.getCoins(p.getUniqueId().toString()) >= 1) {
				ShopCoinsAPI.removeCoins(p.getUniqueId().toString(), 1);
			}
			TodesAPI.addTode(p.getUniqueId().toString(), 1);
			ScoreboardC.sendScoreboard(p);
		}
	}
