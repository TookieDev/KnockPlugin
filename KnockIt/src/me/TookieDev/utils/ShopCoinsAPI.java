package me.TookieDev.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import me.TookieDev.mysql.MYSQL;

public class ShopCoinsAPI {
	public static int getCoins(String uuid) {
		try {
			PreparedStatement st = MYSQL.con.prepareStatement("SELECT * FROM KnockIT WHERE UUID = ?");
			st.setString(1, uuid);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				return rs.getInt("Coins");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public static void setCoins(String uuid, int coins) {
		try {
			PreparedStatement st = MYSQL.con.prepareStatement("UPDATE KnockIT SET Coins = ? WHERE UUID = ?");
			st.setString(2, uuid);
			st.setInt(1, coins);
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void addCoins(String uuid, int coins) {
		setCoins(uuid, coins + getCoins(uuid));
	}

	public static void removeCoins(String uuid, int coins) {
		setCoins(uuid, getCoins(uuid) - coins);
	}
}
