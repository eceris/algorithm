package com.KwonGusung.codility.Lesson4;

public class FrogRiverOne {

	// O(N)
	public static int solution(int X, int[] A) {
		// road 배열 각 값은 최초 시간(초) 가 들어감.
		int[] road = new int[X];
		
		// 초기화
		for(int i=0; i<road.length; i++) {
			road[i] = -1;
		}
		
		// A 배열이 돌면서 road 배열 에 최초 시간(초) 를 입력
		for(int i=0; i<A.length; i++) {
			if(road[A[i] - 1] < 0) {
				road[A[i] - 1] = i;				
			}
		}
		
		// 최종 만들어진 road 배열이 만들어진 최종 시간 검색
		int maxSec = road[0];
		for(int i=0; i<road.length; i++) {
			if(road[i] == -1) {
				return -1;
			}
			if(road[i] > maxSec) {
				maxSec = road[i];
			}
		}
		return maxSec;
	}
	
	// O(N ** 2)
	public static int solution1(int X, int[] A) {
		boolean[] road = new boolean[X];
		
		boolean isFindLast = false;
		for(int i=0; i<A.length; i++) {
			road[A[i] - 1] = true;
			if(A[i] >= X) {
				isFindLast = true;
			}
			if(isFindLast && isMakeRoad(road)) {
				return i;
			}
		}
		return -1;
	}
	
	// O(N ** 2)
	public static int solution2(int X, int[] A) {
		boolean[] road = new boolean[X];
		
		for(int i=0; i<A.length; i++) {
			road[A[i] - 1] = true;
			if(isMakeRoad(road)) {
				return i;
			}
		}
		return -1;
	}
	
	public static boolean isMakeRoad(boolean[] road) {
		for(boolean r : road) {
			if(!r) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		//int[] A = {1,3,1,4,2,3,5,4};
		// int X = 5;
		int[] A = {1, 3, 1, 3, 2, 1, 3};
		int X = 3;
		System.out.println(solution(X, A));
	}
}
