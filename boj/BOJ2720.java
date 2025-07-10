package boj;

public class BOJ2720 {
    static FastReader SC = new FastReader();
    static int T, C;
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        T = SC.nextInt();
        int[] cents = {25, 10, 5, 1};
        while (T > 0) {
            T--;
            C = SC.nextInt();

            for (int i = 0; i < cents.length; i++) {
                int cnt = C / cents[i];
                C -= (cents[i] * cnt);
                SB.append(cnt).append(' ');
            }
            SB.append('\n');
        }

        System.out.println(SB);
    }
}
