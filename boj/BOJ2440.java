package boj;

public class BOJ2440 {
    private static FastReader SC = new FastReader();
    private static int N;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        for (int i = 0; i < N; i++) {
            System.out.println("*".repeat(N - i));
        }
    }

    private static void input() {
        N = SC.nextInt();
    }
}
