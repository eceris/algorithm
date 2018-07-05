package com.KwonGusung.etc;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = {1,3,2,4,3};
		bubbleSort(arr);
		Arrays.stream(arr).forEach(v -> System.out.println(v));
	}
	
	static void bubbleSort(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			for(int j=1; j<arr.length-i; j++) {
				if(arr[j-1] > arr[j]) {
					int temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
}
