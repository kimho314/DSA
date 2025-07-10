package boj;

import java.util.Stack;

public class BOJ10773 {
    static FastReader SC = new FastReader();
    static int K;

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        K = SC.nextInt();
        for (int i = 0; i < K; i++) {
            int num = SC.nextInt();
            if (num == 0) {
                stack.pop();
            }
            else {
                stack.push(num);
            }
        }

        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        System.out.println(res);
    }
}
