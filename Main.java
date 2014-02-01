package com.Dexento.ImpulseMc.Hub;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	public static Main plugin;
	public final Logger logger = Logger.getLogger("Minecraft");
	public static String prefix = ChatColor.YELLOW + "[Impulse] " + ChatColor.GRAY;
	public static final String noPerm = prefix + ChatColor.RED + "You do not have permission to execute this command.";
	public static int bcLoop;
	public static boolean chatMuted;
	public final Broadcasts bc = new Broadcasts();
	public final MainListener ml = new MainListener (this);
	public final Utils utl = new Utils();
	  
	  public void onEnable() {
	    this.logger.info("Hub Core Has Been Enabled");
	    PluginManager pm = getServer().getPluginManager();
		Bukkit.getServer().getPluginManager();
		getServer().getPluginManager().registerEvents(this, this);
		pm.registerEvents(bc, this);
		pm.registerEvents(ml, this);
		pm.registerEvents(utl, this);
		bcLoop = getServer().getScheduler().scheduleSyncRepeatingTask(this, new Broadcasts(), 20L, 240L);
		chatMuted = false;
		
		this.getCommand("fly").setExecutor(new CommandFly(this));
		this.getCommand("sc").setExecutor(new CommandSc(this));
		this.getCommand("sca").setExecutor(new CommandSca(this));
		this.getCommand("say").setExecutor(new CommandSay(this));
		this.getCommand("togglechat").setExecutor(new CommandToggleChat(this));
		this.getCommand("safestop").setExecutor(new CommandSafestop(this));
		this.getCommand("announce").setExecutor(new CommandAnnounce(this));
		this.getCommand("spawn").setExecutor(new CommandSpawn(this));
		this.getCommand("setspawn").setExecutor(new CommandSetspawn(this));
		this.getCommand("gm").setExecutor(new CommandGm(this));
		this.getCommand("horsify").setExecutor(new CommandHorsify(this));
		this.getCommand("tp").setExecutor(new CommandTp(this));
		this.getCommand("day").setExecutor(new CommandDay(this));
		this.getCommand("night").setExecutor(new CommandNight(this));
	  }
	  
	  public void onDisable() {
		  this.logger.info("Hub Core Has Been Disabled");
	  }
	  
	  public void kickLog(String message) {
	        try {
	            File dataFolder = getDataFolder();
	            if(!dataFolder.exists()) {
	                dataFolder.mkdir();
	            }
	            
	            DateFormat dayOfMonth = new SimpleDateFormat("yyMMdd");
	            Date date = new Date();
	            DateFormat fullDate = new SimpleDateFormat("MM/dd HH:mm");
	            Date dateAndTime = new Date();
	            
	            File saveTo = new File(getDataFolder(), "kicklog" + dayOfMonth.format(date) + ".txt");
	            if (!saveTo.exists()) {
	                saveTo.createNewFile();
	            }
	            FileWriter fw = new FileWriter(saveTo, true);
	            PrintWriter pw = new PrintWriter(fw);
	            
	            pw.println(fullDate.format(dateAndTime) + " - " + message);
	            pw.flush();
	            pw.close();
	 
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	  
	  public void banLog(String message) {
	        try {
	            File dataFolder = getDataFolder();
	            if(!dataFolder.exists()) {
	                dataFolder.mkdir();
	            }
	            
	            DateFormat dayOfMonth = new SimpleDateFormat("yyMMdd");
	            Date date = new Date();
	            DateFormat fullDate = new SimpleDateFormat("MM/dd HH:mm");
	            Date dateAndTime = new Date();
	            
	            File saveTo = new File(getDataFolder(), "banlog" + dayOfMonth.format(date) + ".txt");
	            if (!saveTo.exists()) {
	                saveTo.createNewFile();
	            }
	            FileWriter fw = new FileWriter(saveTo, true);
	            PrintWriter pw = new PrintWriter(fw);
	            
	            pw.println(fullDate.format(dateAndTime) + " - " + message);
	            pw.flush();
	            pw.close();
	 
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	  
	  public void blockLog(String message) {
	        try {
	            File dataFolder = getDataFolder();
	            if(!dataFolder.exists()) {
	                dataFolder.mkdir();
	            }
	            
	            DateFormat dayOfMonth = new SimpleDateFormat("yyMMdd");
	            Date date = new Date();
	            DateFormat fullDate = new SimpleDateFormat("MM/dd HH:mm");
	            Date dateAndTime = new Date();
	            
	            File saveTo = new File(getDataFolder(), "blocklog" + dayOfMonth.format(date) + ".txt");
	            if (!saveTo.exists()) {
	                saveTo.createNewFile();
	            }
	            FileWriter fw = new FileWriter(saveTo, true);
	            PrintWriter pw = new PrintWriter(fw);
	            
	            pw.println(fullDate.format(dateAndTime) + " - " + message);
	            pw.flush();
	            pw.close();
	 
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	  
	  public void staffChatLog(String message) {
	        try {
	            File dataFolder = getDataFolder();
	            if(!dataFolder.exists()) {
	                dataFolder.mkdir();
	            }
	            
	            DateFormat dayOfMonth = new SimpleDateFormat("yyMMdd");
	            Date date = new Date();
	            DateFormat fullDate = new SimpleDateFormat("MM/dd HH:mm");
	            Date dateAndTime = new Date();
	            
	            File saveTo = new File(getDataFolder(), "staffchatlog" + dayOfMonth.format(date) + ".txt");
	            if (!saveTo.exists()) {
	                saveTo.createNewFile();
	            }
	            FileWriter fw = new FileWriter(saveTo, true);
	            PrintWriter pw = new PrintWriter(fw);
	            
	            pw.println(fullDate.format(dateAndTime) + " - " + message);
	            pw.flush();
	            pw.close();
	 
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	  
	  public void serverLog(String message) {
	        try {
	            File dataFolder = getDataFolder();
	            if(!dataFolder.exists()) {
	                dataFolder.mkdir();
	            }
	            
	            DateFormat dayOfMonth = new SimpleDateFormat("yyMMdd");
	            Date date = new Date();
	            DateFormat fullDate = new SimpleDateFormat("MM/dd HH:mm");
	            Date dateAndTime = new Date();
	            
	            File saveTo = new File(getDataFolder(), "serverlog" + dayOfMonth.format(date) + ".txt");
	            if (!saveTo.exists()) {
	                saveTo.createNewFile();
	            }
	            FileWriter fw = new FileWriter(saveTo, true);
	            PrintWriter pw = new PrintWriter(fw);
	            
	            pw.println(fullDate.format(dateAndTime) + " - " + message);
	            pw.flush();
	            pw.close();
	 
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	  
	  public void errorLog(String message) {
	        try {
	            File dataFolder = getDataFolder();
	            if(!dataFolder.exists()) {
	                dataFolder.mkdir();
	            }
	            
	            DateFormat dayOfMonth = new SimpleDateFormat("yyMMdd");
	            Date date = new Date();
	            DateFormat fullDate = new SimpleDateFormat("MM/dd HH:mm");
	            Date dateAndTime = new Date();
	            
	            File saveTo = new File(getDataFolder(), "errorlog" + dayOfMonth.format(date) + ".txt");
	            if (!saveTo.exists()) {
	                saveTo.createNewFile();
	            }
	            FileWriter fw = new FileWriter(saveTo, true);
	            PrintWriter pw = new PrintWriter(fw);
	            
	            pw.println(fullDate.format(dateAndTime) + " - " + message);
	            pw.flush();
	            pw.close();
	 
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}
