package boj;

public class BOJ2444 {
    private static FastReader SC = new FastReader();
    private static int N;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        for (int i = 1; i < 2 * N; i++) {
            if (i <= (2 * N) / 2) {
                String blank = " ".repeat(((2 * N) / 2) - i);
                System.out.print(blank);
                String star = "*".repeat((2 * i) - 1);
                System.out.print(star);
            }
            else {
                String blank = " ".repeat((2 * N) / 2 - (2 * N - i));
                System.out.print(blank);
                String star = "*".repeat((2 * (2 * N - i)) - 1);
                System.out.print(star);
            }
            System.out.println();
        }
    }

    private static void input() {
        N = SC.nextInt();
    }
}
