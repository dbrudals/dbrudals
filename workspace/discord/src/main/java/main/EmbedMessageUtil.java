package main;

import java.awt.Color;
import java.io.File;

import org.javacord.api.entity.message.embed.EmbedBuilder;

public class EmbedMessageUtil {
	public static EmbedBuilder alarmTenminEmbed(Schedule s) {
		EmbedBuilder embed = new EmbedBuilder()
				.setAuthor(s.getUsern())
				.setTitle(s.getName())
				.setDescription("10분 전 입니다!!!!!")
				.addField("DATE", s.getDate_time())
				.addInlineField("CONTENT", s.getContent())
				.setThumbnail(new File("C:/Users/ykm09/workspace/discord/src/main/resources/10min.jpg"))
				.setColor(new Color(178, 102, 255));
		return embed;
	}

	public static EmbedBuilder alarmEmbed(Schedule s) {
		EmbedBuilder embed = new EmbedBuilder()
				.setAuthor(s.getUsern())
				.setTitle(s.getName())
				.addField("DATE", s.getDate_time())
				.addInlineField("CONTENT", s.getContent())
				.setThumbnail(new File("C:/Users/ykm09/workspace/discord/src/main/resources/alarm.jpg"))
				.setColor(new Color(76, 0, 153));
		return embed;
	}

	public static EmbedBuilder channelAdd(){
		EmbedBuilder embed = new EmbedBuilder()
				.setDescription("채널이 추가되었습니다.")
				.setColor(Color.YELLOW);
		return embed;
	}
	public static EmbedBuilder warning(){
		EmbedBuilder embed = new EmbedBuilder()
				.setTitle(":warning: 이미 채널이 존재합니다.")
				.setDescription("현재 이 채널을 이용해주시기 바랍니다.")
				.setColor(Color.ORANGE);
		return embed;
	}
}
