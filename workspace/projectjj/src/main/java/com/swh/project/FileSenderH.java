package com.swh.project;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;

class FileSenderH extends FileSender {
	public FileSenderH(Socket socket, String filestr) {
		super(socket, filestr);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		
		byte[] bytes;
		try {
			FileInputStream inputStream = new FileInputStream(this.filepath);

			int d = -1;
			byte[] data= new byte[3000];
			byte[] da = new byte[1024];
			
			//서버로 내보내기 위한 출력 스트림 뚫음
			OutputStream os = socket.getOutputStream();
			FileData fileData = new FileData(this.filename);
			
			while((d=inputStream.read(da))!=-1){
				fileData.setData(d);
				fileData.setData2(da);
				bytes = toByteArray(fileData);
				
//				System.out.println(bytes.length);
				
				System.arraycopy(bytes, 0, data, 0, bytes.length); // byte 크기를 3000으로 맞춰줌
				
				//출력 스트림에 데이터 씀
				os.write(data);
				//보냄
				os.flush();
			}
			
			os.close();
			inputStream.close();
			System.out.println(" [x] Sent Success  ");
			
			Files.delete(Paths.get(filepath));
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}