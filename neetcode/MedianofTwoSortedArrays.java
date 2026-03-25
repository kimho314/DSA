import java.util.Arrays;

public class MedianofTwoSortedArrays {
    public static void main(String[] args) {
        MedianofTwoSortedArrays sol = new MedianofTwoSortedArrays();
        System.out.println(sol.findMedianSortedArrays(new int[] {1, 2}, new int[] {3}));
        System.out.println(sol.findMedianSortedArrays(new int[] {1, 3}, new int[] {2, 4}));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A = nums1;
        int[] B = nums2;
        int total = A.length + B.length;
        int half = (total + 1) / 2;

        if (B.length < A.length) {
            int[] tmp = A;
            A = B;
            B = tmp;
        }

        int l = 0;
        int r = A.length;
        while (l <= r) {
            int i = (l + r) / 2;
            int j = half - i;

            int Aleft = i > 0 ? A[i - 1] : Integer.MIN_VALUE;
            int Aright = i < A.length ? A[i] : Integer.MAX_VALUE;
            int Bleft = j > 0 ? B[j - 1] : Integer.MIN_VALUE;
            int Bright = j < B.length ? B[j] : Integer.MAX_VALUE;

            if (Aleft <= Bright && Bleft <= Aright) {
                if (total % 2 != 0) {
                    return Math.max(Aleft, Bleft);
                }
                return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;
            } else if (Aleft > Bright) {
                r = i - 1;
            } else {
                l = i + 1;
            }
        }

        return -1;
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
