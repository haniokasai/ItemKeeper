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

	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(this, this);
        this.getServer().getLogger().info("[ItemKeeper] Loaded");
	}

	@EventHandler
	public void PlayerDeath(PlayerDeathEvent event){
                event.setKeepInventory(true);

	}
}
