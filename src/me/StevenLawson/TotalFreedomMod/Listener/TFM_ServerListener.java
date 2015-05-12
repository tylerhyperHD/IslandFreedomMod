package me.StevenLawson.TotalFreedomMod.Listener;

import me.StevenLawson.TotalFreedomMod.Config.TFM_ConfigEntry;
import me.StevenLawson.TotalFreedomMod.TFM_BanManager;
import me.StevenLawson.TotalFreedomMod.TFM_ServerInterface;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class TFM_ServerListener implements Listener
{

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onServerPing(ServerListPingEvent event)
    {
        final String ip = event.getAddress().getHostAddress();

        if (TFM_BanManager.isIpBanned(ip))
        {
            event.setMotd(ChatColor.RED + "You are banned.");
            return;
        }

        if (TFM_ConfigEntry.ADMIN_ONLY_MODE.getBoolean())
        {
            event.setMotd(ChatColor.RED + "Server is in admin only mode.");
            return;
        }

        if (Bukkit.hasWhitelist())
        {
            event.setMotd(ChatColor.RED + "Whitelist is enabled.");
            return;
        }

        if (Bukkit.getOnlinePlayers().length >= Bukkit.getMaxPlayers())
        {
            event.setMotd(ChatColor.RED + "The server is full!");
            return;
        }

        if (!TFM_ConfigEntry.SERVER_COLORFUL_MOTD.getBoolean())
        {
            event.setMotd(TFM_Util.colorize(TFM_ConfigEntry.SERVER_MOTD.getString()
                    .replace("%mcversion%", TFM_ServerInterface.getVersion())));
            return;
        }
        
        if (TFM_ConfigEntry.ENABLE_CHAOS.getBoolean())
        {
            event.setMotd(ChatColor.RED + "Server is currently in chaos mode, prepare for some crazy shit!");
            return;
        }
        
        // Colorful MOTD

        String message = String.format("Welcome to IslandFreedom ", TFM_Util.getPlayerFromIp(ip)), " running on Spigot 1.8";

        final StringBuilder motd = new StringBuilder();

        for (String word : message.split(" "))
        {
            motd.append(TFM_Util.randomChatColor()).append(word).append(" ");
        }

        event.setMotd(TFM_Util.colorize(motd.toString()));
    }
}
