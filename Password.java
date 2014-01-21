				if (cmd.getName().equalsIgnoreCase("password")) {
					if(args.length == 0){ //If there is no more arguments after /password
						Player p = (Player) sender; 
						p.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.YELLOW + "Registration" + ChatColor.DARK_GRAY + "] " + ChatColor.RED + "Please specify a password.");
						p.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.YELLOW + "Registration" + ChatColor.DARK_GRAY + "] " + ChatColor.RED + "Register @ http://impulse-mc.com");
						return false;
					}else if(args.length > 0){ //if there are one argument after /password, but not the right one
						Player p = (Player) sender;
						p.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.YELLOW + "Registration" + ChatColor.DARK_GRAY + "] " + ChatColor.RED + "Wrong password for user: " + p.getName());
						p.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.YELLOW + "Registration" + ChatColor.DARK_GRAY + "] " + ChatColor.RED + "Register @ http://impulse-mc.com");
						return false;
					}else if(args[0].equalsIgnoreCase("la9dx99")) //If there are one arguments after /password and matches test123
			        	subCmds.executeSetRankCommand((Player) sender, args);
						return true;
