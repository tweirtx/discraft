import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.Event;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.EventListener;


public class Listener implements EventListener {
    @Override
    public void onEvent(Event event)
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
        }
    }
}