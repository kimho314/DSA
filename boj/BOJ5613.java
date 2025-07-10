package boj;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class BOJ5613 {
    private static FastReader SC = new FastReader();
    private static ArrayDeque<Integer> NUMS;
    private static ArrayList<String> OPS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        StringBuilder sb = new StringBuilder();
        while (!OPS.isEmpty()) {
            String op = OPS.remove(0);
            if (op.equals("=")) {
                sb.append(NUMS.getFirst());
                break;
            }
            int num1 = NUMS.pollFirst();
            int num2 = NUMS.pollFirst();
            int res = Integer.MIN_VALUE;
            switch (op) {
                case "+":
                    res = num1 + num2;
                    break;
                case "-":
                    res = num1 - num2;
                    break;
                case "*":
                    res = num1 * num2;
                    break;
                case "/":
                    res = num1 / num2;
                    break;
            }
//            System.out.println(num1 + " " + num2 + " " + op + " " + res);
            NUMS.addFirst(res);
        }

        System.out.println(sb);
    }

    private static void input() {
        NUMS = new ArrayDeque<>();
        OPS = new ArrayList<>();

        while (true) {
            String str = SC.nextLine();
            if (str.equals("=")) {
                OPS.add(str);
                break;
            }
            if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
                OPS.add(str);
            }
            else {
                NUMS.addLast(Integer.parseInt(str));
            }
        }
    }
}
