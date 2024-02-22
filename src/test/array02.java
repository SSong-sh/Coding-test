package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class array02 {
	
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
        
    	for(int i=1; i<=rotations; i++) { // 회전 횟수만큼 회전시킴
    		rotateArray();
    	}

        // 회전된 배열 출력
        printArray();
    }

    // 배열 회전 메서드
    private static void rotateArray() {
    	for(int t=0; t<min/2; t++) { // 회전 시킬 그룹의 갯수 구하기 // t = 0 , t = 1
    		int x = t; // x =0
    		int y = t; // y =0
    		
    		int temp = array[x][y]; // 마지막에 넣을 값 미리 빼놓음 [0][0]
    		
    		int idx = 0; // 우, 하, 좌, 상 방향으로 이동하며 반시계 방향으로 값 넣을 인덱스
    		while(idx < 4) { // 왼쪽으로 넣는, 위로 넣는, 오른쪽으로 넣는, 아래로 넣는 연산을 차례로 수행
    			int nx = x + dx[idx]; //0+dx[0]=0 > 0+0 = 0
    			int ny = y + dy[idx]; //0+dy[0]=1 > 0+1 =1
    			
    			// 범위 안이라면
    			if(nx < n-t && ny < m-t && nx >= t && ny >= t) { //nx < 4, ny <4, nx >=0 , ny >=0
    				array[x][y] = array[nx][ny]; //array[0][0] = array[0][1]
    				x = nx; //x =0
    				y = ny; //y =1
    			} 
    			// 범위를 벗어났다면 다음 방향으로 넘어감
    			else {
    				idx++; // 1
    			}
    			
    		}
    		
    		array[t+1][t] = temp; // 빼 놓은 값 넣어 줌
    	}
    	
		
	}

    // 배열 출력 메서드
    static void printArray() {
    	for(int i=0; i<n; i++) {
    		for(int j=0; j<n; j++) {
    			System.out.print(array[i][j] + " ");
    		}
    		System.out.println();
    	}
    	System.out.println();
    }
}
