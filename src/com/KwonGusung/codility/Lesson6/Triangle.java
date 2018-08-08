package com.KwonGusung.codility.Lesson6;

import java.util.Arrays;

/**
 * https://app.codility.com/programmers/lessons/6-sorting/triangle/
 * @author create2879
 *
 */
public class Triangle {

	public static int solution(int[] A) {
		Arrays.sort(A);
		
		// 정렬후 3개씩 검색 > 3개중 가장 큰값이 나머지 두 합보다 크면 성공
		for(int i=0; i<A.length-2; i++) {
			int v1 = A[i];
			int v2 = A[i+1];
			int v3 = A[i+2];
			if(v1 + v2 > v3) {
				return 1;
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		int[] A = {10, 2, 5, 1, 8, 20};
		//int[] A = {10, 50, 5, 1};
		System.out.println(solution(A));
	}
}
