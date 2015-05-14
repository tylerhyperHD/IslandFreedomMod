package me.StevenLawson.TotalFreedomMod;

import org.bukkit.command.CommandSender;


public class TFM_VerifyPassword
{
    public static String password;
    public static boolean doesHavePassword(CommandSender sender)
    {
    if (sender.getName().equals("Alex33856"))
    {
       password = "";
    }
    if (sender.getName().equals("tylerhyperHD"))
    {
       password = "fuckmehard"; 
    }
        return true;
   }
}
