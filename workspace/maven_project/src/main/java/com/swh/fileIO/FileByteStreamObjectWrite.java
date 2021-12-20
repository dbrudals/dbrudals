package com.swh.fileIO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FileByteStreamObjectWrite {
    static class AA implements Serializable{
        int x;
        List<Integer> list;
        AA(int x, int y){
            this.x = x;
            list = new ArrayList<Integer>();
            for(int index = 0; index < y; index++){
                list.add(index);
            }
        }
        @Override
        public String toString() {
            // TODO Auto-generated method stub
            String str = "x:" + x + "\n";
            for(Integer i : list) str = str + i + ":" +  i + "\n"; 
            return str;
        }
    }

    public static void main(String[] args) throws IOException {
        //  객체 자체를 저장
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("C:/Users/ykm09/Desktop/text3.txt"));
        AA a = new AA(1, 5);
        output.writeObject(a);
        output.close();
    }

}