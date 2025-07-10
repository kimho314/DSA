package boj;

import java.util.ArrayDeque;

public class BOJ10799 {
    private static FastReader SC = new FastReader();
    private static String INPUT;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        int res = 0;
        for (int i = 0; i < INPUT.length(); i++) {
            if (INPUT.charAt(i) == '(') {
                if (i < INPUT.length() - 1 && INPUT.charAt(i + 1) == ')') {
                    res += stack.size();
                    i++;
                }
                else {
                    stack.addLast(INPUT.charAt(i));
                }
                continue;
            }
            if (INPUT.charAt(i) == ')') {
                if (!stack.isEmpty()) {
                    stack.removeFirst();
                }
                res++;
            }
        }

        System.out.println(res);
    }

    private static void input() {
        INPUT = SC.nextLine();
    }
}
