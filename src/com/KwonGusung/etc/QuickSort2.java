package com.KwonGusung.etc;

import java.util.Arrays;

/**
 * https://ko.wikipedia.org/wiki/%ED%80%B5_%EC%A0%95%EB%A0%AC
 * @author create2879
 * 
 * 내부 분할 알고리즘을 사용하여 처리함.
 *
 */
public class QuickSort2 {

	static int partition(int[] arr, int left, int right, int pivotIndex) {
		int pivotValue = arr[pivotIndex];
		
		// 피벗을 끝으로 옮김
		swap(arr, pivotIndex, right);
		int storeIndex = left;
		for(int i = left; i < right; i++) {
			if(arr[i] <= pivotValue) {
				swap(arr, storeIndex, i);
				storeIndex++;
			}
		}
		
		// 피벗을 두 리스트 사이에 위치
		swap(arr, right, storeIndex);
		return storeIndex;
	}
	
	static void quickSort(int[] arr, int left, int right) {
		if(right > left) {
			int pivotIndex = (left + right) / 2;
			int pivotNewIndex = partition(arr, left, right, pivotIndex);
			quickSort(arr, left, pivotNewIndex-1);
			quickSort(arr, pivotNewIndex+1, right);
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
