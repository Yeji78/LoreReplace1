package com.test.lorereplace;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


import java.io.File;

import static com.test.lorereplace.LoadLore.loadConfig;

public final class LoreReplace extends JavaPlugin {
public static LoreReplace instance;
    @Override
    public void onEnable() {
        // Plugin startup logic
        //如果文件夹中没有lang.yml 新建一个
        if (!(new File(this.getDataFolder(), "lang.yml").exists())){
            this.saveResource("lang.yml", false);
        }
        instance = this;
        //保存初始CONFIG
        this.saveDefaultConfig();
        //注册监听器
        Bukkit.getPluginManager().registerEvents(new OnInventoryClick(),this);
        //在后台发送信息
        getLogger().info("插件已安装");
        //注册指令
        Bukkit.getPluginCommand("LoreReplace").setExecutor(new Command());
        //加载文件
        loadConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
