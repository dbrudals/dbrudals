package com.swh.discord;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;


public class MySecondBot {
	public static void main(String[] args) {
		// Insert your bot's token here
		//		ODY2MTk3OTU2NDIyOTI2Mzc2.YPPDtQ.Wm1u0SZK3JG6_Z6G4dZnjEx6jMU
		String token = "ODY2MTk3OTU2NDIyOTI2Mzc2.YPPDtQ.InpwB_jUZzZ7z-EyfeeUkRfbTBI";
		
		DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();

		// Add a listener which answers with "Pong!" if someone writes "!ping"
		api.addMessageCreateListener(event -> {
			if (event.getMessageContent().equalsIgnoreCase("!ping")) {
				event.getChannel().sendMessage("Pong!");
			}	
		});
		
		api.getTextChannelById("880387990344585276").get().sendMessage("안녕하세요~");

		// Print the invite url of your bot
		System.out.println("You can invite the bot by using the following url: " + api.createBotInvite());
	}

}
