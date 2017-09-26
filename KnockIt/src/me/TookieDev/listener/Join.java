package me.TookieDev.listener;

import java.sql.SQLException;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.TookieDev.mysql.MYSQL;
import me.TookieDev.utils.LocationAPI;
import me.TookieDev.utils.ScoreboardC;
import me.TookieDev.utils.ShopCoinsAPI;
import me.TookieDev.utils.Var;

public class Join implements Listener {
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		p.getInventory().clear();
		p.setGameMode(GameMode.ADVENTURE);
		e.setJoinMessage(null);
		try {
			MYSQL.createUser(p.getUniqueId().toString());
			ShopCoinsAPI.setCoins(p.getUniqueId().toString(), 1);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		ScoreboardC.sendScoreboard(p);
		p.teleport(LocationAPI.getConfigLocation("Location.Spawn", Var.cfg));
		if (Var.con.getString("language").equals("DE")) {
			String Join = Var.decfg.getString("Message.Join");
			Join = Join.replace("%Player%", p.getDisplayName());
			Join = ChatColor.translateAlternateColorCodes('&', Join);
			e.setJoinMessage(Var.pr + Join);
		}
		ItemStack Kn = new ItemStack(Material.STICK);
		ItemStack Sh = new ItemStack(Material.CHEST);
		ItemMeta knmeta = Kn.getItemMeta();
		ItemMeta Shmeta = Sh.getItemMeta();
		Shmeta.setDisplayName("§eSHOP");
		knmeta.setDisplayName("§7Knüppel");
		knmeta.addEnchant(Enchantment.KNOCKBACK, 2, true);
		Kn.setItemMeta(knmeta);
		Sh.setItemMeta(Shmeta);
		p.getInventory().setItem(0, Kn);
		p.getInventory().setItem(7, Sh);
	}
}
