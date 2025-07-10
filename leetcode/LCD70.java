package leetcode;

public class LCD70 {
    public static void main(String[] args) {
        LCD70 sol = new LCD70();
        System.out.println(sol.climbStairs(2)); // 2
        System.out.println(sol.climbStairs(3)); // 3
        System.out.println(sol.climbStairs(4)); // 5
    }

    public int climbStairs(int n) {
        int[][] dp = new int[45 + 1][2];
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[1][0] = 1;
        dp[1][1] = 0;
        dp[2][0] = 1;
        dp[2][1] = 1;
        for (int i = 3; i <= 45; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
            dp[i][1] = dp[i - 2][0] + dp[i - 2][1];
        }

        int res = dp[n][0] + dp[n][1];
        return res;
    }
}
