package me.Dexento.Info;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Info extends JavaPlugin{
        public final Logger logger = Logger.getLogger("Minecraft");
        public static Info plugin;
        
        @Override
        public void onDisable() {
                this.logger.info("[Info] 'by Dexento has been disabled!");
        }
        
        @Override
        public void onEnable() {
                this.logger.info("[Info] by Dexento has been enabled!");
        		@SuppressWarnings("unused")
				PluginManager plm = this.getServer().getPluginManager();
        }
        //---------------------------------------------------- /Information ----------------------------------------------
        public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[]args){
                Player p = (Player) sender;
                String star = "\u2726";
                if(commandLabel.equalsIgnoreCase("Information")){
                	if (p.hasPermission("info.default"))
                	p.sendMessage(ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "[" + ChatColor.YELLOW + "\u2726" + ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "]===========[" + ChatColor.GREEN + "Impulse-mc Info" + ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "]===========[" + ChatColor.YELLOW + "\u2726" + ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "]");
                	p.sendMessage(ChatColor.GRAY + "#" + ChatColor.GOLD + "Developer" + ChatColor.GRAY + ": " + ChatColor.DARK_AQUA + "Dexento");
                	p.sendMessage(ChatColor.GRAY + "#" + ChatColor.GOLD + "Owners" + ChatColor.GRAY + ": " + ChatColor.DARK_AQUA + "Dexento " + ChatColor.GRAY + "| " + ChatColor.DARK_AQUA + "Vexento " + ChatColor.GRAY + "| " + ChatColor.DARK_AQUA + "MrZone64");
                	p.sendMessage(ChatColor.GRAY + "#" + ChatColor.GOLD + "Logo / Sever Designer" + ChatColor.GRAY + ": " + ChatColor.DARK_AQUA + "Vexento");
                	p.sendMessage(ChatColor.GRAY + "#" + ChatColor.GOLD + "Sr.Admins" + ChatColor.GRAY + ": " + ChatColor.DARK_AQUA + "Cegal_Alex " + ChatColor.GRAY + "| " + ChatColor.DARK_AQUA + "Muffia");
                	p.sendMessage(ChatColor.GRAY + "#" + ChatColor.GOLD + "Admins" + ChatColor.GRAY + ": " + ChatColor.DARK_AQUA + "N/A");
                	p.sendMessage(ChatColor.GRAY + "#" + ChatColor.GOLD + "Server Version" + ChatColor.GRAY + ": " + ChatColor.DARK_AQUA + "1.2.5 R5");
                	p.sendMessage(ChatColor.GRAY + "#" + ChatColor.GOLD + "Spawn Made by" + ChatColor.GRAY + ": " + ChatColor.DARK_AQUA + "Dexento " + ChatColor.GRAY + "| " + ChatColor.DARK_AQUA + "Vexento " + ChatColor.GRAY + "| " + ChatColor.DARK_AQUA + "MrZone64");
                	p.sendMessage(ChatColor.GRAY + "#" + ChatColor.LIGHT_PURPLE + "Rules" + ChatColor.GRAY + ": " + ChatColor.DARK_AQUA + "/Rules for a list of avalible rules.");
                	p.sendMessage(ChatColor.GRAY + "#" + ChatColor.LIGHT_PURPLE + "Banned Items" + ChatColor.GRAY + ": " + ChatColor.DARK_AQUA + "/BannedItems for a list of banned items.");
                	p.sendMessage(ChatColor.GRAY + "#" + ChatColor.LIGHT_PURPLE + "Commands" + ChatColor.GRAY + ": " + ChatColor.DARK_AQUA + "/Commands for a list of avalible commands.");
                	p.sendMessage(ChatColor.GRAY + "#" + ChatColor.DARK_PURPLE + "Latest Announcement" + ChatColor.GRAY + ": " + ChatColor.DARK_AQUA + "http://bit.ly/ImpAn for announcements.");
                	p.sendMessage(ChatColor.GRAY + "#" + ChatColor.DARK_PURPLE + "Staff Application" + ChatColor.GRAY + ": " + ChatColor.DARK_AQUA + "http://bit.ly/ImpStaffApp to apply for mod.");
                	p.sendMessage(ChatColor.GRAY + "#" + ChatColor.DARK_PURPLE + "FAQ" + ChatColor.GRAY + ": " + ChatColor.DARK_AQUA + "http://bit.ly/ImpFAQ for a list of FQA.");
                	p.sendMessage(ChatColor.GRAY + "#" + ChatColor.DARK_PURPLE + "Report Abuse" + ChatColor.GRAY + ": " + ChatColor.DARK_AQUA + "http://bit.ly/ImpReport to report players.");
                	p.sendMessage(ChatColor.GRAY + "#" + ChatColor.DARK_PURPLE + "Appeal Ban" + ChatColor.GRAY + ": " + ChatColor.DARK_AQUA + "http://bit.ly/ImpBanApp to appeal bans.");
                	p.sendMessage(ChatColor.GRAY + "#" + ChatColor.DARK_PURPLE + "Donate" + ChatColor.GRAY + ": " + ChatColor.DARK_AQUA + "http://bit.ly/ImpDonate to donate to the server.");
                	p.sendMessage(ChatColor.GRAY + "#" + ChatColor.DARK_PURPLE + "Website" + ChatColor.GRAY + ": " + ChatColor.DARK_AQUA + "http://Impulse-Mc.com ");
                	p.sendMessage(ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "[" + ChatColor.YELLOW + star + ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "]===========[" + ChatColor.GREEN + "Impulse-mc Info" + ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "]===========[" + ChatColor.YELLOW + star + ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "]");
                	p.playEffect(p.getLocation(), Effect.SMOKE, 10);
					p.playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 10);
					p.playEffect(p.getLocation(), Effect.GHAST_SHOOT,10);
                }else{
                	p.sendMessage(ChatColor.YELLOW + "[Impulse-Mc] " + ChatColor.AQUA + "Computer says no.");
                }
				return false;
        }
}
                
                
                
