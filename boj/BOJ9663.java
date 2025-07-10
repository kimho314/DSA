package boj;

public class BOJ9663 {

    static Integer N, ANS;

    static int[] COL;
    static FastReader SC = new FastReader();

    public static void main(String[] args) {
        N = SC.nextInt();
        ANS = 0;
        COL = new int[N + 1];
        recFunc(1);
        System.out.println(ANS);
    }

    private static void recFunc(int row) {
        if (row == N + 1) {
            ANS++;
        }
        else {
            for (int c = 1; c <= N; c++) {
                boolean possible = true;
                for (int r = 1; r <= row - 1; r++) {
                    if (validityCheck(row, c, r, COL[r])) {
                        possible = false;
                        break;
                    }
                }

                if (possible) {
                    COL[row] = c;
                    recFunc(row + 1);
                    COL[row] = 0;
                }
            }
        }
    }

    private static boolean validityCheck(int r1, int c1, int r2, int c2) {
        if (c1 == c2) return true;
        if (r1 - c1 == r2 - c2) return true;
        if (r1 + c1 == r2 + c2) return true;
        return false;
    }
}
