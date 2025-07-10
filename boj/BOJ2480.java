package boj;

public class BOJ2480 {
    private static FastReader SC = new FastReader();
    private static int[] NUMS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int num = 0;
        int res = 0;
        for (int i = 1; i < NUMS.length; i++) {
            if (NUMS[i] == 3) {
                res = 10_000 + (i * 1_000);
                num = i;
                break;
            }
            if (NUMS[i] == 2) {
                res = 1_000 + (i * 100);
                num = i;
                break;
            }
            if (NUMS[i] == 1) {
                num = Math.max(num, i);
            }
        }

        if (res == 0) {
            System.out.println(num * 100);
        }
        else {
            System.out.println(res);
        }
    }

    private static void input() {
        NUMS = new int[7];

        for (int i = 0; i < 3; i++) {
            int num = SC.nextInt();
            NUMS[num]++;
        }
    }
}
