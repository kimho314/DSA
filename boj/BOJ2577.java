package boj;

public class BOJ2577 {
    private static FastReader SC = new FastReader();
    private static int A, B, C;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int multiplyResult = A * B * C;

        int[] counts = new int[10];
        char[] nums = String.valueOf(multiplyResult).toCharArray();
        for (int i = 0; i < nums.length; i++) {
            int num = Integer.parseInt(String.valueOf(nums[i]));
            counts[num]++;
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(counts[i]);
        }
    }

    private static void input() {
        A = SC.nextInt();
        B = SC.nextInt();
        C = SC.nextInt();
    }
}
