package cc.isotopestudio.SiblingPVP.command;
/*
 * Created by Mars Tan on 11/13/2016.
 * Copyright ISOTOPE Studio
 */

import cc.isotopestudio.SiblingPVP.util.S;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SPVPCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("spvp")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(S.toPrefixRed("玩家执行的命令"));
                return true;
            }
            Player player = (Player) sender;
            if (!player.hasPermission("fisher.admin")) {
                player.sendMessage(S.toPrefixRed("你没有权限"));
                return true;
            }
            if (args.length < 1) {
                player.sendMessage(S.toPrefixGreen("帮助菜单"));
                player.sendMessage(S.toYellow("/" + label + " add <权限> - 添加PvP权限"));
                player.sendMessage(S.toYellow("/" + label + " remove <权限> - 删除PvP权限"));
                player.sendMessage(S.toYellow("/" + label + " list - 添加PvP权限"));
                return true;
            }
            if (args[0].equalsIgnoreCase("add")) {
                return true;
            }
            if (args[0].equalsIgnoreCase("remove")) {
                return true;
            }
            if (args[0].equalsIgnoreCase("list")) {
                return true;
            }
            player.sendMessage(S.toPrefixRed("未知命令, 输入 /"+label+" 查看帮助"));
            return true;
        }
        return false;
    }
}