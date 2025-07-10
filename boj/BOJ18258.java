package boj;

import java.util.Deque;
import java.util.LinkedList;

public class BOJ18258 {
    static FastReader SC = new FastReader();
    static int N;
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        N = SC.nextInt();
        Deque<Integer> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String op = SC.next();
            switch (op) {
                case "push":
                    int x = SC.nextInt();
                    queue.offer(x);
                    break;
                case "pop":
                    x = queue.isEmpty() ? -1 : queue.pollFirst();
                    SB.append(x).append('\n');
                    break;
                case "size":
                    SB.append(queue.size()).append('\n');
                    break;
                case "empty":
                    SB.append(queue.isEmpty() ? 1 : 0).append('\n');
                    break;
                case "front":
                    SB.append(queue.isEmpty() ? -1 : queue.peekFirst()).append('\n');
                    break;
                case "back":
                    SB.append(queue.isEmpty() ? -1 : queue.peekLast()).append('\n');
                    break;
                default:
                    break;
            }
        }

        System.out.println(SB.toString());
    }
}
