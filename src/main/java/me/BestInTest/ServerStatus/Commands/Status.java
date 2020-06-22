package me.BestInTest.ServerStatus.Commands;

import me.BestInTest.ServerStatus.Utils.ChatFix;
import me.BestInTest.ServerStatus.Utils.CurrentTPS;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static me.BestInTest.ServerStatus.Utils.ProcessCpuLoad.getProcessCpuLoad;

public class Status implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] strings) {
        final long start = System.currentTimeMillis();
        sender.sendMessage(ChatFix.fixColor("&8---------{&a&lSERVERSTATUS&8}---------"));
        sender.sendMessage(ChatFix.fixColor("&eBukkit: &6" + Bukkit.getBukkitVersion()));
        sender.sendMessage(ChatFix.fixColor("&eJava: &6" + System.getProperty("java.runtime.version")));
        sender.sendMessage(ChatFix.fixColor("&eOS: &9" + System.getProperty("os.name")));
        sender.sendMessage(ChatFix.fixColor("&eArch: &a" + System.getProperty("os.arch")));
        sender.sendMessage(ChatFix.fixColor("&eThread priority: &a" + Thread.currentThread().getPriority()));
        sender.sendMessage(ChatFix.fixColor("&eTPS: &a" + CurrentTPS.getTPS()));
        //List<Player> playerList = new ArrayList<>(Bukkit.getOnlinePlayers());
        //playerList.stream().map(Player::getDisplayName).collect(Collectors.joining(", "));
        //int graczeonline = Bukkit.getServer().getOnlinePlayers().size();
        sender.sendMessage(ChatFix.fixColor("&eGracze: &a" + Bukkit.getServer().getOnlinePlayers().size() + "/" + Bukkit.getMaxPlayers()));
        sender.sendMessage(ChatFix.fixColor("&ePamiec max: &9" + Runtime.getRuntime().totalMemory() + " &8B"));
        sender.sendMessage(ChatFix.fixColor("&ePamiec wolna: &9" + Runtime.getRuntime().freeMemory() + " &8B"));
        sender.sendMessage(ChatFix.fixColor("&eDostepne procesory: &6" + Runtime.getRuntime().availableProcessors()));
        try {
            sender.sendMessage(ChatFix.fixColor("&eUzycie CPU: &c" + getProcessCpuLoad()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        sender.sendMessage(ChatFix.fixColor("&8---------{&a&lSERVERSTATUS&8}---------"));
        final long czas = System.currentTimeMillis() - start;
        sender.sendMessage(ChatFix.fixColor("&7Zbieranie informacji zajelo " + czas + " ms"));
        return false;
    }
}
