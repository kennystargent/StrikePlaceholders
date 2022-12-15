package me.rcti.strikeplaceholders;

import ga.strikepractice.StrikePractice;
import ga.strikepractice.api.StrikePracticeAPI;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PlaceholderManager
        extends PlaceholderExpansion {
    public String getAuthor() {
        return Main.getInstance().getDescription().getAuthors().toString();
    }

    public boolean persist() {
        return true;
    }

    public String getIdentifier() {
        return "SPP";
    }

    public String getVersion() {
        return "1.0";
    }

    public String onPlaceholderRequest(Player p, String i) {
        if (p == null) {
            return "";
        }
        if (i.startsWith("queuecount_")) {
            String kit = i.split("_")[1];
            int c = 0;
            StrikePracticeAPI api = StrikePractice.getAPI();
            for (Player on : Bukkit.getOnlinePlayers()) {
                if (!api.isInQueue(on) || !api.getKit(on).getName().equalsIgnoreCase(kit)) continue;
                ++c;
            }
            return String.valueOf(c);
        }
        if (i.startsWith("infightcount_")) {
            String kit = i.split("_")[1];
            int c = 0;
            StrikePracticeAPI api = StrikePractice.getAPI();
            for (Player on : Bukkit.getOnlinePlayers()) {
                if (!api.isInFight(on) || !api.getFight(on).getKit().getName().equalsIgnoreCase(kit)) continue;
                ++c;
            }
            return String.valueOf(c);
        }
        return null;
    }
}
