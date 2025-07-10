package boj;

public class BOJ14494 {
    static FastReader SC = new FastReader();
    static long[][] DP = new long[1001][1001];
    static int N, M;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void input() {
        N = SC.nextInt();
        M = SC.nextInt();
    }

    private static void solve() {
        DP[1][1] = 0;

        for (int i = 1; i <= 1000; i++) {
            DP[i][1] = 1;
            DP[1][i] = 1;
        }

        for (int i = 2; i <= 1000; i++) {
            for (int j = 2; j <= 1000; j++) {

                long res = ((DP[i - 1][j] % 1_000_000_007) + (DP[i - 1][j - 1] % 1_000_000_007) + (DP[i][j - 1] % 1_000_000_007));
                DP[i][j] = res % 1_000_000_007;
            }
        }

        System.out.println(DP[N][M]);
    }
}
