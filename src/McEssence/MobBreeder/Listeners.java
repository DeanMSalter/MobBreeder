package McEssence.MobBreeder;

import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import java.util.List;

public class Listeners implements Listener {
    @EventHandler(priority= EventPriority.NORMAL, ignoreCancelled=true)
    public void onRightClick(PlayerInteractEntityEvent event) {
        Player player = event.getPlayer();
        Entity entity = event.getRightClicked();
        if (event.getRightClicked().getType() == EntityType.DOLPHIN) {
            if (player.getInventory().getItemInMainHand().getType() == Material.COD) {
                player.spawnParticle(Particle.HEART, entity.getLocation(), 5, 0, 1, 0);
                List<Entity> nearbyEntities = entity.getNearbyEntities(5, 5 ,5);
                for (Entity nearbyEntity : nearbyEntities) {
                    if (nearbyEntity.getType() == EntityType.DOLPHIN) {
                        player.getWorld().spawnEntity(entity.getLocation(), EntityType.DOLPHIN);
                        break;
                    }
                }
            }
            player.sendMessage("right clicked dolphin");
        }
    }
}
