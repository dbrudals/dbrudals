package com.swh.rabbitmq.project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopy {
	private final static String QUEUE_NAME = "ykm";

	public static void fileCopy(String inputPath, String outputPath){
		
		InputStream is = null;
		OutputStream os = null;

		try{
			// ./는 현재경로를 의미합니다.
			is = new FileInputStream(inputPath);
			os = new FileOutputStream(outputPath);

			int data = -1;
			while( (data = is.read()) != -1 ){
				os.write(data);
			}
		}
		catch (FileNotFoundException e){
			System.out.println("파일 없음");
			e.printStackTrace();
		}
		catch (IOException e){
			System.out.println("I/O 에러");
			e.printStackTrace();
		}
		finally {
			// 예외가 발생했을 때도 스트림을 닫아야 하므로 finally에서 스트림을 닫아줍니다.
			try {
				if( is != null ){
					is.close();  
				}
				if( os != null ){
					os.close();
				}
			}
			catch ( IOException e){
				e.printStackTrace();
			}
		}
	}
};