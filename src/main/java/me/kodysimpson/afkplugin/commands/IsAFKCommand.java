package me.kodysimpson.afkplugin.commands;

import me.kodysimpson.afkplugin.AFKManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class IsAFKCommand implements CommandExecutor {

    private final AFKManager afkManager;

    public IsAFKCommand(AFKManager afkManager){
        this.afkManager = afkManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player p){

            if(args.length == 0){

                if(afkManager.isAFK(p)){
                    p.sendMessage("You are currently AFK.");
                }else{
                    p.sendMessage("You are not currently AFK.");
                }

            }else{
                Player target = Bukkit.getPlayerExact(args[0]);

                if(afkManager.isAFK(target)){
                    p.sendMessage(target.getDisplayName() + " is currently AFK.");
                }else{
                    p.sendMessage(target.getDisplayName() + " is not currently AFK.");
                }

            }

        }

        return true;
    }
}
