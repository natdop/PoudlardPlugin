package fr.lefoulichon.poudlardplugin.wands;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Wands {
	
	String name = "Wand" ; 
	String[] lore = {"votre baguette de magicien","Ne la perdez pas !"} ; 

	public Wands() {
		super();
	}

	public String getName() {
		return name;
	}

	public String[] getLore() {
		return lore;
	}
	
	public void create(Player player) {
		
		player.getInventory().clear();
		ItemStack stick = new ItemStack(Material.STICK,1);
		ItemMeta wand = stick.getItemMeta();
		wand.setDisplayName(this.name);
		wand.setLore(Arrays.asList(this.lore));
		stick.setItemMeta(wand); 
		player.getInventory().setItemInMainHand(stick);
		player.updateInventory();
	}
	
}
