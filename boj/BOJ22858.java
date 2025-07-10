package boj;

public class BOJ22858 {
    private static FastReader SC = new FastReader();
    private static int N, K;
    private static int[] S, D;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        for (int i = 0; i < K; i++) {
            int[] res = new int[N];
            for (int j = 0; j < N; j++) {
                res[D[j] - 1] = S[j];
            }
            for (int j = 0; j < N; j++) {
                S[j] = res[j];
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(S[i] + " ");
        }
    }

    private static void input() {
        N = SC.nextInt();
        K = SC.nextInt();
        S = new int[N];
        for (int i = 0; i < N; i++) {
            S[i] = SC.nextInt();
        }
        D = new int[N];
        for (int i = 0; i < N; i++) {
            D[i] = SC.nextInt();
        }
    }
}
