package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class array03 {
	
	static int min =0;
	static int n = 0;
	static int m = 0;
	static int[] dx = {0, 1, 0, -1}; // 왼쪽으로 넣는, 위로 넣는, 오른쪽으로 넣는, 아래로 넣는
	static int[] dy = {1, 0, -1, 0};
	static int[][] array;
	
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer str = new StringTokenizer(reader.readLine());
         n = Integer.parseInt(str.nextToken());
         m = Integer.parseInt(str.nextToken());
        int rotations = Integer.parseInt(str.nextToken());

        array = new int[n][m];
        for (int i = 0; i < n; i++) {
            str = new StringTokenizer(reader.readLine());
            for (int j = 0; j < m; j++) {
                array[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        min = Math.min(n, m); // 행, 열 중 더 작은 것 구함
        // 배열 회전
        System.out.println(min);
    }
}
