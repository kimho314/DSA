public class MaximumProductSubarray {
    public static void main(String[] args) {
        MaximumProductSubarray sol = new MaximumProductSubarray();
        int res = sol.maxProduct(new int[] {1, 2, -3, 4});
        IO.println(res);
        res = sol.maxProduct(new int[] {-2, -1});
        IO.println(res);
        res = sol.maxProduct(new int[] {-2, 3, -4});
        IO.println(res);
        res = sol.maxProduct(new int[] {2, 3, -2, 4});
        IO.println(res);
    }

    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int len = nums.length;
        int[][] dp = new int[len][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(nums[i], Math.max(dp[i - 1][0] * nums[i], dp[i - 1][1] * nums[i]));
            dp[i][1] = Math.min(nums[i], Math.min(dp[i - 1][0] * nums[i], dp[i - 1][1] * nums[i]));
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, dp[i][0]);
            // System.out.println(i + " " + dp[i][0] + " " + dp[i][1]);
        }

        return res;
    }

    public int maxProduct2(int[] nums) {
        int res = nums[0];
        int curMin = 1, curMax = 1;

        for (int num : nums) {
            int tmp = curMax * num;
            curMax = Math.max(Math.max(num * curMax, num * curMin), num);
            curMin = Math.min(Math.min(tmp, num * curMin), num);
            res = Math.max(res, curMax);
        }

        return res;
    }
}
