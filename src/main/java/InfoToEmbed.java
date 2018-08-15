import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class InfoToEmbed {
    infoField ipAddress;
    infoField playerCount;
    infoField activePlugins;
    infoField minecraftVersion;
    infoField lastUpdated;
    infoField upDownMessage;
    List<infoField> allInfo = Arrays.asList(ipAddress, playerCount, activePlugins, minecraftVersion, lastUpdated, minecraftVersion);
}
