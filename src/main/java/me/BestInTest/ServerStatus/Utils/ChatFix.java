package me.BestInTest.ServerStatus.Utils;

import org.bukkit.ChatColor;

public class ChatFix {
    public static String fixColor(String s){
        return ChatColor.translateAlternateColorCodes('&', s);
    }
}
