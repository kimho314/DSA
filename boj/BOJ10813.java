package boj;

public class BOJ10813 {
    private static FastReader SC = new FastReader();
    private static int N, M;
    private static int[] NUMS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        while (M > 0) {
            M--;

            int i = SC.nextInt();
            int j = SC.nextInt();

            int tmp = NUMS[i - 1];
            NUMS[i - 1] = NUMS[j - 1];
            NUMS[j - 1] = tmp;
        }

        for (int i = 0; i < N; i++) {
            System.out.print(NUMS[i] + " ");
        }
    }

    private static void input() {
        N = SC.nextInt();
        M = SC.nextInt();

        NUMS = new int[N];
        for (int i = 0; i < N; i++) {
            NUMS[i] = i + 1;
        }
    }
}
