package main;

public class Schedule{
	
	private Long id;
	private String usern;
	private String name;
	private String date_time;
	private String content;
	private Integer tts;
	private Integer chk;
	
	public Schedule() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getUsern() {
		return usern;
	}

	public void setUsern(String usern) {
		this.usern = usern;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate_time() {
		return date_time;
	}

	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getTts() {
		return tts;
	}

	public void setTts(Integer tts) {
		this.tts = tts;
	}

	public Integer getChk() {
		return chk;
	}

	public void setChk(Integer chk) {
		this.chk = chk;
	}
}