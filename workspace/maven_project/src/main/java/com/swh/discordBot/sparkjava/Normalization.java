package com.swh.discordBot.sparkjava;

public class Normalization {
	
	Boolean Checkbox(String checkbox){
		Boolean tts = false;
		if (checkbox.equals("on")) {
			tts = true;
		}
		return tts;
	}
	
	String UserID(){
		/*user가 입력한 이름을 숫자로 된 userID로 변환
		    문제는 뭘 받아야 저 id를 얻을 수 있느냐
		    아예 링크를 누른 사용자 혹은 입력한 사용자의 정보를 받아올 수  있는 방법은 없나*/
		return null;
	}
	
}