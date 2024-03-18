package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LastestNum {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        
        int N = Integer.parseInt(reader.readLine());

        int[] numbers = new int[N];
        
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(reader.readLine());
        }

        String largestNumber = findLargestNumber(numbers);
        System.out.println(largestNumber);
    }

    public static String findLargestNumber(int[] nums) {
        List<String> permutations = new ArrayList<>();
        generatePermutations(nums, "", new boolean[nums.length], permutations);

        String largestNumber = "0"; // 초기값 설정

        for (String num : permutations) {
            if (isGreater(num, largestNumber)) {
                largestNumber = num;
            }
        }

        return largestNumber;
    }

    private static void generatePermutations(int[] nums, String currentPermutation, boolean[] used, List<String> permutations) {
        if (currentPermutation.length() == nums.length) {
            permutations.add(currentPermutation);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                generatePermutations(nums, currentPermutation + nums[i], used, permutations);
                used[i] = false;
            }
        }
    }

    private static boolean isGreater(String num1, String num2) {
        return (num1 + num2).compareTo(num2 + num1) > 0;
    }
}
