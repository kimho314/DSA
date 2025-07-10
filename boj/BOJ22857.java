package boj;

import java.util.*;

public class BOJ22857 {
    private static FastReader SC = new FastReader();
    private static int N, K;
    private static int[] S;

    public static void main(String[] args) {
        input();
        solve();
        // solve2();
        // solve3();
    }

    // using dynamic programming
    private static void solve3() {
        int[][] dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            S[i - 1] %= 2;
            for (int j = 0; j <= K; j++) {
                if (S[i - 1] == 0) {
                    dp[i][j] = dp[i - 1][j] + 1;
                } else {
                    if (j != 0) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, dp[i][K]);
        }
        System.out.println(max);
    }

    // using two pointers
    private static void solve2() {
        int l = 0;
        int oddCount = 0;
        int maxEvens = 0;
        for (int r = 0; r < N; r++) {
            if (S[r] % 2 == 1) {
                oddCount++;
            }

            while (oddCount > K) {
                if (S[l] % 2 == 1) {
                    oddCount--;
                }
                l++;
            }

            int windowSize = r - l + 1;
            int cnt = windowSize - oddCount;
            maxEvens = Math.max(maxEvens, cnt);
        }

        System.out.println(maxEvens);
    }


    private static void solve() {
        int res = 0;
        for (int i = 0; i < N; i++) {
            if (S[i] % 2 == 1) {
                continue;
            }
            int cnt = 0;
            int len = 1;
            for (int j = i + 1; j < N; j++) {
                if (S[j] % 2 == 0) {
                    len++;
                } else {
                    if (cnt >= K) {
                        break;
                    } else {
                        cnt++;
                    }
                }

            }
            res = Math.max(res, len);
        }

        System.out.println(res);
    }

    private static void input() {
        N = SC.nextInt();
        K = SC.nextInt();
        S = new int[N];
        for (int i = 0; i < N; i++) {
            S[i] = SC.nextInt();
        }
    }
}
