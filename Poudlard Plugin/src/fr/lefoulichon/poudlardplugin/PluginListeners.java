package fr.lefoulichon.poudlardplugin;


import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import fr.lefoulichon.poudlardplugin.commands.Commands;
import fr.lefoulichon.poudlardplugin.spells.Spells;
import fr.lefoulichon.poudlardplugin.wands.Wands;



public class PluginListeners implements Listener {
	
	protected String playerName ; 
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		
		Player player = event.getPlayer();
		Wands wand = new Wands();
		wand.create(player);
	}
	
	
	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		
		Player player = event.getPlayer();
		Action action = event.getAction();
		ItemStack it = event.getItem();
		
		if (it != null && it.getItemMeta().getDisplayName().equals("Wand") ) {
			if(action == Action.LEFT_CLICK_AIR) {
				Spells spell = new Spells(player) ; 
				playerName = player.getName() ; 
				
				if(Commands.getValeur().equals("avada")) {
					spell.avadaKedavra();
				}
				if(Commands.getValeur().equals("expel")){
					spell.expelliarmus();
				}
				if(Commands.getValeur().equals("null")) {
					player.sendMessage("Choisi un sort : /spell §2avada §0ou §aexpel");
				}
			}
			
		}else
			player.sendMessage("Prend ta baguette !");
	}
	
	@EventHandler
	public void onProjectileHit(ProjectileHitEvent event)
	{
		Projectile projectile = event.getEntity() ;
		
		if(projectile.getName().equals("Avada Kedavra")){
			Location ploc = projectile.getLocation();
			World word = projectile.getWorld();
			word.playSound(ploc, Sound.ENTITY_FIREWORK_ROCKET_LARGE_BLAST_FAR, 1, 1);
			word.spawnParticle(Particle.CRIT_MAGIC,ploc, 100);
			//Bukkit.dispatchCommand(Bukkit.getPlayer(playerName), "kill @e[type=item]");
			
		}if(projectile.getName().equals("Expelliarmus")) {
			Location ploc = projectile.getLocation();
			World word = projectile.getWorld();
			word.playSound(ploc, Sound.ENTITY_FIREWORK_ROCKET_LARGE_BLAST_FAR, 1, 1);
			word.spawnParticle(Particle.CRIT_MAGIC,ploc, 100);
		}
			
	}
	

	@SuppressWarnings("deprecation")
	public void onEntityDamage(EntityDamageByEntityEvent event) {
		if(event.getDamager() instanceof Arrow) {
			Arrow arrow = (Arrow) event.getDamager();
			Player player = (Player) arrow.getLastDamageCause();
			if(player.getItemInHand().getItemMeta().getDisplayName().equals("Wand")){
				player.getInventory().clear();
			}
					
		}
			
		
	}
}

	

	