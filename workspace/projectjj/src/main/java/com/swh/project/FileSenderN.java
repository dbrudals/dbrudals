package com.swh.project;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

class FileSenderN extends FileSender {

	public FileSenderN(Socket socket, String filestr) {
		super(socket, filestr);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {

		byte[] bytes = null;
		try {
			FileInputStream inputStream = new FileInputStream(this.filepath);

			int d = -1;
			byte[] da = new byte[1024];

			//서버로 내보내기 위한 출력 스트림 뚫음
			OutputStream os = socket.getOutputStream();
			
			// 제목
			ByteArrayOutputStream stream = new ByteArrayOutputStream(); //BYTES_BODY는 메세지의 전체 길이(bytes)이다.
			String fileNameLen = String.format("%04d", "S".getBytes().length + this.filename.getBytes().length); // left padding 0 (4자리)
			// 알아서 뒤로 값을 붙혀줌.
			stream.write(Arrays.copyOfRange(fileNameLen.getBytes(), 0, 4));
			stream.write(Arrays.copyOfRange("S".getBytes(), 0, "S".getBytes().length));
			stream.write(Arrays.copyOfRange(this.filename.getBytes(), 0, this.filename.getBytes().length));	

			bytes = stream.toByteArray();

			os.write(bytes);
			
			stream.flush();

			while((d=inputStream.read(da))!=-1){
				
				stream = new ByteArrayOutputStream();
				
				// data를 보냄
				fileNameLen = String.format("%04d", "D".getBytes().length + da.length); // left padding 0 (4자리)
				stream.write(Arrays.copyOfRange(fileNameLen.getBytes(), 0, fileNameLen.getBytes().length));
				stream.write(Arrays.copyOfRange("D".getBytes(), 0, "D".getBytes().length));
				stream.write(Arrays.copyOfRange(da, 0, da.length));
				
				bytes = stream.toByteArray();
				//				System.out.println(bytes.length);
				//출력 스트림에 데이터 씀
				os.write(bytes);
				//보냄
				os.flush();
				
				stream.flush();
				
				
			}
			
			// end를 보냄
			fileNameLen = String.format("%04d", "E".getBytes().length); // left padding 0 (4자리)
			stream.write(Arrays.copyOfRange(fileNameLen.getBytes(), 0, fileNameLen.getBytes().length));
			stream.write(Arrays.copyOfRange("E".getBytes(), 0, "E".getBytes().length));
			
			bytes = stream.toByteArray();
			
			os.write(bytes);
			os.flush();
			os.close();
			stream.close();
			inputStream.close();
			System.out.println(" [x] Sent Success  ");

			Files.delete(Paths.get(filepath));


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}