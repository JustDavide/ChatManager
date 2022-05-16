package me.dovide.chatmanager.listeners;

import me.dovide.chatmanager.ChatMain;
import me.dovide.chatmanager.utils.ColorUtil;
import me.dovide.chatmanager.utils.SomeUtils;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.plugin.Plugin;

public class ChatManager implements Listener {

    @EventHandler
    public void onChat(PlayerChatEvent e) {
        Plugin plugin = ChatMain.getPlugin(ChatMain.class);
        String pName = e.getPlayer().getName();
        String mex = e.getMessage();
        Player player = e.getPlayer();
        int radius = plugin.getConfig().getInt("chatRadius");
        int urloRadius = plugin.getConfig().getInt("urloRadius");
        int bisbiglioRadius = plugin.getConfig().getInt("bisbiglioRadius");
        e.setCancelled(true);
        if(mex.startsWith("*urlo*")){
            e.setFormat(ColorUtil.colorize("&d" + pName + " &7ha urlato:&f" + mex.replace("*urlo*", "")));
            player.sendMessage(ColorUtil.colorize(e.getFormat()));
            for(Entity near :player.getNearbyEntities(urloRadius, urloRadius, urloRadius)){
                if (near instanceof Player) {
                    near.sendMessage(e.getFormat());
                }
            }
            SomeUtils.logChatAzioni(ColorUtil.colorize("&c[Spy-Urlo] " + "&d" + pName + " &7ha urlato:&f" + mex.replace("*urlo*", "")));
        }else if(mex.startsWith("*bisbiglio*")){
            e.setFormat(ColorUtil.colorize("&d" + pName + " &7ha bisbligato:&f" + mex.replace("*bisbiglio*", "")));
            player.sendMessage(ColorUtil.colorize(e.getFormat()));
            for(Entity near :player.getNearbyEntities(bisbiglioRadius, bisbiglioRadius, bisbiglioRadius)){
                if (near instanceof Player) {
                    near.sendMessage(e.getFormat());
                }
            }
            SomeUtils.logChatAzioni(ColorUtil.colorize("&c[Spy-Bisbiglio] " + "&d" + pName + " &7ha bisbigliato:&f" + mex.replace("*bisbiglio*", "")));
        }else if(mex.startsWith("*azione*")){
            e.setFormat(ColorUtil.colorize("&e[AZIONE] " + pName + ":" + mex.replace("*azione*", "")));
            player.sendMessage(ColorUtil.colorize(e.getFormat()));
            for(Entity near :player.getNearbyEntities(radius, radius, radius)) {
                if (near instanceof Player) {
                    near.sendMessage(e.getFormat());
                }
            }
            SomeUtils.logChatAzioni(ColorUtil.colorize("&c[Spy-Azioni] " + "&a" + pName + ":" + mex.replace("*azione*", "")));
        }else{
            e.setFormat(ColorUtil.colorize("&7" + pName + ": &f" + mex));
            player.sendMessage(ColorUtil.colorize(e.getFormat()));
            for(Entity near :player.getNearbyEntities(radius, radius, radius)){
                if (near instanceof Player) {
                    near.sendMessage(e.getFormat());
                }
            }
            SomeUtils.logChatAzioni(ColorUtil.colorize("&c[Spy-Chat] " + "&d" + pName + " &7ha detto: &f" + mex));
        }
    }
}

