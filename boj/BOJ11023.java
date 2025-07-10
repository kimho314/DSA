package boj;

public class BOJ11023 {
    private static FastReader SC = new FastReader();
    private static int[] NUMS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int sum = 0;
        for (int n : NUMS) {
            sum += n;
        }

        System.out.println(sum);
    }

    private static void input() {
        String[] input = SC.nextLine().split(" ");
        NUMS = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            NUMS[i] = Integer.parseInt(input[i]);
        }
    }
}
