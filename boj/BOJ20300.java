package boj;

import java.util.*;

public class BOJ20300 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static long[] T;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        Arrays.sort(T);

        long max = 0;
        if (N % 2 == 0) {
            for (int i = 0; i < N / 2; i++) {
                long sum = T[i] + T[N - 1 - i];
                if (max < sum) {
                    max = sum;
                }
            }
        } else {
            max = T[N - 1];
            int size = N - 1;
            for (int i = 0; i < size / 2; i++) {
                long sum = T[i] + T[size - 1 - i];
                if (max < sum) {
                    max = sum;
                }
            }
        }

        System.out.println(max);
    }

    private static void input() {
        N = SC.nextInt();
        T = new long[N];
        for (int i = 0; i < N; i++) {
            T[i] = SC.nextLong();
        }
    }
}
