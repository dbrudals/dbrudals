package com.swh.discordBot.main;

public class DBUtil {
	
    void insert(Object user, Object content, Object time, Object subject, Object tts){ //파라미터 바꿀 수 있음
    	/*DB에 입력*/
    	
    	/*DB close*/
    	Embed fin = new Embed();
    	fin.insertEmbed();
    }
	
    //오버로드 필요?
	void delete(){
		/*삭제 수행
		 * 
		 * DB close*/
		Embed com = new Embed();
		com.deleteEmbed();
	}
	
	public void update(Object info, String type){
		/*수정 수행
		 * 
		 * */
		Embed com = new Embed();
		com.updateEmbed();
	}
}