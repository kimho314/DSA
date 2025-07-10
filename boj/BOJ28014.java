package boj;

public class BOJ28014 {
    static FastReader SC = new FastReader();
    static int N;
    static int[] H;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int cnt = 1;
        for (int i = 1; i < N; i++) {
            if (H[i] >= H[i - 1]) {
                cnt++;
            }

        }

        System.out.println(cnt);
    }

    private static void input() {
        N = SC.nextInt();
        H = new int[N];
        for (int i = 0; i < N; i++) {
            H[i] = SC.nextInt();
        }
    }
}
