import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        CoinChange sol = new CoinChange();
        int res = sol.coinChange(new int[] {1, 5, 10}, 12);
        System.out.println(res); // 3
        res = sol.coinChange(new int[] {2}, 3);
        System.out.println(res); // -1
        res = sol.coinChange(new int[] {1}, 0);
        System.out.println(res); // 0
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);

        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
