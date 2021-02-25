package com.github.carthax08.simplevoterewards;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MainCommand implements CommandExecutor {
    Simplevoterewards svr;
    public MainCommand(Simplevoterewards svl){
        svr = svl;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(player.hasPermission("svr.admin")){
                if(args.length == 1 && args[0].equalsIgnoreCase("reload")){
                    svr.reloadConfig();
                }else if(args.length > 0 && args[0].equalsIgnoreCase("test")){
                    if(args.length == 1){
                        VoteListener.handleTest(player.getName());
                        player.sendMessage(ChatColor.GREEN + "Successfully sent a test vote for yourself. Hooray!");
                    }else{
                        player.sendMessage(ChatColor.GREEN + "no");
                    }
                }
            }
        }else{
            if(args.length > 0){
                if(args[0].equalsIgnoreCase("reload")){
                    svr.reloadConfig();
                }else if(args[0].equalsIgnoreCase("test")){
                    System.out.println(ChatColor.GREEN + "no");
                }else{
                    System.out.println(ChatColor.GREEN + "Unknown Argument");
                }
            }
        }
        return true;
    }
}
