import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.Event;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.EventListener;

import java.io.IOException;


public class Listener implements EventListener {
    public void eventHandler(Event event) throws IOException
    {
        if (event instanceof ReadyEvent) {
            System.out.println("Discord OK!");
        }
        if (event instanceof MessageReceivedEvent) {
            if (((MessageReceivedEvent) event).getMessage().getContentStripped().equals("discrafthere"))
            {
                Message message = ((MessageReceivedEvent) event).getMessage().getChannel().sendMessage("This message will be where the bot puts the latest embeds when you put the ID in the config.").complete();
                ((MessageReceivedEvent) event).getMessage().getChannel().sendMessage(message.getId()+" is the ID to put in the config").complete();
            }
            if (((MessageReceivedEvent) event).getMessage().getContentStripped().equals("discraftupdate")) {
                MinecraftInterface.updateEmbed();
            }
        }
    }
    public void onEvent(Event event) {
        try {
            eventHandler(event);
        }
        catch (Exception e) {
            System.out.println("IOException");
        }
    }
}