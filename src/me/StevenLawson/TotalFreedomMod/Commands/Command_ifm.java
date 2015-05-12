package me.StevenLawson.TotalFreedomMod.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH)
@CommandParameters(description = "Show info about IslandFreedomMod", usage = "/<command>")
public class Command_ifm extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        sender.sendMessage(ChatColor.GREEN + "The IslandFreedom plugin is a fork from FreedomOpMod!,");
        sender.sendMessage(ChatColor.GOLD + "To Make your own FreedomMod, visit https://github.com/TotalFreedom/TotalFreedomMod for more info!");
        sender.sendMessage(ChatColor.DARK_PURPLE + "IFM was Created by Alex33856, TylerHyperHD, Scuph for The IslandFreedom Server!");
        sender.sendMessage(ChatColor.RED + "IFM Version: v" + ChatColor.GRAY + "4.6");
        sender.sendMessage(ChatColor.BLUE + "For more info, please visit our forum at http://islandfreedom.boards.net/");
        sender.sendMessage(ChatColor.BLUE + "Or contact to one of our Developers :)");
        sender.sendMessage(ChatColor.BLUE + "If you would like something added, Please make an Pull request or if you find a issue go to" + ChatColor.GOLD + " http://github.com/IslandFreedom/IslandaFreedomMod/issues");
        return true;
    }
}
        
