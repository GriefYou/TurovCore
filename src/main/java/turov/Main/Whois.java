package turov.Main;

import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.command.*;

public class Whois implements CommandExecutor {

    private TurovCore plugin;

    public Whois(TurovCore plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender.hasPermission("turovcore.whois")) {
            if (args.length > 0) {
                String name = args[0];
                Player p = Bukkit.getPlayer(name);
                if (p == null) {
                    String playernofound = plugin.getConfig().getString("messages.playernofound");
                    sender.sendMessage(playernofound);
                    return true;
                }
                String msg0 = plugin.getConfig().getString("whois.0");
                String msg1 = plugin.getConfig().getString("whois.1");
                String msg2 = plugin.getConfig().getString("whois.2");
                String msg3 = plugin.getConfig().getString("whois.3");
                String msg4 = plugin.getConfig().getString("whois.4");
                String msg5 = plugin.getConfig().getString("whois.5");
                String msg6 = plugin.getConfig().getString("whois.6");
                String msg7 = plugin.getConfig().getString("whois.7");
                String msg8 = plugin.getConfig().getString("whois.8");
                sender.sendMessage(msg0);
                sender.sendMessage(msg1);
                sender.sendMessage(msg2);
                sender.sendMessage(String.valueOf(msg3) + name);
                sender.sendMessage(String.valueOf(msg4) + p.getAddress().getAddress());
                sender.sendMessage(String.valueOf(msg5) + p.getStatistic(Statistic.PLAYER_KILLS));
                sender.sendMessage(String.valueOf(msg6) + p.getStatistic(Statistic.DEATHS));
                sender.sendMessage(String.valueOf(msg7) + p.getStatistic(Statistic.SNEAK_TIME));
                sender.sendMessage(msg8);
                return true;
            }
            return false; // бывает что действие не окончено...
        }
        String nopermission = plugin.getConfig().getString("messages.nopermission"); // genesis optimizer
        sender.sendMessage(nopermission);
        return true;
    }

}
