package me.StevenLawson.TotalFreedomMod;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class TFM_VerifyPassword
{
    private String verifyPassword;
    
    private TFM_VerifyPassword(String verifyPassword)
    {
        this.verifyPassword = verifyPassword;
    }

    public static String getVerifyPassword(CommandSender sender)
    {
        // Handle console
        if (!(sender instanceof Player))
        {
            sender.sendMessage("You must be in game to use this command.");
        }

        // Handle admins
        final TFM_Admin entry = TFM_AdminList.getEntry((Player) sender);
        final String verifyPassword = entry.getVerifyPassword();

        if (verifyPassword == null || verifyPassword.isEmpty())
        {
            sender.sendMessage("Unfortunately, you do not have a verify password defined. Contact tyler to see how you can get one.");
        }
        return ChatColor.translateAlternateColorCodes('&', verifyPassword);
    }

    
    public String getVerifyPassword()
    {
        return verifyPassword;
    }
}
