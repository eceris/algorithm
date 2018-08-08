package com.KwonGusung.codility.Lesson6;

import java.util.HashSet;
import java.util.Set;

/**
 * https://app.codility.com/programmers/lessons/6-sorting/distinct/
 * @author create2879
 *
 */
public class Distinct {

	public static int solution(int[] A) {
		Set<Integer> set = new HashSet<>();
		for(int value : A) {
			set.add(value);
		}
		return set.size();
	}
	
	public static void main(String[] args) {
		int[] A = {2,1,1,2,3,1};
		System.out.println(solution(A));
	}
}
