package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LCD169 {
    public static void main(String[] args) {
        LCD169 sol = new LCD169();
        System.out.println(sol.majorityElement(new int[] {3, 2, 3}));
        System.out.println(sol.majorityElement(new int[] {2, 2, 1, 1, 1, 2, 2}));
    }

    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int elem : nums) {
            map.put(elem, map.getOrDefault(elem, 0) + 1);
        }
        int res = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                res = entry.getKey();
                break;
            }
        }
        return res;
    }
}
