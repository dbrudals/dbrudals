package com.swh.fileIO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import com.swh.fileIO.FileByteStreamObjectWrite.AA;


public class FileByteStreamObjectRead {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ObjectInputStream input = new ObjectInputStream(new FileInputStream("C:/Users/ykm09/Desktop/text3.txt"));
		Object obj = input.readObject();
		if(obj instanceof AA){      //  obj객체가 AA 데이터 타입인지 체크
			System.out.println(obj.toString());
			System.out.println(obj);
		}
		input.close();
	}

}
