package me.StevenLawson.TotalFreedomMod.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH)
@CommandParameters(
        description = "Clears your inventory. Made to remove stress on admins.",
        aliases = "ci,clearinventory,clearme,meneedclearinventory,plzclearmeinventory,inventorycleared,inventoryclear,ciplz",
        usage = "/<command>")
public class Command_clear extends TFM_Command
{
    @Override
    public boolean run(final CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
            Player player = (Player)sender;
            player.closeInventory();
            player.getInventory().clear();
            player.sendMessage(ChatColor.GOLD + "Your inventory has been cleared.");
            return true;
    }
}
