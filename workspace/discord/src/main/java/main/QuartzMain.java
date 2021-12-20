package main;

import java.util.UUID;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * <pre>
 * kr.co.swh.lecture.opensource.quartz
 * QuartzMain.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2018. 9. 30.
 * @author : tobby48
 * @version : v1.0
 */
public class QuartzMain {
	private StdSchedulerFactory schedulerFactory;
	private org.quartz.Scheduler scheduler;

	public QuartzMain(){
		schedulerFactory = new org.quartz.impl.StdSchedulerFactory();
		try {
			scheduler = schedulerFactory.getScheduler();
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean initialise(String cronExpr, Class<main.SchedulerProcessor> class1){
		String id = UUID.randomUUID().toString();

		JobDetail newJob = JobBuilder.newJob(class1).withIdentity(id).build();
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger_" + id)
				.withSchedule(CronScheduleBuilder.cronSchedule(cronExpr)).forJob(id)
				.build();
		if (trigger != null) {
			try {
				scheduler.scheduleJob(newJob, trigger);
			} catch (SchedulerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
	}

	public void start(){
		try {
			scheduler.start();
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void stop(){
		try {
			if(schedulerFactory != null && scheduler.isStarted()){
				scheduler.shutdown();
			}
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void startQuartz(QuartzMain quartz) {
		if(quartz.initialise("30 * * * * ?", SchedulerProcessor.class)){
			quartz.start();
		}
	}
}