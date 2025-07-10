package boj;

public class BOJ2558 {
    private static FastReader SC = new FastReader();
    private static int A, B;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        System.out.println(A + B);
    }

    private static void input() {
        A = SC.nextInt();
        B = SC.nextInt();
    }
}
