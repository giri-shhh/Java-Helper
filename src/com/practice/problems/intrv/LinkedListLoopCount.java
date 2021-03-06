package com.practice.problems.intrv;

/*
Program: Find length of a loop in a LinkedList.

Problem Description:
Write a simple code to identify given LinkedList has a loop and if loop is present then calculate the lenght of a loop. Length of a loop is count of nodes with in the loop. If loop is not present then it should return 0.

The loop count is 5 in the below image.

The below diagram illustrates linked list loop/cycle:
In our last example, we have used Floyd�s Cycle detection algorithm to terminate when fast and slow pointers meet at a common point. The common point is one of the loop node. Here is our approach:

We store the reference of the common point in a temporary variable.
Initialize a counter with 1.
Start iterating to next node from the common point and increment the counter till we again reach the common point.
At that point, the counter value will be equal to the length of the loop.
*/

public class LinkedListLoopCount {

	static class Node {
		int data;
		Node next;

		Node(int tmp) {
			data = tmp;
		}
	}

	public static void main(String[] a) {

		Node n1 = new Node(34);
		Node n2 = new Node(25);
		Node n3 = new Node(31);
		Node n4 = new Node(56);
		Node n5 = new Node(45);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n3;

		System.out.println("Loop count: " + identifyLoopCount(n1));
	}

	static int identifyLoopCount(Node head) {

		Node slowMv = head;
		Node fastMv = head;
		while (slowMv != null && fastMv != null && fastMv.next != null) {
			slowMv = slowMv.next;
			fastMv = fastMv.next.next;
			if (slowMv == fastMv) {
				return loopCount(slowMv);
			}
		}
		return 0;
	}

	static int loopCount(Node node) {

		int count = 1;
		Node tmp = node;
		while (tmp.next != node) {
			count++;
			tmp = tmp.next;
		}
		return count;
	}
}