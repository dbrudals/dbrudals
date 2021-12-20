package com.swh.project;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * <pre>
 * kr.co.swh.lecture.network.filetrans 
 * FileReceiveServer.java
 *
 * 설명 :파일 전송 서버
 * </pre>
 * 
 * @since : 2018. 12. 28.
 * @author : tobby48
 * @version : v1.0
 */
public class FileReceiveTCP implements IReceive{


	@Override
	public void receive() throws Exception {

		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			// 리스너 소켓 생성 후 대기
			serverSocket = new ServerSocket(8081); // socket(),bind();
			// 연결되면 통신용 소켓 생성           
			while(true){
				socket = serverSocket.accept(); // listen(),accept();
				long start = System.currentTimeMillis();
				// 파일 수신 작업 시작
				//			FileReceiver f = new FileReceiverH(socket, start); //class
//				FileReceiver fr = new FileReceiverN(socket, start); //byte array
				FileReceiver fr = YRead.getTypeC(socket, start);
				fr.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
