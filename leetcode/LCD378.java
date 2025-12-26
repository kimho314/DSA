package leetcode;

import java.util.*;
import java.io.*;

public class LCD378 {
    public static void main(String[] args) {
        LCD378 sol = new LCD378();
        int res = sol.kthSmallest(new int[][] {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}}, 8);
        System.out.println(res); // 13
        res = sol.kthSmallest(new int[][] {{-5}}, 1);
        System.out.println(res); // -5
        res = sol.kthSmallest(new int[][] {{1, 3, 5}, {6, 7, 12}, {11, 14, 14}}, 3);
        System.out.println(res); // 5
    }

    private class Pair implements Comparable<Pair> {
        public int value;
        public int elemIdx;
        public int listIdx;

        public Pair(int value, int elemIdx, int listIdx) {
            this.value = value;
            this.elemIdx = elemIdx;
            this.listIdx = listIdx;
        }

        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.value, other.value);
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        if (matrix.length == 0 || k == 0) {
            return Integer.MIN_VALUE;
        }

        int n = matrix.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.offer(new Pair(matrix[i][0], 0, i));
        }
        int res = Integer.MIN_VALUE;
        int cnt = 0;
        // List<Integer> list = new ArrayList<>();
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            cnt++;
            // list.add(p.value);
            if (cnt == k) {
                res = p.value;
                break;
            }

            int nextIdx = p.elemIdx + 1;
            if (nextIdx < matrix[p.listIdx].length) {
                pq.offer(new Pair(matrix[p.listIdx][nextIdx], nextIdx, p.listIdx));
            }
        }
        // System.out.println(list);

        return res;
    }
}
