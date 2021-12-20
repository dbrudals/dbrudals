package com.swh.ykm;

public class UserManagement {
    private User[] list;
    
    public void init(){
        list = new User[10];
    }
//    public void add(User u){
//        list[0] = u; 
//    }
    public void insert(int index, User u){
        list[index] = u; 
    }
    public void add(String name, int age, String id){
        User u = new User(name, age, id);
        u.setAge(age);
        list[list.length] = u;
    }
    public User modify(int index, User u){
        list[index] = u;
        return list[0];
    }
    public void view(){
        User u = list[0];
        System.out.println("이름: " + u.getName());
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //  무한반복
        //  메뉴 1. 사용자 정보
        //      1.1. 사용자 추가
        //      1.2. 사용자 삭제
        //      1.3. 사용자 정보
    	//		↑ 과제
        
        UserManagement mnt = new UserManagement();
        mnt.init();
        mnt.add("코야", 8, "123");
        
        User k = new User("유키", 4,"456");
        mnt.modify(0, k);
    }
}