package com.swh.yaml;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class MainC {

	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
		try {
			Sample sample = mapper.readValue(new File("src/main/resources/spyaml.yml"), Sample.class);
			String className = sample.getClz().getName();

			Class finedClass = Class.forName(className);
			A ci = (A) finedClass.newInstance(); // 생성자 호출
			System.out.println("Class Instance : " + ci);

			ci.hello(); 
			ci.bye();

			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}
}