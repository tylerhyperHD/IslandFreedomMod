package me.StevenLawson.TotalFreedomMod;

import me.StevenLawson.TotalFreedomMod.Config.TFM_ConfigEntry;
import static me.StevenLawson.TotalFreedomMod.TFM_Util.DEVELOPERS;
import static me.StevenLawson.TotalFreedomMod.TFM_Util.FOP_DEVELOPERS;
import static me.StevenLawson.TotalFreedomMod.TFM_Util.IFM_DEVELOPERS;
import static me.StevenLawson.TotalFreedomMod.TFM_Util.SPECIAL_EXECS;
import static me.StevenLawson.TotalFreedomMod.TFM_Util.SYS_ADMINS;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public enum TFM_PlayerRank
{
    DEVELOPER("a " + ChatColor.DARK_PURPLE + "TotalFreedomMod Developer", ChatColor.DARK_PURPLE + "[TFM Dev]"),
    FOP_DEVELOPER("a " + ChatColor.DARK_PURPLE + "FreedomOP Developer", ChatColor.DARK_PURPLE + "[FOP-Dev]"),
    IFM_DEVELOPER("a " + ChatColor.DARK_PURPLE + "Developer", ChatColor.DARK_PURPLE + "[Dev]"),
    SPEC_EXEC("a " + ChatColor.YELLOW + "Special Executive", ChatColor.YELLOW + "[Spec-Exec]"),
    SYS_ADMIN("a " + ChatColor.DARK_RED + "System-Admin", ChatColor.DARK_RED + "[Sys-Admin]"),
    IMPOSTOR("an " + ChatColor.GRAY + ChatColor.UNDERLINE + "Impostor", ChatColor.GRAY.toString() + ChatColor.UNDERLINE + "[IMP]"),
    NON_OP("a " + ChatColor.GREEN + "Non-OP", ChatColor.GREEN.toString()),
    OP("an " + ChatColor.RED + "OP", ChatColor.RED + "[OP]"),
    SUPER("a " + ChatColor.GOLD + "Super Admin", ChatColor.GOLD + "[SA]"),
    TELNET("a " + ChatColor.DARK_GREEN + "Super Telnet Admin", ChatColor.DARK_GREEN + "[STA]"),
    SENIOR("a " + ChatColor.LIGHT_PURPLE + "Senior Admin", ChatColor.LIGHT_PURPLE + "[SrA]"),
    OWNER("the " + ChatColor.BLUE + "Owner of " + ChatColor.LIGHT_PURPLE + "IslandFreedom", ChatColor.BLUE + "[Owner]"),
    CO_OWNER("the " + ChatColor.BLUE + "Co-Owner of " + ChatColor.LIGHT_PURPLE + "IslandFreedom", ChatColor.BLUE + "[Co-Owner]"),
    CONSOLE("the " + ChatColor.DARK_PURPLE + "Console", ChatColor.DARK_PURPLE + "[Console]");
    private String loginMessage;
    private String verifyPassword;
    private String prefix;

    private TFM_PlayerRank(String loginMessage, String prefix)
    {
        this.loginMessage = loginMessage;
        this.verifyPassword = verifyPassword;
        this.prefix = prefix;
    }

    public static String getLoginMessage(CommandSender sender)
    {
        // Handle console
        if (!(sender instanceof Player))
        {
            return fromSender(sender).getLoginMessage();
        }

        // Handle admins
        final TFM_Admin entry = TFM_AdminList.getEntry((Player) sender);
        if (entry == null)
        {
            // Player is not an admin
            return fromSender(sender).getLoginMessage();
        }

        // Custom login message
        final String loginMessage = entry.getCustomLoginMessage();

        if (loginMessage == null || loginMessage.isEmpty())
        {
            return fromSender(sender).getLoginMessage();
        }

        return ChatColor.translateAlternateColorCodes('&', loginMessage);
    }

    public static TFM_PlayerRank fromSender(CommandSender sender)
    {
        if (!(sender instanceof Player))
        {
            return CONSOLE;
        }

        if (TFM_AdminList.isAdminImpostor((Player) sender))
        {
            return IMPOSTOR;
        }
        
        else if (sender.getName().equals("LukaThePenguin"))
        {
            return OWNER;
        }
        
        else if (sender.getName().equals("LegendaryCraft"))
        {
            return CO_OWNER;
        }
        
        else if (SYS_ADMINS.contains(sender.getName()))
        {
            return SYS_ADMIN;
        }

        else if (SPECIAL_EXECS.contains(sender.getName()))
        {
            return SPEC_EXEC;
        }

        else if (FOP_DEVELOPERS.contains(sender.getName()))
        {
            return FOP_DEVELOPER;
        }
        
        else if (IFM_DEVELOPERS.contains(sender.getName()))
        {
            return IFM_DEVELOPER;
        }

        if (DEVELOPERS.contains(sender.getName()))
        {
            return DEVELOPER;
        }

        final TFM_Admin entry = TFM_AdminList.getEntry((Player) sender);

        final TFM_PlayerRank rank;

        if (entry != null && entry.isActivated())
        {
            if (TFM_ConfigEntry.SERVER_OWNERS.getList().contains(sender.getName()))
            {
                return OWNER;
            }

            if (entry.isSeniorAdmin())
            {
                rank = SENIOR;
            }
            else if (entry.isTelnetAdmin())
            {
                rank = TELNET;
            }
            else
            {
                rank = SUPER;
            }
        }
        else
        {
            if (sender.isOp())
            {
                rank = OP;
            }
            else
            {
                rank = NON_OP;
            }

        }
        return rank;
    }

    public String getPrefix()
    {
        return prefix;
    }

    public String getLoginMessage()
    {
        return loginMessage;
    }
    
    public String getVerifyPassword()
    {
        return verifyPassword;
    }
}
