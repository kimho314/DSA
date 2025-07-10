package boj;

import java.util.Deque;
import java.util.LinkedList;

public class BOJ10866 {
    static FastReader SC = new FastReader();
    static StringBuilder SB = new StringBuilder();
    static int N;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String op = SC.next();
            switch (op) {
                case "push_front":
                    int x = SC.nextInt();
                    deque.addFirst(x);
                    break;
                case "push_back":
                    x = SC.nextInt();
                    deque.addLast(x);
                    break;
                case "pop_front":
                    x = deque.isEmpty() ? -1 : deque.removeFirst();
                    SB.append(x).append('\n');
                    break;
                case "pop_back":
                    x = deque.isEmpty() ? -1 : deque.removeLast();
                    SB.append(x).append('\n');
                    break;
                case "size":
                    int size = deque.size();
                    SB.append(size).append('\n');
                    break;
                case "empty":
                    int empty = deque.isEmpty() ? 1 : 0;
                    SB.append(empty).append('\n');
                    break;
                case "front":
                    int front = deque.isEmpty() ? -1 : deque.getFirst();
                    SB.append(front).append('\n');
                    break;
                case "back":
                    int back = deque.isEmpty() ? -1 : deque.getLast();
                    SB.append(back).append('\n');
                    break;
                default:
                    break;
            }
        }

        System.out.println(SB.toString());
    }


    private static void input() {
        N = SC.nextInt();
    }
}
