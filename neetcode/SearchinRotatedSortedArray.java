public class SearchinRotatedSortedArray {
    public static void main(String[] args) {
        SearchinRotatedSortedArray sol = new SearchinRotatedSortedArray();
        System.out.println(sol.search(new int[] {3, 4, 5, 6, 1, 2}, 1));
        System.out.println(sol.search(new int[] {3, 5, 6, 0, 1, 2}, 4));
    }

    public int search(int[] nums, int target) {
        int pivot = 0;
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[r] < nums[mid]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        pivot = l;
        System.out.println("lower = " + pivot);

        int res = -1;
        l = 0;
        r = pivot - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if (res != -1) {
            return res;
        }

        l = pivot;
        r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;
    }
}
