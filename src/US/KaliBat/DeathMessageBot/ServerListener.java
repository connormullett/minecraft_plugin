package US.KaliBat.DeathMessageBot;

import org.bukkit.Bukkit;
import org.bukkit.advancement.Advancement;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class ServerListener implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) throws Exception {
        String deathMessage = event.getDeathMessage();
        String urlEncodedMessage = deathMessage.replace(" ", "%20");

        this.sendBotRequest(urlEncodedMessage);
    }

    @EventHandler
    public void onPlayerAdvancement(PlayerAdvancementDoneEvent event) throws Exception {
        Advancement advancement = event.getAdvancement();
        String advancementName = advancement.toString();
        String player = event.getPlayer().getDisplayName();
        String response = player + " " + advancementName;
        response = response.replace(" ", "%20");
        // sendBotRequest(response);
    }

    public void sendBotRequest(String urlEncodedMessage) throws Exception {
        URL url = new URL("http://127.0.0.1:5000/" + urlEncodedMessage);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(
                con.getInputStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            Bukkit.getServer().broadcastMessage(inputLine);
        }
        in.close();
    }
}
