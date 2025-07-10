package boj;

public class BOJ1010 {
    static FastReader SC = new FastReader();
    static int T;
    static int N, M;
    static int[][] DP = new int[30][30];
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        T = SC.nextInt();
        solve();
    }

    private static void solve() {
        while (T > 0) {
            T--;

            int N = SC.nextInt();
            int M = SC.nextInt();
            comb();
            SB.append(DP[M][N]).append('\n');
        }

        System.out.println(SB.toString());
    }

    private static void comb() {
        for (int i = 0; i < 30; i++) {
            DP[i][i] = 1;
            DP[i][0] = 1;
        }

        for (int i = 2; i < 30; i++) {
            for (int j = 1; j < 30; j++) {
                DP[i][j] = DP[i - 1][j - 1] + DP[i - 1][j];
            }
        }
    }
}
