package me.cobrex.mypetgui2.commands;

import me.clip.placeholderapi.PlaceholderAPI;
import me.cobrex.mypetgui2.MyPetGUI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class GUICommandBehavior implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (sender instanceof Player) {
			Player player = (Player) sender;
			Plugin plugin = MyPetGUI.getPlugin(MyPetGUI.class);
			if (plugin.getConfig().getStringList("black_listed_worlds").contains(player.getWorld().getName()) || !player.hasPermission("mypetgui.use")) {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("lang.messages.no_permission_use")));
			} else {
				Inventory petguib = Bukkit.createInventory(player, 18, ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("lang.behvaior_menu_title")));

				//Menu Options(Items)
//				ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
				ItemStack filler = new ItemStack(Material.valueOf(plugin.getConfig().getString("gui_icons.behavior_gui.filler")));
				ItemStack friendly = new ItemStack(Material.valueOf(plugin.getConfig().getString("gui_icons.behavior_gui.friendly")));
				ItemStack normal = new ItemStack(Material.valueOf(plugin.getConfig().getString("gui_icons.behavior_gui.normal")));
				ItemStack raid = new ItemStack(Material.valueOf(plugin.getConfig().getString("gui_icons.behavior_gui.raid")));
				ItemStack duel = new ItemStack(Material.valueOf(plugin.getConfig().getString("gui_icons.behavior_gui.duel")));
				ItemStack farm = new ItemStack(Material.valueOf(plugin.getConfig().getString("gui_icons.behavior_gui.farm")));
				ItemStack aggressive = new ItemStack(Material.valueOf(plugin.getConfig().getString("gui_icons.behavior_gui.aggressive")));
				ItemStack back = new ItemStack(Material.valueOf(plugin.getConfig().getString("gui_icons.behavior_gui.back")));

				//Edit the items
				ItemMeta filler_meta = filler.getItemMeta();
				filler_meta.setDisplayName(ChatColor.BLACK + " ");
				filler_meta.setLocalizedName(ChatColor.BLACK + " ");
				filler.setItemMeta(filler_meta);

				ItemMeta friendly_meta = friendly.getItemMeta();
				friendly_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("lang.behavior_icon_title_friendly")));
				ArrayList<String> friendly_lore = new ArrayList<>();
				for (String lore_title : plugin.getConfig().getStringList("lang.behavior_icon_lore_friendly")) {
					friendly_lore.add(ChatColor.translateAlternateColorCodes('&', lore_title));
				}
				List<String> friendlyWithPlaceholders = PlaceholderAPI.setPlaceholders(player, friendly_lore);
				friendly_meta.setLore(friendlyWithPlaceholders);
//				friendly_meta.setLore(friendly_lore);
				friendly.setItemMeta(friendly_meta);

				ItemMeta normal_meta = normal.getItemMeta();
				normal_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("lang.behavior_icon_title_normal")));
				ArrayList<String> normal_lore = new ArrayList<>();
				for (String lore_title : plugin.getConfig().getStringList("lang.behavior_icon_lore_normal")) {
					normal_lore.add(ChatColor.translateAlternateColorCodes('&', lore_title));
				}
				List<String> normalWithPlaceholders = PlaceholderAPI.setPlaceholders(player, normal_lore);
				normal_meta.setLore(normalWithPlaceholders);
//				normal_meta.setLore(normal_lore);
				normal.setItemMeta(normal_meta);

				ItemMeta raid_meta = raid.getItemMeta();
				raid_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("lang.behavior_icon_title_raid")));
				ArrayList<String> raid_lore = new ArrayList<>();
				for (String lore_title : plugin.getConfig().getStringList("lang.behavior_icon_lore_raid")) {
					raid_lore.add(ChatColor.translateAlternateColorCodes('&', lore_title));
				}
				List<String> raidWithPlaceholders = PlaceholderAPI.setPlaceholders(player, raid_lore);
				raid_meta.setLore(raidWithPlaceholders);
				raid.setItemMeta(raid_meta);

				ItemMeta duel_meta = duel.getItemMeta();
				duel_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("lang.behavior_icon_title_duel")));
				ArrayList<String> duel_lore = new ArrayList<>();
				for (String lore_title : plugin.getConfig().getStringList("lang.behavior_icon_lore_duel")) {
					duel_lore.add(ChatColor.translateAlternateColorCodes('&', lore_title));
				}
				List<String> duelWithPlaceholders = PlaceholderAPI.setPlaceholders(player, duel_lore);
				duel_meta.setLore(duelWithPlaceholders);
				duel_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
				duel.setItemMeta(duel_meta);

				ItemMeta farm_meta = farm.getItemMeta();
				farm_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("lang.behavior_icon_title_farm")));
				ArrayList<String> farm_lore = new ArrayList<>();
				for (String lore_title : plugin.getConfig().getStringList("lang.behavior_icon_lore_farm")) {
					farm_lore.add(ChatColor.translateAlternateColorCodes('&', lore_title));
				}
				List<String> farmWithPlaceholders = PlaceholderAPI.setPlaceholders(player, farm_lore);
				farm_meta.setLore(farmWithPlaceholders);
				farm_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
				farm.setItemMeta(farm_meta);

				ItemMeta aggressive_meta = aggressive.getItemMeta();
				aggressive_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("lang.behavior_icon_title_aggressive")));
				ArrayList<String> aggressive_lore = new ArrayList<>();
				for (String lore_title : plugin.getConfig().getStringList("lang.behavior_icon_lore_aggressive")) {
					aggressive_lore.add(ChatColor.translateAlternateColorCodes('&', lore_title));
				}
				List<String> aggressiveWithPlaceholders = PlaceholderAPI.setPlaceholders(player, aggressive_lore);
				aggressive_meta.setLore(aggressiveWithPlaceholders);
				aggressive_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
				aggressive.setItemMeta(aggressive_meta);

				ItemMeta back_meta = back.getItemMeta();
				back_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("lang.behavior_icon_title_back")));
				ArrayList<String> back_lore = new ArrayList<>();
				for (String lore_title : plugin.getConfig().getStringList("lang.behavior_icon_lore_back")) {
					back_lore.add(ChatColor.translateAlternateColorCodes('&', lore_title));
				}
				List<String> backWithPlaceholders = PlaceholderAPI.setPlaceholders(player, back_lore);
				back_meta.setLore(backWithPlaceholders);
				back_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
				back.setItemMeta(back_meta);

				//Put the items in the inventory
				ItemStack[] menu_items = {
						filler, friendly, normal, duel, filler, duel, farm, aggressive, filler,
						filler, filler, filler, filler, back, filler, filler, filler, filler};
				petguib.setContents(menu_items);
				player.openInventory(petguib);
			}
		}

		return true;
	}
}
