package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sort02 {
	private static int[] newArr;
	private static int[] copyArr;

	// 수 정렬하기 02
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();

		int N = Integer.parseInt(reader.readLine());

		newArr = new int[N];
		copyArr = new int[N];
		
		for(int i = 0; i < N; i++) {
			newArr[i] = Integer.parseInt(reader.readLine());
		}

		mergeSort(0, newArr.length - 1);
		
		
		for(int a : newArr) {
			builder.append(a).append("\n");
		}
		
		System.out.println(builder);
	}

	private static void mergeSort(int left, int right) {
		if (left < right) {
			int mid = left + (right - left) / 2;
			mergeSort(left, mid);
			mergeSort(mid + 1, right);
			merge(left, mid, right);
		}
	}

	private static void merge(int left, int mid, int right) {

		int i = left;
		int j = mid + 1;
		int k = left;

		while (i <= mid && j <= right) {

			if (newArr[i] <= newArr[j]) {
				copyArr[k++] = newArr[i++];
			} else if (newArr[i] > newArr[j]) {
				copyArr[k++] = newArr[j++];
			}

		}

		//이미 한쪽이 끝남
		if (i > mid) {
			while (j <= right) { //오른쪽을 다 담아줌
				copyArr[k++] = newArr[j++];
			}
		} else {
			while (i <=mid) { //왼쪽을 다 담아줌
			copyArr[k++] = newArr[i++];
			}
		}

		for (int a = left; a <= right; a++) {
			newArr[a] = copyArr[a];
		}
	}
	


}
