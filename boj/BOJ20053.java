package boj;

public class BOJ20053 {
    private static FastReader SC = new FastReader();
    private static int T;
    private static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        input();
        while (T > 0) {
            T--;
            int n = SC.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = SC.nextInt();
            }
            solve(nums);
        }
        System.out.println(SB);
    }

    private static void solve(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }

        SB.append(min).append(" ").append(max).append("\n");
    }

    private static void input() {
        T = SC.nextInt();
    }
}
