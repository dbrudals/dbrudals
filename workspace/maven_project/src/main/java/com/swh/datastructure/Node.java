package com.swh.datastructure;

/**
 * <pre>
 * kr.co.swh.lecture.datastructure
 * Node.java
 *
 * 설명 : 링크드리스트의 노드
 * </pre>
 * 
 * @since : 2017. 6. 29.
 * @author : tobby48
 * @version : v1.0
 */
public class Node {
	public int data; // 변수 생성
	public Node next; // 변수 생성
	public Node(int data) {
		this.data = data; // 값 설정
	}

	public void print() {
		System.out.print("{" + data + "}");  // 값 출력
	}
}