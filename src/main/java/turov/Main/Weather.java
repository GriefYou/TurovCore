package turov.Main;

import java.util.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.command.*;

public class Weather implements CommandExecutor {

    private TurovCore plugin;

    public Weather(TurovCore plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            if (sender.hasPermission("core.gamemode")) {
                if (args.length == 0) {
                    return false;
                }
                int duration = (300 + (new Random()).nextInt(600)) * 20;
                if (args.length >= 2) {
                    duration = getInteger(sender, args[1], 1, 1000000) * 20;
                }
                World world = Bukkit.getWorlds().get(0);
                world.setWeatherDuration(duration);
                world.setThunderDuration(duration);
                if ("clear".equalsIgnoreCase(args[0])) { // GENESIS EQUALS NORM TUTORIAL
                    Player p = (Player) sender;
                    world.setStorm(false);
                    world.setThundering(false);
                    String clear = plugin.getConfig().getString("messages.clear");
                    String worldname = p.getLocation().getWorld().getName();
                    clear = clear.replace("{world}", worldname);
                    p.sendMessage(clear);
                    return true;
                } else if ("storm".equalsIgnoreCase(args[0])) {
                    Player p = (Player) sender;
                    world.setStorm(true);
                    world.setThundering(false);
                    String storm = plugin.getConfig().getString("messages.storm");
                    String worldname = p.getLocation().getWorld().getName();
                    storm = storm.replace("{world}", worldname);
                    p.sendMessage(storm);
                    return true;
                } else if ("thunder".equalsIgnoreCase(args[0])) {
                    Player p = (Player) sender;
                    world.setStorm(true);
                    world.setThundering(true);
                    String thunder = plugin.getConfig().getString("messages.thunder");
                    String worldname = p.getLocation().getWorld().getName();
                    thunder = thunder.replace("{world}", worldname);
                    p.sendMessage(thunder);
                    return true;
                }
                return true;
            }
            String nopermission = plugin.getConfig().getString("messages.nopermission");
            sender.sendMessage(nopermission);
            return true;
        }
        String onlyplayers = plugin.getConfig().getString("messages.onlyplayers");
        sender.sendMessage(onlyplayers);
        return true;
    }

    private int getInteger(CommandSender sender, String string, int i, int j) { // XDDDDDDDDDDDDDDDD
        return 0;
    }

}
