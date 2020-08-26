package US.KaliBat.DeathMessageBot;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Collection;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new ServerListener(), this);
    }

    @Override
    public void onDisable() {

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (command.getName().equalsIgnoreCase("online")) {
            StringBuilder response = new StringBuilder();
            final Collection<? extends Player> players = Bukkit.getOnlinePlayers();
            response.append("Players online: ").append(players.size()).append("\n");
            for (Player player : players) {
                response.append(player.getDisplayName()).append("\n");
            }
            sender.sendMessage(response.toString());
            return true;
        }

        return false;
    }
}
