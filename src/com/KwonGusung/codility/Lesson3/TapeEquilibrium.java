package com.KwonGusung.codility.Lesson3;

/**
 * https://app.codility.com/c/run/training6BXQQN-G3X
 * @author create2879
 *
 */
public class TapeEquilibrium {

	// O(N)
	public static int solution(int[] A) {
		int leftSum = A[0];
		int rightSum = 0;
		for(int i = 1; i<A.length; i++) {
			rightSum += A[i];
		}
		int minimalDiff = Math.abs(leftSum - rightSum);
		for(int i = 1; i<A.length-1; i++) {
			leftSum += A[i];
			rightSum -= A[i];
			
			int diff = Math.abs(leftSum - rightSum);
			if(diff < minimalDiff) {
				minimalDiff = diff;
			}
		}
		return minimalDiff;
	}
	
	// O(N)
	public static int solution2(int[] A) {
		int totalSum = 0;
		for(int value : A) {
			totalSum += value;
		}
		
		int leftSum = 0;
		int rightSum = totalSum;
		int minimalDiff = Math.abs(leftSum - rightSum);
		for(int value : A) {
			leftSum += value;
			rightSum -= value;
			
			int diff = Math.abs(leftSum - rightSum);
			if(diff < minimalDiff) {
				minimalDiff = diff;
			}
		}
		return minimalDiff;
	}
	
	// N*N 번
	public static int solution1(int[] A) {
		int p = 1;
		int minimalDiff = diffCalculate(A, p);
		p++;
		
		while(p < A.length) {
			
			int diff = diffCalculate(A, p);
			if(diff < minimalDiff) {
				minimalDiff = diff;
			}
			p++;
		}
		return minimalDiff;
	}
	
	public static int diffCalculate(int[] A, int p) {
		int leftSum = 0;
		int rightSum = 0;
		
		for(int j=0; j<p; j++) {
			leftSum += A[j];
		}
		for(int j=p; j<A.length; j++) {
			rightSum += A[j];
		}
		return Math.abs(leftSum - rightSum);
	}
	
	public static void main(String[] args) {
		int[] A = {-1000, 1000};
		//int[] A = {5, 6, 2, 4, 1};
		//int[] A = {3, 1, 2, 4, 3};
		System.out.println(solution(A));
	}
}
