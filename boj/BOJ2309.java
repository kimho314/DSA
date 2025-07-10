package boj;

import java.util.Arrays;

public class BOJ2309 {
    static FastReader SC = new FastReader();

    public static void main(String[] args) {
        int[] arr = new int[9];
        for (int i = 0; i < 9; i++) {
            arr[i] = SC.nextInt();
        }
        Arrays.sort(arr);

        int sum = Arrays.stream(arr).sum();
        boolean isFound = false;
        int[] ans = new int[7];
        for (int i = 8; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (sum - arr[i] - arr[j] == 100) {
                    int[] copied1 = Arrays.copyOfRange(arr, 0, Math.min(i, j));
                    int[] copied2 = Arrays.copyOfRange(arr, Math.min(i, j) + 1, Math.max(i, j));
                    int[] copied3 = Arrays.copyOfRange(arr, Math.max(i, j) + 1, arr.length);

                    int[] array = Arrays.asList(copied1, copied2, copied3).stream().flatMapToInt(it -> Arrays.stream(it)).toArray();
                    ans = array;
                    isFound = true;
                    break;
                }
            }
            if (isFound) {
                break;
            }
        }

        for (int elem : ans) {
            System.out.println(elem);
        }
    }
}
