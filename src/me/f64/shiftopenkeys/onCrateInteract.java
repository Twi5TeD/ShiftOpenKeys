package me.f64.shiftopenkeys;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;

import com.hazebyte.crate.api.crate.Crate;
import com.hazebyte.crate.api.crate.CrateAction;
import com.hazebyte.crate.api.event.CrateInteractEvent;

public class onCrateInteract implements Listener {
	ShiftKeysOpen plugin;

	public onCrateInteract(ShiftKeysOpen instance) {
		plugin = instance;
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void ShiftKeyOpen(CrateInteractEvent e) {
		final Player p = e.getPlayer();
		ItemStack item = p.getInventory().getItemInHand();
		Crate crate = ShiftKeysOpen.crates.getCrateRegistrar().getCrate(item);
		boolean action = p.isSneaking() && e.getRootAction() == Action.RIGHT_CLICK_BLOCK && ShiftKeysOpen.crates.getBlockCrateRegistrar().hasCrate(e.getLocation(), crate) && e.getAction() == CrateAction.OPEN;
		int keys = 1;
		keys = p.getInventory().getItemInHand().getAmount();
		if (action && keys > 1) {
			for (; keys > 0; keys--) {
				if (!(p.getInventory().firstEmpty() == -1)) {
					if (crate != null) {
						crate.open(p, crate);
					} else {
						break;
					}
				}
			}
		}
	}
}