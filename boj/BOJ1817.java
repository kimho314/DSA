package boj;

public class BOJ1817 {
    static FastReader SC = new FastReader();
    static int N, M;
    static int[] NUMS;

    public static void main(String[] args) {
        N = SC.nextInt();
        M = SC.nextInt();
        if (N == 0) {
            System.out.println(0);
            return;
        }
        NUMS = new int[N];
        for (int i = 0; i < N; i++) {
            NUMS[i] = SC.nextInt();
        }

        int box = 1;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (sum + NUMS[i] <= M) {
                sum += NUMS[i];
            }
            else {
                sum = NUMS[i];
                box++;
            }
        }
        System.out.println(box);
    }
}
