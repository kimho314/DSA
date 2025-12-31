public class MaximumProductSubarray {
    public static void main(String[] args) {
        MaximumProductSubarray sol = new MaximumProductSubarray();
        int res = sol.maxProduct(new int[] {1, 2, -3, 4});
        IO.println(res);
        res = sol.maxProduct(new int[] {-2, -1});
        IO.println(res);
        res = sol.maxProduct(new int[] {-2, 3, -4});
        IO.println(res);
        res = sol.maxProduct(new int[] {2, 3, -2, 4});
        IO.println(res);
    }

    public int maxProduct(int[] nums) {
        int res = nums[0];
        int curMin = 1, curMax = 1;

        for (int num : nums) {
            int tmp = curMax * num;
            curMax = Math.max(Math.max(num * curMax, num * curMin), num);
            curMin = Math.min(Math.min(tmp, num * curMin), num);
            res = Math.max(res, curMax);
        }

        return res;
    }
}
