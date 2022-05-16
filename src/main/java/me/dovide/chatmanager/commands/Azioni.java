package me.dovide.chatmanager.commands;

import me.dovide.chatmanager.ChatMain;
import me.dovide.chatmanager.utils.ColorUtil;
import me.dovide.chatmanager.utils.SomeUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class Azioni implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Plugin plugin = ChatMain.getPlugin(ChatMain.class);
        double actionRadius = plugin.getConfig().getDouble("azioniRadius");

        if(!(sender instanceof Player))
            return true;

        Player player = (Player) sender;
        String pName = player.getDisplayName();
        if (args.length == 0) {
            player.sendMessage(ColorUtil.colorize("&cInserisci la tua azione"));
            return true;
            }

        SomeUtils.logChatAzioni(ColorUtil.colorize("&c[Spy-Azioni] " + "&a" + pName + ":" + String.join(" ", args)));
        player.sendMessage(ColorUtil.colorize("&e[AZIONE] " + pName + ": " + String.join(" ", args)));
        for (Entity e : player.getNearbyEntities(actionRadius, actionRadius, actionRadius)) {
            if (e instanceof Player) {
                e.sendMessage(ColorUtil.colorize("&e[AZIONE] " + pName + ": " + String.join(" ", args)));
            }
        }
        return false;
    }
}
