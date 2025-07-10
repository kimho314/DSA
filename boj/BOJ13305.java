package boj;

public class BOJ13305 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static long[] G;
    private static long[] D;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        long res = G[0] * D[0];
        long min = G[0];

        for (int i = 1; i < N - 1; i++) {
            if (G[i] < min) {
                min = G[i];
            }
            res += min * D[i];
        }

        System.out.println(res);
    }

    private static void input() {
        N = SC.nextInt();
        D = new long[N - 1];
        for (int i = 0; i < N - 1; i++) {
            D[i] = SC.nextInt();
        }
        G = new long[N];
        for (int i = 0; i < N; i++) {
            G[i] = SC.nextInt();
        }
    }
}
