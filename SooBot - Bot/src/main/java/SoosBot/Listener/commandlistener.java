package SoosBot.Listener;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import SoosBot.Handlers.commandHandler;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class commandlistener extends ListenerAdapter {

	@Override
    public void onMessageReceived(MessageReceivedEvent event) {

        if (event.getMessage().getContentRaw().startsWith("-") && event.getMessage().getAuthor().getId() != event.getJDA().getSelfUser().getId()) {
			try {
				commandHandler.handleCommand(commandHandler.parser.parse(event.getMessage().getContentRaw(), event));
			} catch (FileNotFoundException | UnsupportedEncodingException e) {
				e.printStackTrace();
			}
        }

    }
}