package boj;

import java.util.Arrays;
import java.util.Collections;

public class BOJ20186 {
    static FastReader SC = new FastReader();
    static int N, K;
    static Integer[] A;

    public static void main(String[] args) {
        init();
        solve();
    }

    private static void solve() {
        Integer[] copy = Arrays.copyOfRange(A, 0, A.length);
        Arrays.sort(copy, Collections.reverseOrder());

        int minus = (K - 1) * K / 2;

        int result = 0;
        for (int i = 0; i < K; i++) {
            result += copy[i];
        }

        System.out.println(result - minus);
    }

    private static void init() {
        N = SC.nextInt();
        K = SC.nextInt();
        A = new Integer[N];
        for (int i = 0; i < N; i++) {
            A[i] = SC.nextInt();
        }
    }
}
