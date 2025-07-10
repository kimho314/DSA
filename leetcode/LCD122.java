package leetcode;

public class LCD122 {
    public static void main(String[] args) {
        LCD122 sol = new LCD122();
        System.out.println(sol.maxProfit(new int[] {7, 1, 5, 3, 6, 4}));
        System.out.println(sol.maxProfit(new int[] {1, 2, 3, 4, 5}));
        System.out.println(sol.maxProfit(new int[] {7, 6, 4, 3, 1}));
    }

    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                res += (prices[i + 1] - prices[i]);
            }
        }
        return res;
    }
}
