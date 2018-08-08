package com.KwonGusung.codility.Lesson3;

/**
 * https://app.codility.com/c/run/trainingSUQTRJ-EEU
 * @author create2879
 *
 */
public class FrogJmp {

	public static int solution(int X, int Y, int D) {
		int distance = Y - X;
		
		int jumpCnt = distance / D;
		if(distance % D != 0) {
			jumpCnt++;
		}
		return jumpCnt;
	}
	
	public static void main(String[] args) {
		System.out.println(solution(10, 85, 30));
	}
	
}
