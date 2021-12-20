package main;

import java.util.Timer;
import java.util.TimerTask;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;


/**
 * Simple demo that uses java.util.Timer to schedule a task 
 * to execute once 5 seconds have passed.
 */

public class TimerThread extends Thread {
	enum CheckState{
		INIT,
		IN_SCHEDULE,
		EXIT
	}
	Timer timer;
	Timer timer2;

	private Embed embed = new Embed();
	private TimeChange timeChange = new TimeChange();

	public TimerThread(String time ,Schedule s) {
		timer = new Timer();
		timer2 = new Timer();

		long timerTime = timeChange.change(s.getDate_time())-timeChange.change(time);

		if(timerTime<=600000){ // 일정 시간이 10분 이하로 차이가 난다면
			timer2.schedule(new CronThreadTask2 (s), timerTime-5000); // 바로 제시간에 울림
		}
		else{
			timer.schedule(new CronThreadTask(s), timerTime-600000); // 10분전에 알람이 울림
			timer2.schedule(new CronThreadTask2 (s), timerTime-5000); // 일정 제 시간에 울림
		}
		Singleton.getQueryA().updateSchedule(s, CheckState.IN_SCHEDULE); // 체크를 1로 수정
		
	}

	class CronThreadTask extends TimerTask {
		private Schedule s;
		private boolean t = false;
		public CronThreadTask(Schedule s) {
			// TODO Auto-generated constructor stub
			if(s.getTts() == 2){
				this.t = true;
			}
			this.s = s;
		}

		public void run() {
			// 아래는 디스코드 문자를 보내는 코드
			long id = Singleton.getQueryA().selectChannel_id().getChannel_id();
			embed.getApi().getTextChannelById(id).get().sendMessage("10분 전 알람입니다.", embed.alarmTenminEmbed(this.s), this.t, null); // 채널id를 이용해 embed메시지 전송
			timer.cancel(); //Terminate the timer thread
		}
	}

	class CronThreadTask2 extends TimerTask {
		private Schedule s;
		private boolean t = false;
		public CronThreadTask2(Schedule s) {
			// TODO Auto-generated constructor stub
			if(s.getTts() == 2){
				this.t = true;
			}
			this.s = s;
		}

		public void run() {
			// 아래는 디스코드 문자를 보내는 코드
			long id = Singleton.getQueryA().selectChannel_id().getChannel_id();
			embed.getApi().getTextChannelById(id).get().sendMessage("정각 알람입니다.", embed.alarmEmbed(this.s), this.t, null); // 채널id를 이용해 embed메시지 전송
			Singleton.getQueryA().updateSchedule(this.s, CheckState.EXIT); // 체크를 2로 수정
			timer2.cancel(); //Terminate the timer thread
		}
	}
}