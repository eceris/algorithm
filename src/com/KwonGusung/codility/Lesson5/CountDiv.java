package com.KwonGusung.codility.Lesson5;

/**
 * https://app.codility.com/c/run/training7GXGY2-9K8
 * @author create2879
 *
 */
public class CountDiv {
	
	// O(1)
	public static int solution(int A, int B, int K) {
		int temp = A % K == 0 ? 1 : 0;
		int headCount = (A /  K) - temp;
		int tailCount = B / K;
		return tailCount - headCount;
	}
	
	// O(B-A)
	public static int solution2(int A, int B, int K) {
		int count = 0;
		for(int i=A; i<=B; i++) {
			if(i % K == 0) {
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		int A = 6;
		int B = 11;
		int K = 2;
		System.out.println(solution(A,B,K));
	}

}
