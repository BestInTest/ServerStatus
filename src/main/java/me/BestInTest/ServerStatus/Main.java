package me.BestInTest.ServerStatus;

import me.BestInTest.ServerStatus.Commands.Status;
import me.BestInTest.ServerStatus.Commands.sprawdzanietps;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        //System.out.println(ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + ChatColor.BOLD + "ServerStatus" + ChatColor.RESET + ChatColor.DARK_GRAY + "]");
        getServer().getConsoleSender().sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + ChatColor.BOLD + "ServerStatus" + ChatColor.RESET + ChatColor.DARK_GRAY + "]");
        System.out.println(" ");
        //System.out.println(ChatColor.RED + "Ladowanie komend...");
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "Ladowanie komend...");
        getCommand("status").setExecutor(new Status());
        getCommand("atps").setExecutor(new sprawdzanietps());
        //System.out.println(ChatColor.RED + "&cLadowanie ukonczone!");
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "Ladowanie ukonczone!");
        System.out.println(" ");
        //System.out.println(ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + ChatColor.BOLD + "ServerStatus" + ChatColor.RESET + ChatColor.DARK_GRAY + "]");
        getServer().getConsoleSender().sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + ChatColor.BOLD + "ServerStatus" + ChatColor.RESET + ChatColor.DARK_GRAY + "]");
    }
}
