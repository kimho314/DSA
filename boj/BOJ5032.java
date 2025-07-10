package boj;

public class BOJ5032 {
    private static FastReader SC = new FastReader();
    private static int E, F, C;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int cnt = E + F;
        int res = 0;
        while (cnt >= C) {
            cnt -= C;
            res++;
            cnt++;
        }

        System.out.println(res);
    }

    private static void input() {
        E = SC.nextInt();
        F = SC.nextInt();
        C = SC.nextInt();
    }
}
