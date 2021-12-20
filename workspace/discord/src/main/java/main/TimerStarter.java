package main;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TimerStarter {
	
	public TimerStarter(){
//		시간을 계산하는 part
		
		List<Schedule> l = Singleton.getQueryA().selectSchedule();

		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String time = df.format(cal.getTime());
		cal.add(Calendar.DATE, 1);
		String nextTime = df.format(cal.getTime());
		
//		time = 현재시간, nextTime = 24시간 후 시간
		for (Schedule s : l){
			if(nextTime.compareTo(time)>=0 && s.getDate_time().compareTo(time)>0 && s.getChk() == 0){ 
				// 현재시간보단 크지만 24시간보다는 작고 한 번도 돌지 않은(0) 일정이면
				TimerThread cronThread = new TimerThread(time, s); // 타이머
			}
		}
	}	
}
