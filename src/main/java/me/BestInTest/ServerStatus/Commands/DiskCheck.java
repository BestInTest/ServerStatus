package me.BestInTest.ServerStatus.Commands;

import me.BestInTest.ServerStatus.Utils.ChatFix;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.io.File;

public class DiskCheck implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (args.length != 0) {
            if (args[0].equalsIgnoreCase("linux")) {
                File root = new File("/");
                sender.sendMessage(ChatFix.fixColor("&8---------{&a&lSERVERSTATUS&8}---------"));
                sender.sendMessage(ChatFix.fixColor(String.format("&7Pamiec calkowita:&9 %.2f GB", (double) root.getTotalSpace() / 1073741824)));
                sender.sendMessage(ChatFix.fixColor(String.format("&7Wolna pamiec:&9 %.2f GB", (double) root.getFreeSpace() / 1073741824)));
                sender.sendMessage(ChatFix.fixColor(String.format("&7Dostepna pamiec:&9 %.2f GB", (double) root.getUsableSpace() / 1073741824)));
                sender.sendMessage(ChatFix.fixColor("&8---------{&a&lSERVERSTATUS&8}---------"));
                return true;
            }
            if (args[0].equalsIgnoreCase("windows")) {
                File cDrive = new File("C:");
                sender.sendMessage(ChatFix.fixColor("&8---------{&a&lSERVERSTATUS&8}---------"));
                sender.sendMessage(ChatFix.fixColor(String.format("&7Pamiec calkowita:&9 %.2f GB", (double) cDrive.getTotalSpace() / 1073741824)));
                sender.sendMessage(ChatFix.fixColor(String.format("&7Wolna pamiec:&9 %.2f GB", (double) cDrive.getFreeSpace() / 1073741824)));
                sender.sendMessage(ChatFix.fixColor(String.format("&7Dostepna pamiec:&9 %.2f GB", (double) cDrive.getUsableSpace() / 1073741824)));
                sender.sendMessage(ChatFix.fixColor("&8---------{&a&lSERVERSTATUS&8}---------"));
                return true;
            } else {
                sender.sendMessage(ChatFix.fixColor("&7Uzycie sprawdzania dysku: &a/diskcheck <linux/windows>"));
            }
        }
        else {
            sender.sendMessage(ChatFix.fixColor("&7Uzycie sprawdzania dysku: &a/diskcheck <linux/windows>"));
        }
        return false;
    }
}
