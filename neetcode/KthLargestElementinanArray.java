import java.util.*;

public class KthLargestElementinanArray {
    public static void main(String[] args) {
        KthLargestElementinanArray sol = new KthLargestElementinanArray();
        int res = sol.findKthLargest(new int[] {2, 3, 1, 5, 4}, 2);
        System.out.println(res);
        res = sol.findKthLargest(new int[] {2, 3, 1, 5, 4}, 2);
        System.out.println(res);
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int elem : nums) {
            pq.add(elem);
        }

        int cnt = 0;
        while (true) {
            int n = pq.poll();
            if (cnt == k - 1) {
                return n;
            }
            cnt++;
        }
    }
}
