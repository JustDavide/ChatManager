package me.dovide.chatmanager;

import me.dovide.chatmanager.commands.*;
import me.dovide.chatmanager.listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class ChatMain extends JavaPlugin {

    // Variabili
    private static ChatMain plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        // PlaceHolderAPI Warn
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            /*
             * Se PlaceHolderAPI C'è nel server facciamo funzionare il plugin
             */


            // Instance
            plugin = this;

            // Config + Start
            getLogger().info("Roleplay Chat - @JustDavide - Private Version 2.5");
            this.getConfig();
            this.saveConfig();


            // Comandi
            getCommand("azione").setExecutor(new Azioni());
            getCommand("bisbiglio").setExecutor(new Bisbiglio());
            getCommand("urlo").setExecutor(new Urlo());
            getCommand("annuncio").setExecutor(new MessaggioAziendale());

            //Listeners
            getServer().getPluginManager().registerEvents(new ChatManager(), this);

        } else {
            getLogger().warning("PlaceHolderAPI non trovato. Per il funzionamento di questo plugin è richiesto.");
            Bukkit.getPluginManager().disablePlugin(this);
        }
    }

    public void onDisable() {
        getLogger().info("Roleplay Core - Disabilitato con successo");
    }

    public static ChatMain getInstance() {
        return plugin;
    }


}
