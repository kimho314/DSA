package boj;

public class BOJ2442 {
    private static FastReader SC = new FastReader();
    private static int N;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        for (int i = 0; i < N; i++) {
            System.out.print(" ".repeat(N - i - 1));
            System.out.println("*".repeat(2 * (i + 1) - 1));
        }
    }

    private static void input() {
        N = SC.nextInt();
    }
}
