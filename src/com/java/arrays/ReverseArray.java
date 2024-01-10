package com.java.arrays;


public class ReverseArray {

	public static void main(String[] args) {
		
		int[] intArray = new int[] {1,2,3,4,5,6};
		
		for (int i = intArray.length-1; i >=0; i--) {
			System.out.println(intArray[i]);
		}
	}
}
