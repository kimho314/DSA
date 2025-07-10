package boj;

public class BOJ11659 {
    static FastReader SC = new FastReader();
    static int N, M;
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        N = SC.nextInt();
        M = SC.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = SC.nextInt();
        }

        int[] sums = new int[N];
        sums[0] = nums[0];
        for (int i = 1; i < N; i++) {
            sums[i] += (sums[i - 1] + nums[i]);
        }


        for (int idx = 0; idx < M; idx++) {
            int i = SC.nextInt() - 1;
            int j = SC.nextInt() - 1;

            int subSum = sums[j] - ((i == 0) ? 0 : sums[i - 1]);
            SB.append(subSum).append('\n');
        }

        System.out.println(SB.toString());
    }
}
