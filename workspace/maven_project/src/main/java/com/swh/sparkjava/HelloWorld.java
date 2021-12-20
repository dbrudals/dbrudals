package com.swh.sparkjava;

import static spark.Spark.*;

public class HelloWorld {
	public static void main(String[] arg){
		get("/hello", (request, response) -> {
			return "Hello World!";	
		});
		get("/hello", "application/json", (request, response) -> "{\"message\": \"Hello World\"}");
	}
}
