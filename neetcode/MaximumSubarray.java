public class MaximumSubarray {
    public static void main(String[] args) {
        MaximumSubarray sol = new MaximumSubarray();
        int res = sol.maxSubArray(new int[] {2, -3, 4, -2, 2, 1, -1, 4});
        IO.println(res);
        res = sol.maxSubArray(new int[] {-1});
        IO.println(res);
        res = sol.maxSubArray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4});
        IO.println(res);
    }

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }

        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public int maxSubArray2(int[] nums) {
        int len = nums.length;
        int res = nums[0];
        for (int i = 0; i < len; i++) {
            int cur = 0;
            for (int j = i; j < len; j++) {
                cur += nums[j];
                res = Math.max(res, cur);
            }
        }
        return res;
    }
}
