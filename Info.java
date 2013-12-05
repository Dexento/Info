package me.Dexento.Info;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Info extends JavaPlugin{
        public final Logger logger = Logger.getLogger("Minecraft");
        public static Info plugin;
        
        @Override
        public void onDisable() {
                this.logger.info("[Info]stop by Dexento has been disabled!");
        }
        
        @Override
        public void onEnable() {
                this.logger.info("[Info] by Dexento has been enabled!");
    }
        public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[]args){
                Player player = (Player) sender;
                if(commandLabel.equalsIgnoreCase("Info")){
                	player.sendMessage(ChatColor.GRAY + "-*-*-*-*-*-*-*-" + ChatColor.YELLOW + "[" + ChatColor.GREEN + "MovementMC" + ChatColor.YELLOW + "]" + ChatColor.GRAY + "-*-*-*-*-*-*-*-");
                	player.sendMessage(ChatColor.YELLOW + "Developer : " + ChatColor.GREEN + "Dexento");
                	player.sendMessage(ChatColor.YELLOW + "Craftbukkit : " + ChatColor.GREEN + "CraftBukkit Version 1.6.4 R2");
                	player.sendMessage(ChatColor.YELLOW + "Server IP : " + ChatColor.GREEN + "25.100.199.233");
                	player.sendMessage(ChatColor.YELLOW + "Owners : " + ChatColor.GREEN + "Dexento & Vexento");
                }
                return false;
        }
}        
