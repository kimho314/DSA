package boj;

public class BOJ2491 {
    static FastReader SC = new FastReader();
    static int N;
    static int[] A;
    static int[][] DP;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        for (int i = 1; i < N; i++) {
            if (A[i] >= A[i - 1]) {
                DP[i][0] = Math.max(DP[i][0], DP[i - 1][0] + 1);
            }

            if (A[i] <= A[i - 1]) {
                DP[i][1] = Math.max(DP[i][1], DP[i - 1][1] + 1);
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, DP[i][0]);
            max = Math.max(max, DP[i][1]);
        }
        System.out.println(max);
    }

    private static void input() {
        N = SC.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = SC.nextInt();
        }

        DP = new int[N][2];
        for (int i = 0; i < N; i++) {
            DP[i][0] = 1;
            DP[i][1] = 1;
        }
    }
}
