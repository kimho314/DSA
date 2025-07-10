package boj;

import java.util.Arrays;

public class BOJ17484 {
    private static FastReader SC = new FastReader();
    private static int N, M;
    private static int[][] MAP;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int[][][] dp = new int[N][M][3];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }

        for (int i = 0; i < M; i++) {
            dp[0][i][0] = MAP[0][i];
            dp[0][i][1] = MAP[0][i];
            dp[0][i][2] = MAP[0][i];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (j == 0) {
                    dp[i][j][0] = Math.min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2]) + MAP[i][j];
                    dp[i][j][1] = dp[i - 1][j][0] + MAP[i][j];
                }
                else if (j == M - 1) {
                    dp[i][j][2] = Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][0]) + MAP[i][j];
                    dp[i][j][1] = dp[i - 1][j][2] + MAP[i][j];
                }
                else {
                    dp[i][j][0] = Math.min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2]) + MAP[i][j];
                    dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + MAP[i][j];
                    dp[i][j][2] = Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][0]) + MAP[i][j];
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 3; j++) {
                min = Math.min(min, dp[N - 1][i][j]);
            }
        }
        System.out.println(min);
    }

    private static void input() {
        N = SC.nextInt();
        M = SC.nextInt();
        MAP = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                MAP[i][j] = SC.nextInt();
            }
        }
    }
}
