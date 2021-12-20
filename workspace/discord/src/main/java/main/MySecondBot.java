package main;

import java.util.concurrent.ExecutionException;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.channel.ServerTextChannelBuilder;
import org.javacord.api.entity.channel.TextChannel;


public class MySecondBot {
	public static void main(String[] args) {
		// Insert your bot's token here
		// ODY2MTk3OTU2NDIyOTI2Mzc2.YPPDtQ.Wm1u0SZK3JG6_Z6G4dZnjEx6jMU
		
        String token = "NjgxMDA2MTg1NjMzMjg0MTMw.XlIKbw.UM_mPEAGIrbdIOYScwXVO96zNfM";
        DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();
		QueryA queryA = Singleton.getQueryA();

		api.addMessageCreateListener(event -> {
			if (event.getMessageContent().equals("!setup")) { // !setup 을 입력하면
				Channel_id channel_id = new Channel_id();
				ServerTextChannelBuilder s = new ServerTextChannelBuilder(event.getServer().get());
				s.setName("Scheduler"); // 채널 이름 설정
				
				try {
					if(queryA.isEmpty()){ // 채널id DB가 비어있다면 그냥 채널id추가
						queryA.insertChannel_id(new Channel_id());
						channel_id.setChannel_id(s.create().get().getId());
						queryA.insertChannel_id(channel_id);
					}
					
					else{ // 채널id DB에 값이 있다면
						for(TextChannel textChannel : api.getTextChannels()){ // 서버에 있는 채널 비교
							if(textChannel.getId() == Singleton.getQueryA().selectChannel_id().getChannel_id()){ // 채널이 이미 있다면
								api.getTextChannelById(Singleton.getQueryA().selectChannel_id().getChannel_id()).get().sendMessage(EmbedMessageUtil.warning());
								return;
							}
						}
						queryA.updateChannel_id(s.create().get().getId()); // 채널이 없으면 채널을 만들고, DB 업뎃
					}		
					
				} catch (InterruptedException | ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		// embed 메시지 보내는 코드들		
//		api.getTextChannelById("880387990344585276").get().sendMessage(embed);
//		api.getTextChannelById("880387990344585276").get().sendMessage(embed2);

		// Print the invite url of your bot
	}

}
