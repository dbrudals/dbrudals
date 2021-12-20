package main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.javacord.api.entity.channel.TextChannel;

import main.TimerThread.CheckState;

public class QueryA {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	private Session session = sessionFactory.openSession();
	private Embed embed = new Embed();

	public List<Schedule> selectSchedule(){
		Query<Schedule> query = session.createQuery("FROM Schedule ORDER BY DATE_TIME");
		return query.getResultList();
	}

	public void updateSchedule(Schedule s, CheckState state){
		session.beginTransaction();
		Schedule myuser = (Schedule)session.get(Schedule.class, s.getId());
		myuser.setChk(state.ordinal());
		session.getTransaction().commit();
		//		Query<Schedule> query = session.createQuery("UPDATE Schedule s SET s.CHK = 0");
	}

	public Channel_id selectChannel_id(){
		Query<Channel_id> query = session.createQuery("FROM Channel_id");
		return query.getSingleResult();
	}

	public void updateChannel_id(long channel_id){
		session.beginTransaction();
		Query<Schedule> query = session.createQuery("DELETE Channel_id");
		query.executeUpdate();
		session.getTransaction().commit();
		this.insertChannel_id(channel_id);

	}

	public void insertChannel_id(Channel_id channel_id){
		session.beginTransaction();
		session.save(channel_id);
		session.getTransaction().commit();
	}

	public void insertChannel_id(long channel_id){
		session.beginTransaction();
		Channel_id c = new Channel_id();
		c.setChannel_id(channel_id);
		session.save(c);
		session.getTransaction().commit();
	}


	//웹페이지로부터 받은 일정 정보 DB에 insert
	public void insertSchedule(Schedule sch, String usern, String name, String date_time, String content, int tts) throws Exception{
		sch.setUsern(usern);
		sch.setName(name);
		sch.setDate_time(date_time);
		sch.setContent(content);
		sch.setTts(tts);
		sch.setChk(0);
		//insert
		session.beginTransaction();
		session.save(sch);
		session.getTransaction().commit();
		//		System.out.println("Insert completed");
		long cid = selectChannel_id().getChannel_id();
		TextChannel channel = embed.getApi().getTextChannelById(cid).get();
		channel.sendMessage(String.format("%s 님의 일정 등록", usern));
		channel.sendMessage(embed.insertEmbed(name, date_time, content, usern)); //?        
	}
	public boolean isEmpty(){
		Query<Long> query = session.createQuery("SELECT COUNT(*) FROM Channel_id");
		if(query.getSingleResult().equals(0L)){ 
			return true;
		}
		else return false;
	}


	public void close() throws Exception{
		session.close();
		sessionFactory.close();
	}

}