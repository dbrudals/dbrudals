package com.swh.project;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class FileReceiver extends Thread {
	Socket socket;
	DataInputStream dis;
	FileOutputStream fos;
	BufferedOutputStream bos;
	String filename;
	long start;
	int control = 0;

	public FileReceiver(Socket socket, long starttime) {
		this.socket = socket;
		this.start = starttime;
	}

	public static void saveObject(FileData data) throws IOException {
		FileOutputStream outputStream = new FileOutputStream("C:/Users/ykm09/Desktop/coding/_receiveTestFile/"+data.getFileName(), true);
		outputStream.write(data.getData2(), 0, data.getData());
		outputStream.close();
	}

	public static FileData toObject (byte[] bytes, Class<FileData> type)
	{
		Object obj = null;
		try {
			ByteArrayInputStream bis = new ByteArrayInputStream (bytes);
			ObjectInputStream ois = new ObjectInputStream(bis);
			obj = ois.readObject();
		}
		catch (IOException ex) {
			ex.printStackTrace();
			//TODO: Handle the exception
		}
		catch (ClassNotFoundException ex) {
			//TODO: Handle the exception
		}

		return (FileData) obj;	

	}
	
	@Override
	public void run(){
		
	}

}
