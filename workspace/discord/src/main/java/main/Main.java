package main;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.javacord.api.entity.channel.ServerTextChannelBuilder;
import org.javacord.api.entity.channel.TextChannel;

public class Main {
	public static void main(String[] args) {
		//ip 받아 실행
		String ip = System.getProperty("serverip");
		
		//생성자 호출
		Embed embedMessage = new Embed();
		QueryA queryA = Singleton.getQueryA();

		//Timer Starter : 스케줄링 실행
		QuartzMain quartz = new QuartzMain();
		quartz.startQuartz(quartz);

		//setup : 서비스를 위한 전용 텍스트채널 Scheduler을 세팅하는 명령어
		embedMessage.getApi().addMessageCreateListener(event -> {
			if (event.getMessageContent().equals("!setup")) { // !setup 을 입력하면
				Channel_id channel_id = new Channel_id();
				ServerTextChannelBuilder s = new ServerTextChannelBuilder(event.getServer().get());
				s.setName("Scheduler"); // 채널 이름 설정
				
				try {
					if(queryA.isEmpty()){ // 채널id DB가 비어있다면 그냥 채널id추가
						queryA.insertChannel_id(new Channel_id());
						channel_id.setChannel_id(s.create().get().getId());
						queryA.insertChannel_id(channel_id);
						embedMessage.getApi().getTextChannelById(Singleton.getQueryA().selectChannel_id().getChannel_id()).get().sendMessage(Embed.channelAdd());
					}
					
					else{ // 채널id DB에 값이 있다면
						for(TextChannel textChannel : embedMessage.getApi().getTextChannels()){ // 서버에 있는 채널 비교
							if(textChannel.getId() == Singleton.getQueryA().selectChannel_id().getChannel_id()){ // 채널이 이미 있다면
								embedMessage.getApi().getTextChannelById(Singleton.getQueryA().selectChannel_id().getChannel_id()).get().sendMessage(Embed.warning());
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

		//create : 알람 등록 링크를 제공하는 명령어
		embedMessage.getApi().addMessageCreateListener(event -> {
			if (event.getMessageContent().equalsIgnoreCase("!create")) {
				String name = event.getMessageAuthor().getName(); //명령어를 친 사용자 이름 (해당 사용자 전용 링크를 만들기위함)
				long id = queryA.selectChannel_id().getChannel_id(); //Scheduler채널의 id
				TextChannel channel = embedMessage.getApi().getTextChannelById(id).get(); //Scheduler채널의 id로 Channel객체 가져옴
				if(event.getChannel().getId() != id){ //명령어가 감지된 채널이 Scheduler채널 외의 채널일 때 경고 메시지 전송
					event.getChannel().sendMessage(embedMessage.warningEmbed());
				}
				else channel.sendMessage(embedMessage.registerEmbed(ip, name)); //등록 임베드 전송
			}
		});

		//list : 등록된 일정 중 알람이 울리지 않은 일정들의 목록을 제공하는 명령어
		embedMessage.getApi().addMessageCreateListener(event -> {
			if (event.getMessageContent().equalsIgnoreCase("!list")) {
				long id = queryA.selectChannel_id().getChannel_id(); //Scheduler채널의 id
				TextChannel channel = embedMessage.getApi().getTextChannelById(id).get(); //Scheduler채널의 id로 Channel객체 가져옴
				if(event.getChannel().getId() != id){ //명령어가 감지된 채널이 Scheduler채널 외의 채널일 때 경고 메시지 전송
					event.getChannel().sendMessage(embedMessage.warningEmbed());
				}
				else {//일정 목록 임베드 전송
					List<Schedule> resultList = queryA.selectSchedule();
					channel.sendMessage("일정 목록");
					channel.sendMessage(embedMessage.listEmbed(resultList));
				}
			}
		});

		//디스코드 봇이 작동할 준비를 마쳤을 때 츨력
		System.out.println("You can invite the bot by using the following url: " + embedMessage.getApi().createBotInvite());
	}
}