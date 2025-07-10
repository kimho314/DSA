package boj;

import java.util.LinkedList;
import java.util.ListIterator;

public class BOJ1406 {
    private static FastReader SC = new FastReader();
    private static int N, M;
    private static LinkedList<Character> CHARS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        ListIterator<Character> iterator = CHARS.listIterator();
        while (iterator.hasNext()) { // 커서 맨 뒤로 옮기기
            iterator.next();
        }

        while (M > 0) {
            M--;
            String op = SC.next();
            if (op.equals("L")) {
                if (iterator.hasPrevious()) { // 이전 요소가 있다면
                    iterator.previous(); // 커서 위치를 왼쪽으로 이동
                }
            } else if (op.equals("D")) {
                if (iterator.hasNext()) { // 다음 요소가 있다면
                    iterator.next(); // 커서 위치를 오른쪽으로 이동
                }
            } else if (op.equals("B")) {
                if (iterator.hasPrevious()) { // 왼쪽에 문자가 있다면
                    iterator.previous(); // 커서를 왼쪽으로 이동하고
                    iterator.remove(); // 그 위치의 문자 삭제하기
                }
            } else if (op.equals("P")) {
                char ch = SC.next().charAt(0);
                iterator.add(ch);
            } else {
                throw new IllegalArgumentException();
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character s : CHARS) {
            sb.append(s);
        }
        System.out.println(sb.toString());
    }

    private static void input() {
        String STR = SC.next();
        N = STR.length();
        M = SC.nextInt();
        CHARS = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            CHARS.add(STR.charAt(i));
        }
    }
}
