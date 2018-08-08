package com.KwonGusung.codility.Lesson1;

/**
 * https://app.codility.com/c/run/trainingPBG2E7-6J3
 * @author create2879
 *
 */
public class BinaryGap {

	public static int solution(int N) {
        // write your code in Java SE 8
        String binaryStr = Integer.toBinaryString(N);
        int zero = '0';
        int one = '1';
        
        int maxCount = 0;
        boolean head = false;
        
        int tempCount = 0;
        for(char c : binaryStr.toCharArray()) {
        	if(!head && c == one) {
        		head = true;
        	} else if(head && c == zero) {
        		tempCount++;
        	} else if(head && c == one) {
        		if(maxCount < tempCount) {
        			maxCount = tempCount;
        		}
        		tempCount = 0;
        	}
        }
        
        return maxCount;
        
    }
	
	public static void main(String[] args) {
		int result = solution(529);
		System.out.println(result);
	}
}
