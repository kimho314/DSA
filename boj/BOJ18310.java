package boj;

import java.util.Arrays;

public class BOJ18310 {
    static FastReader SC = new FastReader();
    static int N;

    public static void main(String[] args) {
        N = SC.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = SC.nextInt();
        }

        Arrays.sort(arr);
        if (N == 1) {
            System.out.println(arr[0]);
        }
        else {
            if (N % 2 == 0) {
                int pos = N / 2 - 1;
                System.out.println(arr[pos]);
            }
            else {
                int pos = N / 2;
                System.out.println(arr[pos]);
            }
        }
    }
}
