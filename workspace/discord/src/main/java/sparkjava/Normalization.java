package sparkjava;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Normalization {
	//페이지에 보일 날짜 정보
	public String dateform() {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm"); //날짜 포맷
		Calendar time = Calendar.getInstance(); //현재 날짜
		String format_time1 = format1.format(time.getTime()); //현재 날짜 포맷에 맞춤
		int tem = 2 + Integer.parseInt(format_time1.substring(14)); //2분 추가(등록 시 2분 후부터 등록 가능하도록)
		if (tem == 60) { //60분 -> 0분
			tem = 0;
		}
		else if (tem == 61) { //61분 -> 1분
			tem = 1;
		}
		String date_time = null;
		if (tem < 10){ //분이 한 자리수일 때 '0'붙여줌
			String hour = format_time1.substring(11, 13); //시 추출
			if(tem==0 || tem==1){ //0분or1분일 때 시 바꾸기
				if(hour.equals("23")){ //23시이면 00시로 바꾸기
					date_time = format_time1.substring(0, 11) + "00:0" + Integer.toString(tem);
				}
				else{
					int h = Integer.parseInt(hour)+1;
					if(h<10){//시가 한 자리수일 때 '0'붙여줌
						date_time = format_time1.substring(0, 11) + '0' + Integer.toString(h) + ":0" + Integer.toString(tem);
					}
					else{
						date_time = format_time1.substring(0, 11) + Integer.toString(h) + ":0" + Integer.toString(tem);
					}
				}
			}
			else{
				date_time = format_time1.substring(0, 14) + '0' + Integer.toString(tem);
			}
		}
		else {
			date_time = format_time1.substring(0, 14) + tem;
		}
		date_time = date_time.replace(" ", "T");//공백에 'T' 추가 : html의 datetime-local type 형식에 맞추기 위함
		return date_time;
	}
	
	//tts정보 : string to integer
	public Integer checkbox(String checkbox){
		int tts = 1;
		if (checkbox.equals("on")) {//on -> 2, off -> 1
			tts = 2;
		}
		return tts;
	}
}