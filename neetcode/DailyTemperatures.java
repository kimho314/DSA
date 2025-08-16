

import java.util.*;

public class DailyTemperatures {
    public static void main(String[] args) {
        DailyTemperatures sol = new DailyTemperatures();
        System.out.println(
                Arrays.toString(sol.dailyTemperatures(new int[] {30, 38, 30, 36, 35, 40, 28})));
        System.out.println(Arrays.toString(sol.dailyTemperatures(new int[] {22, 21, 20})));
    }

    public int[] dailyTemperatures2(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            int t = temperatures[i];
            while (!stack.isEmpty() && t > stack.peek()[0]) {
                int[] pair = stack.pop();
                res[pair[1]] = i - pair[1];
            }
            stack.push(new int[] {t, i});
        }

        return res;
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];

        for (int i = 0; i < len; i++) {
            int idx = i;
            for (int j = i + 1; j < len; j++) {
                if (temperatures[j] > temperatures[i]) {
                    idx = j;
                    break;
                }
            }

            int days = idx - i;
            res[i] = days;
        }

        return res;
    }


}
