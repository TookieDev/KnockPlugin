package me.TookieDev.listener;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import me.TookieDev.utils.LocationAPI;
import me.TookieDev.utils.ScoreboardC;
import me.TookieDev.utils.Var;

public class Respawn implements Listener {
	@EventHandler
	public void onRes(PlayerRespawnEvent e) {
		Player p = e.getPlayer();

		p.getInventory().clear();
		p.setGameMode(GameMode.ADVENTURE);

		e.setRespawnLocation(LocationAPI.getConfigLocation("Location.Spawn", Var.cfg));

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

		ScoreboardC.sendScoreboard(p);
	}
}
