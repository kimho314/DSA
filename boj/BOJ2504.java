package boj;

import java.util.*;

public class BOJ2504 {
    private static FastReader SC = new FastReader();
    private static char[] ARR;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void input() {
        ARR = SC.nextLine().toCharArray();
    }

    private static void solve() {
        int res = 0;
        int value = 1;
        ArrayDeque<Character> s = new ArrayDeque<>();

        for (int i = 0; i < ARR.length; i++) {
            if (ARR[i] == '(') {
                value *= 2;
                s.addLast(ARR[i]);
            } else if (ARR[i] == '[') {
                value *= 3;
                s.addLast(ARR[i]);
            } else if (ARR[i] == ')') {
                if (s.isEmpty() || s.peekLast() != '(') {
                    res = 0;
                    break;
                }
                if (ARR[i - 1] == '(') {
                    res += value;
                }
                value /= 2;
                s.pollLast();

            } else if (ARR[i] == ']') {
                if (s.isEmpty() || s.peekLast() != '[') {
                    res = 0;
                    break;
                }
                if (ARR[i - 1] == '[') {
                    res += value;
                }
                value /= 3;
                s.pollLast();
            }
            // System.out.println(ARR[i] + " " + res + " " + value);
        }

        if (!s.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(res);
        }
    }
}
