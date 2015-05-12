package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.SENIOR, source = SourceType.BOTH)
@CommandParameters(description = "Manage the telnet client", usage = "/<command> <off | on>")
public class Command_telnet extends TFM_Command
{

    @Override
    public boolean run(final CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (!TFM_Util.SYS_ADMINS.contains(sender.getName()) && !TFM_Util.IFM_DEVELOPERS.contains(sender.getName()) && !TotalFreedomMod.OWNER.contains(sender.getName()))
        {
            sender.sendMessage(TotalFreedomMod.MSG_NO_PERMS);

            if (!senderIsConsole)
            {
                sender.setOp(false);
            }
            else
            {
                sender.sendMessage("You may not use this, sorry.");
            }

            return true;
        }
        if (args.length == 0)
        {
            return false;
        }
        else if (args.length == 1)
        {
        if (args[0].equals("on"))
        {
            server.dispatchCommand(sender, "plugincontrol enable BukkitTelnet");
        TFM_Util.adminAction(sender.getName(), "Enabling the telnet client for all admins", true);
        return true;
        }
        else if (args[0].equals("off"))
        {
            server.dispatchCommand(sender, "plugincontrol disable BukkitTelnet");
            TFM_Util.adminAction(sender.getName(), "Disabling the telnet client for all admins", true);
        }
        }
    return true;
    }
}