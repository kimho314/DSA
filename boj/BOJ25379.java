package boj;

public class BOJ25379 {
    static FastReader SC = new FastReader();
    static int N;
    static int[] A;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        long cntL = 0;
        long cntR = 0;
        long sum = 0;
        int idx = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] % 2 == 0) {
                sum += idx++;
                cntL += i;
                cntR += N - 1 - i;
            }
        }

        System.out.println(Math.min(cntL, cntR) - sum);
    }

    private static void input() {
        N = SC.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = SC.nextInt();
        }
    }
}
