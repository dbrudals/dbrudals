package com.swh.fileIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class FileCharacterStreamRead {
    public static void main(String[] args) throws IOException {
        //  파일 내용을 라인단위로 읽어오기 위해 버퍼에 라인별로 저장
        BufferedReader br = new BufferedReader(new FileReader("C:/Users/ykm09/Desktop/text2.txt"));
        while(true) {
            String line = br.readLine();
            if (line==null) break;      //  파일의 끝일 경우 null
            System.out.println(line);
        }
        br.close();
    }
}