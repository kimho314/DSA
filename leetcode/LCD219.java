package leetcode;

import java.util.*;

public class LCD219 {
    public static void main(String[] args) {
        LCD219 sol = new LCD219();
        System.out.println(sol.containsNearbyDuplicate(new int[] {1, 2, 3, 1}, 3));
        System.out.println(sol.containsNearbyDuplicate(new int[] {1, 0, 1, 1}, 1));
        System.out.println(sol.containsNearbyDuplicate(new int[] {1, 2, 3, 1, 2, 3}, 2));
    }

    /**
     * My strategy is to keep track of the latest index at which each number appears, which I'll
     * call index j. This index represents the closest position for that number from the current
     * index.
     * 
     * This approach works because we need to find duplicate numbers within a distance of k from the
     * current index i, so the closer the previous index j is to the current index i, the more
     * likely we are to find an answer.
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (seen.containsKey(val) && i - seen.get(val) <= k) {
                return true;
            }
            seen.put(val, i);
        }

        return false;
    }
}
