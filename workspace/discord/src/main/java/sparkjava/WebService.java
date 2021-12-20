package sparkjava;

import static spark.Spark.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import main.QueryA;
import main.Schedule;
import main.Singleton;

public class WebService {
	public static void main(String args[]) throws IOException {
		//ip 받아 실행
		String ip = System.getProperty("serverip");
		//생성자 호출
		Normalization n = new Normalization();
		QueryA queryA = Singleton.getQueryA();
		
		//등록 페이지
		get("/register/:usern", (request, response) -> { //사용자 이름을 전달한 사용자 전용 링크
			Map<String, Object> att1 = new HashMap<>(); //ftl파일 내 포맷팅을 위한
			String date_time = n.dateform(); //날짜 정보 받아 옴
			att1.put("ip", ip); //ip 전달
			String usern = request.params(":usern").replace(":", "");
			att1.put("username", usern); //사용자 이름 전달 (사용자 이름 입력란 수정 불가)
			att1.put("date_time", date_time); //미리보기 날짜 전달
			att1.put("min_dt", date_time); //등록 가능 시간범위 전달
			return modelAndView(att1, "register.ftl");
		}, new FreeMarkerEngine());

		//제출 페이지
		post("/submit", (request, response) -> {
			//등록 페이지에서 받아온 정보를 변수에 저장
			String usern = request.queryParams("usern"); 
			String name = request.queryParams("name");
			String date_time = request.queryParams("date_time");
			String content = request.queryParams("content");
			String checkbox = request.queryParams("checkbox");
			//받아온 데이터를 DB에 넣을 일관된 형식으로 변환
			if (checkbox == null) {
				checkbox = "";
			}
			int tts = n.checkbox(checkbox); //tts 정보 변환
			date_time = date_time.replace("T", " ") + ":00";
			//받아 온 정보들을 DB에 insert
	    	queryA.insertSchedule(new Schedule(), usern, name, date_time, content, tts);
			//페이지
			Map<String, Object> att2 = new HashMap<>(); //ftl파일 내 포맷팅을 위한
			att2.put("message", "등록 완료되었습니다.");
			att2.put("message2", "완료됐슈-");
			return modelAndView(att2, "submit.ftl");
		}, new FreeMarkerEngine());
	}
}