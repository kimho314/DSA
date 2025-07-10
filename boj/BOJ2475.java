package boj;

public class BOJ2475 {
    private static FastReader SC = new FastReader();
    private static int[] NUMS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int sum = 0;
        int res = 0;

        for (int i = 0; i < 5; i++) {
            sum += (NUMS[i] * NUMS[i]);
        }
        res = sum % 10;

        System.out.println(res);
    }

    private static void input() {
        NUMS = new int[5];
        for (int i = 0; i < 5; i++) {
            NUMS[i] = SC.nextInt();
        }
    }
}
