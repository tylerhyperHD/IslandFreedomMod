package me.StevenLawson.TotalFreedomMod;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class TFM_VerifyPassword
{
    private String verifyPassword;
    
    private TFM_VerifyPassword(String verifyPassword)
    {
        this.verifyPassword = verifyPassword;
    }
    
    public String getVerifyPassword()
    {
        return verifyPassword;
    }
}
