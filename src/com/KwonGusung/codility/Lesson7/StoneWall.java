package com.KwonGusung.codility.Lesson7;

import java.util.Stack;

/**
 * https://app.codility.com/programmers/lessons/7-stacks_and_queues/stone_wall/
 * @author create2879
 *
 */
public class StoneWall {

	public static int solution(int[] H) {
		Stack<Integer> stack = new Stack<>();
		
		int count = 0;
		for(int value : H) {
			if(stack.isEmpty()) {
				stack.push(value);
				continue;
			}
			if(stack.peek() > value) {
				while(!stack.isEmpty() && stack.peek() > value) {
					count++;
					stack.pop();
				}
				if(!stack.isEmpty() && stack.peek() != value) {
					stack.push(value);					
				} else if(stack.isEmpty()) {
					stack.push(value);
				}
			} else if(stack.peek() < value) {
				stack.push(value);
			}
			
		}
		return count + stack.size();
	}
	
	public static void main(String[] args) {
		int[] H = {8,8,5,7,9,8,7,4,8};
		System.out.println(solution(H));
	}
}
