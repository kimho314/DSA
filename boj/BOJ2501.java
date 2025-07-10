package boj;

public class BOJ2501 {
    static FastReader SC = new FastReader();
    static int N, K;

    public static void main(String[] args) {
        N = SC.nextInt();
        K = SC.nextInt();

        int cnt = 0;
        int res = 0;
        for (int i = 1; i <= N; i++) {
            if (N % i == 0) {
                cnt++;
                if (cnt == K) {
                    res = i;
                    break;
                }
            }
        }
        System.out.println(res);
    }
}
