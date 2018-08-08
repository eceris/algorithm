package com.KwonGusung.codility.Lesson3;

import java.util.Arrays;

/**
 * https://app.codility.com/c/run/trainingJKSJ3G-U6Y
 * @author create2879
 *
 */
public class PermMissingElem {

	public static int solution(int[] A) {
		Arrays.sort(A);
		
		int checkNum = 1;
		for(int value : A) {
			if(checkNum != value) {
				break;
			} else {
				checkNum++;
			}
		}
		return checkNum;
	}
	
	public static void main(String[] args) {
		int[] A = {2,3,1,5};
		System.out.println(solution(A));
	}
}
