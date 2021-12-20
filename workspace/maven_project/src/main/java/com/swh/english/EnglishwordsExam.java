package com.swh.english;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import lombok.Data;

@Data
public class EnglishwordsExam {
	private Map<String, String> engList = new HashMap<String, String>();
	private String day; 
	private Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		EnglishwordsExam e = new EnglishwordsExam();
		
		System.out.print("DAY 몇 입니까?(숫자만 입력)            :  ");
		e.setDay(e.scanner.nextLine());
		
		while(true){
			if(e.askMessage()){
				
			}
		}
	}
	
	public boolean askMessage(){
		System.out.print("단어를 추가하시겠습니까?(y/n)          :  ");
		if(scanner.nextLine().equals("y")){
			return true;
		}else return false;
	}
	
	public void dataPutMessage(){
		System.out.print("추가할 영어 단어를 입력해주세요                 :  ");
		String en = scanner.nextLine();
		System.out.print("추가할 영어 단어의 한글 뜻을 입력해주세요    :  ");
		engList.put(en, scanner.nextLine());
	}
	
	
	
}
