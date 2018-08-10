package com.KwonGusung.codility.Lesson7;

import java.util.Stack;

/**
 * https://app.codility.com/programmers/lessons/7-stacks_and_queues/brackets/
 * @author create2879
 *
 */
public class Brackets {
	
	public static int solution(String S) {
		Stack<Character> stack = new Stack<>();
		
		for(char c : S.toCharArray()) {
			if(c == '[' || c == '{' || c == '(') {
				stack.push(c);				
			} else if(c == ']') {
				if(stack.isEmpty() || (!stack.isEmpty() && stack.pop() != '[')) {
					return 0;
				}
			} else if(c == '}') {
				if(stack.isEmpty() || (!stack.isEmpty() && stack.pop() != '{')) {
					return 0;
				}
			} else if(c == ')') {
				if(stack.isEmpty() || (!stack.isEmpty() && stack.pop() != '(')) {
					return 0;
				}
			}
		}
		
		return stack.isEmpty() ? 1 : 0;
	}
	
	public static void main(String[] args) {
		String S = "{[()()]}";
		//String S = ")(";
		//String S = "([)()]";
		//String S = "[]]";
		System.out.println(solution(S));
	}

}
