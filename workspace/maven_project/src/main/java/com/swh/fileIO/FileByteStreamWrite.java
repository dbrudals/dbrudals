package com.swh.fileIO;

import java.io.FileOutputStream;
import java.io.IOException;
//import java.io.File;

public class FileByteStreamWrite {
    public static void main(String[] args) throws IOException {
//    	File f = new File("C:/Users/ykm09/Desktop/text.txt");
//    	FileOutputStream output = new FileOutputStream(f);
        FileOutputStream output = new FileOutputStream("C:/Users/ykm09/Desktop/text.txt");
        for(int i=1; i<=10; i++) {
            String d = i + " 번째 줄입니다.\r\n";  // 윈도우에서 메모장에 줄바꿈이 일어나기 위해 \r 표기
            output.write(d.getBytes());  // 바이트 단위로 데이터를 쓰기 위해
        }
        output.close();
    }
}