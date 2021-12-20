package com.swh.datastructure;

import java.util.ArrayList;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

/**
 * <pre>
 * kr.co.swh.lecture.datastructure
 * LinkedListMain.java
 *
 * 	링크드리스트 메인
 * </pre>
 * 
 * @since : 2017. 6. 29.
 * @author : tobby48
 * @version : v1.0
 */
public class LinkedListMain {
	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList(); // 객체 생성
		linkedList.addLast(1); // 리스트 맨 마지막에 값 추가
		linkedList.addLast(2);
		linkedList.addLast(3);
		linkedList.addLast(4);
		linkedList.addLast(5);
		linkedList.add(2, 8); // 위치, 값 순서로 원하는 위치에 값을 추가
		linkedList.delete(4); // 그 위치에 값을 삭제
		linkedList.addFirst(0); // 값을 맨 앞에 추가 
		while(!linkedList.isEmpty()) { // 리스트가 비어있지 않다면
			Node delLink = linkedList.deleteFirst(); // 맨 앞에 있는 요소 삭제
			delLink.print(); // 리스트 프린트
			System.out.println(); // 빈줄
		}
	}
}