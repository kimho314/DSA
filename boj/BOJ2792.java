package boj;

public class BOJ2792 {
    private static FastReader SC = new FastReader();
    private static int N, M;
    private static int[] NUMS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int l = 1;
        int r = 0;
        for (int num : NUMS) {
            if (num > r) {
                r = num;
            }
        }

        while (l < r) {
            int mid = (l + r) / 2;
            long sum = 0;

            for (int num : NUMS) {
                if (num % mid == 0) {
                    sum += num / mid;
                }
                else {
                    sum += num / mid + 1;
                }
            }

            if (sum > N) {
                l = mid + 1;
            }
            else {
                r = mid;
            }
        }

        System.out.println(l);
    }

    private static void input() {
        N = SC.nextInt();
        M = SC.nextInt();
        NUMS = new int[M];
        for (int i = 0; i < M; i++) {
            NUMS[i] = SC.nextInt();
        }
    }
}
