package com.KwonGusung.etc;

import java.util.Arrays;

public class Quicksort {
	
	/**
	 * 쿽소트
	 * 기본 개념 작은것은 왼쪽 큰거는 오른쪽 
	 * 한번 정렬 된것에서 왼쪽, 오른쪽을 다시 쿽 소트 진행
	 * 
	 * @param arr
	 * @param left
	 * @param right
	 */
	static void quickSort(int[] arr, int left, int right) {		
		if(left < right) {
			
			int pivotIndex = (left + right) / 2;
			int pivotValue = arr[pivotIndex];
			
			int lIndex = left;
			int rIndex = right;
			while(lIndex <= rIndex) {
				
				// pivot 보다 큰것이 나올때 까지 index 구함
				while(arr[lIndex] < pivotValue) {
					lIndex++;
				}
				
				// pivot 보다 작은것이 나올때 까지 index 구함
				while(arr[rIndex] > pivotValue) {
					rIndex--;
				}
				
				// 왼쪽탐색중 pivot 보다 큰것과 오른쪽 탐색중 pivot 보다 작은것을 서로 교체
				if(lIndex <= rIndex) {
					swap(arr, lIndex, rIndex);	
					lIndex++;
					rIndex--;
				}
				
			}
			
			if(left < rIndex) {
				quickSort(arr, left, rIndex);				
			}
			if(lIndex < right) {
				quickSort(arr, lIndex, right);				
			}
		}
	}
	
	static void swap(int[] arr, int idx1, int idx2) {
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 4, 3, 2, 5, 10, 2};
		quickSort(arr, 0, arr.length - 1);
		System.out.println(arr);
		Arrays.stream(arr).forEach(v -> System.out.println(v));
	}
}
