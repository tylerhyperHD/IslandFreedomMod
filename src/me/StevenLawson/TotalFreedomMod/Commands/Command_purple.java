package me.StevenLawson.TotalFreedomMod.Commands;

/*

  ____                 _                              _     _             
 |  _ \    ___   ___  (_)   __ _   _ __     ___    __| |   | |__    _   _ 
 | | | |  / _ \ / __| | |  / _` | | '_ \   / _ \  / _` |   | '_ \  | | | |
 | |_| | |  __/ \__ \ | | | (_| | | | | | |  __/ | (_| |   | |_) | | |_| |
 |____/   \___| |___/ |_|  \__, | |_| |_|  \___|  \__,_|   |_.__/   \__, |
                           |___/                                    |___/ 


  _             _                 _                                     _   _   ____  
 | |_   _   _  | |   ___   _ __  | |__    _   _   _ __     ___   _ __  | | | | |  _ \ 
 | __| | | | | | |  / _ \ | '__| | '_ \  | | | | | '_ \   / _ \ | '__| | |_| | | | | |
 | |_  | |_| | | | |  __/ | |    | | | | | |_| | | |_) | |  __/ | |    |  _  | | |_| |
  \__|  \__, | |_|  \___| |_|    |_| |_|  \__, | | .__/   \___| |_|    |_| |_| |____/ 
        |___/                             |___/  |_|                                  



*/

import java.util.Arrays;
import java.util.List;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

@CommandPermissions(level = AdminLevel.OP, source = SourceType.BOTH)
@CommandParameters(description = "Graces the world with purple. Command that is pretty pointless unless you are tyler.", usage = "/<command>")
public class Command_purple extends TFM_Command
{

    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
     if (!sender.getName().equals("tylerhyperHD"))
        {
            sender_p.sendMessage(ChatColor.RED + "Only Tyler may use this command.\nNo permissions for the people who aren't purple.");
            sender_p.setHealth(0.0);

            if (!senderIsConsole)
            {
                sender.setOp(false);
            }
            else
            {
                sender_p.sendMessage(ChatColor.RED + "Only Tyler may use this command.\nNo permissions for the people who aren't purple.");
                sender_p.setHealth(0.0);
            }

            return true;
        }
            if (args.length == 0)
        {
          for(Player player : Bukkit.getOnlinePlayers())
                {
                    PlayerInventory inv = player.getInventory();
                    ItemStack CamWool = new ItemStack(Material.WOOL, 1, (short)10);
                    for (Enchantment ench : Enchantment.values()) {
                     if (!ench.equals(Enchantment.DURABILITY)) {
                        CamWool.addUnsafeEnchantment(ench, 32767);
                      }
                    }
                    ItemMeta meta = CamWool.getItemMeta();
                    meta.setDisplayName(ChatColor.YELLOW + "Purple Aura");
                    Object lore = Arrays.asList(new String[] { ChatColor.BLUE + "This aura should protect", ChatColor.BLUE + "you from all possible harm." });
                    meta.setLore((List)lore);
                    CamWool.setItemMeta(meta);
                    World world = player.getWorld();
                    Location loc = player.getLocation();
                    inv.setHelmet(CamWool);
                    world.strikeLightningEffect(loc);
                }
                for(Player player : Bukkit.getOnlinePlayers())
                {
                World world = player.getWorld();
                Location loc = player.getLocation();
                TFM_Util.adminAction(sender_p.getName(), "Gracing the world with purple!", false);
                world.strikeLightningEffect(loc);
                TFM_Util.adminAction(sender_p.getName(), "Gracing the world with purple!", false);
                world.strikeLightningEffect(loc);
                TFM_Util.adminAction(sender_p.getName(), "Gracing the world with purple!", false);
                world.strikeLightningEffect(loc);
                TFM_Util.adminAction(sender_p.getName(), "Gracing the world with purple!", false);
                world.strikeLightningEffect(loc);
                TFM_Util.adminAction(sender_p.getName(), "Gracing the world with purple!", false);
                world.strikeLightningEffect(loc);
                TFM_Util.adminAction(sender_p.getName(), "Gracing the world with purple!", false);
                world.strikeLightningEffect(loc);
                TFM_Util.adminAction(sender_p.getName(), "Gracing the world with purple!", false);
                world.strikeLightningEffect(loc);
                TFM_Util.adminAction(sender_p.getName(), "Gracing the world with purple!", false);
                world.strikeLightningEffect(loc);
                TFM_Util.adminAction(sender_p.getName(), "Gracing the world with purple!", false);
                world.strikeLightningEffect(loc);
                TFM_Util.adminAction(sender_p.getName(), "Gracing the world with purple!", false);
                world.strikeLightningEffect(loc);
                }
        for(Player player : Bukkit.getOnlinePlayers())
                {
                PlayerInventory inv = player.getInventory();
                ItemStack CamBow = new ItemStack(Material.BOW, 1);
                for (Enchantment ench : Enchantment.values()) {
                 CamBow.addUnsafeEnchantment(ench, 32767);
                }
                ItemMeta meta = CamBow.getItemMeta();
                meta.setDisplayName(ChatColor.DARK_AQUA + "The Purple Shot");
                Object lore = Arrays.asList(new String[] { ChatColor.BLUE + "Legend has it, this bow", ChatColor.BLUE + "can only shoot purple arrows!" });
                meta.setLore((List)lore);
                CamBow.setItemMeta(meta);
                inv.addItem(CamBow);
                ItemStack CamSword = new ItemStack(Material.GOLD_SWORD, 1);
                for (Enchantment ench : Enchantment.values()) {
                CamSword.addUnsafeEnchantment(ench, 32767);
                }
                ItemMeta sword = CamSword.getItemMeta();
                sword.setDisplayName(ChatColor.DARK_GREEN + "The Purple Blade");
                Object a = Arrays.asList(new String[] { ChatColor.BLUE + "The purple has the power", ChatColor.BLUE + "to wield this legendary blade!" });
                sword.setLore((List)a);
                CamSword.setItemMeta(sword);
                inv.addItem(CamSword);
                ItemStack CamArrow = new ItemStack(Material.ARROW, 1);
                for (Enchantment ench : Enchantment.values()) {
                      CamArrow.addUnsafeEnchantment(ench, 32767);
                }
                ItemMeta arrow = CamArrow.getItemMeta();
                arrow.setDisplayName(ChatColor.DARK_PURPLE + "Purple Arrow");
                Object b = Arrays.asList(new String[] { ChatColor.BLUE + "This arrow has a mysterious", ChatColor.BLUE + "purple aura around it..." });
                arrow.setLore((List)b);
                CamArrow.setItemMeta(arrow);
                inv.addItem(CamArrow);
                ItemStack CamChest = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
                 for (Enchantment ench : Enchantment.values()) {
                if (!ench.equals(Enchantment.DURABILITY)) {
                  CamChest.addUnsafeEnchantment(ench, 32767);
                }
              }
               LeatherArmorMeta chest = (LeatherArmorMeta)CamChest.getItemMeta();
               chest.setDisplayName(ChatColor.YELLOW + "Purple Aura");
                 Object c = Arrays.asList(new String[] { ChatColor.BLUE + "This aura should protect", ChatColor.BLUE + "you from all possible harm." });
               chest.setLore((List)c);
               chest.setColor(Color.fromRGB(125, 20, 240));
               CamChest.setItemMeta(chest);
               inv.setChestplate(CamChest);
               ItemStack CamLegs = new ItemStack(Material.LEATHER_LEGGINGS, 1);
               for (Enchantment ench : Enchantment.values()) {
                if (!ench.equals(Enchantment.DURABILITY)) {
                    CamLegs.addUnsafeEnchantment(ench, 32767);
                  }
               }
                 LeatherArmorMeta legs = (LeatherArmorMeta)CamLegs.getItemMeta();
                 legs.setDisplayName(ChatColor.YELLOW + "Purple Aura");
                 Object d = Arrays.asList(new String[] { ChatColor.BLUE + "This aura should protect", ChatColor.BLUE + "you from all possible harm." });
                 legs.setLore((List)d);
                 legs.setColor(Color.fromRGB(125, 20, 240));
                 CamLegs.setItemMeta(legs);
                 inv.setLeggings(CamLegs);
              ItemStack CamBoots = new ItemStack(Material.LEATHER_BOOTS, 1);
              for (Enchantment ench : Enchantment.values()) {
                if (!ench.equals(Enchantment.DURABILITY)) {
                     CamBoots.addUnsafeEnchantment(ench, 32767);
                  }
                }
               LeatherArmorMeta boots = (LeatherArmorMeta)CamBoots.getItemMeta();
               boots.setDisplayName(ChatColor.YELLOW + "Purple Aura");
               Object e = Arrays.asList(new String[] { ChatColor.BLUE + "This aura should protect", ChatColor.BLUE + "you from all possible harm." });
               boots.setLore((List)e);
               boots.setColor(Color.fromRGB(125, 20, 240));
                 CamBoots.setItemMeta(boots);
                 inv.setBoots(CamBoots);
                }
    }
    return true;
}
}