package turov.Main;

import java.io.*;
import org.bukkit.*;
import java.util.logging.*;
import org.bukkit.plugin.java.*;

public class TurovCore extends JavaPlugin {
    Logger info = Logger.getLogger("MineCraft");

    @Override
    public void onEnable() { // туров говорил что даже по туторам напишет ахуительный плагин, но чё то пошло не так и допускает дефолт начальные ошибки... туторы 2015 годов, я в ахуе...
        File config = new File(getDataFolder() + File.separator + "config.yml");
        if(!config.exists()) {
            info.warning("§6[TurovCore] §fАвтоматическое создание конфига");
            getConfig().options().copyDefaults();
            saveDefaultConfig(); // если по секрету, то выше строка и эта делают почти одно и тоже, только эта ещё и сохраняет ресурс через saveResource, и вообще нахуя ему чекать присутствие кфг, ну блять этот метод ещё и проверяет наличие файла этого, ебать на Турове нищеброд
        }
        Bukkit.getPluginManager().registerEvents(new Joiner(this), this);
        getCommand("gm").setExecutor(new Gamemode(this));
        getCommand("heal").setExecutor(new Heal(this));
        getCommand("feed").setExecutor(new Feed(this));
        getCommand("time").setExecutor(new Time(this));
        getCommand("weather").setExecutor(new Weather(this));
        getCommand("whois").setExecutor(new Whois(this));
        info.info("§6[TurovCore] §aВключение плагина");
    }

    @Override
    public void onDisable() {
        info.info("§6[TurovCore] §cВыключение плагина"); // А ГДЕ HANDLERLIST UNREGISTER ALL(THIS) или у нас туторы от долбоёбов, которые не могут объяснить зачем это нужно???
        // HandlerList.unregisterAll(this);
    }
}
