package boj;

public class BOJ2562 {
    private static FastReader SC = new FastReader();
    private static int[] NUMS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int max = -1;
        int idx = -1;
        for (int i = 0; i < 9; i++) {
            if (max < NUMS[i]) {
                max = NUMS[i];
                idx = i + 1;
            }
        }

        System.out.println(max);
        System.out.println(idx);
    }

    private static void input() {
        NUMS = new int[9];
        for (int i = 0; i < 9; i++) {
            NUMS[i] = SC.nextInt();
        }
    }
}
