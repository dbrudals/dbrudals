package com.swh.fileIO;

import java.io.FileWriter;
import java.io.IOException;
public class FileCharacterStreamWrite {
    public static void main(String[] args) throws IOException {
        FileWriter output = new FileWriter("C:/Users/ykm09/Desktop/text2.txt");
        for(int i=1; i<=10; i++) {
            String data = i + " 번째 줄입니다.\r\n";      //  윈도우에서 메모장에 줄바꿈이 일어나기 위해 \r 표기
            output.write(data);     //  문자 단위로 데이터를 쓰기 위해
        }
        output.close();
    }

}