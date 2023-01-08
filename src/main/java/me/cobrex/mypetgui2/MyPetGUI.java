package me.cobrex.mypetgui2;


import me.cobrex.mypetgui2.commands.GUICommand;
import me.cobrex.mypetgui2.commands.GUICommandBehavior;
import me.cobrex.mypetgui2.events.ClickEvent;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.List;

public final class MyPetGUI extends JavaPlugin {

	@Override
	public void onEnable() {
		// Plugin startup logic
		getConfig().options().copyDefaults();
		saveDefaultConfig();
		getCommand("pet").setExecutor(new GUICommand());
		getCommand("petbmenu").setExecutor(new GUICommandBehavior());
		getServer().getPluginManager().registerEvents(new ClickEvent(), this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("mypetgui")) {
			if (sender instanceof Player) {
				if (!sender.hasPermission("mypetgui.reload") || !sender.hasPermission("mypetgui.*")) {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("lang.messages.no_permission_reload")));
					return true;
				}
				if (args.length == 0) {
					// /mypetgui
					sender.sendMessage(ChatColor.RED + "Usage: /mypetgui reload");
					return true;
				}
				if (args.length > 0) {
					// /mypetgui
					if (args[0].equalsIgnoreCase("reload")) {
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("lang.messages.message_reloaded")));
						this.reloadConfig();
						this.saveDefaultConfig();
					} else {
						sender.sendMessage(ChatColor.RED + "Usage: /mypetgui reload");
						return true;
					}
				}
			} else {
				if (args.length == 0) {
					// /mypetgui
					sender.sendMessage(ChatColor.RED + "Usage: /mypetgui reload");
					return true;
				}
				if (args.length > 0) {
					// /mypetgui
					if (args[0].equalsIgnoreCase("reload")) {
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("lang.messages.message_reloaded")));
						this.reloadConfig();
						this.saveDefaultConfig();
					} else {
						sender.sendMessage(ChatColor.RED + "Usage: /mypetgui reload");
						return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if (command.getName().equalsIgnoreCase("mypetgui")) {
			if (sender.hasPermission("mypetgui.reload") || sender.hasPermission("mypetgui.*")) {
				return Arrays.asList("reload");
			}
		}
		return null;
	}

}
