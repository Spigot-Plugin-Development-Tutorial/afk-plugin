package me.kodysimpson.afkplugin;

import me.kodysimpson.afkplugin.commands.AFKCommand;
import me.kodysimpson.afkplugin.commands.IsAFKCommand;
import me.kodysimpson.afkplugin.listeners.AFKListener;
import me.kodysimpson.afkplugin.tasks.MovementChecker;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class AFKPlugin extends JavaPlugin {

    private AFKManager afkManager;

    //Game Plan:
    //1. Create a new class called AFKManager
    //2. The class has a hashmap or other DS of players and when they last triggered the PlayerMoveEvent
    //3. Have a task asynchronously running that reports a player as AFK when they have not moved in a while.
    //4. Have a way for players to manually become AFK.

    @Override
    public void onEnable() {
        // Plugin startup logic

        this.afkManager = new AFKManager();

        getCommand("isafk").setExecutor(new IsAFKCommand(this.afkManager));
        getCommand("afk").setExecutor(new AFKCommand(this.afkManager));

        getServer().getPluginManager().registerEvents(new AFKListener(this.afkManager), this);

        Bukkit.getScheduler().runTaskTimerAsynchronously(this, new MovementChecker(this.afkManager), 0L, 600L);

    }

}
