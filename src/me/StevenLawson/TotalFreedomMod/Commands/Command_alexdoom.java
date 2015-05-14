package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Ban;
import me.StevenLawson.TotalFreedomMod.TFM_BanManager;
import me.StevenLawson.TotalFreedomMod.TFM_PlayerList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import me.StevenLawson.TotalFreedomMod.TFM_Log;
import org.bukkit.Bukkit;
import static org.bukkit.Bukkit.getPlayer;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

@CommandPermissions(level=AdminLevel.ALL, source=SourceType.BOTH)
@CommandParameters(description="For the bad Superadmins", usage="/<command> <playername>")
public class Command_alexdoom extends TFM_Command
{
  public boolean run(final CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
  {
    if (!sender.getName().equals("Alex33856"))
    {
      sender.sendMessage(TotalFreedomMod.MSG_NO_PERMS);
      TFM_Log.info("Alert: " + sender.getName() + "Tried to use Alexdoom!");
      
      return true;
    }
    if (args.length != 1) {
      return false;
    }
    final Player player = getPlayer(args[0]);
    if (player == null)
    {
      sender.sendMessage(TotalFreedomMod.PLAYER_NOT_FOUND);
      return true;
    }
    sender_p.chat("Hey " + player.getName() + ", I have a present for you!");
    player.chat("Sure, what is it?");
    sender_p.chat("It's........ OBLIVION!");
    TFM_Util.adminAction(sender.getName(), "INCOMING OBLIVION! Casting a dark, EVILLLLLLLL shadow of oblivion over " + player.getName(), true);
    TFM_Util.bcastMsg(player.getName() + "  Will be obliviated by Alex's dark,  EVILL power", ChatColor.RED);
    TFM_Log.info("[ALERT]: Alex33856 is fucking mad with " + player.getName() + "!");
    
    final String ip = player.getAddress().getAddress().getHostAddress().trim();
    
    // Removes player from whitelist
    player.setWhitelisted(false);
    // Deops Player
    player.setOp(false);
    // Puts them in survival
    player.setGameMode(GameMode.SURVIVAL);
    // Closes inventory
    player.closeInventory();
    // Clears Inventory
    player.getInventory().clear();
    // Burns them
    player.setFireTicks(10000);
    // Blows them up
    player.getWorld().createExplosion(player.getLocation(), 4.0F);
    // Mades them Scream!!
    player.chat("AHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH!!!!!!!! NOOOOOOOOO!!!");
    // Say there gone
    TFM_Util.bcastMsg(player.getName() + "Is GoNEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE", ChatColor.GREEN);
    // Says i made them vanish
    TFM_Log.info("Alex33856 has made them vanish :O");
    
    new BukkitRunnable()
    {
      public void run()
      {
        player.getWorld().strikeLightning(player.getLocation());
      }
    }
    

      .runTaskLater(this.plugin, 40L);
    



    player.getWorld().createExplosion(player.getLocation(), 4.0F);
    
    new BukkitRunnable()
    {
      public void run()
      {
        // Strikes them with lighting
        player.getWorld().strikeLightning(player.getLocation());
        // Made them say sorry :)
        Player sender_p = Bukkit.getPlayer(sender.getName());
        player.chat("Alex33856, I " + player.getName() + "shall never make you angry again or else you may" + ChatColor.RED + "Alex-DOOM" + ChatColor.RESET + "Me!");
        sender_p.chat(player.getName() + "Its " + ChatColor.BLUE + "Alexdoom" + ChatColor.RESET + "GOT IT!!!!!");
        player.chat("NO HAHAHAHHAHAHHAH");
        TFM_Log.info("How dare they, right?");
        // ban uuid
        TFM_BanManager.addUuidBan(player);
      }
    }
    
      .runTaskLater(this.plugin, 40L);
    


    TFM_Util.adminAction(player.getName(), "Has been Obliviated by " + sender.getName() + "may the pain continue as you burn", true);
    player.setFireTicks(10000);
    // ban IPs
        for (String playerIp : TFM_PlayerList.getEntry(player).getIps())
        {
            TFM_BanManager.addIpBan(new TFM_Ban(playerIp, player.getName()));
        }
    new BukkitRunnable()
    {
      public void run()
      {
        TFM_Util.adminAction(sender.getName(), "Has sent oblivion over: " + player.getName() + ", IP: " + ip, true);
        player.getWorld().createExplosion(player.getLocation(), 4.0F);
        player.kickPlayer(ChatColor.RED + player.getName() + "Why did you have to mess with " + sender.getName() + "?");
        TFM_Log.info("There gone!!!!");
      }
    }
    
      .runTaskLater(this.plugin, 80L);
    

    return true;
  }
}
