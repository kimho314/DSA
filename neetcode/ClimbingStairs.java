public class ClimbingStairs {
    public static void main(String[] args) {
        ClimbingStairs sol = new ClimbingStairs();
        int res = sol.climbStairs(2); // 2
        System.out.println(res);
        res = sol.climbStairs(3); // 3
        System.out.println(res);
        res = sol.climbStairs(4); // 5
        System.out.println(res);
    }

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
