package com.test.lorereplace;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static com.test.lorereplace.LoadLore.LoreMap;
import static com.test.lorereplace.LoadLore.loadConfig;
import static com.test.lorereplace.LoreReplace.instance;

public class Command implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {

        if (sender instanceof Player){
            Player player = (Player) sender;
            //指令为lorereplace reload
            if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
                LoreMap.clear();
                loadConfig();
                player.sendMessage("[LoreReplace]插件重载成功");
                return true;
            }
        }
        return true;
    }
}
