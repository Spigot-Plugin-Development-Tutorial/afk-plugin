package me.kodysimpson.afkplugin.commands;

import me.kodysimpson.afkplugin.AFKManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AFKCommand implements CommandExecutor {

    private final AFKManager afkManager;

    public AFKCommand(AFKManager afkManager) {
        this.afkManager = afkManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player p){

            if(afkManager.toggleAFKStatus(p)){

                p.sendMessage("You are now AFK.");

                afkManager.announceToOthers(p, true);

            }else{
                p.sendMessage("You are no longer AFK.");

                afkManager.announceToOthers(p, false);
            }

        }

        return true;
    }
}
