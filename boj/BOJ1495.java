package boj;

public class BOJ1495 {
    static FastReader SC = new FastReader();
    static int N, S, M;
    static boolean[][] DP;
    static int[] V;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        DP[0][S] = true;

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                if (!DP[i - 1][j]) {
                    continue;
                }

                if (j - V[i] >= 0) {
                    DP[i][j - V[i]] = true;
                }
                if (j + V[i] <= M) {
                    DP[i][j + V[i]] = true;
                }
            }
        }

        int ans = -1;
        for (int i = M; i >= 0; i--) {
            if (DP[N][i]) {
                ans = i;
                break;
            }
        }
        System.out.println(ans);
    }

    private static void input() {
        N = SC.nextInt();
        S = SC.nextInt();
        M = SC.nextInt();
        V = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            V[i] = SC.nextInt();
        }
        DP = new boolean[N + 1][M + 1];
    }
}
