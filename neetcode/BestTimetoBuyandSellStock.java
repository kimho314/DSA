package neetcode;

public class BestTimetoBuyandSellStock {
    public static void main(String[] args) {
        BestTimetoBuyandSellStock sol = new BestTimetoBuyandSellStock();
        System.out.println(sol.maxProfit(new int[] {7, 1, 5, 3, 6, 4}));
        System.out.println(sol.maxProfit(new int[] {7, 6, 4, 3, 1}));
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        int len = prices.length;
        for (int i = 0; i < len; i++) {
            if (minPrice > prices[i]) {
                minPrice = prices[i];
            } else {
                int profit = prices[i] - minPrice;
                maxProfit = Math.max(maxProfit, profit);
            }
        }

        return maxProfit;
    }
}
