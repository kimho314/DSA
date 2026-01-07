package leetcode;

import java.util.*;

public class LCD496 {
    public static void main(String[] args) {
        LCD496 sol = new LCD496();
        int[] res = sol.nextGreaterElement(new int[] {4, 1, 2}, new int[] {1, 3, 4, 2});
        IO.println(Arrays.toString(res));
        res = sol.nextGreaterElement(new int[] {2, 4}, new int[] {1, 2, 3, 4});
        IO.println(Arrays.toString(res));
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums2.length == 0) {
            return new int[0];
        }

        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if (!map.containsKey(nums1[i])) {
                map.put(nums1[i], i);
            }
        }

        int len = nums2.length;
        Stack<Integer> s = new Stack<>();
        // int[] tmp = new int[len];
        // Arrays.fill(tmp, -1);
        for (int i = 0; i < len; i++) {
            while (!s.isEmpty() && nums2[s.peek()] < nums2[i]) {
                int idx = s.pop();
                // tmp[idx] = nums2[i];
                if (map.containsKey(nums2[idx])) {
                    res[map.get(nums2[idx])] = nums2[i];
                }
            }
            s.push(i);
        }
        // System.out.println(map);
        // System.out.println(Arrays.toString(tmp));
        return res;
    }

    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        if (nums2.length == 0) {
            return new int[0];
        }

        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if (!map.containsKey(nums1[i])) {
                map.put(nums1[i], i);
            }
        }

        int len = nums2.length;
        for (int i = 0; i < len; i++) {
            if (!map.containsKey(nums2[i])) {
                continue;
            }
            for (int j = i + 1; j < len; j++) {
                if (nums2[i] < nums2[j]) {
                    res[map.get(nums2[i])] = nums2[j];
                    break;
                }
            }
        }
        return res;
    }
}
