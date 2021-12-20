package com.swh.fileIO;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class FileCharacterStreamWrite2 {
    public static void main(String[] args) throws IOException {
        PrintWriter output1 = new PrintWriter("C:/Users/ykm09/Desktop/text2.txt");
        for(int i=1; i<=10; i++) {
            String data = i + " 번째 줄입니다.";      
            output1.println(data);      //  문자 단위로 데이터를 개행 처리로 출력
        }
        output1.close();

        //  파일 이어서 추가
        FileWriter output2 = new FileWriter("C:/Users/ykm09/Desktop/text2.txt", true);
        for(int i=11; i<=15; i++) {
            String data = i+" 번째 줄입니다.\r\n";
            output2.write(data);
        }
        output2.close();
    }
}