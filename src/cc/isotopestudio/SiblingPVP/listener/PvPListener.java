package cc.isotopestudio.SiblingPVP.listener;
/*
 * Created by Mars Tan on 11/13/2016.
 * Copyright ISOTOPE Studio
 */

import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PvPListener implements Listener {

    @EventHandler
    public final void onPlayerDamage(final EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player) {
            if (event.getDamager() instanceof Player) {
                event.setCancelled(true);
                return;
            }
            if (event.getDamager() instanceof Projectile && ((Projectile) event.getDamager()).getShooter() instanceof Player) {
                event.setCancelled(true);
            }
        }
    }
}
