package com.swh.project;
import java.io.File;
import java.lang.reflect.Constructor;
import java.net.Socket;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class YRead {

	private static Ysr ysr;

	public static void getInstance() throws Exception{
		if(ysr == null){
			ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
			ysr = mapper.readValue(new File("src/main/resources/name.yml"), Ysr.class);
		}
	}

	public ISend getSendC() throws Exception {
		Class<?> finedClass = Class.forName(ysr.getSend());
		ISend sender = (ISend) finedClass.newInstance(); // 생성자 호출
		return sender;
	}

	public IReceive getReceiveC() throws Exception {
		Class<?> finedClass = Class.forName(ysr.getReceive());
		IReceive receiver = (IReceive) finedClass.newInstance();
		return receiver;
	}

	public FileReceiver getTypeC(Socket socket, long start) throws Exception {
		Class<?> finedClass = Class.forName(ysr.getReceive());
		Constructor<?> ctor=finedClass.getConstructor(Socket.class, Long.class);
		FileReceiver type = (FileReceiver) ctor.newInstance(socket, start);
		return type;
	}

}
