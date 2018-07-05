package com.KwonGusung.etc;

import java.util.Arrays;

/**
 * merge sort - 최소 nlogn 보장. https://xmfpes.github.io/algorithm-study/daily-algorithm-09/
 * @author create2879
 *
 */
public class MergeSort {

	static void mergeSort(int[] arr, int left, int right) {
		if(left < right) {
			int middle = (left + right) / 2;
			mergeSort(arr, left, middle);
			mergeSort(arr, middle + 1, right);
			merge(arr, left, middle, right);
		}
	}
	
	static void merge(int[] arr, int left, int middle, int right) {
		int i = left;
		int j = middle+1;
		int k = left;
		int[] temp = new int[arr.length];
		while(i<=middle && j<=right) {
			if(arr[i] < arr[j]) {
				temp[k++] = arr[i++];
			}else {
				temp[k++] = arr[j++];
			}
		}
		while(i<=middle)
			temp[k++] = arr[i++];
		while(j<=right)
			temp[k++] = arr[j++];
		for(int index=left; index<k; index++)
			arr[index] = temp[index];
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 4, 3, 2, 5, 10, 2};
		mergeSort(arr, 0, arr.length - 1);
		System.out.println(arr);
		Arrays.stream(arr).forEach(v -> System.out.println(v));
	}
}
