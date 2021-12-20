package main;

public class Singleton {

	private static QueryA queryA= new QueryA();

	public static QueryA getQueryA(){
		return queryA;
	}
}