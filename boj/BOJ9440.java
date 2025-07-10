package boj;

import java.util.Arrays;

public class BOJ9440 {
    private static FastReader SC = new FastReader();

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = SC.nextInt();
            if (n == 0) {
                break;
            }

            int[] arr = new int[n];
            int zeroCount = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = SC.nextInt();
                if (arr[i] == 0) {
                    zeroCount++;
                }
            }

            Arrays.sort(arr);

            if (zeroCount > 0) {
                int[] tempArr = new int[zeroCount + 2];
                for (int i = 0; i < zeroCount + 2; i++) {
                    tempArr[i] = arr[i];
                }

                leftShift(tempArr);

                for (int i = 0; i < zeroCount + 2; i++) {
                    arr[i] = tempArr[i];
                }
            }

            StringBuilder num1 = new StringBuilder();
            StringBuilder num2 = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                if (i % 2 == 0) {
                    num1.append(arr[i]);
                } else {
                    num2.append(arr[i]);
                }
            }

            int n1 = Integer.parseInt(num1.toString());
            int n2 = Integer.parseInt(num2.toString());
            sb.append(n1 + n2).append('\n');
        }

        System.out.println(sb);
    }

    private static void leftShift(int[] arr) {
        int size = arr.length;
        reverse(arr, size - 2, size);
        reverse(arr, 0, size - 2);
        reverse(arr, 0, size);
    }

    private static void reverse(int[] arr, int start, int end) {
        end = end - 1;
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
