package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class array02 {
	
	public static void main(String[] args) throws IOException {
	    try {
	        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	        // 첫 번째 입력을 받아 공백으로 구분된 정수로 분리
	        String input [] = reader.readLine().split(" ");
	        int indexOne = Integer.parseInt(input[0]); // 첫 번째 정수
	        int indexTwo = Integer.parseInt(input[1]); // 두 번째 정수
	        int cycle = Integer.parseInt(input[2]);

	        System.out.println(indexOne);
	        System.out.println(indexTwo);
	        System.out.println(cycle);
	        
	        //첫째 줄에 배열의 크기 N, M과 수행해야 하는 회전의 수 R이 주어진다.
	        int array [][] = new int [indexOne][indexTwo];
	        
	        
	        
	    } catch (Exception e) {
	        e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력
	    }
	}

}
