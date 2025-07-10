package boj;

public class BOJ14929 {
    static FastReader SC = new FastReader();
    static int N;
    static int[] X;
    static int[] PREFIX_SUM;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += X[i];
            PREFIX_SUM[i + 1] = sum;
        }

        long ans = 0;
        for (int i = 0; i < N; i++) {
            int standard = X[i];
            int calc = PREFIX_SUM[N] - PREFIX_SUM[i + 1];
            ans += ((long) standard * (long) calc);
        }
        System.out.println(ans);
    }

    private static void input() {
        N = SC.nextInt();
        X = new int[N];
        PREFIX_SUM = new int[N + 1];
        for (int i = 0; i < N; i++) {
            X[i] = SC.nextInt();
        }
    }
}
