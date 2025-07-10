package boj;

public class BOJ1568 {
    private static FastReader SC = new FastReader();
    private static long N;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int time = 0;
        int cnt = 1;
        while (N > 0) {
            if (cnt > N) {
                cnt = 1;
                continue;
            }

            time++;
            N -= cnt;
            cnt++;
        }

        System.out.println(time);
    }

    private static void input() {
        N = SC.nextLong();
    }
}
