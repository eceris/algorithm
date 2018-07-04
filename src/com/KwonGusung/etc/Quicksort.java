package com.KwonGusung.etc;

import java.util.Arrays;

public class Quicksort {
	
	/**
	 * 쿽소트
	 * 기본 개념 작은것은 왼쪽 큰거는 오른쪽 
	 * 한번 정렬 된것에서 왼쪽, 오른쪽을 다시 쿽 소트 진행
	 * 
	 * => partiion 후 =>  좌 퀵소트, 우 퀵 소트
	 * @param arr
	 * @param left
	 * @param right
	 */
	static void quickSort(int[] arr, int left, int right) {
		if(left <= right) {
			int q = partition(arr, left, right);
			quickSort(arr, left, q - 1);
			quickSort(arr, q +1, right);
		}
	}
	
	static int partition(int[] arr, int left, int right) {
		int pivot = arr[left];
		int i = left + 1;
		int j = right;
		
		while(i<j) {
			// pivot 보다 큰것이 나올때 까지 index 구함
			while(i <= right && arr[i] <= pivot) {
				i++;
			}
			// pivot 보다 작은것이 나올때 까지 index 구함
			while((left + 1) <= j && arr[j] >= pivot) {
				j--;
			}
			
			// 왼쪽탐색중 pivot 보다 큰것과 오른쪽 탐색중 pivot 보다 작은것을 서로 교체
			if(i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;				
			}
		}
		
		int temp = arr[left];
		arr[left] = arr[j];
		arr[j] = temp;
		return j;
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 4, 3, 2, 5, 10, 2};
		quickSort(arr, 0, arr.length - 1);
		System.out.println(arr);
		Arrays.stream(arr).forEach(v -> System.out.println(v));
	}
}
