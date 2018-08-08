package com.KwonGusung.codility.Lesson4;

public class MaxCounters {

	// performance test failed...
	public static int[] solution(int N, int[] A) {
		int[] returnArr = new int[N];
		
		int maxValue = 0;
		for(int value : A) {
			if(value >= 1 && value <= N) {
				returnArr[value-1] += 1;
				if(returnArr[value-1] > maxValue) {
					maxValue = returnArr[value-1];
				}
			} else if(value == N + 1) {
				for(int i=0; i<returnArr.length; i++) {
					returnArr[i] = maxValue;
				}
			}
		}
		
		return returnArr;
	}
	
	public static void main(String[] args) {
		int N = 5;
		int[] A = {3, 4, 4, 6, 1, 4, 4};
		
		int[] result = solution(N, A);
		
		for(int r : result) {
			System.out.println(r);
		}
	}
}
