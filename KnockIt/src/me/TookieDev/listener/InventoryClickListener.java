package me.TookieDev.listener;

import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import me.TookieDev.utils.ShopCoinsAPI;
import me.TookieDev.utils.Var;

public class InventoryClickListener implements Listener {
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		if (e.getCurrentItem() == null) {
			return;
		}
		if (e.getInventory() == null) {
			return;
		}
		Player p = (Player) e.getWhoClicked();
		String uuid = p.getUniqueId().toString();
		if (e.getInventory().getName().equals("§eSHOP")) {
			if (e.getCurrentItem().getType() == Material.POTION) {
				if (ShopCoinsAPI.getCoins(uuid) >= 2) {
					p.closeInventory();
					p.getInventory().addItem(new ItemStack[] { e.getCurrentItem() });
					p.sendMessage(Var.pr + "§aKauf erfolgreich :)");
				} else {
					p.closeInventory();
					p.sendMessage(Var.pr + "§cDu hast zu wenig Coins!");
				}
			}
			if (e.getCurrentItem().getType() == Material.FISHING_ROD) {
				if (ShopCoinsAPI.getCoins(uuid) >= 5) {
					p.closeInventory();
					p.getInventory().addItem(new ItemStack[] { e.getCurrentItem() });
					p.sendMessage(Var.pr + "§aKauf erfolgreich :)");
				} else {
					p.closeInventory();
					p.sendMessage(Var.pr + "§cDu hast zu wenig Coins!");
				}
			}
			if (e.getCurrentItem().getType() == Material.BOW) {
				if (ShopCoinsAPI.getCoins(uuid) >= 7) {
					p.closeInventory();
					p.getInventory().addItem(new ItemStack[] { e.getCurrentItem() });
					p.sendMessage(Var.pr + "§aKauf erfolgreich c:");
				} else {
					p.closeInventory();
					p.sendMessage(Var.pr + "§cDu hast zu wenig Coins!");
				}
			}
			if (e.getCurrentItem().getType() == Material.ARROW) {
				if (ShopCoinsAPI.getCoins(uuid) >= 1) {
					p.closeInventory();
					p.getInventory().addItem(new ItemStack[] { e.getCurrentItem() });
					p.sendMessage(Var.pr + "§aKauf erfolgreich :)");
				} else {
					p.closeInventory();
					p.sendMessage(Var.pr + "§cDu hast zu wenig Coins!");
				}
			}
		}
		e.setCancelled(true);
	}
}
