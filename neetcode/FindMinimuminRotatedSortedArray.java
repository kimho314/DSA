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

            int mid = (l + r) / 2;
            res = Math.min(res, nums[mid]);
            if (nums[mid] >= nums[l]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }
}
