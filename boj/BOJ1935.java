package boj;

import java.util.*;

public class BOJ1935 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static int[] NUMS;
    private static char[] ARR;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        ArrayDeque<Double> operands = new ArrayDeque<>();
        for (int i = 0; i < ARR.length; i++) {
            if (Character.isUpperCase(ARR[i])) {
                operands.addLast((double) NUMS[ARR[i] - 'A']);
            } else {
                if (operands.isEmpty()) {
                    continue;
                }
                char op = ARR[i];
                double n1 = operands.pollLast();
                double n2 = operands.pollLast();

                switch (op) {
                    case '+':
                        double res = n2 + n1;
                        operands.addLast(res);
                        break;
                    case '-':
                        res = n2 - n1;
                        operands.addLast(res);
                        break;
                    case '*':
                        res = n2 * n1;
                        operands.addLast(res);
                        break;
                    case '/':
                        res = n2 / n1;
                        operands.addLast(res);
                        break;
                }
            }
        }

        System.out.println(String.format("%.2f", operands.poll()));
    }


    private static void input() {
        N = SC.nextInt();
        ARR = SC.next().toCharArray();
        NUMS = new int[N];
        for (int i = 0; i < N; i++) {
            NUMS[i] = SC.nextInt();
        }
    }
}
