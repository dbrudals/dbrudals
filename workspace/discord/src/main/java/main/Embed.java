package main;

import java.awt.Color;
import java.io.File;
import java.util.List;

import org.javacord.api.entity.message.embed.EmbedBuilder;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

public class Embed {

	//토큰과 api를 이 클래스에 넣은 이유 : api가 필요한 경우는 임베드를 전송할 때 뿐임
	private String token = "NjgxMDA2MTg1NjMzMjg0MTMw.XlIKbw.UM_mPEAGIrbdIOYScwXVO96zNfM"; //디스코드 봇 토큰
	private DiscordApi api = new DiscordApiBuilder().setToken(token).login().join(); //봇 api 정보

	//api Getter
	public DiscordApi getApi() {
		return api;
	}

	//등록 임베드
	public EmbedBuilder registerEmbed(String ip, String name) {
		//임베드 구성
		EmbedBuilder embed = new EmbedBuilder()
				.setTitle(String.format("%s님의 일정등록", name))
				.addField("아래 링크를 통해 일정을 등록하세요.","[일정등록하세요]"+"("+String.format("http://%s:4567/register/:%s", ip, name)+")") //등록 링크
				.setColor(Color.WHITE);
		return embed;
	}

	//DB insert 완료 후, 일정이 등록되었음을 알리는 임베드
	public EmbedBuilder insertEmbed(String name, String date_time, String content, String usern){
		//임베드 구성
		EmbedBuilder embed = new EmbedBuilder();
		embed.setTitle(String.format("📅 %s", name));
		embed.addField("일정 시작", date_time);
		if(!content.equals("")) { //content가 null이 아닐 때만 항목 추가
			embed.addField("Content", content);
		}
		embed.setColor(Color.WHITE);
		return embed;
	}

	//일정 목록 임베드
	public EmbedBuilder listEmbed(List<Schedule> resultList){
		//임베드 구성
		EmbedBuilder embed = new EmbedBuilder();
		embed.setTitle("일정 List");
		embed.setColor(Color.CYAN);
		int sum = 1;
		String res = "";
		String tem;
		for(Schedule sch : resultList){
			if (sum > 10){ //최대 10개까지만 제공
				break;
			}
			if(sch.getChk() < 2){ //알람이 울린 일정은 제공하지 않음
				String s = "**"+sch.getName()+"** | " + sch.getDate_time()+" | " + sch.getContent() + " | _"+sch.getUsern()+"_"; //항목
				tem = Integer.toString(sum)+". "+ s + "\n\n"; //목록번호 추가
				res += tem;
				sum += 1;
			}
		}
		embed.setDescription(res);
		return embed;
	}

	//Scheduler 채널 외의 채널에서 메시지를 보낼 경우 경고 메시지 임베드
	public EmbedBuilder warningEmbed() {
		EmbedBuilder embed = new EmbedBuilder()
				.setTitle("❌잘못된 접근❌")
				.setDescription("Schedule 채널을 이용해주세요")
				.setColor(Color.RED);
		return embed;
	}
	
	//채널 추가
	public static EmbedBuilder channelAdd(){
		EmbedBuilder embed = new EmbedBuilder()
				.setDescription("채널이 추가되었습니다.")
				.setColor(Color.YELLOW);
		return embed;
	}
	
	//schedule 채널 경고
	public static EmbedBuilder warning(){
		EmbedBuilder embed = new EmbedBuilder()
				.setTitle(":warning: 이미 채널이 존재합니다.")
				.setDescription("현재 이 채널을 이용해주시기 바랍니다.")
				.setColor(Color.ORANGE);
		return embed;
	}

	//알람
	//10분 전 알람
	public EmbedBuilder alarmTenminEmbed(Schedule s) {
		//임베드 구성
		EmbedBuilder embed = new EmbedBuilder();
		embed.setAuthor(s.getUsern());
		embed.setTitle(s.getName());
		embed.setDescription("10분 전 입니다!!!!!");
		embed.addField("DATE", s.getDate_time());
		if(!s.getContent().equals("")) { //content는 null 허용 : null일 때 임베드 설정
			embed.addInlineField("CONTENT", s.getContent());
		}
		embed.setThumbnail(new File("C:/Users/USER/workspace/discord_m/src/main/resources/10min.jpg"));
		embed.setColor(new Color(178, 102, 255));
		return embed;
	}

	//정각 알람
	public EmbedBuilder alarmEmbed(Schedule s) {
		EmbedBuilder embed = new EmbedBuilder();
		embed.setAuthor(s.getUsern());
		embed.setTitle(s.getName());
		embed.addField("DATE", s.getDate_time());
		if(!s.getContent().equals("")) { //content는 null 허용 : null일 때 임베드 설정
			embed.addInlineField("CONTENT", s.getContent());
		}
		embed.setThumbnail(new File("C:/Users/USER/workspace/discord_m/src/main/resources/alarm.jpg"));
		embed.setColor(new Color(76, 0, 153));
		return embed;
	}

//	void deleteEmbed(){
//		/*삭제 정보 임베드로 제공*/
//	}
//
//	void updateEmbed(){
//		/*수정 정보 임베드로 제공*/
//	}
}