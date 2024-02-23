package test;

import java.util.Arrays;
import java.util.Scanner;

public class array01 {	

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		String str = scanner.nextLine();
		String[] substrings  = new String[str.length()]; // 타입[] 변수 = new 타입[길이];
		
		/* String substring > 문자열 자르기 사용 > 시작 위치 인덱스 포함, 끝 인덱스 포함 x
		 *  i = 0 substring의 1번 = baekjoon
		 *  ...
		 *  i = 7 substring의 7번 = n
		 */ 
		for (int i = 0; i < str.length(); i++) {
			substrings[i] = str.substring(i);
		}
		
		/* Arrays.sort(Object[] a) > ascending order 
		 * Arrays.sort(배열, Collections.reverseOrder()) > 내림차순 
		 */
		Arrays.sort(substrings); 

		// 배열에 저장된 부분 문자열 출력
		for (String substringStr : substrings) {
			System.out.println(substringStr);
		}

	}

}
