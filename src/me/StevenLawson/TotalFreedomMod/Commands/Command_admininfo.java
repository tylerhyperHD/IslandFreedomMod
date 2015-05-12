// Not allowed to be removed idiots

package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH)
@CommandParameters(
        description = "See how to become admin.",
        aliases = "ai",
        usage = "/<command>")
public class Command_admininfo extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        TFM_Util.playerMsg(sender_p, "So you wish to apply for admin do you?", ChatColor.BLUE);
        TFM_Util.playerMsg(sender_p, "Go to our forums at http://islandfreedom.boards.net", ChatColor.GREEN);
        TFM_Util.playerMsg(sender_p, ChatColor.GREEN + "Admin Application Details:");
		TFM_Util.playerMsg(sender_p, ChatColor.YELLOW + "You must of been registed on forums for 30 Days before applying and need an Admin recommendation");
		TFM_Util.playerMsg(sender_p, ChatColor.GREEN + "First, Go to the Admin Applications Section");
		TFM_Util.playerMsg(sender_p, ChatColor.BLUE + "After that you need to look for the template");
		TFM_Util.playerMsg(sender_p, ChatColor.GREEN + "After finding the template, Copy the whole template");
        TFM_Util.playerMsg(sender_p, ChatColor.BLUE + "Then, Go out of that and make a new thread");
		TFM_Util.playerMsg(sender_p, ChatColor.GREEN + "Name it " + sender.getName() + "'s Admin Application!");
		TFM_Util.playerMsg(sender_p, ChatColor.BLUE + "Then paste the template there and begin filling out your answers");
		TFM_Util.playerMsg(sender_p, ChatColor.GREEN + "Forum URL: http://islandfreedom.boards.net");
        return true;
    }
}
