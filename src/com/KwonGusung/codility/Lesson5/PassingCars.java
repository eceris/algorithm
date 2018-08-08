package com.KwonGusung.codility.Lesson5;

/**
 * https://app.codility.com/c/run/trainingX5VX8D-29X
 * @author create2879
 *
 */
public class PassingCars {
	
	// O(N)
	public static int solution(int[] A) {
		int count = 0;
		int multiple = 0;
		for(int i=0; i<A.length; i++) {
			if(A[i] == 0) {
				multiple++;
			} else {
				count = count + (multiple * 1);
				if(count > 1000000000) {
					return -1;
				}
			}
		}
		return count;
	}
	
	// O(N ** 2)
	public static int solution2(int[] A) {
		int count = 0;
		for(int i=0; i<A.length-1; i++) {
			for(int j=i+1; j<A.length; j++) {
				if(A[i] == 0) {
					if(A[j] == 1) {
						if(++count > 1000000000) {
							return -1;
						}
					}
				} else {
					break;
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		int[] A = {0,1,0,1,1};
		System.out.println(solution(A));
	}
}
