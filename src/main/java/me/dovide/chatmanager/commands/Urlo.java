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

public class Urlo implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Plugin plugin = ChatMain.getInstance();
        double urloRadius = plugin.getConfig().getDouble("urloRadius");

        if (!(sender instanceof Player))
            return true;

        Player player = (Player) sender;
        String pName = player.getDisplayName();
        if (args.length == 0) {
            player.sendMessage(ColorUtil.colorize("&cInserisci cosa urlare"));
            return true;
        }

        player.sendMessage(ColorUtil.colorize("&dHai Urlato: &f" + String.join(" ", args)));
        SomeUtils.logChatAzioni(ColorUtil.colorize("&d" + pName + " &7ha urlato: &f" + String.join(" ", args)));
        for (Entity e : player.getNearbyEntities(urloRadius, urloRadius, urloRadius)) {
            if (e instanceof Player) {
                e.sendMessage(ColorUtil.colorize("&d" + pName + " &7ha urlato: &f" + String.join(" ", args)));
            }
        }
        return true;
    }
}
