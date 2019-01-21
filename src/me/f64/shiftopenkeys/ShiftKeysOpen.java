package me.f64.shiftopenkeys;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.hazebyte.crate.api.CratePlugin;

public class ShiftKeysOpen extends JavaPlugin implements Listener {
	public static Plugin plugin;
	public static CratePlugin crates;

	@Override
	public void onEnable() {
		plugin = this;
		ShiftKeysOpen.crates = (CratePlugin) getServer().getPluginManager().getPlugin("CrateReloaded");
		Bukkit.getServer().getPluginManager().registerEvents(new onCrateInteract(this), this);
	}
}