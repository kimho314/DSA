package boj;

public class BOJ25176 {
    private static FastReader SC = new FastReader();
    private static int N;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int res = 1;
        for (int i = N; i >= 1; i--) {
            res *= i;
        }

        System.out.println(res);
    }

    private static void input() {
        N = SC.nextInt();
    }
}
