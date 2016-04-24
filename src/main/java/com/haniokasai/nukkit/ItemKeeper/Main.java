package com.haniokasai.nukkit.ItemKeeper;

import java.util.HashMap;
import java.util.Map;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerDeathEvent;
import cn.nukkit.event.player.PlayerRespawnEvent;
import cn.nukkit.item.Item;
import cn.nukkit.plugin.PluginBase;



public class Main extends PluginBase implements Listener{

	private static HashMap<String,Map<Integer,Item>> item = new HashMap<String,Map<Integer,Item>>();
	private static HashMap<String,Item[]> ar = new HashMap<String,Item[]>();

	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(this, this);
        this.getServer().getLogger().info("[ItemKeeper] Loaded");
	}

	@EventHandler
	public void PlayerDeath(PlayerDeathEvent event){
		Player player = event.getEntity();
		item.put(player.getName(),player.getInventory().getContents());
		ar.put(player.getName(),player.getInventory().getArmorContents());
	}

	@EventHandler
	public void PlayerRespawn(PlayerRespawnEvent event){
		Player player = event.getPlayer();
		String name = player.getName();
		player.getInventory().setContents(item.get(name));
		player.getInventory().setArmorContents(ar.get(name));
		item.remove(name);
		ar.remove(name);
	}
}