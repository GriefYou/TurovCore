package turov.Main;

import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.command.*;

public class Heal implements CommandExecutor {

    private TurovCore plugin;

    public Heal(TurovCore plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            if (args.length < 1) {
                if (sender.hasPermission("turovcore.heal")) {
                    Player p = (Player) sender;
                    p.setHealth(20.0D);
                    String heal = plugin.getConfig().getString("messages.heal");
                    sender.sendMessage(heal);
                } else {
                    String nopermission = plugin.getConfig().getString("messages.nopermission");
                    sender.sendMessage(nopermission);
                    return true;
                }
            } else if (args.length > 0) {
                if (sender.hasPermission("turovcore.heal.others")) {
                    String name = args[0];
                    Player other = Bukkit.getPlayer(name);
                    if (other == null) {
                        String healother = plugin.getConfig().getString("messages.playernofound");
                        sender.sendMessage(healother);
                        return true;
                    }
                    other.setHealth(20.0D);
                    String healother = plugin.getConfig().getString("messages.healother");
                    healother = healother.replace("{heal_player}", name);
                    sender.sendMessage(healother);
                } else {
                    String nopermission = plugin.getConfig().getString("messages.nopermission");
                    sender.sendMessage(nopermission);
                    return true;
                }
            }
            return true;
        }
        String onlyplayers = plugin.getConfig().getString("messages.onlyplayers");
        sender.sendMessage(onlyplayers);
        return true;
    }

}
