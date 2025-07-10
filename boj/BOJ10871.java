package boj;

public class BOJ10871 {
    private static FastReader SC = new FastReader();
    private static int N, X;
    private static int[] NUMS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            if (NUMS[i] < X) {
                sb.append(NUMS[i]).append(' ');
            }
        }

        System.out.println(sb);
    }

    private static void input() {
        N = SC.nextInt();
        X = SC.nextInt();
        NUMS = new int[N];
        for (int i = 0; i < N; i++) {
            NUMS[i] = SC.nextInt();
        }
    }
}
