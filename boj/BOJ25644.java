package boj;

public class BOJ25644 {
    static FastReader SC = new FastReader();
    static int N;
    static int[] A;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int min = A[0];
        int res = 0;
        for (int i = 1; i < N; i++) {
            if (min > A[i]) {
                min = A[i];
            }
            else {
                res = Math.max(res, A[i] - min);
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
    }
}
