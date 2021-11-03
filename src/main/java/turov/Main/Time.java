package turov.Main;

import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class Time implements CommandExecutor {

    private TurovCore plugin;

    public Time(TurovCore plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            if(args.length == 0) {
                return false;
            }
            if (sender.hasPermission("turovcore.time")) {
                if (args[0].equals("day")) {
                    Player p = (Player)sender;
                    p.getLocation().getWorld().setTime(10000L);
                    String world = p.getLocation().getWorld().getName();
                    String setday = plugin.getConfig().getString("messages.setday");
                    setday = setday.replace("{world}", world);
                    sender.sendMessage(setday);
                    return true;
                } else if (args[0].equals("night")) {
                    Player p = (Player)sender;
                    p.getLocation().getWorld().setTime(16000L);
                    String world = p.getLocation().getWorld().getName();
                    String setnight = plugin.getConfig().getString("messages.setnight");
                    setnight = setnight.replace("{world}", world);
                    sender.sendMessage(setnight);
                    return true;
                }
                return false;
            }
            String nopermission = plugin.getConfig().getString("messages.nopermission");
            sender.sendMessage(nopermission);
            return true;
        }
        String nopermission = plugin.getConfig().getString("messages.onlyplayers");
        sender.sendMessage(nopermission);
        return false;
    }

}
