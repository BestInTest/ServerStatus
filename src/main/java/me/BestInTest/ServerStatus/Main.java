package me.BestInTest.ServerStatus;

import me.BestInTest.ServerStatus.Commands.DiskCheck;
import me.BestInTest.ServerStatus.Commands.Status;
import me.BestInTest.ServerStatus.Commands.sprawdzanietps;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        String svs = ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + ChatColor.BOLD + "ServerStatus" + ChatColor.RESET + ChatColor.DARK_GRAY + "]";
        getServer().getConsoleSender().sendMessage(svs);
        System.out.println(" ");
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "Ladowanie komend...");
        getCommand("status").setExecutor(new Status());
        getCommand("atps").setExecutor(new sprawdzanietps());
        getCommand("diskcheck").setExecutor(new DiskCheck());
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "Ladowanie ukonczone!");
        System.out.println(" ");
        getServer().getConsoleSender().sendMessage(svs);
    }
}
