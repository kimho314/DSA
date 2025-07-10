package boj;

public class BOJ11382 {
    private static FastReader SC = new FastReader();
    private static long A, B, C;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        System.out.println(A + B + C);
    }

    private static void input() {
        A = SC.nextLong();
        B = SC.nextLong();
        C = SC.nextLong();
    }
}
