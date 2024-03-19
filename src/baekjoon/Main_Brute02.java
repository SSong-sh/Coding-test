package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_Brute02 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());

        int[] card = new int[N];

        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int maxSum = -1; // M보다 작은 경우에만 갱신되는 최댓값을 저장할 변수

        // 3개의 숫자를 선택하여 합을 구함
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    int sum = card[i] + card[j] + card[k];
                    if (sum <= M) { // 합이 M보다 작은 경우에만 최댓값 갱신
                        maxSum = Math.max(maxSum, sum);
                    }
                }
            }
        }

        System.out.println(maxSum); // 최댓값 출력
    }
}
