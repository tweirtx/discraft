import java.io.*;
import java.net.*;

public class MinecraftInterface {
    private static String getIP() throws IOException {

        String customip = Discord.config.customip;
        if (customip.equals("auto")) {
            URL whatismyip = new URL("http://checkip.amazonaws.com");
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    whatismyip.openStream()));
            return in.readLine();
        }
        else {
            return customip;
        }
    }
    static void updateEmbed() throws IOException {
        InfoToEmbed embedInfo = new InfoToEmbed();

        //IP Address
        embedInfo.ipAddress.fieldName = "IP Address";
        embedInfo.ipAddress.data = getIP(); //Needs testing

        //Online player count
        embedInfo.playerCount.fieldName = "Player count";
        embedInfo.playerCount.data = "Testing player count";

        //Active plugins
        embedInfo.activePlugins.fieldName = "Plugins";
        embedInfo.activePlugins.data = "Testing plugins";

        //Minecraft version
        embedInfo.minecraftVersion.fieldName = "Minecraft version";
        embedInfo.minecraftVersion.data = "Minecraft version test";

        //Up/down message
        embedInfo.upDownMessage.fieldName = "Is the server online?";
        embedInfo.upDownMessage.data = "See the bot status to determine whether or not the server is online"; //Done

        //Formatting for last updated
        embedInfo.lastUpdated.fieldName = "Last updated";
        embedInfo.lastUpdated.data = "see timestamp below"; //Done

        //Actually update the message
        Discord.update(embedInfo);
    }
}
