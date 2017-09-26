package me.TookieDev.utils;

import java.util.Random;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class ScoreboardC {
	public static void sendScoreboard(Player p) {
		Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
		Objective obj = board.getObjective("aaa") != null ? board.getObjective("aaa")
				: board.registerNewObjective("aaa", "bbb");

		obj.setDisplayName("§c " + p.getDisplayName());
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);

		obj.getScore(Var.pr).setScore(5);
		obj.getScore("§a").setScore(4);
		obj.getScore("§aKills: " + KillsAPI.getKills(p.getUniqueId().toString())).setScore(3);
		obj.getScore("§aTode: " + TodesAPI.getTode(p.getUniqueId().toString())).setScore(2);
		obj.getScore("§aCoins: " + ShopCoinsAPI.getCoins(p.getUniqueId().toString())).setScore(1);

		p.setScoreboard(board);
	}

	public static void updateScoreboard(Player p) {
		Objective obj = p.getScoreboard().getObjective("aaa") != null ? p.getScoreboard().getObjective("aaa")
				: p.getScoreboard().registerNewObjective("aaa", "bbb");
		obj.getScore(Var.pr).setScore(new Random().nextInt(5));
		obj.getScore("§a").setScore(new Random().nextInt(4));
		obj.getScore("§aKills: " + KillsAPI.getKills(p.getUniqueId().toString())).setScore(new Random().nextInt(3));
		obj.getScore("§aTode: " + TodesAPI.getTode(p.getUniqueId().toString())).setScore(new Random().nextInt(2));
		obj.getScore("§aCoins: " + ShopCoinsAPI.getCoins(p.getUniqueId().toString())).setScore(new Random().nextInt(1));
	}
}
