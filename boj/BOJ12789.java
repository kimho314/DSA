package boj;

import java.util.Stack;

public class BOJ12789 {
    static FastReader SC = new FastReader();
    static int N;

    public static void main(String[] args) {
        N = SC.nextInt();
        int[] students = new int[N];
        for (int i = 0; i < N; i++) {
            students[i] = SC.nextInt();
        }
        Stack<Integer> emptySpot = new Stack<>();
        Stack<Integer> queue = new Stack<>();
        int cnt = 0;
        while (cnt < N) {
            if (!queue.isEmpty() && !emptySpot.isEmpty() && queue.peek() == emptySpot.peek() - 1) {
                queue.push(emptySpot.pop());
                continue;
            }
            if (queue.isEmpty() && students[cnt] == 1) {
                queue.push(students[cnt]);
            }
            else {
                if (!queue.isEmpty() && queue.peek() == students[cnt] - 1) {
                    queue.push(students[cnt]);
                }
                else {
                    emptySpot.push(students[cnt]);
                }
            }

            cnt++;
        }

        while (!emptySpot.isEmpty()) {
            int top = emptySpot.peek();
            if (queue.peek() == top - 1) {
                queue.push(emptySpot.pop());
            }
            else {
                break;
            }
        }

        System.out.println(emptySpot.isEmpty() ? "Nice" : "Sad");
    }
}
