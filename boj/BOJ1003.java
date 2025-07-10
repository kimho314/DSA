package boj;

public class BOJ1003 {
    static FastReader SC = new FastReader();
    static int T;
    static int[][] D;
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        T = SC.nextInt();
        D = new int[41][2];
        D[0][0] = 1;
        D[0][1] = 0;
        D[1][0] = 0;
        D[1][1] = 1;
        for (int i = 2; i <= 40; i++) {
            D[i][0] = D[i - 1][0] + D[i - 2][0];
            D[i][1] = D[i - 1][1] + D[i - 2][1];
        }
        while (T > 0) {
            T--;
            int n = SC.nextInt();
            SB.append(D[n][0]).append(' ').append(D[n][1]).append('\n');
        }
        System.out.println(SB);
    }
}
