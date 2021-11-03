package turov.Main;

import org.bukkit.event.*;
import org.bukkit.entity.*;
import org.bukkit.event.player.*;

public class Joiner implements Listener {

    private TurovCore plugin;

    public Joiner(TurovCore plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void join(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        String msg = plugin.getConfig().getString("join.text");
        p.sendMessage(msg);
        String join_bar = plugin.getConfig().getString("join.actionbar");
        p.sendActionBar(join_bar); // warning: this method contains PAPER VERSION!!!! (1.12.2 Paper core using GriefYou, file patched_VERSION.jar)
    }

}
