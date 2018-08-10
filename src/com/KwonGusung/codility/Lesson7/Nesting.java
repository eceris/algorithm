package com.KwonGusung.codility.Lesson7;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Nesting {
	
	// O(N)
	public static int solution(String S) {
		int parenthesisCnt = 0;
		for(char c : S.toCharArray()) {
			if(c == '(') {
				parenthesisCnt++;
			} else if(c == ')') {
				parenthesisCnt--;
			}
			if(parenthesisCnt < 0) {
				return 0;
			}
		}
		return parenthesisCnt == 0 ? 1 : 0;
	}

	// O(3**N) 쓸데 없는 반복문을 만들지 말자...
	public static int solution2(String S) {
		List<Character> cList = S.chars().mapToObj(i -> (char) i).collect(Collectors.toList());
		Queue<Character> q = new LinkedList<>(cList);
		
		int parenthesisCnt = 0;
		while(!q.isEmpty()) {
			char c = q.poll();
			if(c == '(') {
				parenthesisCnt++;
			} else if(c == ')') {
				parenthesisCnt--;
			}
			if(parenthesisCnt < 0) {
				return 0;
			}
		}
		return parenthesisCnt == 0 ? 1 : 0;
	}
	
	public static void main(String[] args) {
		String S = "(()(())())";
		//String S = ")(";
		System.out.println(solution(S));
	}
}
