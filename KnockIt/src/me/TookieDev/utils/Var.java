package me.TookieDev.utils;

import java.io.File;
import java.io.IOException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.configuration.file.YamlConfigurationOptions;

public class Var {
	public static String pr = "§aKnock-IT §7» ";
	public static String noperm = pr + "§cDu hast dafür keine §l§n§oRechte!";
	public static File configFile = new File("plugins//Knock-IT//config.yml");
	public static File cfgFile = new File("plugins//Knock-IT//spawn.yml");
	public static File MysqlFile = new File("plugins//Knock-IT//Mysql.yml");
	public static File deFile = new File("plugins//Knock-IT//languages//german.yml");
	public static YamlConfiguration con = YamlConfiguration.loadConfiguration(configFile);
	public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(cfgFile);
	public static YamlConfiguration Mysqlcfg = YamlConfiguration.loadConfiguration(MysqlFile);
	public static YamlConfiguration decfg = YamlConfiguration.loadConfiguration(deFile);

	public static File getMySQLFile() {
		return new File("plugins//Knock-IT", "mysql.yml");
	}

	public static FileConfiguration getMySQLFileConfiguration() {
		return YamlConfiguration.loadConfiguration(getMySQLFile());
	}

	public static void readMySQL() {
		FileConfiguration cfg = getMySQLFileConfiguration();
		me.TookieDev.mysql.MYSQL.username = cfg.getString("Mysql.User");
		me.TookieDev.mysql.MYSQL.password = cfg.getString("Mysql.Passwort");
		me.TookieDev.mysql.MYSQL.database = cfg.getString("Mysql.Database");
		me.TookieDev.mysql.MYSQL.host = cfg.getString("Mysql.Host");
		me.TookieDev.mysql.MYSQL.port = cfg.getString("Mysql.Port");
	}

	public static void setMySQL() {
		Mysqlcfg.options().copyDefaults(true);
		Mysqlcfg.addDefault("Mysql.User", "KnockIT");
		Mysqlcfg.addDefault("Mysql.Passwort", "your_password");
		Mysqlcfg.addDefault("Mysql.Database", "Knock-IT");
		Mysqlcfg.addDefault("Mysql.Host", "localhost");
		Mysqlcfg.addDefault("Mysql.Port", "3306");
		try {
			Mysqlcfg.save(MysqlFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void setcfg() {
		con.options().copyDefaults(true);
		con.set("Info", "Das Plugin ist für Durchrasten Programmiert!");
		con.addDefault("language", "DE");
		try {
			con.save(configFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void setDE() {
		decfg.options().copyDefaults(true);
		decfg.addDefault("Message.Join", "&aDer Spieler %Player% hat das Spiel betreten!");
		decfg.addDefault("Message.Quit", "&aDer Spieler %Player% hat das Spiel verlassen!");
		decfg.addDefault("Tod.Spieler", "&aDu wurdest von %Killer% getötet!");
		decfg.addDefault("Tod.Killer", "&aDu hast %Player% getötet!");
		decfg.addDefault("Tod.Nichts", "&aDu bist ins nichts gefallen!");
		try {
			decfg.save(deFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
