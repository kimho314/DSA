package boj;

import java.util.Stack;

public class BOJ4949 {
    static FastReader SC = new FastReader();
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        String s;

        while (true) {
            s = SC.nextLine();
            if (s.equals(".")) {
                break;
            }

            String res = solve(s);
            SB.append(res).append('\n');
        }
        System.out.println(SB.toString());
    }


    private static String solve(String input) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == '(' || c == '[') {
                stack.push(c);
            }
            if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return "no";
                }
                else {
                    stack.pop();
                }
            }
            if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    return "no";
                }
                else {
                    stack.pop();
                }
            }
        }

        if (stack.isEmpty()) {
            return "yes";
        }
        else {
            return "no";
        }
    }
}
