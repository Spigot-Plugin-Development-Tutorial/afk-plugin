package me.kodysimpson.afkplugin.tasks;

import me.kodysimpson.afkplugin.AFKManager;

public class MovementChecker implements Runnable {

    private final AFKManager afkManager;

    public MovementChecker(AFKManager afkManager) {
        this.afkManager = afkManager;
    }

    @Override
    public void run() {

        System.out.println("AFK Status for each player is being checked");

        afkManager.checkAllPlayersAFKStatus();

    }

}
