package boj;

public class BOJ15964 {
    private static FastReader SC = new FastReader();
    private static int A, B;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        long res = (long) (A + B) * (long) (A - B);
        System.out.println(res);
    }

    private static void input() {
        A = SC.nextInt();
        B = SC.nextInt();
    }
}
