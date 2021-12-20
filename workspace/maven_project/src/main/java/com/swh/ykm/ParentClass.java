package com.swh.ykm;

public class ParentClass {
    String url;
    String date;
    
    ParentClass(String date){
        url = "https://swhcoding.com";
        this.date = date;
    }
    void view() {
        System.out.println(url);
    }
}