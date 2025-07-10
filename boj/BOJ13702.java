package boj;

public class BOJ13702 {
    static FastReader SC = new FastReader();
    static int N, K;
    static int[] MAKGOLIES;

    public static void main(String[] args) {
        N = SC.nextInt();
        K = SC.nextInt();
        MAKGOLIES = new int[N];
        for (int i = 0; i < N; i++) {
            MAKGOLIES[i] = SC.nextInt();
        }

        long l = 1;
        long r = MAKGOLIES[0];
        for (int i = 1; i < N; i++) {
            r = Math.max(r, MAKGOLIES[i]);
        }

        long res = 0;
        if (K > 0) {
            while (l <= r) {
                long mid = (r + l) / 2;

                if (determine(mid)) {
                    l = mid + 1;
                    res = mid;
                }
                else {
                    r = mid - 1;
                }
            }
        }
        System.out.println(res);
    }

    private static boolean determine(long mid) {
        long cnt = 0;
        for (int i = 0; i < N; i++) {
            cnt += MAKGOLIES[i] / mid;
        }

        boolean res = cnt >= K;
        System.out.println("mid : " + mid + ", cnt : " + cnt + ", res : " + res);
        return res;
    }
}
