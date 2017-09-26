package me.TookieDev.listener;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.FishHook;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.util.Vector;

public class EnterhakenAngel implements Listener {
	@EventHandler
	public void onFish(PlayerFishEvent e) {
		Player p = e.getPlayer();
		FishHook hook = e.getHook();
		if (hook.getLocation().subtract(0.0D, 1.0D, 0.0D).getBlock().getType() != Material.AIR) {
			Location loc = p.getLocation();
			Location hloc = hook.getLocation();

			Vector v = p.getVelocity();
			double distance = loc.distance(hloc);

			v.setX(1.08D * distance * (hloc.getX() - loc.getX()) / distance);
			v.setY(1.0D * distance * (hloc.getY() - loc.getY()) / distance - -0.05D * distance);
			v.setZ(1.08D * distance * (hloc.getZ() - loc.getZ()) / distance);

			p.setVelocity(v);
			p.getInventory().getItemInHand().setDurability((short) 0);
			p.updateInventory();
		}
	}
}
