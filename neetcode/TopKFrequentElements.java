package neetcode;

import java.util.*;

/**
 * https://neetcode.io/problems/top-k-elements-in-list?list=neetcode150
 */
public class TopKFrequentElements {
    public static void main(String[] args) {
        TopKFrequentElements sol = new TopKFrequentElements();
        System.out.println(Arrays.toString(sol.topKFrequent(new int[] {1, 2, 2, 3, 3, 3}, 2)));
        System.out.println(Arrays.toString(sol.topKFrequent(new int[] {7, 7}, 1)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int elem : nums) {
            map.put(elem, map.getOrDefault(elem, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq =
                new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        for (Map.Entry<Integer, Integer> elem : map.entrySet()) {
            pq.add(elem);
        }

        int[] res = new int[k];
        int cnt = 0;
        while (cnt < k) {
            Map.Entry<Integer, Integer> m = pq.poll();
            // System.out.println(m);
            res[cnt++] = m.getKey();
        }
        return res;
    }
}
