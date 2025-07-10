package boj;

public class BOJ10818 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static int[] NUMS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            if (min > NUMS[i]) {
                min = NUMS[i];
            }
            if (max < NUMS[i]) {
                max = NUMS[i];
            }
        }

        System.out.println(min + " " + max);
    }

    private static void input() {
        N = SC.nextInt();
        NUMS = new int[N];
        for (int i = 0; i < N; i++) {
            NUMS[i] = SC.nextInt();
        }
    }
}
