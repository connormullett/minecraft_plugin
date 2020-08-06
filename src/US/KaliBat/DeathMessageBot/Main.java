package US.KaliBat.DeathMessageBot;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new DeathListener(), this);
    }

    @Override
    public void onDisable() {

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("hello")){
            sender.sendMessage("hello from plugin");
            return true;
        }

        if (command.getName().equalsIgnoreCase("online")) {
            int players = Bukkit.getOnlinePlayers().size();
            sender.sendMessage("Online players: " + players + "!");
            return true;
        }

        return false;
    }
}
