package example;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class First {

	public static void main(String[] args) {
		int year = 2017;
		int month = 11;
		int day = 15;
		Calendar c = Calendar.getInstance();    //  추상클래스라서 객체만들 수 없다.
		c.set(year, month, day);
		System.out.println(c.get(Calendar.YEAR) + ". " + c.get(Calendar.MONTH));

		Date date = new Date();         //  컴퓨터 시스템에 등록된 현재시간을 얻음
		System.out.println(date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
		System.out.println(sdf.format(date));
	}

}
