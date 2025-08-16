

public class BinarySearch {
    public static void main(String[] args) {
        BinarySearch sol = new BinarySearch();
        System.out.println(sol.search(new int[] {-1, 0, 2, 4, 6, 8}, 4));
        System.out.println(sol.search(new int[] {-1, 0, 2, 4, 6, 8}, 3));
        System.out.println(sol.search(new int[] {-1, 0, 3, 5, 9, 12}, 9));
    }

    public int search(int[] nums, int target) {
        if (target == nums[0]) {
            return 0;
        }
        if (target == nums[nums.length - 1]) {
            return nums.length - 1;
        }

        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return -1;
    }
}
