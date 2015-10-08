package com.cq.arithmeticinjava.p4;

public class LinkedList <T>{
	
	private class Node<T>{
		 T data;
		 Node<T> next;
		public Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}
	}
	
	private Node<T> head;
	
	private Node<T>tail;
	
	private int size = 0;
	
	public LinkedList() {
	}
	
	public LinkedList(T data){
		Node<T> node = new Node<T>(data, null);
		head = node;
		tail = head;
		size++;
	}
	
	/**
	 * get the element in the pointed pos
	 * @param index
	 * @return
	 */
	public Node<T> getNodeByIndex(int index){
		if(index <0 || index > size)
			throw new IllegalArgumentException();
		int i = 0;
		Node<T> cur = head;
		while(i++ < size){
			cur = cur.next;
			if(i == index && cur != null)
				return cur;
		}
		return null;
	}
	
	/**
	 * add ele at head
	 * @param data
	 * @return
	 */
	public Node<T> addAtHead(T data){
		head = new Node<T>(data,head);
		if(tail == null)
			tail = head;
		size++;
		return head;
	}

}
