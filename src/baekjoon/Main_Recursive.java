package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_Recursive {

    private static int[] numArr;
    private static int[] copyArr;
    private static int K;
    static int count;
    static int result;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(tokenizer.nextToken());
        K = Integer.parseInt(tokenizer.nextToken());

        numArr = new int[N];
        copyArr = new int[N];


        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(tokenizer.nextToken());
        }

        mergeSort(0, numArr.length - 1);

        if (count < K) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
        
    }

    private static void mergeSort(int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(left, mid);
            mergeSort(mid + 1, right);
            merge(left, mid, right);
        }
    }

    private static void merge(int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (numArr[i] <= numArr[j]) {
                copyArr[k++] = numArr[i++];
            } else {
                copyArr[k++] = numArr[j++];
            }
        }

        while (j <= right) {
            copyArr[k++] = numArr[j++];
        }

        while (i <= mid) {
            copyArr[k++] = numArr[i++];
        }

        // 병합 후의 배열을 다시 numArr로 복사
        for (int index = left; index <= right; index++) {
            numArr[index] = copyArr[index];
            count++; // 복사될 때마다 count 증가
            if (count == K) {
                result = numArr[index];
                return;
            }                          
        }
    }
}
