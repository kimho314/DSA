package boj;

public class BOJ15729 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static int[] NUMS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int res = 0;
        int[] nums = new int[N + 2];
        for (int i = 0; i < N; i++) {
            if (NUMS[i] != nums[i]) {
                res++;
                nums[i] = nums[i] == 1 ? 0 : 1;
                nums[i + 1] = nums[i + 1] == 1 ? 0 : 1;
                nums[i + 2] = nums[i + 2] == 1 ? 0 : 1;
            }
//            System.out.println(Arrays.toString(nums));
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
