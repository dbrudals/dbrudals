package com.swh.quiz;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MusicQuiz {
	public static void main(String[] args) {
		Map<String, String> musicMap = new HashMap<String, String>();
		musicMap.put("https://www.youtube.com/watch?v=OQlC-1FV6CE", "베르디-오페라 ‘리골레토’ 중 “여자의마음”");
		Random random = new Random();
		while(musicMap.size()!=0){
			random.nextInt(musicMap.size());
		}
	}
}
