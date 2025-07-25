package neetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://neetcode.io/problems/three-integer-sum?list=neetcode150
 */
public class ThreeSum {
    public static void main(String[] args) {
        ThreeSum sol = new ThreeSum();
        System.out.println(sol.threeSum(new int[] {-1, 0, 1, 2, -1, -4})); // [[-1,-1,2],[-1,0,1]]
        System.out.println(sol.threeSum(new int[] {0, 1, 1})); // []
        System.out.println(sol.threeSum(new int[] {0, 0, 0})); // [[0,0,0]]

    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Map<String, List<Integer>> map = new HashMap<>();
        int len = nums.length;

        for (int i = 0; i < len - 2; i++) {
            int l = i + 1;
            int r = len - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    String key = nums[i] + "" + nums[l] + "" + nums[r];
                    if (!map.containsKey(key)) {
                        map.put(key, List.of(nums[i], nums[l], nums[r]));
                    }
                    l++;
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }


        return new ArrayList<>(map.values());
    }
}
