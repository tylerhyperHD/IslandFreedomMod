package me.StevenLawson.TotalFreedomMod.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "Deez nuts :)", usage = "/<command>")
public class Command_deeznuts extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
            Bukkit.broadcastMessage(ChatColor.GOLD + sender.getName() + "has started taking telling people to suck deez, deez? DEEZ NUTS!!!");
            return true;
    }
}
