import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageEmbed;
import java.time.Instant;

import java.io.*;
import java.util.*;

import javax.security.auth.login.LoginException;

public class Discord {
    public static JDA jda;
    public static Config config;

    private static void generateConfig() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("config.yml"));
            writer.write("token: 'put the Discord token here' \nmessageid: 'put the message id the bot gives you here'\ncustomip: 'auto'\nguildid: 'put the guild ID here'\nchannelid: 'put the channel ID here'");
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
        Message embedMessage = jda.getGuildById("333825924942397442").getTextChannelById("333825924942397442").getMessageById("481601948387115019").complete();
        EmbedBuilder newEmbed = new EmbedBuilder();
        List<infoField> embedArray = new ArrayList<>(embedInfo.allInfo);
        for (infoField info: embedArray)
        {
            MessageEmbed.Field newField = new MessageEmbed.Field(info.fieldName, info.data, false);
            newEmbed.addField(newField);
        }
        newEmbed.setTimestamp(Instant.now());
        embedMessage.editMessage(newEmbed.build()).complete();
    }
}
