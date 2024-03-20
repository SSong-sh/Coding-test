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
		//DP[현재 날의 상담 기간을 계산했을 때 끝나는 날]
		//n+1인 이유 : 돈은 그 다음날 받기 때문에
		int[] dp = new int[n+1];		
		
		for (int i=0; i<n; i++) {
			if (i + t[i] <= n) { 
				//max(DP[현재 날의 상담 기간을 계산했을 때 끝나는 날], DP[현재 날까지 계산된 값] + pay[현재 날 상담을 통해 얻는 값])
				//지금까지 계산한 값 vs 지금 해야할 계산
				dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);
			}

			dp[i+1] = Math.max(dp[i+1], dp[i]);
		}
		System.out.println(dp[n]);
		
	}//main
}