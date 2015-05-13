package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Admin;
import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_PlayerData;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH, blockHostConsole = true)
@CommandParameters(description = "Verifys a superadmin via their password.", usage = "/<command> <player> <reason>")
public class Command_verify extends TFM_Command
{
    private final String verifyPassword;
    
    private Command_verify (String verifyPassword)
    {
    this.verifyPassword = verifyPassword;
    }

    public String getVerifyPassword()
    {
        return verifyPassword;
    }
    
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        final TFM_Admin entry = TFM_AdminList.getEntry((Player) sender);
        if (!(sender instanceof Player))
        {
            TFM_Util.playerMsg(sender, "Verification on Console is supering yourself!", ChatColor.BLACK);
        }
        if (args.length == 0)
        {
            return false;
        }
        else if (args.length == 1)
        {
        // If the player is an official imposter
        if(TFM_AdminList.isAdminImpostor((Player) sender))
        {
           final String verifyPassword = entry.getVerifyPassword();
           if (verifyPassword == null || verifyPassword.isEmpty() || verifyPassword == "none") {
               sender.sendMessage("Unfortunately, you do not have a verify password defined. Contact tyler to see how you can get one.");
           }
           if (args[0].equalsIgnoreCase(verifyPassword)) {
               TFM_Util.bcastMsg(ChatColor.RED + sender.getName() + "has verified successfully with their password.");
               TFM_Util.bcastMsg("PwdVerifier - Adding " + sender.getName() + " to the superadmin list");
                final TFM_PlayerData playerdata = TFM_PlayerData.getPlayerData(sender_p.getPlayer());
                    if (playerdata.isFrozen())
                    {
                        playerdata.setFrozen(false);
                    }
           }
        }
        else {
            sender.sendMessage(ChatColor.YELLOW + "You are either not admin or are not an imposter to use this command!");
        }
            
        }
      return false;
  }
}