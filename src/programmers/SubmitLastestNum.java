package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubmitLastestNum {

	private static int[] numArr;
	private static String num ;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());

        numArr = new int[N];

        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(reader.readLine());
        }

        findLargestNum(numArr);

        System.out.println(num);
    }

    static String findLargestNum(int[] numArr) {
        int n = numArr.length;

        // 초기값 설정
        if (n > 0) {
        	num = String.valueOf(numArr[0]);
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    num = String.valueOf(numArr[i]) + String.valueOf(numArr[j]) + String.valueOf(numArr[k]);
                                     
                }
            }
        }

        return num;
    }


}
