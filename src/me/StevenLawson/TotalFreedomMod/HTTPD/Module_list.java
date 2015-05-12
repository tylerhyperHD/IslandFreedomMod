package me.StevenLawson.TotalFreedomMod.HTTPD;

import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Module_list extends TFM_HTTPD_Module
{
    public Module_list(NanoHTTPD.HTTPSession session)
    {
        super(session);
    }

    @Override
    public String getBody()
    {
        final StringBuilder body = new StringBuilder();

        final Player[] onlinePlayers = Bukkit.getOnlinePlayers();

        body.append("<p>There are ").append(onlinePlayers.length).append("/").append(Bukkit.getMaxPlayers()).append(" players online:</p>\r\n");

        body.append("<ul>\r\n");

        for (Player player : onlinePlayers)
        {
            String prefix = "";
            if (TFM_AdminList.isSuperAdmin(player))
            {
                if (TFM_AdminList.isSeniorAdmin(player))
                {
                    prefix = "[SrA]";
                }
                else
                {
                    prefix = "[SA]";
                }

                if (TFM_Util.DEVELOPERS.contains(player.getName()))
                {
                    prefix = "[Dev]";
                }

                if (TFM_AdminList.isOwner(player))
                {
                    prefix = "[Owner]";
                }
            }
            else
            {
                if (player.isOp())
                {
                    prefix = "[OP]";
                }
            }

            body.append("<li>").append(prefix).append(player.getName()).append("</li>\r\n");
        }

        body.append("</ul>\r\n");

        return body.toString();
    }

    @Override
    public String getTitle()
    {
        return TotalFreedomMod.MOD_NAME + " - Online Users";
    }
}
