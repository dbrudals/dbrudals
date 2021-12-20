package main;

public class Schedule {
	String user, content, time, subject;
	Boolean tts;

	public Schedule(String user, String content, String time, String subject, Boolean tts) {
		this.user = user;
		this.content = content;
		this.time = time;
		this.subject = subject;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Boolean getCheckbox() {
		return tts;
	}

	public void setCheckbox(Boolean checkbox) {
		this.tts = checkbox;
	}
}