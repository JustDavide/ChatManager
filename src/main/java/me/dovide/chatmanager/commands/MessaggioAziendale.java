package me.dovide.chatmanager.commands;

import me.dovide.chatmanager.utils.ColorUtil;
import me.dovide.chatmanager.utils.SomeUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class MessaggioAziendale implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

       if(!(sender instanceof Player))
           return true;

       Player player = (Player) sender;

       if(!(player.hasPermission("roleplay.bcazienda"))){
           player.sendMessage(ColorUtil.colorize("&cNon hai abbastanza permessi"));
           return true;
       }

       if(args.length == 0){
           player.sendMessage(ColorUtil.colorize("&cInserisci il messaggio aziendale"));
           return true;
       }

        SomeUtils.bcUser(player, String.join(" ", args));


        return true;
    }
}
