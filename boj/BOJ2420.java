package boj;

public class BOJ2420 {
    private static FastReader SC = new FastReader();
    private static int N, M;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        long res = Math.abs((long) N - (long) M);
        System.out.println(res);
    }

    private static void input() {
        N = SC.nextInt();
        M = SC.nextInt();
    }
}
