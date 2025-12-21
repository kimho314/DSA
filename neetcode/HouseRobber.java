public class HouseRobber {
    public static void main(String[] args) {
        HouseRobber sol = new HouseRobber();
        int res = sol.rob(new int[] {1, 1, 3, 3});
        System.out.println(res);
        res = sol.rob(new int[] {2, 9, 8, 3, 6});
        System.out.println(res);
    }

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }

        return dp[nums.length - 1];
    }
}
