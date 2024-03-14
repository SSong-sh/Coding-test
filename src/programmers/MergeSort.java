package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class MergeSort {

	private static int mid = 0;
	private static String[] copyArr;
	private static String[] numArr;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder builder = new StringBuilder();
		
		int N = Integer.parseInt(reader.readLine());
		numArr = new String[N];
		copyArr = new String[N];
		
		for(int i = 0; i < N; i++) {
			numArr[i] = reader.readLine();
		}
		
		mergeSort(0, numArr.length-1);
		
		
//		for(String a : numArr) {
//			builder.append(a).append("\n");
//		}
		
		System.out.println(numArr[0]);

	}



	private static void mergeSort(int left , int right) {
		if(left<right) {
			int mid = left+(right-left)/2;
			mergeSort(left, mid);  // 1 4 7 대기 
			mergeSort(mid+1 , right);
			merge(left, mid, right);
		}
	}
	

	private static void merge(int left, int mid, int right) {
		int i = left;
		int j = mid + 1;
		int k = left;

		while (i <= mid && j <= right) {

			if (Integer.parseInt(numArr[i] + numArr[j]) >= Integer.parseInt(numArr[j] + numArr[i])) {
				copyArr[k] = numArr[i] + numArr[j];
				k++;
				i++;
			} else {
				copyArr[k] = numArr[j] + numArr[i];
				k++;
				j++;

			}
			

		}

		while (j <= right) {
			copyArr[k++] = numArr[j++];
		}

		while (i <= mid) {
			copyArr[k++] = numArr[i++];
		}


		for (int a = left; a <= right; a++) {
			numArr[a] = copyArr[a];
		}
	}

}
