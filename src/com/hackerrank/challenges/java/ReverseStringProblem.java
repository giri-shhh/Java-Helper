package com.hackerrank.challenges.java;

public class ReverseStringProblem {

	public static void main(String[] args) {
		String s ="madamji";
		String s1 = "";
		char[] charArray = s.toCharArray();
		char[] newArray = new char[charArray.length];
 		for(int i=charArray.length-1, j=0; i>=0; i--, j++) {
 			newArray[j] = charArray[i];
		}
 		System.out.println(new String(newArray));
		
	}
}
