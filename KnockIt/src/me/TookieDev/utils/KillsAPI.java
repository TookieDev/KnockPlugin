package me.TookieDev.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import me.TookieDev.mysql.MYSQL;

public class KillsAPI {
	public static int getKills(String uuid) {
		try {
			PreparedStatement st = MYSQL.con.prepareStatement("SELECT * FROM KnockIT WHERE UUID = ?");
			st.setString(1, uuid);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				return rs.getInt("Kills");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public static void setKills(String uuid, int Kills) {
		try {
			PreparedStatement st = MYSQL.con.prepareStatement("UPDATE KnockIT SET Kills = ? WHERE UUID = ?");
			st.setString(2, uuid);
			st.setInt(1, Kills);
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void addKills(String uuid, int Kills) {
		setKills(uuid, Kills + getKills(uuid));
	}
}
