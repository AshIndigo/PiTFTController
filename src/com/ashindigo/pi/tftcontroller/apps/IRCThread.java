package com.ashindigo.pi.tftcontroller.apps;

import org.pircbotx.Configuration;
import org.pircbotx.PircBotX;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.types.GenericMessageEvent;

public class IRCThread extends ListenerAdapter implements Runnable {
	
	public static PircBotX bot;
	
	@Override
    public void onGenericMessage(GenericMessageEvent event) {
          AppIRC.chatBox.setText(AppIRC.chatBox.getText() + "\n" + event.getUser().getNick() + ": " + event.getMessage());
          //if (event.getMessage().contains("stabs AshIndigoPi"))
    }

	@Override
	public void run() {
		//try {
			Configuration configuration = new Configuration.Builder().setName("AshIndigoPi").addServer("irc.esper.net")
					.addAutoJoinChannel("#ashindigo").setRealName("AshIndigoPi").addListener(this)
					.buildConfiguration();
			bot = new PircBotX(configuration);
			//bot.startBot();
		//} catch (IOException | IrcException e) {
			//e.printStackTrace();
		//}
	}
}
