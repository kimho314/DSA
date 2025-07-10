package boj;

public class BOJ17451 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static int[] V;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        long res = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (res <= V[i]) {
                res = V[i];
            } else {
                if (res % V[i] != 0) {
                    res = (long) V[i] * (res / V[i] + 1);
                }
            }
        }

        System.out.println(res);
    }

    private static void input() {
        N = SC.nextInt();
        V = new int[N];
        for (int i = 0; i < N; i++) {
            V[i] = SC.nextInt();
        }
    }
}
