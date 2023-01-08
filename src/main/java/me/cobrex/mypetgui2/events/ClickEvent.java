package me.cobrex.mypetgui2.events;


import me.cobrex.mypetgui2.MyPetGUI;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.Plugin;

public class ClickEvent implements Listener {

	@EventHandler
	public void onMenuClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		Plugin plugin = MyPetGUI.getPlugin(MyPetGUI.class);
		if (e.getView().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("lang.mypetgui_menu_title")))) {
			e.setCancelled(true);
			if (e.getCurrentItem() == null) {
				return;
//			} else if (e.getCurrentItem().getType().equals(Material.CHEST)) {
			} else if (e.getCurrentItem().getType().equals(Material.valueOf(plugin.getConfig().getString("gui_icons.main_menu_gui.inventory")))) {
				p.closeInventory();
				p.performCommand("petinventory");
			} else if (e.getCurrentItem().getType().equals(Material.valueOf(plugin.getConfig().getString("gui_icons.main_menu_gui.beacon")))) {
				p.closeInventory();
				p.performCommand("petbeacon");
			} else if (e.getCurrentItem().getType().equals(Material.valueOf(plugin.getConfig().getString("gui_icons.main_menu_gui.skill_tree")))) {
				p.closeInventory();
				p.performCommand("petchooseskilltree");
			} else if (e.getCurrentItem().getType().equals(Material.valueOf(plugin.getConfig().getString("gui_icons.main_menu_gui.ride")))) {
				p.closeInventory();
				p.performCommand("petcall");
			} else if (e.getCurrentItem().getType().equals(Material.valueOf(plugin.getConfig().getString("gui_icons.main_menu_gui.send_away")))) {
				p.closeInventory();
				p.performCommand("petsendaway");
			} else if (e.getCurrentItem().getType().equals(Material.valueOf(plugin.getConfig().getString("gui_icons.main_menu_gui.store_pet")))) {
				p.closeInventory();
				p.performCommand("petstore");
			} else if (e.getCurrentItem().getType().equals(Material.valueOf(plugin.getConfig().getString("gui_icons.main_menu_gui.select_pet")))) {
				p.closeInventory();
				p.performCommand("petswitch");
			} else if (e.getCurrentItem().getType().equals(Material.valueOf(plugin.getConfig().getString("gui_icons.main_menu_gui.item_pickup")))) {
				p.closeInventory();
				p.performCommand("petpickup");
			} else if (e.getCurrentItem().getType().equals(Material.valueOf(plugin.getConfig().getString("gui_icons.main_menu_gui.pet_behavior")))) {
				p.closeInventory();
				p.performCommand("petbmenu");
			} else if (e.getCurrentItem().getType().equals(Material.valueOf(plugin.getConfig().getString("gui_icons.main_menu_gui.pet_info")))) {
				p.closeInventory();
				p.performCommand("petinfo");
			} else if (e.getCurrentItem().getType().equals(Material.valueOf(plugin.getConfig().getString("gui_icons.main_menu_gui.pet_skill_info")))) {
				p.closeInventory();
				p.performCommand("petskill");
			} else if (e.getCurrentItem().getType().equals(Material.valueOf(plugin.getConfig().getString("gui_icons.main_menu_gui.pet_shop")))) {
				p.closeInventory();
				p.performCommand("petshop");
			} else if (e.getCurrentItem().getType().equals(Material.valueOf(plugin.getConfig().getString("gui_icons.main_menu_gui.rename_pet")))) {
				p.closeInventory();
				p.performCommand("petname");
			} else if (e.getCurrentItem().getType().equals(Material.valueOf(plugin.getConfig().getString("gui_icons.main_menu_gui.trade_pet")))) {
				p.closeInventory();
				p.performCommand("pettrade");
			} else if (e.getCurrentItem().getType().equals(Material.valueOf(plugin.getConfig().getString("gui_icons.main_menu_gui.release_pet")))) {
				p.closeInventory();
				p.performCommand("petrelease");
			}
		} else if (e.getView().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("lang.behvaior_menu_title")))) {
			e.setCancelled(true);
			if (e.getCurrentItem() == null) {
				return;
			} else if (e.getCurrentItem().getType().equals(Material.valueOf(plugin.getConfig().getString("gui_icons.behavior_gui.friendly")))) {
				p.closeInventory();
				p.performCommand("petbehavior Friendly");
			} else if (e.getCurrentItem().getType().equals(Material.valueOf(plugin.getConfig().getString("gui_icons.behavior_gui.normal")))) {
				p.closeInventory();
				p.performCommand("petbehavior Normal");
			} else if (e.getCurrentItem().getType().equals(Material.valueOf(plugin.getConfig().getString("gui_icons.behavior_gui.raid")))) {
				p.closeInventory();
				p.performCommand("petbehavior Raid");
			} else if (e.getCurrentItem().getType().equals(Material.valueOf(plugin.getConfig().getString("gui_icons.behavior_gui.duel")))) {
				p.closeInventory();
				p.performCommand("petbehavior Duel");
			} else if (e.getCurrentItem().getType().equals(Material.valueOf(plugin.getConfig().getString("gui_icons.behavior_gui.farm")))) {
				p.closeInventory();
				p.performCommand("petbehavior Farm");
			} else if (e.getCurrentItem().getType().equals(Material.valueOf(plugin.getConfig().getString("gui_icons.behavior_gui.aggressive")))) {
				p.closeInventory();
				p.performCommand("petbehavior Aggressive");
			} else if (e.getCurrentItem().getType().equals(Material.valueOf(plugin.getConfig().getString("gui_icons.behavior_gui.back")))) {
				p.closeInventory();
				p.performCommand("pet");
			}
		}
	}
}