package com.github.carthax08.simplevoterewards;

import com.vexsoftware.votifier.model.Vote;
import com.vexsoftware.votifier.model.VotifierEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class VoteListener implements Listener {
    Simplevoterewards main;

    public VoteListener(Simplevoterewards ree){
        main = ree;
    }

    @EventHandler(priority=EventPriority.NORMAL)
    public void onVoteifierEvent(VotifierEvent e){
        Vote vote = e.getVote();
        for(String string : main.getConfig().getStringList("rewards.commands")){
            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), string.replace("[PLAYER]", vote.getUsername()));
        }
    }
}
