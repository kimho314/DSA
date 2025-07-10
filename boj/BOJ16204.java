package boj;

public class BOJ16204 {
    private static FastReader SC = new FastReader();
    private static int N, M, K;


    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int[] front = new int[2];
        int[] back = new int[2];

        front[0] = M;
        front[1] = N - M;
        back[0] = K;
        back[1] = N - K;

        int res = Math.min(front[0], back[0]) + Math.min(front[1], back[1]);
        System.out.println(res);
    }


    private static void input() {
        N = SC.nextInt();
        M = SC.nextInt();
        K = SC.nextInt();
    }
}
