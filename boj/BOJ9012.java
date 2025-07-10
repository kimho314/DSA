package boj;

import java.util.Stack;

public class BOJ9012 {
    static FastReader SC = new FastReader();
    static int T;
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        T = SC.nextInt();
        while (T > 0) {
            T--;
            String[] parentheses = SC.nextLine().split("");
            Stack<String> stack = new Stack<>();
            for (int i = 0; i < parentheses.length; i++) {
                if (!stack.isEmpty() && (stack.peek().equals("(") && parentheses[i].equals(")"))) {
                    stack.pop();
                }
                else {
                    stack.push(parentheses[i]);
                }
            }

            if (stack.isEmpty()) {
                SB.append("YES").append("\n");
            }
            else {
                SB.append("NO").append("\n");
            }
        }

        System.out.println(SB.toString());
    }
}
