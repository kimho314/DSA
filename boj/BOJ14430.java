package boj;

public class BOJ14430 {
    private static FastReader SC = new FastReader();
    private static int N, M;
    private static int[][] MAP;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int[][] dp = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                dp[i][j] = MAP[i][j] + Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        System.out.println(dp[N][M]);
    }


    private static void input() {
        N = SC.nextInt();
        M = SC.nextInt();
        MAP = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                MAP[i][j] = SC.nextInt();
            }
        }
    }
}
