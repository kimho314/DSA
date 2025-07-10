package boj;

public class BOJ1063 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static int[][] POSES;
    private static String[] MOVES;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int x1 = POSES[0][0];
        int y1 = POSES[0][1];
        int x2 = POSES[1][0];
        int y2 = POSES[1][1];

        for (int i = 0; i < N; i++) {
            int[] newPos = op(x1, y1, MOVES[i]);
            if (newPos[0] == -1 && newPos[1] == -1) {
                continue;
            }
            if (newPos[0] == x2 && newPos[1] == y2) {
                int[] newPos2 = op(x2, y2, MOVES[i]);
                if (newPos2[0] == -1 && newPos2[1] == -1) {
                    continue;
                }
                x2 = newPos2[0];
                y2 = newPos2[1];
            }
            x1 = newPos[0];
            y1 = newPos[1];
        }

        System.out.println(convert(x1, y1));
        System.out.println(convert(x2, y2));
    }

    private static String convert(int x, int y) {
        return String.valueOf((char) (x + 'A')) + String.valueOf((char) (y + '1'));
    }

    private static int[] op(int x, int y, String move) {
        int dx = x;
        int dy = y;
        switch (move) {
            case "R":
                dx = dx + 1;
                break;
            case "L":
                dx = dx - 1;
                break;
            case "B":
                dy = dy - 1;
                break;
            case "T":
                dy = dy + 1;
                break;
            case "RT":
                dx = dx + 1;
                dy = dy + 1;
                break;
            case "LT":
                dx = dx - 1;
                dy = dy + 1;
                break;
            case "RB":
                dx = dx + 1;
                dy = dy - 1;
                break;
            case "LB":
                dx = dx - 1;
                dy = dy - 1;
                break;
        }

        if (dx < 0 || dy < 0 || dx >= 8 || dy >= 8) {
            return new int[]{-1, -1};
        }
        return new int[]{dx, dy};
    }

    private static void input() {
        String king = SC.next();
        String stone = SC.next();
        N = SC.nextInt();

        POSES = new int[2][2];
        POSES[0][0] = king.charAt(0) - 'A';
        POSES[0][1] = king.charAt(1) - '1';
        POSES[1][0] = stone.charAt(0) - 'A';
        POSES[1][1] = stone.charAt(1) - '1';

        MOVES = new String[N];
        for (int i = 0; i < N; i++) {
            MOVES[i] = SC.next();
        }
    }
}
