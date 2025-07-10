package boj;

public class BOJ6236 {
    static FastReader SC = new FastReader();
    static int N, M;
    static int[] A;

    public static void main(String[] args) {
        N = SC.nextInt();
        M = SC.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = SC.nextInt();
        }

        int res = 0;
        int l = 1, r = 1000000000;
        
        // 적어도 하루에 쓸 돈의 최댓값 만큼은 인출해야 한다!
        for (int i = 0; i < N; i++) {
            l = Math.max(l, A[i]);
        }
        while (l <= r) {
            int mid = (r + l) / 2;
            if (isAvailable(mid)) {
                r = mid - 1;
                res = mid;
            }
            else {
                l = mid + 1;
            }
        }
        System.out.println(res);
    }

    private static boolean isAvailable(int k) {
        int cnt = 1;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (sum + A[i] > k) {
                cnt++;
                sum = A[i];
            }
            else {
                sum += A[i];
            }
        }
//        System.out.println(k + " " + cnt);
        return cnt <= M;
    }
}
