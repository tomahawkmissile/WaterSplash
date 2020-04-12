package com.gmail.tomahawkmissile2.WaterSplash;

import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PotionSplashEvent;

public class Potion implements Listener {

	@EventHandler
	public void onWaterSplash(PotionSplashEvent e) {
		if(e.getPotion()!=null || e.getEntity().getItem().getType()==Material.SPLASH_POTION) {
			for(Entity entity : e.getAffectedEntities()) {
				if(entity.getFireTicks()>0) {
					entity.getLocation().getWorld().spawnParticle(Particle.SMOKE_NORMAL, entity.getLocation(), 75, 0, 0, 0, 0.1);
					entity.getLocation().getWorld().playSound(entity.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1, 1);
				}
				entity.setFireTicks(0);
			}
			Entity direct = e.getHitEntity();
			if(direct.getFireTicks()>0) {
				direct.getLocation().getWorld().spawnParticle(Particle.SMOKE_NORMAL, direct.getLocation(), 75, 0, 0, 0, 0.1);
				direct.getLocation().getWorld().playSound(direct.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1, 1);
				direct.setFireTicks(0);
			}
			if(e.getHitBlock()!=null && e.getHitBlock().getType()==Material.FIRE) {
				e.getHitBlock().setType(Material.AIR);
				for(BlockFace c : BlockFace.values()) {
					Block b = e.getHitBlock().getRelative(c);
					b.setType(Material.FIRE);
				}
			}
		}
	}
}
