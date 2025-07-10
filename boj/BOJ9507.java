package boj;

public class BOJ9507 {
    static FastReader SC = new FastReader();
    static int T;
    static long[] KOONG = new long[68];
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        T = SC.nextInt();

        KOONG[0] = 1;
        KOONG[1] = 1;
        KOONG[2] = 2;
        KOONG[3] = 4;
        for (int i = 4; i <= 67; i++) {
            KOONG[i] = KOONG[i - 1] + KOONG[i - 2] + KOONG[i - 3] + KOONG[i - 4];
        }

        while (T > 0) {
            T--;
            int n = SC.nextInt();
            SB.append(KOONG[n]).append('\n');
        }
        System.out.println(SB);
    }
}
