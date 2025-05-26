package com.yedam.collection;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * LIFO - Stack구조
 * FIFO - Que구조
 */
public class StackQueExe {
	public static void main(String[] args) {
		
		Queue<String> orders = new LinkedList<String>();
		orders.offer("카페라떼");
		orders.offer("아메리카노");
		orders.offer("녹차");
		
		while(!orders.isEmpty()) {
			System.out.println(orders.poll());
		}
		
		System.out.println();
		
		Stack<String> books = new Stack<String>();
		books.push("이것이 자바다");
		books.push("HTML,CSS");
		books.push("자바스크립트기초"); //제일 마지막에넣은놈.
		
		while(!books.isEmpty()) {
			System.out.println(books.pop());
		}
	}
	
}//end StackQueExe
