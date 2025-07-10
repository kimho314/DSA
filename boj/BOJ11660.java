package boj;

public class BOJ11660 {
    static FastReader SC = new FastReader();
    static int[][] INPUT;
    static int[][] DP;
    static int N, M;
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        init();
        solve();
    }

    private static void solve() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                DP[i][j] = DP[i][j - 1] + DP[i - 1][j] - DP[i - 1][j - 1] + INPUT[i][j];
            }
        }

        for (int i = 0; i < M; i++) {
            int x1 = SC.nextInt();
            int y1 = SC.nextInt();
            int x2 = SC.nextInt();
            int y2 = SC.nextInt();

            int res = DP[x2][y2] - DP[x1 - 1][y2] - DP[x2][y1 - 1] + DP[x1 - 1][y1 - 1];
            SB.append(res).append('\n');
        }

        System.out.println(SB.toString());
    }

    private static void init() {
        N = SC.nextInt();
        M = SC.nextInt();
        INPUT = new int[N + 1][N + 1];
        DP = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                INPUT[i][j] = SC.nextInt();
            }
        }
    }
}
