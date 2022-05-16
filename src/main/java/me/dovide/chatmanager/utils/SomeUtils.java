package me.dovide.chatmanager.utils;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class SomeUtils {

    public static void soundError(Player player){

        player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_FALL, 1F, 1);

    }

    public static int logChatAzioni(String log) {

        return Bukkit.broadcast(log,"roleplay.spychat");

    }

    public static void bcUser(Player player, String bc) {

        Bukkit.broadcastMessage("————————————————————————");
        Bukkit.broadcastMessage(ColorUtil.colorize("&b&lMESSAGGIO AZIENDALE"));
        Bukkit.broadcastMessage("");
        Bukkit.broadcastMessage(ColorUtil.colorize(bc));
        Bukkit.broadcastMessage("");
        Bukkit.broadcastMessage(ColorUtil.colorize("Cittadino: " + player));
        Bukkit.broadcastMessage("————————————————————————");

    }

}
