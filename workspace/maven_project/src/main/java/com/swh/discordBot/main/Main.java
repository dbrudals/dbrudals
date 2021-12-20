package com.swh.discordBot.main;

import org.javacord.api.*;
//import org.javacord.api.entity.message.embed.EmbedBuilder;

public class Main {
	public static void main(String[] args)  {
		String token = "your token";
		DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();

		/*삭제 명령어 감지*/
		DBUtil db = new DBUtil();
		db.delete();
		
		
		/*수정 명령어 감지
		 *수정 내용, type 걸러서 파라미터로 전달
		 * */
		Object info = null; //변경 내용
		String type = null; //변경 type

		db.update(info, type);
        
        System.out.println("You can invite the bot by using the following url: " + api.createBotInvite());
    }
}