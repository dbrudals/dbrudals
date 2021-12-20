package com.swh.ykm;

import java.io.IOException;
import java.util.Scanner;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class NaverTest {

	public static String naverAddress(){
		Scanner s = new Scanner(System.in);
		System.out.println("검색어를 입력하세요:");
		String keyword = s.next();
		s.close();
		return keyword;
	}
	public static void main(String args[]){
		try {			
			// 1. 수집 대상 URL
			String URL = "https://search.naver.com/search.naver?where=image&sm=tab_jum&query="+ NaverTest.naverAddress();

			// 2. Connection 생성
			Connection conn = Jsoup.connect(URL);

			// 3. HTML 파싱.
			Document html = conn.get(); // conn.post();

			// 4. HTML 출력
			System.out.println(html.toString()); 

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
