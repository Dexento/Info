package com.Dexento.ImpulseMc.Hub;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockSpreadEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MainListener implements Listener {
	public Main plugin;
	public MainListener(Main plugin) {
		this.plugin = plugin;
	}
	private int capsCount;

	@EventHandler
	public void onChat (AsyncPlayerChatEvent event) {
		Player p = event.getPlayer();
		String message = event.getMessage();
		if (Main.chatMuted == true) {
			if (!p.hasPermission("impulse.mutebypass")) {
				p.sendMessage(Main.prefix + ChatColor.RED + "The chat has been muted, you will be notified when is re-enabled.");
				try {
					event.setCancelled(true);
				} catch (Exception ex) {
					event.setFormat("");
				}
			}
		} else {
			for(int i = 10; i<message.length(); i++) {
				if(Character.isUpperCase(message.charAt(i)) && !Character.isLetter(message.charAt(i))) {
				capsCount++;
				if (capsCount > (message.length() * 0.50)) {
					message = message.toLowerCase();
					char[] msg = message.toCharArray();
					msg[0] = Character.toUpperCase(msg[0]);
					msg.toString();
					message = new String(msg);
					event.setMessage(message);
					}
				}
			}
			
			String[] message2 = message.split(" ");
			for (int i = 0; i < message.length(); i++)
		      {
		        String txt = message2[i];
		        if (txt.startsWith("@"))
		        {
		          String[] pName = txt.split("@");
		          try
		          {
		            final Player player = Bukkit.getServer().getPlayerExact(pName[1]);
		            if (player.isOnline()) {
		                String formatMessage = ChatColor.WHITE + message;
		                String cusMessage = formatMessage.replace(txt, ChatColor.YELLOW + ">>> " + ChatColor.RED + txt + ChatColor.YELLOW + " you got pinged:" + ChatColor.RED);
		                player.sendMessage(cusMessage);
		            }
		          }
		          catch (Exception ex)
		          {
		            event.getPlayer().sendMessage(Main.prefix + ChatColor.RED + "That user is not online - ping failed.");
		          }
		        }
		      }
		}
	}
	
	@EventHandler
	public void loginErrors(PlayerLoginEvent e) {
		if(e.getResult() == Result.KICK_WHITELIST) {
			e.setKickMessage(ChatColor.DARK_RED + "\u2726" + ChatColor.DARK_GREEN + " MAINTENANCE " + ChatColor.DARK_GRAY + "| " + ChatColor.RED + "We're doing a quick update! Back in a second!");
		} else if(e.getResult() == Result.KICK_FULL) {
			e.setKickMessage(Main.prefix + "The server is " + ChatColor.RED + "full" + ChatColor.GRAY + " - " + ChatColor.YELLOW + "we're working on being able to handle more players!");
			plugin.errorLog("IMPORTANT: Server was full. Disconnected " + e.getPlayer().getName());
		}
	}
	
	@EventHandler
	  public void onPlayerJoin(PlayerJoinEvent e) {
	    Player p = e.getPlayer();
	    if (!p.hasPlayedBefore()) {
	    	e.setJoinMessage(ChatColor.GREEN + "\u25b2 " + ChatColor.GRAY + p.getDisplayName() + ChatColor.DARK_GRAY + " joined the server for the first time EVER!");
	    } else if(p.hasPermission("impulse.modtool")){
			ItemStack is = new ItemStack(Material.FLINT);
			ItemMeta im = is.getItemMeta();
			im.setDisplayName(ChatColor.RED + "Mod Tools");
			is.setItemMeta(im);
			p.getInventory().addItem(5, ModTools);
	    } else {
	    e.setJoinMessage(ChatColor.GREEN + "\u25b2 " + ChatColor.GRAY + p.getDisplayName() + ChatColor.DARK_GRAY + " joined the server!");
	    }
	  }
	
	@EventHandler
	  public void onPlayerLeave(PlayerQuitEvent e) {
	    Player p = e.getPlayer();
	    e.setQuitMessage(ChatColor.RED +"\u25bc " + ChatColor.GRAY + p.getDisplayName() + ChatColor.DARK_GRAY + " left the server!");
	  }
	
	@EventHandler
	  public void onPlayerKick(PlayerKickEvent e) {
	    Player p = e.getPlayer();
	    e.setLeaveMessage(ChatColor.RED + "\u25bc " + ChatColor.GRAY + p.getDisplayName() + ChatColor.DARK_GRAY + " left the server!");
	  }
	
	@EventHandler
	public void fireSpread(BlockSpreadEvent e) {
		if (e.getNewState().getType() == Material.FIRE) {
			e.setCancelled(true);
		}
	}	
	
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent e){
		if (Main.chatMuted){
			e.setDeathMessage("");
		}
	}
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		try {
			if (event.getPlayer().getItemInHand().getItemMeta()
					.getDisplayName().equals(ChatColor.RED + "Mod Tools")) {
				Inventory inv = Bukkit.createInventory(null, 18,
						ChatColor.YELLOW + "Mod Tools");
				List<ItemStack> itemStacks = Utils.getPapers();

				for (int i = 0; i < 18; i++)
					inv.setItem(i, itemStacks.get(i));
				
				event.getPlayer().openInventory(inv);

			}
		} catch (Exception e) {
		}
	}

	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		try {
			if (event.getInventory().getName()
					.equals(ChatColor.YELLOW + "Mod Tools")) {
				event.setCancelled(true);
				event.getWhoClicked().closeInventory();
				for (String s : event.getCurrentItem().getItemMeta().getLore())
					((Player) event.getWhoClicked()).chat(s);
			}
		} catch (Exception e) {

		}
	}
}
