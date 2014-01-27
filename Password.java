package me.Dexento.ModTools;

import java.util.List;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class ModTools extends JavaPlugin implements Listener {
	public final Logger logger = Logger.getLogger("MineCraft");


	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
		this.logger.info("ModTools Plugin Has Been Enabled!");

	}

	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if(label.equalsIgnoreCase("modtools")){
		if (sender instanceof Player) {
			Player player = (Player) sender;
				ItemStack is = new ItemStack(Material.FLINT);
				ItemMeta im = is.getItemMeta();
				im.setDisplayName(ChatColor.RED + "Mod Tools");
				is.setItemMeta(im);
				player.getInventory().addItem(is);
		}
	}
		return false;
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
