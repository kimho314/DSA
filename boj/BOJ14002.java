package boj;

import java.util.Arrays;

public class BOJ14002 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static int[] A;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int[] dp = new int[N];
        Arrays.fill(dp, 1);
        String[] list = new String[N];
        for (int i = 0; i < N; i++) {
            list[i] = A[i] + "";
        }


        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        String tmp = list[j] + " " + A[i];
                        list[i] = tmp;
                    }
                }
            }
        }

        int max = 0;
        int maxIdx = -1;
        for (int i = 0; i < N; i++) {
            if (dp[i] > max) {
                max = dp[i];
                maxIdx = i;
            }
        }

        System.out.println(max);
        System.out.println(list[maxIdx]);
    }

    private static void input() {
        N = SC.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = SC.nextInt();
        }
    }
}
