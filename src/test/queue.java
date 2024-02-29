package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class queue {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for(int k = 0; k < T; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			LinkedList<int[]> queue = new LinkedList<>();

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				queue.offer(new int[] { i, Integer.parseInt(st.nextToken()) });
			}
			
			System.out.println();
			// 큐에 들어있는 원소와 우선순위를 출력
			System.out.println("Queue contents:");
			for (int[] element : queue) {
			    System.out.println("Index: " + element[0] + ", Priority: " + element[1]);
			}

			
			
		}
	}

}
