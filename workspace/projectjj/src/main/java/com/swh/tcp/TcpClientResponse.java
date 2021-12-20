package com.swh.tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * <pre>
 * kr.co.swh.lecture.network.tcp
 * TcpClientResponse.java
 *
 * 설명 :TCP 클라이언트
 * </pre>
 * 
 * @since : 2018. 6. 23.
 * @author : tobby48
 * @version : v1.0
 */
public class TcpClientResponse {
	public static void main(String[] args) {
		Socket sock = null;		// 서버에 접속할 소켓 변수
		try{
			// 서버 연결
			sock = new Socket("127.0.0.1", 9999);
			// 서버에 메세지 전송
//			PrintWriter out = new PrintWriter(sock.getOutputStream()); // 테이터를 전송할  Write 변수
//			out.println("SWHAcademy\n");
//			out.flush();
			
//			BufferedWriter w = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
//			w.write("SWHAcademy\n");
//			w.close();
			
			BufferedReader w = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			System.out.println(w.readLine());
			w.close();
			
			// 접속 끊기
			sock.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}

	}
}