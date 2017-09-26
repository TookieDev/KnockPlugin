package me.TookieDev.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;

import me.TookieDev.utils.Var;

public class MYSQL {
	public static String host;
	public static String port;
	public static String database;
	public static String username;
	public static String password;
	public static Connection con;

	public static void connect() {
		if (!isConnect()) {
			try {
				con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username,
						password);
				Bukkit.getConsoleSender().sendMessage(Var.pr + "§aMySQL ist nun an!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void end() {
		if (isConnect()) {
			try {
				con.close();
				Bukkit.getConsoleSender().sendMessage(Var.pr + "§aMySQL ist nun aus!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static boolean isConnect() {
		return con != null;
	}

	public static void createTable() {
		if (isConnect()) {
			try {
				PreparedStatement ps = con.prepareStatement(
						"CREATE TABLE IF NOT EXISTS KnockIT (id INT AUTO_INCREMENT NOT NULL, UUID VARCHAR(64), Kills INT, Tode INT, Coins INT, PRIMARY KEY (id))");
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void createUser(String uuid) throws SQLException {
		ResultSet rs = con.prepareStatement("SELECT * FROM KnockIT WHERE UUID='" + uuid + "'").executeQuery();
		if (rs.next()) {
			return;
		}
		PreparedStatement ps = con
				.prepareStatement("INSERT INTO KnockIT (UUID, Kills, Tode, Coins) VALUES ('" + uuid + "', 0, 0, 1)");
		ps.execute();
	}
}
