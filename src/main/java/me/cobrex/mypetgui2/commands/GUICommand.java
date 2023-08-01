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

public class GUICommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (sender instanceof Player) {
			Player player = (Player) sender;
			Plugin plugin = MyPetGUI.getPlugin(MyPetGUI.class);
			boolean shopPermission = false;
			if (player.hasPermission("mypetgui.shop")) {
				shopPermission = true;
			}
			if (plugin.getConfig().getStringList("black_listed_worlds").contains(player.getWorld().getName()) || !player.hasPermission("mypetgui.use")) {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("lang.messages.no_permission_use")));
			} else {
				Inventory petgui = Bukkit.createInventory(player, 45, ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("lang.mypetgui_menu_title")));

				//Menu Options(Items)
				ItemStack filler = new ItemStack(Material.valueOf(plugin.getConfig().getString("gui_icons.main_menu_gui.filler")));
				ItemStack inventory = new ItemStack(Material.valueOf(plugin.getConfig().getString("gui_icons.main_menu_gui.inventory")));
				ItemStack beacon = new ItemStack(Material.valueOf(plugin.getConfig().getString("gui_icons.main_menu_gui.beacon")));
				ItemStack skill_tree = new ItemStack(Material.valueOf(plugin.getConfig().getString("gui_icons.main_menu_gui.skill_tree")));
				ItemStack ride = new ItemStack(Material.valueOf(plugin.getConfig().getString("gui_icons.main_menu_gui.ride")));
				ItemStack send_away = new ItemStack(Material.valueOf(plugin.getConfig().getString("gui_icons.main_menu_gui.send_away")));
				ItemStack store_pet = new ItemStack(Material.valueOf(plugin.getConfig().getString("gui_icons.main_menu_gui.store_pet")));
				ItemStack select_pet = new ItemStack(Material.valueOf(plugin.getConfig().getString("gui_icons.main_menu_gui.select_pet")));
				ItemStack item_pickup = new ItemStack(Material.valueOf(plugin.getConfig().getString("gui_icons.main_menu_gui.item_pickup")));
				ItemStack pet_behavior = new ItemStack(Material.valueOf(plugin.getConfig().getString("gui_icons.main_menu_gui.pet_behavior")));
				ItemStack pet_info = new ItemStack(Material.valueOf(plugin.getConfig().getString("gui_icons.main_menu_gui.pet_info")));
				ItemStack pet_skill_info = new ItemStack(Material.valueOf(plugin.getConfig().getString("gui_icons.main_menu_gui.pet_skill_info")));
				ItemStack pet_shop = new ItemStack(Material.valueOf(plugin.getConfig().getString("gui_icons.main_menu_gui.pet_shop")));
				if (!shopPermission) {
					pet_shop = new ItemStack(Material.valueOf(plugin.getConfig().getString("gui_icons.main_menu_gui.filler")));
				}
				ItemStack rename_pet = new ItemStack(Material.valueOf(plugin.getConfig().getString("gui_icons.main_menu_gui.rename_pet")));
				ItemStack trade_pet = new ItemStack(Material.valueOf(plugin.getConfig().getString("gui_icons.main_menu_gui.trade_pet")));
				ItemStack release_pet = new ItemStack(Material.valueOf(plugin.getConfig().getString("gui_icons.main_menu_gui.release_pet")));

				//Edit the items
				ItemMeta filler_meta = filler.getItemMeta();
				filler_meta.setDisplayName(ChatColor.BLACK + " ");
				filler_meta.setLocalizedName(ChatColor.BLACK + " ");
				filler.setItemMeta(filler_meta);

				ItemMeta inventory_meta = inventory.getItemMeta();
				inventory_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("lang.mypetgui_icon_title_petinventory")));
				ArrayList<String> chest_lore = new ArrayList<>();
				for (String lore_title : plugin.getConfig().getStringList("lang.mypetgui_icon_lore_petinventory")) {
					chest_lore.add(ChatColor.translateAlternateColorCodes('&', lore_title));
				}
				List<String> inventoryWithPlaceholders = PlaceholderAPI.setPlaceholders(player, chest_lore);
				inventory_meta.setLore(inventoryWithPlaceholders);
//				inventory_meta.setLore(chest_lore);
				inventory.setItemMeta(inventory_meta);

				ItemMeta beacon_meta = beacon.getItemMeta();
				beacon_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("lang.mypetgui_icon_title_petbeacon")));
				ArrayList<String> beacon_lore = new ArrayList<>();
				for (String lore_title : plugin.getConfig().getStringList("lang.mypetgui_icon_lore_petbeacon")) {
					beacon_lore.add(ChatColor.translateAlternateColorCodes('&', lore_title));
				}
				List<String> beaconWithPlaceholders = PlaceholderAPI.setPlaceholders(player, beacon_lore);
				beacon_meta.setLore(beaconWithPlaceholders);
//				beacon_meta.setLore(beacon_lore);
				beacon.setItemMeta(beacon_meta);

				ItemMeta skill_tree_meta = skill_tree.getItemMeta();
				skill_tree_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("lang.mypetgui_icon_title_skilltree")));
				ArrayList<String> skill_tree_lore = new ArrayList<>();
				for (String lore_title : plugin.getConfig().getStringList("lang.mypetgui_icon_lore_skilltree")) {
					skill_tree_lore.add(ChatColor.translateAlternateColorCodes('&', lore_title));
				}
				List<String> skillWithPlaceholders = PlaceholderAPI.setPlaceholders(player, skill_tree_lore);
				skill_tree_meta.setLore(skillWithPlaceholders);
				skill_tree.setItemMeta(skill_tree_meta);

				ItemMeta ride_meta = ride.getItemMeta();
				ride_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("lang.mypetgui_icon_title_callpet")));
				ArrayList<String> ride_lore = new ArrayList<>();
				for (String lore_title : plugin.getConfig().getStringList("lang.mypetgui_icon_lore_callpet")) {
					ride_lore.add(ChatColor.translateAlternateColorCodes('&', lore_title));
				}
				List<String> rideWithPlaceholders = PlaceholderAPI.setPlaceholders(player, ride_lore);
				ride_meta.setLore(rideWithPlaceholders);
				ride.setItemMeta(ride_meta);

				ItemMeta send_away_meta = send_away.getItemMeta();
				send_away_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("lang.mypetgui_icon_title_sendpetaway")));
				ArrayList<String> send_away_lore = new ArrayList<>();
				for (String lore_title : plugin.getConfig().getStringList("lang.mypetgui_icon_lore_sendpetaway")) {
					send_away_lore.add(ChatColor.translateAlternateColorCodes('&', lore_title));
				}
				List<String> sendawayWithPlaceholders = PlaceholderAPI.setPlaceholders(player, send_away_lore);
				send_away_meta.setLore(sendawayWithPlaceholders);
				send_away.setItemMeta(send_away_meta);

				ItemMeta store_pet_meta = store_pet.getItemMeta();
				store_pet_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("lang.mypetgui_icon_title_storepet")));
				ArrayList<String> store_pet_lore = new ArrayList<>();
				for (String lore_title : plugin.getConfig().getStringList("lang.mypetgui_icon_lore_storepet")) {
					store_pet_lore.add(ChatColor.translateAlternateColorCodes('&', lore_title));
				}
				List<String> storeWithPlaceholders = PlaceholderAPI.setPlaceholders(player, store_pet_lore);
				store_pet_meta.setLore(storeWithPlaceholders);
				store_pet.setItemMeta(store_pet_meta);

				ItemMeta select_pet_meta = select_pet.getItemMeta();
				select_pet_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("lang.mypetgui_icon_title_choosepet")));
				ArrayList<String> select_pet_lore = new ArrayList<>();
				for (String lore_title : plugin.getConfig().getStringList("lang.mypetgui_icon_lore_choosepet")) {
					select_pet_lore.add(ChatColor.translateAlternateColorCodes('&', lore_title));
				}
				List<String> selectWithPlaceholders = PlaceholderAPI.setPlaceholders(player, select_pet_lore);
				select_pet_meta.setLore(selectWithPlaceholders);
				select_pet.setItemMeta(select_pet_meta);

				ItemMeta item_pickup_meta = item_pickup.getItemMeta();
				item_pickup_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("lang.mypetgui_icon_title_itempickup")));
				ArrayList<String> item_pickup_lore = new ArrayList<>();
				for (String lore_title : plugin.getConfig().getStringList("lang.mypetgui_icon_lore_itempickup")) {
					item_pickup_lore.add(ChatColor.translateAlternateColorCodes('&', lore_title));
				}
				List<String> itempickupWithPlaceholders = PlaceholderAPI.setPlaceholders(player, item_pickup_lore);
				item_pickup_meta.setLore(itempickupWithPlaceholders);
				item_pickup.setItemMeta(item_pickup_meta);

				ItemMeta pet_behavior_meta = pet_behavior.getItemMeta();
				pet_behavior_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("lang.mypetgui_icon_title_petbehavior")));
				ArrayList<String> pet_behavior_lore = new ArrayList<>();
				for (String lore_title : plugin.getConfig().getStringList("lang.mypetgui_icon_lore_petbehavior")) {
					pet_behavior_lore.add(ChatColor.translateAlternateColorCodes('&', lore_title));
				}
				List<String> setbehaviorWithPlaceholders = PlaceholderAPI.setPlaceholders(player, pet_behavior_lore);
				pet_behavior_meta.setLore(setbehaviorWithPlaceholders);
				pet_behavior_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
				pet_behavior.setItemMeta(pet_behavior_meta);

				ItemMeta pet_info_meta = pet_info.getItemMeta();
				pet_info_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("lang.mypetgui_icon_title_petinfo")));
				ArrayList<String> pet_info_lore = new ArrayList<>();
				for (String lore_title : plugin.getConfig().getStringList("lang.mypetgui_icon_lore_petinfo")) {
					pet_info_lore.add(ChatColor.translateAlternateColorCodes('&', lore_title));
				}
				List<String> petinfoWithPlaceholders = PlaceholderAPI.setPlaceholders(player, pet_info_lore);
				pet_info_meta.setLore(petinfoWithPlaceholders);
				pet_info.setItemMeta(pet_info_meta);

				ItemMeta pet_skill_info_meta = pet_skill_info.getItemMeta();
				pet_skill_info_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("lang.mypetgui_icon_title_petskillinfo")));
				ArrayList<String> pet_skill_info_lore = new ArrayList<>();
				for (String lore_title : plugin.getConfig().getStringList("lang.mypetgui_icon_lore_petskillinfo")) {
					pet_skill_info_lore.add(ChatColor.translateAlternateColorCodes('&', lore_title));
				}
				List<String> petskillWithPlaceholders = PlaceholderAPI.setPlaceholders(player, pet_skill_info_lore);
				pet_skill_info_meta.setLore(petskillWithPlaceholders);
				pet_skill_info.setItemMeta(pet_skill_info_meta);

				ItemMeta pet_shop_meta = pet_shop.getItemMeta();
				if (shopPermission) {
					pet_shop_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("lang.mypetgui_icon_title_petshop")));
					ArrayList<String> pet_shop_lore = new ArrayList<>();
					for (String lore_title : plugin.getConfig().getStringList("lang.mypetgui_icon_lore_petshop")) {
						pet_shop_lore.add(ChatColor.translateAlternateColorCodes('&', lore_title));
					}
					List<String> petshopWithPlaceholders = PlaceholderAPI.setPlaceholders(player, pet_shop_lore);
					pet_shop_meta.setLore(petshopWithPlaceholders);
					pet_shop.setItemMeta(pet_shop_meta);
				} else {
					pet_shop_meta.setDisplayName(ChatColor.BLACK + " ");
					pet_shop_meta.setLocalizedName(ChatColor.BLACK + " ");
					pet_shop.setItemMeta(pet_shop_meta);
				}

				ItemMeta rename_pet_meta = rename_pet.getItemMeta();
				rename_pet_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("lang.mypetgui_icon_title_petname")));
				ArrayList<String> rename_pet_lore = new ArrayList<>();
				for (String lore_title : plugin.getConfig().getStringList("lang.mypetgui_icon_lore_petname")) {
					rename_pet_lore.add(ChatColor.translateAlternateColorCodes('&', lore_title));
				}
				List<String> renameWithPlaceholders = PlaceholderAPI.setPlaceholders(player, rename_pet_lore);
				rename_pet_meta.setLore(renameWithPlaceholders);
				rename_pet.setItemMeta(rename_pet_meta);

				ItemMeta trade_pet_meta = trade_pet.getItemMeta();
				trade_pet_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("lang.mypetgui_icon_title_tradepet")));
				ArrayList<String> trade_pet_lore = new ArrayList<>();
				for (String lore_title : plugin.getConfig().getStringList("lang.mypetgui_icon_lore_tradepet")) {
					trade_pet_lore.add(ChatColor.translateAlternateColorCodes('&', lore_title));
				}
				List<String> tradeWithPlaceholders = PlaceholderAPI.setPlaceholders(player, trade_pet_lore);
				trade_pet_meta.setLore(tradeWithPlaceholders);
				trade_pet.setItemMeta(trade_pet_meta);

				ItemMeta release_pet_meta = release_pet.getItemMeta();
				release_pet_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("lang.mypetgui_icon_title_deletepet")));
				ArrayList<String> release_pet_lore = new ArrayList<>();
				for (String lore_title : plugin.getConfig().getStringList("lang.mypetgui_icon_lore_deletepet")) {
					release_pet_lore.add(ChatColor.translateAlternateColorCodes('&', lore_title));
				}
				List<String> releaseWithPlaceholders = PlaceholderAPI.setPlaceholders(player, release_pet_lore);
				release_pet_meta.setLore(releaseWithPlaceholders);
				release_pet.setItemMeta(release_pet_meta);

				//Put the items in the inventory
				if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
					if (PlaceholderAPI.setPlaceholders(player, "%mypet_has_pet%").equalsIgnoreCase("no")) {
						ItemStack[] menu_items = {filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, select_pet, pet_shop, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler};
						petgui.setContents(menu_items);
						player.openInventory(petgui);
					} else {
						if (PlaceholderAPI.setPlaceholders(player, "%mypet_skilltree_name%").length() > 1) {
							if (PlaceholderAPI.setPlaceholders(player, "%mypet_status%").equalsIgnoreCase("Here")) {
								ItemStack[] menu_items = {filler, inventory, beacon, skill_tree, filler, filler, ride, send_away, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, store_pet, select_pet, pet_shop, filler, filler, item_pickup, pet_behavior, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, pet_info, pet_skill_info, filler, filler, rename_pet, trade_pet, release_pet, filler};
								petgui.setContents(menu_items);
								player.openInventory(petgui);
							} else if (PlaceholderAPI.setPlaceholders(player, "%mypet_status%").equalsIgnoreCase("Dead")) {
								ItemStack[] menu_items = {filler, filler, filler, skill_tree, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, select_pet, pet_shop, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, pet_info, pet_skill_info, filler, filler, rename_pet, filler, filler, filler};
								petgui.setContents(menu_items);
								player.openInventory(petgui);
							} else if (PlaceholderAPI.setPlaceholders(player, "%mypet_status%").equalsIgnoreCase("Despawned")) {
								ItemStack[] menu_items = {filler, filler, filler, skill_tree, filler, filler, ride, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, store_pet, select_pet, pet_shop, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, pet_info, pet_skill_info, filler, filler, rename_pet, trade_pet, filler, filler};
								petgui.setContents(menu_items);
								player.openInventory(petgui);
							}
						} else {
							if (PlaceholderAPI.setPlaceholders(player, "%mypet_status%").equalsIgnoreCase("Here")) {
								ItemStack[] menu_items = {filler, filler, filler, skill_tree, filler, filler, ride, send_away, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, store_pet, select_pet, pet_shop, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, pet_info, filler, filler, filler, rename_pet, trade_pet, release_pet, filler};
								petgui.setContents(menu_items);
								player.openInventory(petgui);
							} else if (PlaceholderAPI.setPlaceholders(player, "%mypet_status%").equalsIgnoreCase("Dead")) {
								ItemStack[] menu_items = {filler, filler, filler, skill_tree, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, select_pet, pet_shop, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, pet_info, filler, filler, filler, rename_pet, filler, filler, filler};
								petgui.setContents(menu_items);
								player.openInventory(petgui);
							} else if (PlaceholderAPI.setPlaceholders(player, "%mypet_status%").equalsIgnoreCase("Despawned")) {
								ItemStack[] menu_items = {filler, filler, filler, skill_tree, filler, filler, ride, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, store_pet, select_pet, pet_shop, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, pet_info, filler, filler, filler, rename_pet, trade_pet, filler, filler};
								petgui.setContents(menu_items);
								player.openInventory(petgui);
							}
						}
					}
				} else {
					ItemStack[] menu_items = {
							filler, inventory, beacon, skill_tree, filler, filler, ride, send_away, filler,
							filler, filler, filler, filler, filler, filler, filler, filler, filler,
							filler, store_pet, select_pet, pet_shop, filler, filler, item_pickup, pet_behavior, filler,
							filler, filler, filler, filler, filler, filler, filler, filler, filler,
							filler, pet_info, pet_skill_info, filler, filler, rename_pet, trade_pet, release_pet, filler};
					petgui.setContents(menu_items);
					player.openInventory(petgui);
				}
			}
		}
		return true;
	}
}
