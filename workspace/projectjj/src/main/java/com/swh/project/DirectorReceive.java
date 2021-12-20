package com.swh.project;

public class DirectorReceive {
	private IReceive b;
	
	public DirectorReceive(IReceive b) {
		// TODO Auto-generated constructor stub
		this.b = b;
	}
	
	public boolean construct(){
		try{
			this.b.receive();
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	

}
