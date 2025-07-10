package boj;

import java.util.Deque;
import java.util.LinkedList;

public class BOJ28279 {
    static FastReader SC = new FastReader();
    static int N;
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        N = SC.nextInt();
        Deque<Integer> deque = new LinkedList<>();
        while (N > 0) {
            N--;
            int op = SC.nextInt();
            switch (op) {
                case 1:
                    int num = SC.nextInt();
                    deque.addFirst(num);
                    break;
                case 2:
                    num = SC.nextInt();
                    deque.addLast(num);
                    break;
                case 3:
                    num = deque.isEmpty() ? -1 : deque.removeFirst();
                    SB.append(num).append('\n');
                    break;
                case 4:
                    num = deque.isEmpty() ? -1 : deque.removeLast();
                    SB.append(num).append('\n');
                    break;
                case 5:
                    SB.append(deque.size()).append('\n');
                    break;
                case 6:
                    SB.append(deque.isEmpty() ? 1 : 0).append('\n');
                    break;
                case 7:
                    num = deque.isEmpty() ? -1 : deque.peekFirst();
                    SB.append(num).append('\n');
                    break;
                case 8:
                    num = deque.isEmpty() ? -1 : deque.peekLast();
                    SB.append(num).append('\n');
                    break;
            }
        }
        System.out.println(SB.toString());
    }
}
