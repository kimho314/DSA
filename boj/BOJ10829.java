package boj;

public class BOJ10829 {
    private static FastReader SC = new FastReader();
    private static long N;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        String res = Long.toBinaryString(N);
        System.out.println(res);
    }

    private static void input() {
        N = SC.nextLong();
    }
}
