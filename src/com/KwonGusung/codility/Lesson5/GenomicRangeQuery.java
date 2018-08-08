package com.KwonGusung.codility.Lesson5;

/**
 * https://app.codility.com/c/run/trainingZT4XGE-QF9
 * @author create2879
 *
 */
public class GenomicRangeQuery {
	
	// O(N*M)
	public static int[] solution(String S, int[] P, int[] Q) {
		int[] returnArr = new int[P.length];
		for(int i=0; i<P.length; i++) {
			returnArr[i] = cal(S, P[i], Q[i]);
		}
		return returnArr;
	}
	
	public static int cal(String S, int p, int q) {
		String subS = S.substring(p, q + 1);
		char[] cs = subS.toCharArray();
		
		int minValue = 4;
		for(char c : cs) {
			int tempValue = 0;
			if(c == 'A') {
				return 1;
			} else if(c == 'C') {
				tempValue = 2;
			} else if(c == 'G') {
				tempValue = 3;
			} else if(c == 'T') {
				tempValue = 4;
			}
			if(tempValue < minValue) {
				minValue = tempValue;
			}
		}
		return minValue;
	}
	
	public static void main(String[] args) {
		String S = "CAGCCTA";
		int[] P = {2,5,0};
		int[] Q = {4,5,6};
		
		int[] result = solution(S, P, Q);
		
		for(int r : result) {
			System.out.println(r);
		}
	}
}
