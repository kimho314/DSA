package boj;

import java.util.ArrayDeque;

public class BOJ17413 {
    private static FastReader SC = new FastReader();
    private static String S;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        boolean isTag = false;
        ArrayDeque<Character> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (char ch : S.toCharArray()) {
            if (ch == '<' && !isTag) {
                while (!dq.isEmpty()) {
                    sb.append(dq.pollLast());
                }
                dq.addLast(ch);
                isTag = true;
            }
            else if (ch == '>' && isTag) {
                dq.addLast(ch);
                isTag = false;
                while (!dq.isEmpty()) {
                    sb.append(dq.pollFirst());
                }
            }
            else if (Character.isDigit(ch) || Character.isLowerCase(ch)) {
                dq.addLast(ch);
            }
            else {
                if (!isTag) {
                    while (!dq.isEmpty()) {
                        sb.append(dq.pollLast());
                    }
                    sb.append(ch);
                }
                else {
                    dq.addLast(ch);
                }
            }
        }
        while (!dq.isEmpty()) {
            sb.append(dq.pollLast());
        }

        System.out.println(sb);
    }

    private static void input() {
        S = SC.nextLine();
    }
}
