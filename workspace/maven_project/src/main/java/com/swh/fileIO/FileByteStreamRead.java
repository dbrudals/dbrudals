package com.swh.fileIO;

import java.io.FileInputStream;
import java.io.IOException;
public class FileByteStreamRead {
    public static void main(String[] args) throws IOException {
        FileInputStream input = new FileInputStream("C:/Users/ykm09/Desktop/text.txt");
        byte[] data = new byte[1024];  // 파일 내용의 길이가 1024바이트보다 크면 좋지 못한 방법
        input.read(data);
        System.out.println(new String(data));
        input.close();
    }
}