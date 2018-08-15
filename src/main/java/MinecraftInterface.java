public class MinecraftInterface {
    static void updateEmbed() {
        InfoToEmbed embedInfo = new InfoToEmbed();

        //IP Address
        embedInfo.ipAddress.fieldName = "IP Address";
        embedInfo.ipAddress.data = "Testing IP address";

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
        embedInfo.upDownMessage.data = "See the bot status to determine whether or not the server is online";

        //Last updated timestamps
        embedInfo.lastUpdated.fieldName = "Embed last updated";
        embedInfo.lastUpdated.data = "Last updated at time";

        //Actually update the message
        Discord.update(embedInfo);
    }
}
