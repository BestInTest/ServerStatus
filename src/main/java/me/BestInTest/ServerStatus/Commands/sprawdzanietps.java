package me.BestInTest.ServerStatus.Commands;

import me.BestInTest.ServerStatus.Utils.ChatFix;
import me.BestInTest.ServerStatus.Utils.CurrentTPS;
import net.minecraft.server.v1_15_R1.MinecraftServer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class sprawdzanietps implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        sender.sendMessage(ChatFix.fixColor("&8---------{&a&lSERVERSTATUS&8}---------"));
        sender.sendMessage(ChatFix.fixColor("&7Aktualny TPS: &9") + CurrentTPS.getTPS());
        sender.sendMessage(ChatFix.fixColor("&7TPS: &a") + MinecraftServer.getServer().recentTps);
        sender.sendMessage(ChatFix.fixColor("&7Tick time: &a") + MinecraftServer.TICK_TIME);
        sender.sendMessage(ChatFix.fixColor("&8---------{&a&lSERVERSTATUS&8}---------"));
        return false;
    }
}