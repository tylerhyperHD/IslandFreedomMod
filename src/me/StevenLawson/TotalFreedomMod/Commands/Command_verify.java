package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_PlayerData;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TFM_VerifyPassword;
import static me.StevenLawson.TotalFreedomMod.TFM_VerifyPassword.password;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH, blockHostConsole = true)
@CommandParameters(description = "Verifys a superadmin via their password.", usage = "/<command> <password>")
public class Command_verify extends TFM_Command
{   
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (!(sender instanceof Player))
        {
            TFM_Util.playerMsg(sender, "Verification on Console is supering yourself!", ChatColor.BLACK);
            return true;
        }
        if (args.length == 0)
        {
            sender.sendMessage("Too few arguments!");
            return false;
        }
        else if (args.length == 1)
        {
        // If the player is an official imposter
        if(TFM_AdminList.isAdminImpostor((Player) sender))
        {
           if (TFM_VerifyPassword.doesHavePassword((Player) sender)) {
               if (args[0].contains(password)) {
               TFM_Util.bcastMsg(ChatColor.RED + sender.getName() + " has verified successfully with their password.");
               TFM_Util.bcastMsg(ChatColor.RED + "PwdVerifier - Adding " + sender.getName() + " to the superadmin list");
               TFM_AdminList.addSuperadmin(sender_p);
                final TFM_PlayerData playerdata = TFM_PlayerData.getPlayerData(sender_p.getPlayer());
                  if (playerdata.isFrozen())
                    {
                        playerdata.setFrozen(false);
                    }
               return true;
               }
               else {
                   sender.sendMessage(ChatColor.RED + "Your password is incorrect!");
                   return true;
               }
           }
        }
        else {
            sender.sendMessage(ChatColor.YELLOW + "You are either not admin or are not an imposter to use this command!");
            return true;
        }
      }
      return false;
  }
}