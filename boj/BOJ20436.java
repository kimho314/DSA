package boj;

import java.util.ArrayList;
import java.util.List;

public class BOJ20436 {
    private static FastReader SC = new FastReader();
    private static char L, R;
    private static String STR;
    private static char[][] KEYBOARD;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int res = 0;

        ArrayList<Character> LEFT = new ArrayList<>();
        LEFT.addAll(List.of('q', 'w', 'e', 'r', 't', 'a', 's', 'd', 'f', 'g', 'z', 'x', 'c', 'v'));
        ArrayList<Character> RIGHT = new ArrayList<>();
        RIGHT.addAll(List.of('y', 'u', 'i', 'o', 'p', 'h', 'j', 'k', 'l', 'b', 'n', 'm'));

        for (int i = 0; i < STR.length(); i++) {
            char ch = STR.charAt(i);
            boolean isLeft = LEFT.contains(ch);
            boolean isRight = RIGHT.contains(ch);
            if (isLeft && !isRight) {
                int diff = calcDiff(ch, L);
                res += (diff + 1);
                L = ch;
            }
            if (!isLeft && isRight) {
                int diff = calcDiff(ch, R);
                res += (diff + 1);
                R = ch;
            }
        }

        System.out.println(res);
    }

    private static int calcDiff(char target, char from) {
        int targetY = -1;
        int targetX = -1;
        int fromY = -1;
        int fromX = -1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 10; j++) {
                if (target == KEYBOARD[i][j]) {
                    targetY = i;
                    targetX = j;
                }
                if (from == KEYBOARD[i][j]) {
                    fromY = i;
                    fromX = j;
                }
            }
        }

        int diff = Math.abs(targetY - fromY) + Math.abs(targetX - fromX);
//        System.out.println(target + " " + from + " " + diff);
        return diff;
    }

    private static void input() {
        L = SC.next().charAt(0);
        R = SC.next().charAt(0);
        STR = SC.nextLine();

        KEYBOARD = new char[3][10];
        KEYBOARD[0][0] = 'q';
        KEYBOARD[0][1] = 'w';
        KEYBOARD[0][2] = 'e';
        KEYBOARD[0][3] = 'r';
        KEYBOARD[0][4] = 't';
        KEYBOARD[0][5] = 'y';
        KEYBOARD[0][6] = 'u';
        KEYBOARD[0][7] = 'i';
        KEYBOARD[0][8] = 'o';
        KEYBOARD[0][9] = 'p';
        KEYBOARD[1][0] = 'a';
        KEYBOARD[1][1] = 's';
        KEYBOARD[1][2] = 'd';
        KEYBOARD[1][3] = 'f';
        KEYBOARD[1][4] = 'g';
        KEYBOARD[1][5] = 'h';
        KEYBOARD[1][6] = 'j';
        KEYBOARD[1][7] = 'k';
        KEYBOARD[1][8] = 'l';
        KEYBOARD[2][0] = 'z';
        KEYBOARD[2][1] = 'x';
        KEYBOARD[2][2] = 'c';
        KEYBOARD[2][3] = 'v';
        KEYBOARD[2][4] = 'b';
        KEYBOARD[2][5] = 'n';
        KEYBOARD[2][6] = 'm';
    }
}
