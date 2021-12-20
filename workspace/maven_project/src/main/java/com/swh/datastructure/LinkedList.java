package com.swh.datastructure;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * <pre>
 * kr.co.swh.lecture.datastructure
 * LinkedList.java
 *
 * 설명 :링크드 리스트
 * </pre>
 * 
 * @since : 2017. 6. 29.
 * @author : tobby48
 * @version : v1.0
 */
public class LinkedList {
	private Node head;

	public LinkedList(){
		head = null; 			// 처음 생성할때 값을 비워줌
	}
	
	public boolean isEmpty(){	// 리스트가 비어있는지 확인해줌
		return head == null;
	}
	
	// node에 계속 다음 노드를 index 까지 넣어주다 멈춤
	public Node get(int index) {
	    Node node = head; // node 를 맨 처음 노드 주소로 함
	    for (int i = 0; i < index; i++) // index번째 까지 돌아감
	        node = node.next;	// for문이 도는동안 계속 다음 노드로 바꿈
	    return node; // 리턴
	}

	public void addFirst(int value){
		Node link = new Node(value); // 새 노드 생성
		link.next = head;		//	새로 추가하는 노드의 next를 앞 노드로 지정
		head = link;			//	새로 추가하는 노드를 first로 지정
	}
	public void addLast(int value){
		Node link = new Node(value); // 새로운 노드 생성

		//	마지막까지 보내는 구문
		Node tmpLink = head;	// tmpLink에 맨 앞 노드 저장
		Node lastLink = null;
		while(tmpLink != null) {	// list에 값이 있다면
			lastLink = tmpLink;		// lastLink에 현재 노드를 저장
			tmpLink = tmpLink.next; // tmpLink가 다음 노드 저장
		}
		if(lastLink == null) head = link;	// list에 값이 없다면 맨 앞에 값 추가됨
		else lastLink.next = link;				//	새로 추가하는 노드를 first로 지정
	}
	
	/*
	 * 가장 마지막 값을 얻기 위해 lastLink 변수 사용
	 * lastLink의 다음 노드를 연결해줌
	 */
	
	public void add(int index, int value){
		// index가 0이면 첫번째 노드에 추가
		if(index == 0){
			addFirst(value);
		} else {
			Node previosNode = get(index-1);	//	추가할 인덱스 앞 요소(이전노드)
			Node nextNode = previosNode.next;	//	이전노드의 링크 노드는 새로운 노드의 링크가 되어야 함
			Node newNode = new Node(value);
			previosNode.next = newNode;		//	이전노드의 링크 노드는 새로운 노드
			newNode.next = nextNode;		//	새로운 노드의 링크는 이전노드가 가르켰던 노드
		}
	}
	public int size(){
		int count = 0;
		while(!isEmpty()) {
			deleteFirst();
			count++;
		}
		return count;
	}
	public Iterator<Integer> listIterator(){
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(!isEmpty()) {
			Node delLink = deleteFirst();
			list.add(delLink.data);
		}
		return list.iterator();
	}
	public Node deleteFirst(){
		Node link = head;	// 제일 앞의 first부터 값을 리턴
		if(head == null){	// 만약 비어있다면
			return null;	// 빈 값을 보낸다
		}
		head = head.next;	// head는 다음 값을 지정
		return link;
	}
	public Object delete(int index){
	    if(index == 0)
	        return deleteFirst();  // 
	    Node previosNode = get(index-1);				//	삭제할 인덱스 앞 요소(이전노드)
	    Node deleteNode = previosNode.next;				//	이전노드의 링크 노드는 삭제할 노드, 지금 삭제하면 노드를 연결할 수 없다. 
	    previosNode.next = deleteNode.next;				//	삭제할 노드의 링크노드가 이전노드의 링크노드가 되어야 삭제할 노드와의 연결이 끊어진다.
	    Object returnValue = deleteNode.data; 			//	삭제할 노드의 값을 리턴하기 위해 저장
	    return returnValue;
	}
	public void print() {
		Node link = head;
		while(link != null) {
			link.print();
			link = link.next;
		}
		System.out.println();
	}
}
