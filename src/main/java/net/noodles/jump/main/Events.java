package net.noodles.jump.main;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Events implements Listener {


    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        Location l = p.getLocation();
        l.add(0, -1, 0);
        Block b = l.getBlock();
        if (b.getType() == (Material.EMERALD_BLOCK)) {
            p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 15, 9));
        } else {
            return;
        }
    }

    @EventHandler
    public void onPlayerDamage(final EntityDamageEvent e){
        if(e.getCause() == EntityDamageEvent.DamageCause.FALL){
            e.setCancelled(true);
        }
    }

}
