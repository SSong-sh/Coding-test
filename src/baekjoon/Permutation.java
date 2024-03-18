package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Permutation {
	
	private static int[] numArr;
	private static int[] outPut;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		StringTokenizer str = new StringTokenizer(reader.readLine());
		
		int N = Integer.parseInt(str.nextToken());
		int M = Integer.parseInt(str.nextToken());
		
		numArr = new int[N];
		outPut = new int[N];
		
		for(int i = 0; i < N; i++) {
			numArr[i] = i + 1;
		}
		
		perm(numArr,outPut, 0, N, M);
		
	}

	private static void perm(int[] numArr, int[] outPut, int depth, int n, int r) {
		if (depth == r) {
			print(outPut,r);
			return;
		}
		
		for(int i = 0; i < n; i++) {
			boolean isUsed = false;
			for (int j = 0; j < depth; j++) {
				if (outPut[j] == numArr[i]) {
					isUsed = true;
					break;
				}
			}
			if (!isUsed) {
				outPut[depth] = numArr[i];
				perm(numArr, outPut, depth + 1, n, r);
			}
		}
		
	}

	private static void print(int[] numArr, int r) {	
	        for (int i = 0; i < r; i++)
	            System.out.print(numArr[i] + " ");
	        System.out.println();
			
	}

}
