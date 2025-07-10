package boj;

public class BOJ10709 {
    private static FastReader SC = new FastReader();
    private static int H, W;
    private static int[][] TIME;
    private static char[][] MAP;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (MAP[i][j] == 'c') {
                    TIME[i][j] = 0;
                }
                else {
                    int pos = -1;
                    for (int k = 0; k < j; k++) {
                        if (MAP[i][k] == 'c') {
                            pos = k;
                        }
                    }
                    if (pos != -1) {
                        TIME[i][j] = j - pos;
                    }
                    else {
                        TIME[i][j] = -1;
                    }
                }
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                System.out.print(TIME[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void input() {
        H = SC.nextInt();
        W = SC.nextInt();
        MAP = new char[H][W];
        TIME = new int[H][W];
        for (int i = 0; i < H; i++) {
            String str = SC.nextLine();
            for (int j = 0; j < W; j++) {
                MAP[i][j] = str.charAt(j);
            }
        }
    }
}
