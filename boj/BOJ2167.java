package boj;

public class BOJ2167 {
    static FastReader SC = new FastReader();
    static int N, M, K;
    static int[][] NUMS, SUMS;
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                SUMS[i][j] = NUMS[i][j] + SUMS[i - 1][j] + SUMS[i][j - 1] - SUMS[i - 1][j - 1];
            }
        }

        while (K > 0) {
            K--;

            int i = SC.nextInt();
            int j = SC.nextInt();
            int x = SC.nextInt();
            int y = SC.nextInt();
            int sum = SUMS[x][y] - SUMS[x][j - 1] - SUMS[i - 1][y] + SUMS[i - 1][j - 1];
            SB.append(sum).append('\n');
        }
        System.out.println(SB.toString());
    }

    private static void input() {
        N = SC.nextInt();
        M = SC.nextInt();
        NUMS = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                NUMS[i][j] = SC.nextInt();
            }
        }

        K = SC.nextInt();

        SUMS = new int[N + 1][M + 1];
    }
}
