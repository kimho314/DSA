package boj;

public class BOJ13900 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static int[] NUMS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += NUMS[i];
        }

        long res = 0;
        for (int i = 0; i < N; i++) {
            sum -= NUMS[i];
            res += sum * NUMS[i];
        }

        System.out.println(res);
    }

    private static void input() {
        N = SC.nextInt();
        NUMS = new int[N];
        for (int i = 0; i < N; i++) {
            NUMS[i] = SC.nextInt();
        }
    }
}
