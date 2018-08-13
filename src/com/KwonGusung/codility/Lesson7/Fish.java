package com.KwonGusung.codility.Lesson7;

import java.util.Stack;

public class Fish {

	// 0: up, 1: down index 작으면 상류
	public static int solution(int[] A, int[] B) {
		
		Stack<Integer> stack = new Stack<>();
		
		int fishCount = A.length;
		for(int i=0; i<A.length; i++) {
			// 하류로 이동하는 것만. 상류로 이동하는것은 체크할 필요가 없음
			if(B[i] == 1) {
				stack.push(A[i]);
			} else {
				while(!stack.isEmpty()) {
					int tempFish = stack.peek();
					if(tempFish > A[i]) {
						fishCount--;
						break;
					} else if(tempFish < A[i]) {
						stack.pop();
						fishCount--;
					}
				}
			}
		}
		return fishCount;
	}
	
	public static void main(String[] args) {
		//int[] A = {4,3,2,1,5};
		//int[] B = {0,1,0,0,0};
		int[] A = {4,3,2,1,5};
		int[] B = {0,1,1,0,0};
		
		
		System.out.println(solution(A, B));
	}
}
