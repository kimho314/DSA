package boj;

public class BOJ16194 {
    static FastReader SC = new FastReader();
    static int N;
    static int[] P, DP;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                DP[i] = Math.min(DP[i], DP[j] + P[i - j]);
            }
        }

        System.out.println(DP[N]);
    }

    private static void input() {
        N = SC.nextInt();
        P = new int[N + 1];
        DP = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            P[i] = SC.nextInt();
            DP[i] = P[i];
        }
    }
}
