package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_Brute {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(reader.readLine());
		
		int[] t = new int[n];
		int[] p = new int[n];
		
		StringTokenizer st;
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(reader.readLine());
			
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		//N일에 얻을 수 있는 최대 수익
		int[] High = new int[n];		
		
		for (int i=0; i<n; i++) {
			if (i + t[i] <= n) { 
				High[i + t[i]] = Math.max(High[i + t[i]], High[i] + p[i]);
			}

			High[i+1] = Math.max(High[i+1], High[i]);
		}
		System.out.println(High[n]);
		
	}//main
}