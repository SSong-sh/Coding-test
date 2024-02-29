package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class array02 {
	
	static int min = 0;
	static int n = 0;
	static int m = 0;
	static int[] di = {0, 1, 0, -1}; 
	static int[] dj = {1, 0, -1, 0};
	//왼쪽으로 넣는, 위로 넣는, 오른쪽으로 넣는, 아래로 넣는
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
    	
    	for(int g = 0; g < min / 2; g++) { // 회전 시킬 그룹의 갯수 구하기 
    		
    		int i = g; // x =0
    		int j = g; // y =0
    		int temp = array[i][j]; // 마지막에 넣을 값 미리 빼놓음 [0][0] = 회전을 시작할 위치
    		int index = 0; // 반시계 방향으로 값 넣을 인덱스
    		
    		while(index < 4) { 
    			
    			// nextI와 nextJ변수는 다음 위치의 행과 열을 나타냄
    			int nextI = i + di[index]; 
    			int nextJ = j + dj[index]; 
    			
    			// 그룹의 크기를 고려하여 범위를 조정
    			if(nextI < n-g && nextJ < m-g && nextI >= g && nextJ >= g) { 
    				
    				array[i][j] = array[nextI][nextJ]; //array[0][0] = array[0][1]
    				i = nextI; //x =0
    				j = nextJ; //y =1
    				
    			} 
    			// 범위를 벗어났다면 다음 방향으로 넘어감
    			else {
    				index++; // 1
    			}
    			
    		}
    		array[g+1][g] = temp;
    		
    	}
    	
	}

    // 배열 출력 메서드
    static void printArray() {
    	
    	for(int i=0; i<n; i++) {
    		
    		for(int j=0; j<m; j++) {
    			System.out.print(array[i][j] + " ");
    		}
    		
    		System.out.println();
    		
    	}
    	
    	System.out.println();
    	
    }
    
}
