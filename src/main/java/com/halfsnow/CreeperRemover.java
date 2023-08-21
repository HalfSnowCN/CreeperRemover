package com.halfsnow;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Creeper;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class CreeperRemover extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        System.out.println(
                        "\n"+
                        "   ______                               ____\n"+
                        "  / ____/_______  ___  ____  ___  _____/ __ \\___  ____ ___  ____ _   _____  _____\n"+
                        " / /   / ___/ _ \\/ _ \\/ __ \\/ _ \\/ ___/ /_/ / _ \\/ __ `__ \\/ __ \\ | / / _ \\/ ___/\n"+
                        "/ /___/ /  /  __/  __/ /_/ /  __/ /  / _, _/  __/ / / / / / /_/ / |/ /  __/ /\n"+
                        "\\____/_/   \\___/\\___/ .___/\\___/_/  /_/ |_|\\___/_/ /_/ /_/\\____/|___/\\___/_/\n"+
                        "                   /_/");
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onHangingBreakByEntity(HangingBreakByEntityEvent event) {
        Entity remover = event.getRemover();
        if (remover instanceof Creeper) {
            Entity entity = event.getEntity();
            if (entity instanceof ItemFrame) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onEntityExplode(EntityExplodeEvent event) {
        Entity entity = event.getEntity();
        if (entity instanceof Creeper) {
            event.blockList().clear();
        }
    }
}