package boj;

public class BOJ2839 {
    static FastReader SC = new FastReader();
    static int N;

    public static void main(String[] args) {
        N = SC.nextInt();

        int max1 = N / 5;
        int max2 = N / 3;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= max1; i++) {
            for (int j = 0; j <= max2; j++) {
                if (i * 5 + j * 3 == N) {
                    res = Math.min(res, (i + j));
                }
            }
        }

        if (res == Integer.MAX_VALUE) {
            System.out.println(-1);
        }
        else {
            System.out.println(res);
        }
    }
}
