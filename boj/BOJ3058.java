package boj;

public class BOJ3058 {
    private static FastReader SC = new FastReader();
    private static int T;
    private static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        input();
        while (T > 0) {
            T--;
            solve();
        }

        System.out.println(SB);
    }

    private static void solve() {
        int[] nums = new int[7];
        for (int i = 0; i < 7; i++) {
            nums[i] = SC.nextInt();
        }

        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 7; i++) {
            if (nums[i] % 2 == 0) {
                sum += nums[i];
                min = Math.min(min, nums[i]);
            }
        }

        SB.append(sum).append(' ').append(min).append('\n');
    }

    private static void input() {
        T = SC.nextInt();
    }
}
