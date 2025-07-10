package leetcode;

public class LCD121 {
    public static void main(String[] args) {
        LCD121 sol = new LCD121();
        System.out.println(sol.maxProfit(new int[] {7, 1, 5, 3, 6, 4}));
        System.out.println(sol.maxProfit(new int[] {7, 6, 4, 3, 1}));
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (minPrice > prices[i]) {
                minPrice = prices[i];
            } else {
                int profit = prices[i] - minPrice;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }

        return maxProfit;
    }
}
