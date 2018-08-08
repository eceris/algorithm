package com.KwonGusung.codility.Lesson4;

import java.util.Arrays;

/**
 * https://app.codility.com/c/run/trainingMVAFJ4-3QA
 * @author create2879
 *
 */
public class PermCheck {

	public static int solution(int[] A) {
		Arrays.sort(A);
		
		boolean isPerm = true;
		int v = 1;
		for(int value : A) {
			if(value == v) {
				v++;
			} else {
				isPerm = false;
				break;
			}
		}
		return isPerm ? 1 : 0;
	}
	
	public static void main(String[] args) {
		int[] A = {4,1,3};
		
		System.out.println(solution(A));
	}
}
