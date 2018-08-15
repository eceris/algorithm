package com.KwonGusung.codility.Lesson8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * https://app.codility.com/programmers/lessons/8-leader/dominator/
 * @author create2879
 *
 */
public class Dominator {
	
	// O(N*log(N)) or O(N)
	public static int solution(int[] A) {
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i=0; i<A.length; i++) {
			Integer mValue = map.get(A[i]);
			if(mValue == null) {
				map.put(A[i], 1);
			} else {
				map.put(A[i], ++mValue);				
			}
			
			if(map.get(A[i]) > (A.length / 2)) {
				return i;
			}
		}
		
		return -1;
	}

	// O(N*log(N)) or O(N) or O(N**2)
	public static int solution2(int[] A) {
		Entry<Integer, Long> dominator = Arrays.stream(A).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet().stream().sorted(new Comparator<Entry<Integer, Long>>() {
					@Override
					public int compare(Entry<Integer, Long> o1, Entry<Integer, Long> o2) {
						return o2.getValue().compareTo(o1.getValue());
					}
				}).findFirst().orElse(null);
		if(dominator != null && dominator.getValue() > (A.length / 2)) {
			for(int i=0; i<A.length; i++) {
				if(A[i] == dominator.getKey()) {
					return i;
				}
			}			
		}
		return -1;
		
	}
	
	public static void main(String[] args) {
		int[] A = {3,4,3,2,3,-1,3,3};
		//int[] A = {};
		System.out.println(solution(A));
	}
}
