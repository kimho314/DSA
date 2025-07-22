package leetcode;

import java.util.*;

public class LCD739 {
    public static void main(String[] args) {
        LCD739 sol = new LCD739();
        System.out.println(
                Arrays.toString(sol.dailyTemperatures(new int[] {73, 74, 75, 71, 69, 72, 76, 73})));
        System.out.println(Arrays.toString(sol.dailyTemperatures(new int[] {30, 40, 50, 60})));
        System.out.println(Arrays.toString(sol.dailyTemperatures(new int[] {30, 60, 90})));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];
        ArrayDeque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < len; i++) {
            while (!dq.isEmpty() && temperatures[i] > temperatures[dq.peekLast()]) {
                int idx = dq.pollLast();
                res[idx] = i - idx;
            }
            dq.addLast(i);
        }

        return res;
    }
}
