package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeSort {
	
	static int[] numArr;
	static int[] copyArr;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		
		int N = Integer.parseInt(reader.readLine());
		numArr = new int[N];
		copyArr = new int[N];
		
		for(int i = 0; i < N; i++) {
			numArr[i] = Integer.parseInt(reader.readLine());
		}
		
		mergeSort(0, numArr.length-1);
		
		
		for(int a : numArr) {
			builder.append(a).append("\n");
		}
		
		System.out.println(builder);

	}//main

	private static void mergeSort(int left , int right) {
		if(left<right) {
			int mid = left+(right-left)/2;
			mergeSort(left, mid);  // 1 4 7 대기 
			mergeSort(mid+1 , right);
			merge(left, mid, right);
		}
	}
	
								// 1         1         2
	private static void merge(int left, int mid, int right) {
		
		int i = left;    // 1
		int j = mid + 1; // 2
		int k = left;    // 1    // 인덱스
		
		while(i<=mid && j<=right) {
			
			if(numArr[i]<=numArr[j]) {
				copyArr[k++] = numArr[i++]; 
			} else if(numArr[i]>numArr[j]) {
				copyArr[k++] = numArr[j++];
				
			}
			
			
		}
		
		//if(i>mid) {
			
			while(j<=right) {
				copyArr[k++] = numArr[j++];
			}
		//} else if(j>right) {
			
			while(i<=mid) {
				copyArr[k++] = numArr[i++];
			}
			
		//}
		
		for(int a = left; a<=right; a++) {
			numArr[a] = copyArr[a];
		}
		
		
		
	}

}
