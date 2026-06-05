package neetcode;

import java.util.*;

/**
 * https://neetcode.io/problems/three-integer-sum?list=neetcode150
 */
public class ThreeSum {
    public static void main(String[] args) {
        ThreeSum sol = new ThreeSum();
        System.out.println(sol.threeSum(new int[]{-1, 0, 1, 2, -1, -4})); // [[-1,-1,2],[-1,0,1]]
        System.out.println(sol.threeSum(new int[]{0, 1, 1})); // []
        System.out.println(sol.threeSum(new int[]{0, 0, 0})); // [[0,0,0]]

    }

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                if (set.contains(0 - nums[i] - nums[j])) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(0 - nums[i] - nums[j]);
                    // System.out.println(i+" "+j+" "+list);
                    res.add(list);
                }
                set.add(nums[j]);
            }
        }
        return new ArrayList<>(res);
    }
}
