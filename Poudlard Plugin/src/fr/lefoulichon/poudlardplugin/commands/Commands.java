package fr.lefoulichon.poudlardplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {
	
	static String spellCast = "null" ; 
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String message, String[] arg) {
		if(sender instanceof Player) {
			Player player = (Player)sender; 
			if(arg[0].equals("avada")) {
				spellCast = arg[0] ; 
				player.sendMessage("§2 sort sélectionné: " + spellCast);
				System.out.println(spellCast);
			}
			if(arg[0].equals("expel")) {
				spellCast = arg[0] ; 
				player.sendMessage("§c sort sélectionné: " + spellCast );
				System.out.println(spellCast);
				
			} 
			return true;
		}
		return false;
	}
	
	public static String getValeur() {
		return spellCast;
		}
}
