package programmers;


class Solution {
    public String solution(int[] numbers) {
        String[] numArr = new String[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            numArr[i] = String.valueOf(numbers[i]);
        }
        
        mergeSort(numArr, 0, numArr.length - 1);
        
        StringBuilder answer = new StringBuilder();
        for (String num : numArr) {
            answer.append(num);
        }
        
        if (answer.charAt(0) == '0') {
            return "0"; 
        }
        
        return answer.toString();
    }
    
    private void mergeSort(String[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
    
    private void merge(String[] arr, int left, int mid, int right) {
        String[] temp = new String[arr.length];
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if ((arr[i] + arr[j]).compareTo(arr[j] + arr[i]) >= 0) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (int index = left; index <= right; index++) {
            arr[index] = temp[index];
        }
    }
}

