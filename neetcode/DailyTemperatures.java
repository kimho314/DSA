package neetcode;

import java.util.ArrayDeque;
import java.util.Arrays;

public class DailyTemperatures {
    public static void main(String[] args) {
        DailyTemperatures sol = new DailyTemperatures();
        System.out.println(
                Arrays.toString(sol.dailyTemperatures(new int[]{30, 38, 30, 36, 35, 40, 28})));
        System.out.println(Arrays.toString(sol.dailyTemperatures(new int[]{22, 21, 20})));
    }


    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];
        ArrayDeque<int[]> stack = new ArrayDeque<>();

        for (int i = 0; i < len; i++) {
            int t = temperatures[i];
            while (!stack.isEmpty() && stack.peek()[0] < t) {
                int[] top = stack.pollLast();
                int day = i - top[1];
                res[top[1]] = day;
            }
            stack.offerLast(new int[]{t, i});
        }

        return res;
    }


}
