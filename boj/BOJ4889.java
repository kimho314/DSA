package boj;

import java.util.Stack;

public class BOJ4889 {
    static FastReader SC = new FastReader();
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        int idx = 0;
        while (true) {
            String input = SC.nextLine();
            if (input.contains("-")) {
                break;
            }
            ++idx;
            Stack<Character> stack = new Stack<>();
            for (char ch : input.toCharArray()) {
                if (ch == '}') {
                    if (stack.isEmpty()) {
                        stack.push(ch);
                    }
                    else {
                        if (stack.peek() == '{') {
                            stack.pop();
                        }
                        else {
                            stack.push(ch);
                        }
                    }
                }
                else {
                    stack.push(ch);
                }
            }

            int cnt = 0;
            while (!stack.isEmpty()) {
                char ch1 = stack.pop();
                char ch2 = stack.pop();
                if (ch1 == ch2) {
                    cnt += 1;
                }
                else {
                    cnt += 2;
                }
            }
            SB.append(idx).append(". ").append(cnt).append("\n");
        }
        System.out.println(SB.toString());
    }
}
