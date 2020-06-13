package me.BestInTest.ServerStatus.Commands;

import me.BestInTest.ServerStatus.Utils.ChatFix;
import me.BestInTest.ServerStatus.Utils.CurrentTPS;
import net.minecraft.server.v1_15_R1.MinecraftServer;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.management.Attribute;
import javax.management.AttributeList;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static net.minecraft.server.v1_15_R1.MinecraftServer.TPS;

public class Status implements CommandExecutor {
    public static double getProcessCpuLoad() throws Exception {

        MBeanServer mbs    = ManagementFactory.getPlatformMBeanServer();
        ObjectName name    = ObjectName.getInstance("java.lang:type=OperatingSystem");
        AttributeList list = mbs.getAttributes(name, new String[]{ "ProcessCpuLoad" });

        if (list.isEmpty())     return Double.NaN;

        Attribute att = (Attribute)list.get(0);
        Double value  = (Double)att.getValue();

        // usually takes a couple of seconds before we get real values
        if (value == -1.0)      return Double.NaN;
        // returns a percentage value with 1 decimal point precision
        return ((int)(value * 1000) / 10.0);
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] strings) {
        final long start = System.currentTimeMillis();
        sender.sendMessage(ChatFix.fixColor("&8---------{&a&lSERVERSTATUS&8}---------"));
        sender.sendMessage(ChatFix.fixColor("&eBukkit: &6" + Bukkit.getBukkitVersion()));
        sender.sendMessage(ChatFix.fixColor("&eJava: &6" + System.getProperty("java.runtime.version")));
        sender.sendMessage(ChatFix.fixColor("&eOS: &9" + System.getProperty("os.name")));
        sender.sendMessage(ChatFix.fixColor("&eArch: &a" + System.getProperty("os.arch")));
        sender.sendMessage(ChatFix.fixColor("&eThread priority: &a" + Thread.currentThread().getPriority()));
        sender.sendMessage(ChatFix.fixColor("&eTPS (server): &a" + TPS));
        sender.sendMessage(ChatFix.fixColor("&eTPS aktualny: &a" + CurrentTPS.getTPS()));
        sender.sendMessage(ChatFix.fixColor("&eAktualny tick: &a" + MinecraftServer.currentTick));
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
