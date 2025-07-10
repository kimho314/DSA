package boj;

public class BOJ9063 {
    static FastReader SC = new FastReader();
    static int N;
    static int MIN_X = Integer.MAX_VALUE, MAX_X = Integer.MIN_VALUE, MIN_Y = Integer.MAX_VALUE, MAX_Y = Integer.MIN_VALUE;

    public static void main(String[] args) {
        N = SC.nextInt();

        for (int i = 0; i < N; i++) {
            int x = SC.nextInt();
            int y = SC.nextInt();
            MIN_X = Math.min(MIN_X, x);
            MAX_X = Math.max(MAX_X, x);
            MIN_Y = Math.min(MIN_Y, y);
            MAX_Y = Math.max(MAX_Y, y);
        }

        if (N == 1) {
            System.out.println(0);
        }
        else {
            int res = (MAX_X - MIN_X) * (MAX_Y - MIN_Y);
            System.out.println(res);
        }
    }
}
