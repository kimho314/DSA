package boj;

public class BOJ2903 {
    static FastReader SC = new FastReader();
    static int N;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int res = (int) Math.pow(Math.pow(2, N) + 1, 2);
        System.out.println(res);
    }

    private static void input() {
        N = SC.nextInt();
    }
}
