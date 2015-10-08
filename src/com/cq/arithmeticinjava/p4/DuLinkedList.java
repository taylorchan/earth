package com.cq.arithmeticinjava.p4;
/**
 * double arrows LinkedList
 * @author taylor
 *
 * @param <T>
 */
public class DuLinkedList<T> {
	
	private class Node{
		T data;
		Node pre;
		Node next;
		public Node(T data,Node pre,Node next) {
			this.data = data;
			this.pre  = pre;
			this.next = next;
		}
		
		public String toString(){
			return data.toString();
		}
	}
	
	private Node head;
	
	private Node tail;
	
	private int size;
	
	public DuLinkedList() {
	}
	
	public DuLinkedList(T data){
		this.head = new Node(data, null, null);
		this.tail = head;
		size++;
	}
	/**
	 * get the ele in the pos
	 * @param index
	 * @return
	 */
	public Node getNodeByIndex(int index){
		if(index > size-1 || index< 0)
			throw new IllegalArgumentException();
		
		if(index <= size/2){
			Node cur = head;
			for(int i = 0;i<=index && cur != null;){
				i++;
				cur = cur.next;
				if(i == index)
					return cur;
			}
		}else{
			Node cur = tail;
			for(int i = size-1; i>=index && cur != null; ){
				i--;
				cur = cur.pre;
				if(i == index)
					return cur;
			}
		}
		return null;
		
	}
	
	/**
	 * add an ele after the tail
	 * @param data
	 */
	public void add(T data){
		Node newNode = null;
		if(head  == null){
			newNode = new Node(data, null, null);
			head = newNode;
		}else{
			newNode = new Node(data, tail, null);
			tail.next = newNode;
		}
		tail = newNode;
		size++;
	}
	
	/**
	 * add an ele at index
	 * @param index
	 */
	public void addAtHead(T data){
		Node newNode = null;
		if(head  == null){
			newNode = new Node(data, null, null);
			tail = newNode;
		}else{
			newNode = new Node(data, null, head);
			head.pre = newNode;
		}
		head = newNode;
		size++;
	}
	
	/**
	 * insert an ele in the index pos
	 * @param index
	 * @param data
	 */
	public void insert(int index,T data){
		if(index > size || index < 0)
			throw new IllegalArgumentException();
		
		if(head == null)
			add(data);
		
		else if(index == 0)
			addAtHead(data);
		else{
			Node preNode = getNodeByIndex(index-1);
			Node nextNode = preNode.next;
			Node newNode = new Node(data, preNode, nextNode);
			preNode.next = newNode;
			if(nextNode != null)
				nextNode.pre = newNode; 
			size++;
		}
	}
	
	/**
	 * remove a ele in the pos
	 * @return
	 */
	public T remove(int index){
		if(index < 0 || index > size -1)
			throw new IllegalArgumentException();
		Node del = null;
		if(index == 0){//remove the head ele
			del = head;
			head = head.next;
			head.pre = null;
			if(tail ==del)//only one ele
				tail = null;
		}else{
			del = getNodeByIndex(index);
			Node delPre = del.pre;
			Node delNext = del.next;
			delPre.next = delNext;
			if(delNext != null)
				delNext.pre = delPre;
			else//the del ele is the last ele
				tail = delPre;
		}
		size --;
		return del.data;
	}
	
	public void clear(){
		head = tail = null;
		size = 0;
	}
	
	public String toString(){
		if(getLength() == 0)
			return "";
		else{
			Node cur = head;
			StringBuilder sb = new StringBuilder(32);
			while(cur != null){
				sb.append(" "+cur.toString()+" ").append("<-->");
				cur = cur.next;
			}
			return sb.toString();
		}
	}
	
	public int getLength(){
		return size;
	}
	public static void main(String[] args) {
		DuLinkedList<String> dls = new DuLinkedList<String>();
		dls.add("a");
		dls.addAtHead("b");
		dls.insert(2, "c");
		System.out.println(dls);
	}
}
