package boj;

public class BOJ1932 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static int[][] MAP;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int[][] dp = new int[N][N];
        dp[0][0] = MAP[0][0];
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + MAP[i][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + MAP[i][j];
                }
            }
        }

        int res = 0;
        for (int i = 0; i < N; i++) {
            res = Math.max(res, dp[N - 1][i]);
        }
        System.out.println(res);
    }

    private static void input() {
        N = SC.nextInt();
        MAP = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] split = SC.nextLine().split(" ");
            for (int j = 0; j < split.length; j++) {
                MAP[i][j] = Integer.parseInt(split[j]);
            }
        }
    }
}
