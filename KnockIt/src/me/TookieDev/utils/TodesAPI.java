package me.TookieDev.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import me.TookieDev.mysql.MYSQL;

public class TodesAPI {
	public static int getTode(String uuid) {
		try {
			PreparedStatement st = MYSQL.con.prepareStatement("SELECT * FROM KnockIT WHERE UUID = ?");
			st.setString(1, uuid);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				return rs.getInt("Tode");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public static void setTode(String uuid, int Tode) {
		try {
			PreparedStatement st = MYSQL.con.prepareStatement("UPDATE KnockIT SET Tode = ? WHERE UUID = ?");
			st.setString(2, uuid);
			st.setInt(1, Tode);
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void addTode(String uuid, int Tode) {
		setTode(uuid, Tode + getTode(uuid));
	}
}
