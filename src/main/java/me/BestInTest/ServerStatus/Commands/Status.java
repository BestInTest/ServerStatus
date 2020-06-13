package me.BestInTest.ServerStatus.Commands;

import me.BestInTest.ServerStatus.Utils.ChatFix;
import me.BestInTest.ServerStatus.Utils.CurrentTPS;
import net.minecraft.server.v1_15_R1.MinecraftServer;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static net.minecraft.server.v1_15_R1.MinecraftServer.TPS;

public class Status implements CommandExecutor {
    @Override

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] strings) {
        final long start = System.currentTimeMillis();
        sender.sendMessage(ChatFix.fixColor("&8---------{&a&lSERVERSTATUS&8}---------"));
        sender.sendMessage(ChatFix.fixColor("&eBukkit: &6" + Bukkit.getBukkitVersion()));
        sender.sendMessage(ChatFix.fixColor("&eJava: &6" + System.getProperty("java.runtime.version")));
        sender.sendMessage(ChatFix.fixColor("&eOS: &9" + System.getProperty("os.name")));
        sender.sendMessage(ChatFix.fixColor("&eArch: &a" + System.getProperty("os.arch")));
        sender.sendMessage(ChatFix.fixColor("&eThread: &a" + Thread.currentThread()));
        sender.sendMessage(ChatFix.fixColor("&eTPS (server): &a" + TPS));
        sender.sendMessage(ChatFix.fixColor("&eTPS aktualny: &a" + CurrentTPS.getTPS()));
        sender.sendMessage(ChatFix.fixColor("&eAktualny tick: &a" + MinecraftServer.currentTick));
        //List<Player> playerList = new ArrayList<>(Bukkit.getOnlinePlayers());
        //playerList.stream().map(Player::getDisplayName).collect(Collectors.joining(", "));
        //int graczeonline = Bukkit.getServer().getOnlinePlayers().size();
        sender.sendMessage(ChatFix.fixColor("&eGracze: &a" + Bukkit.getServer().getOnlinePlayers().size() + "/" + Bukkit.getMaxPlayers()));
        sender.sendMessage(ChatFix.fixColor("&8---------{&a&lSERVERSTATUS&8}---------"));
        final long czas = System.currentTimeMillis() - start;
        sender.sendMessage(ChatFix.fixColor("&7Zbieranie informacji zajelo " + czas + " ms"));
        return false;
    }
}
