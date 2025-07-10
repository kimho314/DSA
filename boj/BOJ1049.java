package boj;

public class BOJ1049 {
    static FastReader SC = new FastReader();
    static int N, M;
    static int MIN_PACKAGE = Integer.MAX_VALUE, MIN_UNIT = Integer.MAX_VALUE;

    public static void main(String[] args) {
        N = SC.nextInt();
        M = SC.nextInt();
        for (int i = 0; i < M; i++) {
            int pack = SC.nextInt();
            int unit = SC.nextInt();
            MIN_PACKAGE = Math.min(MIN_PACKAGE, pack);
            MIN_UNIT = Math.min(MIN_UNIT, unit);
        }

        int packs = N / 6;
        int remainder = N % 6;
        int res = 0;
        if (MIN_PACKAGE > MIN_UNIT * 6) {
            res = MIN_UNIT * N;
        }
        else {
            res = packs * MIN_PACKAGE;
            res += Math.min(MIN_PACKAGE, remainder * MIN_UNIT);
        }

        System.out.println(res);
    }
}
