package me.TookieDev.listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.ItemMeta.Spigot;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;

public class InterAct implements Listener {
	@EventHandler
	public void onInta(PlayerInteractEvent e) {
		Inventory shop = Bukkit.createInventory(null, 18, "§eSHOP");
		Player p = e.getPlayer();
		if ((p.getItemInHand().getType() == Material.CHEST)
				&& ((e.getAction() == Action.RIGHT_CLICK_BLOCK) || (e.getAction() == Action.RIGHT_CLICK_AIR))) {
			ItemStack bow = new ItemStack(Material.BOW);
			ItemStack arrow = new ItemStack(Material.ARROW);
			ItemStack rod = new ItemStack(Material.FISHING_ROD);
			Potion speedp = new Potion(PotionType.SPEED, 2);
			ItemStack speed = speedp.toItemStack(1);

			ItemMeta metar = rod.getItemMeta();
			ItemMeta metab = bow.getItemMeta();
			ItemMeta metaa = arrow.getItemMeta();
			ItemMeta pmeta = speed.getItemMeta();

			pmeta.setDisplayName("§7Doping §7- §62 Coins");
			metar.setDisplayName("§fSpielerangel §7- §65 Coins");
			metaa.setDisplayName("§fMunition §7- §61Coin");
			metab.setDisplayName("§fSniper §7- §67 Coins");

			metab.spigot().setUnbreakable(true);
			metab.addEnchant(Enchantment.ARROW_KNOCKBACK, 2, true);

			rod.setItemMeta(metar);
			speed.setItemMeta(pmeta);
			arrow.setItemMeta(metaa);
			bow.setItemMeta(metab);

			shop.setItem(0, speed);
			shop.setItem(4, rod);
			shop.setItem(8, bow);
			shop.setItem(17, arrow);

			p.openInventory(shop);
		}
	}
}
