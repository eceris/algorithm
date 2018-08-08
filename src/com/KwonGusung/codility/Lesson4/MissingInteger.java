package com.KwonGusung.codility.Lesson4;

import java.util.Arrays;

/**
 * https://app.codility.com/c/run/trainingAK5K5W-SZV
 * @author create2879
 *
 */
public class MissingInteger {

	public static int solution(int[] A) {
		Arrays.sort(A);
		
		int checkValue = 1;
		for(int value : A) {
			if(value > 0) {
			}
			if(checkValue == value) {
				checkValue++;
			} else if(checkValue < value){
				return checkValue;
			}
		}
		return checkValue;
	}
	
	public static void main(String[] args) {
		//int[] A = {1, 3, 6, 4, 1, 2};
		//int[] A = {1, 2, 3};
		int[] A = {-1, -3};
		System.out.println(solution(A));
	}
}
