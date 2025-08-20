public class FindMinimuminRotatedSortedArray {
    public static void main(String[] args) {
        FindMinimuminRotatedSortedArray sol = new FindMinimuminRotatedSortedArray();
        System.out.println(sol.findMin(new int[] {3, 4, 5, 6, 1, 2}));
        System.out.println(sol.findMin(new int[] {4, 5, 0, 1, 2, 3}));
    }

    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int res = nums[0];

        while (l <= r) {
            if (nums[l] < nums[r]) {
                res = Math.min(res, nums[l]);
                break;
            }

            int m = l + (r - l) / 2;
            res = Math.min(res, nums[m]);
            if (nums[m] >= nums[l]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return res;
    }
}
