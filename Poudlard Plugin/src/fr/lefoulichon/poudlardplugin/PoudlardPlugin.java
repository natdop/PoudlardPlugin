package fr.lefoulichon.poudlardplugin;

import org.bukkit.plugin.java.JavaPlugin;

import fr.lefoulichon.poudlardplugin.commands.Commands;



public class PoudlardPlugin extends JavaPlugin {
	
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new PluginListeners(),this);
		getCommand("spell").setExecutor(new Commands());
	}
	
	@Override
	public void onDisable() {
		
	}
	
}
