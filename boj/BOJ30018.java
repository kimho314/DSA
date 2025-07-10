package boj;

public class BOJ30018 {
    static FastReader SC = new FastReader();
    static int N;
    static int[] A, B;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int res = 0;

        for (int i = 0; i < N; i++) {
            if (A[i] < B[i]) {
                res += (B[i] - A[i]);
            }
        }

        System.out.println(res);
    }

    private static void input() {
        N = SC.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = SC.nextInt();
        }
        B = new int[N];
        for (int i = 0; i < N; i++) {
            B[i] = SC.nextInt();
        }
    }
}
