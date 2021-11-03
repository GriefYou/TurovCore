package turov.Main;

import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class Gamemode implements CommandExecutor {

    private static final GameMode Creative = GameMode.CREATIVE;
    private static final GameMode Survival = GameMode.SURVIVAL;
    private static final GameMode Adventure = GameMode.ADVENTURE;
    private static final GameMode Spectator = GameMode.SPECTATOR;
    private TurovCore plugin;

    public Gamemode(TurovCore plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            if(sender.hasPermission("core.gamemode")) {
                if (args.length == 0) {
                    return false;
                }
                Player p = (Player)sender;
                if (args.length > 0) {
                    if (args[0].equals("1")) {
                        if (sender.hasPermission("turovcore.gamemode.creative")) {
                            p.setGameMode(Creative);
                            String setcreative = plugin.getConfig().getString("messages.setcreative");
                            sender.sendMessage(setcreative);
                            return true;
                        }
                        String nopermission = plugin.getConfig().getString("messages.nopermission");
                        sender.sendMessage(nopermission);
                        return true;
                    } else if (args[0].equals("0")) {
                        if (sender.hasPermission("turovcore.gamemode.survival")) {
                            p.setGameMode(Survival);
                            String setsurvival = plugin.getConfig().getString("messages.setsurvival");
                            sender.sendMessage(setsurvival);
                            return true;

                        }
                        String nopermission = plugin.getConfig().getString("messages.nopermission");
                        sender.sendMessage(nopermission);
                        return true;
                    } else if (args[0].equals("3")) {
                        if (sender.hasPermission("turovcore.gamemode.spectator")) {
                            p.setGameMode(Spectator);
                            String setspectator = plugin.getConfig().getString("messages.setspectator");
                            sender.sendMessage(setspectator);
                            return true;
                        }
                        String nopermission = plugin.getConfig().getString("messages.nopermission");
                        sender.sendMessage(nopermission);
                        return true;
                    } else if (args[0].equals("2")) {
                        if (sender.hasPermission("turovcore.gamemode.setadventure")) {
                            p.setGameMode(Adventure);
                            String setadventure = plugin.getConfig().getString("messages.setadventure");
                            sender.sendMessage(setadventure);
                            return true;
                        }
                        String nopermission = plugin.getConfig().getString("messages.nopermission");
                        sender.sendMessage(nopermission);
                        return true;
                    }
                }
                return false;
            }
            String nopermission = plugin.getConfig().getString("messages.nopermission");
            sender.sendMessage(nopermission);
            return true;
        }
        String onlyplayers = plugin.getConfig().getString("messages.onlyplayers");
        sender.sendMessage(onlyplayers);
        return false;
    }

}
