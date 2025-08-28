import java.util.Arrays;

public class MedianofTwoSortedArrays {
    public static void main(String[] args) {
        MedianofTwoSortedArrays sol = new MedianofTwoSortedArrays();
        System.out.println(sol.findMedianSortedArrays(new int[] {1, 2}, new int[] {3}));
        System.out.println(sol.findMedianSortedArrays(new int[] {1, 3}, new int[] {2, 4}));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int[] res = new int[len];
        int idx = 0;
        for (int elem : nums1) {
            res[idx++] = elem;
        }
        for (int elem : nums2) {
            res[idx++] = elem;
        }
        Arrays.sort(res);

        if (len % 2 == 1) {
            return res[len / 2];
        } else {
            return (double) (res[len / 2 - 1] + res[len / 2]) / 2.0;
        }
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int[] res = new int[len];
        int idx = 0;
        int l = 0, r = 0;
        while (l < nums1.length && r < nums2.length) {
            if (nums1[l] <= nums2[r]) {
                res[idx] = nums1[l];
                l++;
            } else {
                res[idx] = nums2[r];
                r++;
            }

            idx++;
        }

        while (l < nums1.length) {
            res[idx++] = nums1[l++];
        }
        while (r < nums2.length) {
            res[idx++] = nums2[r++];
        }

        if (len % 2 == 1) {
            return res[len / 2];
        } else {
            return (double) (res[len / 2 - 1] + res[len / 2]) / 2.0;
        }
    }
}
