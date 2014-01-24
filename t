		
		
		
		
		
		
				if (cmd.getName().equalsIgnoreCase("password")) {
					Player p = (Player) sender;
					String regPrefix = ChatColor.DARK_GRAY + "[" + ChatColor.YELLOW + "Registration" + ChatColor.DARK_GRAY + "] " + ChatColor.RED;
					if (args.length == 1) {
						if(args[0].equalsIgnoreCase("X1fg65n9")) {
				        	subCmds.executeSetRankCommand((Player) sender, args);
				        	p.sendMessage(regPrefix + ChatColor.GREEN + "You've been promoted to the member rank!");
						} else {
							p.sendMessage(regPrefix + "That password is incorrect.");
							p.sendMessage(regPrefix + "Register @ http://impulse-mc.com");
						}
					} else {
						p.sendMessage(regPrefix + "Please specify a password.");
						p.sendMessage(regPrefix + "Register @ http://impulse-mc.com");
