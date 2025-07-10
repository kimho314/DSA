package boj;

import java.util.Stack;

public class BOJ28278 {
    static FastReader SC = new FastReader();
    static int N;
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        N = SC.nextInt();
        for (int i = 0; i < N; i++) {
            int op = SC.nextInt();
            switch (op) {
                case 1:
                    int num = SC.nextInt();
                    stack.push(num);
                    break;
                case 2:
                    if (stack.isEmpty()) {
                        SB.append(-1).append('\n');
                    }
                    else {
                        int top = stack.pop();
                        SB.append(top).append('\n');
                    }
                    break;
                case 3:
                    SB.append(stack.size()).append('\n');
                    break;
                case 4:
                    if (stack.isEmpty()) {
                        SB.append(1).append('\n');
                    }
                    else {
                        SB.append(0).append('\n');
                    }
                    break;
                case 5:
                    if (stack.isEmpty()) {
                        SB.append(-1).append('\n');
                    }
                    else {
                        SB.append(stack.peek()).append('\n');
                    }
                    break;

            }
        }
        System.out.println(SB.toString());
    }


}
