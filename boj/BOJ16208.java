package boj;

public class BOJ16208 {
    static FastReader SC = new FastReader();
    static int N;
    static int[] A;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        long total = 0;
        for (int i = 0; i < N; i++) {
            total += A[i];
        }

        long res = 0;
        for (int i = 0; i < N; i++) {
            total -= A[i];
            res += (A[i] * total);
        }

        System.out.println(res);
    }


    private static void input() {
        N = SC.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = SC.nextInt();
        }
    }
}
