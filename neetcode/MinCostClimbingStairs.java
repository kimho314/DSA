public class MinCostClimbingStairs {
    public static void main(String[] args) {
        MinCostClimbingStairs sol = new MinCostClimbingStairs();
        int res = sol.minCostClimbingStairs(new int[] {1, 2, 3});
        System.out.println(res); // 2
        res = sol.minCostClimbingStairs(new int[] {1, 2, 1, 2, 1, 1, 1});
        System.out.println(res); // 4
    }

    public int minCostClimbingStairs(int[] cost) {
        // dp[0] = 0, dp[1] = 0
        // dp[i] = min(dp[i-1]+cost[i-1], dp[i-2]+cost[i-2])

        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }

        return dp[cost.length];
    }
}
