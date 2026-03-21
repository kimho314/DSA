

public class BestTimetoBuyandSellStock {
    public static void main(String[] args) {
        BestTimetoBuyandSellStock sol = new BestTimetoBuyandSellStock();
        IO.println(sol.maxProfit(new int[] {7, 1, 5, 3, 6, 4}));
        IO.println(sol.maxProfit(new int[] {7, 6, 4, 3, 1}));
    }

    public int maxProfit(int[] prices) {
        int l = 0, r = 1;
        int maxProfit = 0;
        while (r < prices.length) {
            if (prices[l] < prices[r]) {
                int profit = prices[r] - prices[l];
                maxProfit = Math.max(maxProfit, profit);
            } else {
                l = r;
            }
            r++;
        }

        return maxProfit;
    }
}
