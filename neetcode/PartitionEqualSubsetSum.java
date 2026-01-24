public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        PartitionEqualSubsetSum sol = new PartitionEqualSubsetSum();
        boolean res = sol.canPartition(new int[] { 1, 2, 3, 4 });
        IO.println(res);
        res = sol.canPartition(new int[] { 1, 2, 3, 4, 5 });
        IO.println(res);
    }

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;
        boolean[][] dp = new boolean[n + 1][target + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][target];
    }

    public boolean canPartition2(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        if (totalSum % 2 != 0) {
            return false;
        }

        return dfs(0, totalSum, 0, nums);
    }

    private boolean dfs(int leftSum, int rightSum, int idx, int[] nums) {
        if (idx == nums.length) {
            return false;
        }
        if (leftSum == rightSum) {
            return true;
        }

        return dfs(leftSum + nums[idx], rightSum - nums[idx], idx + 1, nums) ||
                dfs(leftSum, rightSum, idx + 1, nums);
    }
}
