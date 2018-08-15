import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageEmbed;

import java.io.*;
import java.util.*;

import javax.security.auth.login.LoginException;

public class Discord {
    private static JDA jda;
    private InfoToEmbed embedInfo;

    private static void generateConfig() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("config.yml"));
            writer.write("token: put the Discord token here \nmessageid: put the message id the bot gives you here \ncustomip: auto");
            writer.close();
            System.out.println("Generated config.yml, please fill it out.");
            System.exit(1);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        // Note: It is important to register your ReadyListener before building
        try {
            Config config = mapper.readValue(new File("config.yml"), Config.class);
            String token = config.token;
            jda = new JDABuilder(AccountType.BOT)
                    .setToken(token)
                    .addEventListener(new Listener())
                    .buildBlocking();
        }
        catch (LoginException e) {
            System.out.println("Invalid token");
            System.exit(1);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
            System.exit(1);
        }
        catch (FileNotFoundException e)
        {
            generateConfig();
            System.exit(1);
        }
        catch (Exception e) {
            System.out.println("General error");
            e.printStackTrace();
            System.exit(1);
        }
    }

    static void update(InfoToEmbed embedInfo) {
        Message embedMessage; //TODO
        EmbedBuilder newEmbed = new EmbedBuilder();
        List<infoField> embedArray = new ArrayList<>(embedInfo.allInfo);
        for (infoField info: embedArray)
        {
            System.out.println(info);
            MessageEmbed.Field newField = new MessageEmbed.Field(info.fieldName, info.data, true);
            newEmbed.addField(newField);
        }

    }
}
