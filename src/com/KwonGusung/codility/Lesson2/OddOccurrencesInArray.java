package com.KwonGusung.codility.Lesson2;

import java.util.Arrays;

public class OddOccurrencesInArray {

	public static int solution(int[] A) {
		Arrays.sort(A);
		
		int prevValue = A[0];
		int sameCount = 0;
		int returnValue = A[A.length-1];
		for(int value : A) {
			if(prevValue == value) {
				sameCount++;
			} else {
				if(sameCount % 2 != 0) {
					returnValue = prevValue;
					break;
				} else {
					sameCount = 1;
				}
			}
			prevValue = value;
		}
		return returnValue;
		
	}
	
	public static void main(String[] args) {
		int[] a = {2, 2, 3, 3, 4};
		solution(a);
	}
}
