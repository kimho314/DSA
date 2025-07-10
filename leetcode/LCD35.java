package leetcode;

public class LCD35 {
    public static void main(String[] args) {
        LCD35 lcd35 = new LCD35();

        System.out.println(lcd35.searchInsert(new int[] {1, 3, 5, 6}, 5));
        System.out.println(lcd35.searchInsert(new int[] {1, 3, 5, 6}, 2));
        System.out.println(lcd35.searchInsert(new int[] {1, 3, 5, 6}, 7));
    }

    public int searchInsert(int[] nums, int target) {
        if (target <= nums[0]) {
            return 0;
        }
        if (target == nums[nums.length - 1]) {
            return nums.length - 1;
        }
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        int l = 0;
        int r = nums.length - 1;
        int res = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] >= target) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return res;
    }
}
