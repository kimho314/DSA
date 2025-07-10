package boj;

public class BOJ21918 {
    private static FastReader SC = new FastReader();
    private static int N, M;
    private static int[] S;
    private static int[][] OPS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        for (int t = 0; t < M; t++) {
            int a = OPS[t][0];
            int b = OPS[t][1];
            int c = OPS[t][2];

            operate(a, b, c);
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(S[i] + " ");
        }
    }

    private static void operate(int a, int b, int c) {
        if (a == 1) {
            S[b] = c;
        }
        if (a == 2) {
            for (int i = b; i <= c; i++) {
                S[i] = S[i] == 1 ? 0 : 1;
            }
        }
        if (a == 3) {
            for (int i = b; i <= c; i++) {
                S[i] = 0;
            }
        }
        if (a == 4) {
            for (int i = b; i <= c; i++) {
                S[i] = 1;
            }
        }
    }

    private static void input() {
        N = SC.nextInt();
        M = SC.nextInt();
        S = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            S[i] = SC.nextInt();
        }
        OPS = new int[M][3];
        for (int i = 0; i < M; i++) {
            OPS[i][0] = SC.nextInt();
            OPS[i][1] = SC.nextInt();
            OPS[i][2] = SC.nextInt();
        }
    }
}
