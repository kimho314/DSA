import java.util.*;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        SlidingWindowMaximum sol = new SlidingWindowMaximum();
        System.out
                .println(Arrays.toString(sol.maxSlidingWindow(new int[] {1, 2, 1, 0, 4, 2, 6}, 3)));
        System.out.println(Arrays.toString(sol.maxSlidingWindow(new int[] {1, -1}, 1)));
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        int[] output = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            int maxi = nums[i];
            for (int j = i; j < i + k; j++) {
                maxi = Math.max(maxi, nums[j]);
            }
            output[i] = maxi;
        }

        return output;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int[] output = new int[nums.length - k + 1];
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            heap.offer(new int[] {nums[i], i});
            if (i >= k - 1) {
                while (heap.peek()[1] <= i - k) {
                    heap.poll();
                }
                output[idx++] = heap.peek()[0];
            }
        }
        return output;
    }
}
