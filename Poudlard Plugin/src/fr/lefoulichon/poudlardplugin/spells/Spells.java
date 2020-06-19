package fr.lefoulichon.poudlardplugin.spells;


import org.bukkit.Color;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;

public class Spells {
	
	String spellName;
	Player castingPlayer;

	public Spells(Player castingPlayer) {
		super();
		this.spellName = "inconnu";
		this.castingPlayer = castingPlayer;
	}

	public String getSpellName() {
		return spellName;
	}

	public void setSpellName(String spellName) {
		this.spellName = spellName;
	}

	public Player getCastingPlayer() {
		return castingPlayer;
	}
	
	private void cast(Particle particle)
	{
		castingPlayer.playSound(castingPlayer.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_LAUNCH, 2, 1);
		castingPlayer.spawnParticle(particle, (castingPlayer.getLocation().getX() -1 ) , (castingPlayer.getLocation().getY()+1), (castingPlayer.getLocation().getZ() -0.5), 10);
	}
	
	public void avadaKedavra() {
		this.setSpellName("Avada Kedavra");
		
		Arrow arrow = castingPlayer.launchProjectile(Arrow.class);
		arrow.setGravity(false);
		arrow.setColor(Color.GREEN);
		arrow.setCustomName("Avada Kedavra");
		arrow.setSilent(true);
		arrow.setDamage(1000000);
		cast(Particle.SLIME);
		this.castingPlayer.sendMessage("Avada Kedavra");
	}
	
	public void expelliarmus() {
		
		this.setSpellName("Expelliarmus");
		
		Arrow arrow = castingPlayer.launchProjectile(Arrow.class);
		arrow.setGravity(false);
		arrow.setColor(Color.RED);
		arrow.setSilent(true);
		arrow.setDamage(0);
		arrow.setKnockbackStrength(2);
		cast(Particle.DRIP_LAVA);
		this.castingPlayer.sendMessage("Expelliarmus");
	}
	
}
