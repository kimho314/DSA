package boj;

public class BOJ9461 {
    static FastReader SC = new FastReader();
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        long[] p = new long[101];
        p[1] = 1;
        p[2] = 1;
        p[3] = 1;
        for (int i = 4; i <= 100; i++) {
            p[i] = p[i - 2] + p[i - 3];
        }

        int t = SC.nextInt();
        while (t > 0) {
            t--;
            int n = SC.nextInt();
            SB.append(p[n]).append('\n');
        }
        System.out.println(SB);
    }
}
