package com.gmail.tomahawkmissile2.WaterSplash;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

	public static Main plugin;
	
	public void onEnable() {
		Main.plugin = this;
		
		this.getServer().getPluginManager().registerEvents(this, this);
		this.getServer().getPluginManager().registerEvents(new Potion(), this);
		
		this.getCommand("splash").setExecutor(new CommandHandler());
	}
}
