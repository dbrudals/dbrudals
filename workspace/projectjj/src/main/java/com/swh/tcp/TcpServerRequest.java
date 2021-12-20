package com.swh.tcp;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * <pre>
 * kr.co.swh.lecture.network.tcp
 * TcpServerRequest.java
 *
 * 설명 :TCP 서버
 * </pre>
 * 
 * @since : 2018. 6. 23.
 * @author : tobby48
 * @version : v1.0
 */
public class TcpServerRequest {
	public static void main(String[] args) {
		ServerSocket ss = null;		// 서버소켓 변수
		Socket sock = null;		// 접속할 클라이언트 소켓변수
		try {
			ss = new ServerSocket(9999);	// 서버소켓생성
			System.out.println("서버 대기중 ");
			while (true) {
				// 클라이언트가 접속 할때까지 대기하다가 접속하면 socket생성
				sock = ss.accept();
				System.out.println("접속자 정보 : " + sock);
				
//				// 클라이언트에서 보낸 한줄의 메시지를 출력
//				BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
//				String msg = in.readLine();
//				System.out.println("보낸 메시지 : "+msg);
				
				// 클라이언트에서 보낸 한줄의 메시지를 출력
				BufferedWriter in = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
				in.write("haha");
				
				//클라이언트와의 연결 끊기
				in.close();
				sock.close();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
