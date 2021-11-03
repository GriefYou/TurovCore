package turov.Main;

import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.command.*;

public class Feed implements CommandExecutor {

    private TurovCore plugin;

    public Feed(TurovCore plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            if (args.length < 1) {
                if (sender.hasPermission("core.feed")) {
                    Player p = (Player)sender;
                    p.setFoodLevel(20);
                    p.setSaturation(10.0F);
                    p.setExhaustion(0.0F);
                    String feed = plugin.getConfig().getString("messages.feed");
                    sender.sendMessage(feed);
                } else {
                    String nopermission = plugin.getConfig().getString("messages.nopermission");
                    sender.sendMessage(nopermission);
                    return true;
                }
            } else if (args.length > 0) {
                if (sender.hasPermission("core.feed.others")) {
                    String name = args[0];
                    Player other = Bukkit.getPlayer(name);
                    if (other == null) {
                        String playernofound = plugin.getConfig().getString("messages.playernofound");
                        sender.sendMessage(playernofound);
                        return true;
                    }
                    other.setFoodLevel(20);
                    other.setSaturation(10.0F);
                    other.setExhaustion(0.0F);
                    String feedother = plugin.getConfig().getString("messages.feedother");
                    feedother = feedother.replace("{feed_player}", name);
                    sender.sendMessage(feedother);
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
