package com.swh.discordBot.sparkjava;

import static spark.Spark.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.swh.discordBot.main.DBUtil;

public class WebService {

    public static void main(String args[]) throws IOException {
    	
        get("/register", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();

            // The register.ftl file is located in directory:
            // src/test/resources/spark/examples/templateview/freemarker
            return modelAndView(attributes, "register.ftl");
        }, new WebEngine());
        
//        get("/submit", (request, response) -> {
//            Map<String, Object> attributes = new HashMap<>();
//            attributes.put("message", "등록이 완료되었습니다.");
//            attributes.put("message2", "디스코드 채널에서 등록 여부를 확인하세요.");
//            // The register.ftl file is located in directory:
//            // src/test/resources/spark/examples/templateview/freemarker
//            return modelAndView(attributes, "submit.ftl");
//        }, new WebEngine());
        
        post("/submit", (request, response) -> {
            String user = request.queryParams("user");
            String content = request.queryParams("content");
            String date = request.queryParams("date");
            String time = request.queryParams("time");
            String subject = request.queryParams("subject");
            String checkbox = request.queryParams("checkbox");
            
            date = date+" "+time;
            
            Normalization n = new Normalization();
            Boolean tts = n.Checkbox(checkbox);

//            DBUtil s = new DBUtil();
//            s.insert(user, content, date, time, subject, checkbox);
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("message", "등록이 완료되었습니다.");
            attributes.put("message2", "디스코드 채널에서 등록 여부를 확인하세요.");
            return modelAndView(attributes, "submit.ftl");
        }, new WebEngine());
    }
}