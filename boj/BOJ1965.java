package boj;

import java.util.Arrays;

public class BOJ1965 {
    static FastReader SC = new FastReader();
    static int N;
    static int[] A, DP;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        Arrays.fill(DP, 1);

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j]) {
                    DP[i] = Math.max(DP[i], DP[j] + 1);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, DP[i]);
        }
        System.out.println(max);
    }

    private static void input() {
        N = SC.nextInt();
        A = new int[N];
        DP = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = SC.nextInt();
        }
    }
}
