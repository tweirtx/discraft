import java.util.Arrays;
import java.util.List;

public class InfoToEmbed {
    infoField ipAddress = new infoField();
    infoField playerCount = new infoField();
    infoField activePlugins = new infoField();
    infoField minecraftVersion = new infoField();
    infoField lastUpdated = new infoField();
    infoField upDownMessage = new infoField();
    List<infoField> allInfo = Arrays.asList(ipAddress, playerCount, activePlugins, minecraftVersion, lastUpdated, minecraftVersion);
}
