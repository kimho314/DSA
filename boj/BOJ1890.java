package boj;

public class BOJ1890 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static int[][] MAP;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        long[][] dp = new long[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                }
                else {
                    for (int k = 0; k < i; k++) {
                        if (i - k == MAP[k][j]) {
                            dp[i][j] += dp[k][j];
                        }
                    }

                    for (int k = 0; k < j; k++) {
                        if (j - k == MAP[i][k]) {
                            dp[i][j] += dp[i][k];
                        }
                    }
                }
            }
        }

        System.out.println(dp[N - 1][N - 1]);
    }

    private static void input() {
        N = SC.nextInt();
        MAP = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                MAP[i][j] = SC.nextInt();
            }
        }
    }
}
