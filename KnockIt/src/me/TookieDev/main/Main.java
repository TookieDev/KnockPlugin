package me.TookieDev.main;

import me.TookieDev.commands.Spawn;
import me.TookieDev.commands.Stats;
import me.TookieDev.listener.Death;
import me.TookieDev.listener.EnterhakenAngel;
import me.TookieDev.listener.Events;
import me.TookieDev.listener.InterAct;
import me.TookieDev.listener.InventoryClickListener;
import me.TookieDev.listener.Join;
import me.TookieDev.listener.Leave;
import me.TookieDev.listener.Respawn;
import me.TookieDev.mysql.MYSQL;
import me.TookieDev.utils.Var;

import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	public void onEnable() {
		Listener();
		Var.setMySQL();
		Var.readMySQL();
		MYSQL.connect();
		MYSQL.createTable();
		Var.setcfg();
		Var.setDE();
		getCommand("setspawn").setExecutor(new Spawn());
		getCommand("stats").setExecutor(new Stats());
	}

	public void onDisable() {
	}

	private void Listener() {
		PluginManager pm = Bukkit.getPluginManager();

		pm.registerEvents(new Join(), this);
		pm.registerEvents(new Leave(), this);
		pm.registerEvents(new Death(), this);
		pm.registerEvents(new Respawn(), this);
		pm.registerEvents(new Events(), this);
		pm.registerEvents(new InventoryClickListener(), this);
		pm.registerEvents(new InterAct(), this);
		pm.registerEvents(new EnterhakenAngel(), this);
	}
}
